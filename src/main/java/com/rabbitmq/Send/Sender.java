package com.rabbitmq.Send;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class Sender {
	private static final Logger log = LoggerFactory.getLogger(Sender.class);
	@Resource
	private RabbitTemplate rabbitTemplate;

	/**
	 * 死信队列
	 * 
	 * @return
	 */
	@RequestMapping(value = "sendToDeadQueue", method = RequestMethod.POST)
	public String sendToDeadQueue() {
		
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		MessagePostProcessor messagePostProcessor = message -> {
			MessageProperties messageProperties = message.getMessageProperties();
			messageProperties.setContentEncoding("utf-8");
			messageProperties.setExpiration("10000");
			return message;
		};
		
		rabbitTemplate.convertAndSend("DL_EXCHANGE", "DL_KEY", "helle World", messagePostProcessor, correlationData);
		log.info("dead message  send time " + new Date());
		return "OK";
	}
}
