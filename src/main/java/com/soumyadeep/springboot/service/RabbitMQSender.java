package com.soumyadeep.springboot.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.soumyadeep.springboot.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingKey;
	
	public void send(Employee employee) {
		
		rabbitTemplate.convertAndSend(exchange,routingKey, employee);
		System.out.println("Send msg = " + employee);
	}

}
