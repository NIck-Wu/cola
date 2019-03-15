package com.rabbitmq.Send;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

@Component
public class Sender {
	
	@Resource
	private RabbitTemplate rabbitTemplate;
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
	/**
	 * 创建死信任务
	 * 
	 * @return
	 */
	@RequestMapping(value = "creatDeadTask", method = RequestMethod.POST)
	public boolean creatDeadTask(JSONObject json) {
		
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		MessagePostProcessor messagePostProcessor = message -> {
			MessageProperties messageProperties = message.getMessageProperties();
			messageProperties.setContentEncoding("utf-8");
			messageProperties.setExpiration("10000");  //10S
			return message;
		};
		
		rabbitTemplate.convertAndSend("DL_EXCHANGE", "DL_KEY", json, messagePostProcessor, correlationData);
		System.out.println("消息发送时间： "+ sdf.format(new Date())+", 消息内容为 ："+json.toString());
		return true;
	}
}
