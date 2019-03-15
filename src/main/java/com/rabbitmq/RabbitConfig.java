package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 队列配置.
 *
 * @author dax.
 * @version v1.0
 * @since 2018 /2/23 14:28
 */
@Configuration
public class RabbitConfig {

	@Resource
	private RabbitTemplate rabbitTemplate;
	
	/** 死信队列 交换机 */
	private static final String DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";
	/**  死信队列交换机绑定键 */
	private static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

	/**
	 * 定制化amqp模版 可根据需要定制多个
	 * <p>
	 * <p>
	 * 此处为模版类定义 Jackson消息转换器 ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调
	 * 即消息发送到exchange ack ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调
	 * 即消息发送不到任何一个队列中 ack
	 *
	 * @return the amqp template
	 */
//    @Primary
	@Bean
	public AmqpTemplate amqpTemplate() {
		Logger log = LoggerFactory.getLogger(RabbitTemplate.class);
//          使用jackson 消息转换器
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.setEncoding("UTF-8");
//        开启returncallback     yml 需要 配置    publisher-returns: true
		rabbitTemplate.setMandatory(true);
		rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
			String correlationId = message.getMessageProperties().getCorrelationId();
			log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange,
					routingKey);
		});
		// 消息确认 yml 需要配置 publisher-returns: true
		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			if (ack) {
				log.debug("消息发送到exchange成功,id: {}", correlationData.getId());
			} else {
				log.debug("消息发送到exchange失败,原因: {}", cause);
			}
		});
		return rabbitTemplate;
	}

	/*
	 * ------------------------------------------------
	 * Direct exchange（直连交换机）
	 * 交换机和队列一一对应绑定 不需要用key约束 
	 */

	/**
	 * 声明一个直连交换机,并设置支持持久化。
	 * durable(true)：支付 durable(false)不支持
	 * 交换机名称：DIRECT_EXCHANGE
	 *
	 * @return the exchange
	 */
	@Bean("directExchange")
	public Exchange directExchange() {
		return ExchangeBuilder.directExchange("DIRECT_EXCHANGE").durable(true).build();
	}

	/**
	 * 声明一个队列 支持持久化.
	 * 隊列名称：DIRECT_QUEUE
	 * @return the queue
	 */
	@Bean("directQueue")
	public Queue directQueue() {
		return QueueBuilder.durable("DIRECT_QUEUE").build();
	}

	/**
	 * 通过绑定键 将指定队列绑定到一个指定的交换机 .
	 *
	 * @param queue    the DIRECT_QUEUE
	 * @param exchange the DIRECT_EXCHANGE
	 * @param key      the DIRECT_ROUTING_KEY
	 * @return the binding
	 */
	@Bean
	public Binding directBinding(@Qualifier("directQueue") Queue queue,
			@Qualifier("directExchange") Exchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("DIRECT_ROUTING_KEY").noargs();
	}

	/*
	 * ----------------------------------------------------------------------------
	 * Fanout exchange  （扇形交换机）
	 * 一个路由可以绑定多个消息队列。
	 *  一条消息经过交换机会转发到所有绑定的队列上
	 */

	/**
	 * 声明 一个FANOUT路由.並且支持持久化
	 * 路由名稱：FANOUT_EXCHANGE
	 * @return the exchange
	 */
	@Bean("fanoutExchange")
	public FanoutExchange fanoutExchange() {
		return (FanoutExchange) ExchangeBuilder.fanoutExchange("FANOUT_EXCHANGE").durable(true).build();
	}

	/**
	 * Fanout queue A.
	 * 声明一个FANOUT队列A, 队列名称FANOUT_QUEUE_A
	 *  
	 * @return the queue
	 */
	@Bean("fanoutQueueA")
	public Queue fanoutQueueA() {
		return QueueBuilder.durable("FANOUT_QUEUE_A").build();
	}

	/**
	 * Fanout queue B .
	 * 声明一个FANOUT队列B, 队列名称FANOUT_QUEUE_FANOUT_QUEUE_B
	 * @return the queue
	 */
	@Bean("fanoutQueueB")
	public Queue fanoutQueueB() {
		return QueueBuilder.durable("FANOUT_QUEUE_B").build();
	}

	/**
	 * 绑定队列A 到Fanout 交换机.
	 *
	 * @param queue          the queue
	 * @param fanoutExchange the fanout exchange
	 * @return the binding
	 */
	@Bean
	public Binding bindingA(@Qualifier("fanoutQueueA") Queue queue,
			@Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queue).to(fanoutExchange);
	}

	/**
	 * 绑定队列B 到Fanout 交换机.
	 *
	 * @param queue          the queue
	 * @param fanoutExchange the fanout exchange
	 * @return the binding
	 */
	@Bean
	public Binding bindingB(@Qualifier("fanoutQueueB") Queue queue,
			@Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queue).to(fanoutExchange);
	}

	/**
	 * ----------------------------------------------------------
	 * 死信队列 
	 * 1.死信队列跟交换机类型没有关系 不一定为directExchange 不影响该类型交换机的特性.
	 * 2.死信队列实质是将过期的消息转发到绑定的queue上,实现再次消费
	 * ----------------------------------------------------------
	 */

	/**
	 * 声明一个死信路由,支持持久化
	 * 死信路由名稱：DL_EXCHANGE
	 * deadLetterExchange
	 * @return
	 */
	@Bean("deadLetterExchange")
	public Exchange deadLetterExchange() {
		return ExchangeBuilder.directExchange("DL_EXCHANGE").durable(true).build();
	}

	/**
	 * 声明一个死信队列. 
	 * 死信队列名称：deadLetterQueue
	 * 死信路由名称：DL_EXCHANGE
	 * 綁定KEY：KEY_R
	 * x-dead-letter-exchange 对应 死信交换机 x-dead-letter-routing-key 对应 死信队列
	 *
	 * @return the queue
	 */
	@Bean("deadLetterQueue")
	public Queue deadLetterQueue() {
		Map<String, Object> args = new HashMap<>(2);
//       x-dead-letter-exchange    声明  死信交换机
		args.put(DEAD_LETTER_QUEUE_KEY, "DL_EXCHANGE");
//       x-dead-letter-routing-key    声明 死信路由键
		args.put(DEAD_LETTER_ROUTING_KEY, "KEY_R");
		return QueueBuilder.durable("DL_QUEUE").withArguments(args).build();
	}

	/**
	 * 聲明一個死信隊列轉發到新的消息隊列
	 * 转发后的消息队列名称：REDIRECT_QUEUE
	 *
	 * @return the queue
	 */
	@Bean("redirectQueue")
	public Queue redirectQueue() {
		return QueueBuilder.durable("REDIRECT_QUEUE").build();
	}

	/**
	 * 通过key将死信路由绑定到死信队列
	 *
	 * @return the binding
	 */
	@Bean
	public Binding deadLetterBinding() {
		return new Binding("DL_QUEUE", Binding.DestinationType.QUEUE, "DL_EXCHANGE", "DL_KEY", null);
		// 隊列名稱 綁定類型 路由名稱  key 參數
		
	}

	/**
	 *  通过key将死信路由绑定到死信队列并设置转发到转发的队列上
	 *  
	 * @return the binding
	 */
	@Bean
	public Binding redirectBinding() {
		return new Binding("REDIRECT_QUEUE", Binding.DestinationType.QUEUE, "DL_EXCHANGE", "KEY_R", null);
	}
}
