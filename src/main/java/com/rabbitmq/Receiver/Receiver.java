package com.rabbitmq.Receiver;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.mapper.UserMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 监听器.
 *
 * @author dax.
 * @version v1.0
 * @since 2018 /2/24 9:36
 */
@Component
public class Receiver {
	private static final Logger log = LoggerFactory.getLogger(Receiver.class);
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
	@Autowired
	private UserMapper userMapper;

	/**
	 * FANOUT广播队列监听一.
	 *
	 * @param message the message
	 * @param channel the channel
	 * @throws IOException the io exception 这里异常需要处理
	 */
	@RabbitListener(queues = { "FANOUT_QUEUE_A" })
	public void on(Message message, Channel channel) throws IOException {
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		log.debug("FANOUT_QUEUE_A " + new String(message.getBody()));
	}

	/**
	 * FANOUT广播队列监听二.
	 *
	 * @param message the message
	 * @param channel the channel
	 * @throws IOException the io exception 这里异常需要处理
	 */
	@RabbitListener(queues = { "FANOUT_QUEUE_B" })
	public void t(Message message, Channel channel) throws IOException {
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		log.debug("FANOUT_QUEUE_B " + new String(message.getBody()));
	}

	/**
	 * DIRECT模式.
	 *
	 * @param message the message
	 * @param channel the channel
	 * @throws IOException the io exception 这里异常需要处理
	 */
	@RabbitListener(queues = { "DIRECT_QUEUE" })
	public void message(Message message, Channel channel) throws IOException {
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		log.debug("DIRECT " + new String(message.getBody()));
	}

	/**
	 * 监听替补队列 来验证死信.（死信队列转发后实际消费的队列）
	 *
	 * @param message the message
	 * @param channel the channel
	 * @throws IOException the io exception 这里异常需要处理
	 */
	@RabbitListener(queues = { "REDIRECT_QUEUE" })
	public void redirect(Message message, Channel channel) throws IOException {
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		byte[] body = message.getBody();
		String requestString = new String(body);
		JSONObject requestJson=JSONObject.parseObject(requestString);
		User user = userMapper.selectByPrimaryKey(Integer.parseInt(requestJson.getString("userID")));
		if(null!=user) {
			user.setPhoneNumber("001");
			user.setLastUpdate(new Date());
			userMapper.updateByPrimaryKeySelective(user);
//			userMapper.deleteByPrimaryKey(Integer.parseInt(requestJson.getString("userID")));
			System.out.println("消息處理時間： "+ sdf.format(new Date())+", 消息内容为 ："+requestString+", 更新用户信息");
		}
	}
}
