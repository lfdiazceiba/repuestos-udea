package com.repuestos.bi.infraestructura;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Consumidor implements MessageListener{
	
	@Override
	public void onMessage(Message message) {
		System.out.println(new String(message.getBody()));		
	}


	
}

