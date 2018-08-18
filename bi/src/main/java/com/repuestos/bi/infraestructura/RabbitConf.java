package com.repuestos.bi.infraestructura;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConf {

	
	@Bean
	public ConnectionFactory connectionFactory() {
		
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory( "lion-01.rmq.cloudamqp.com");
		connectionFactory.setUsername("yxborocx");
		connectionFactory.setPassword("1l-8TJ0eNK7Tg3aLBXXmPyScMdqaHuwy");
		connectionFactory.setChannelCheckoutTimeout(1000);
		connectionFactory.setRequestedHeartBeat(300);
		connectionFactory.setVirtualHost("yxborocx");
		return connectionFactory;
	}
	
	@Bean
	public SimpleMessageListenerContainer containerPedido(ConnectionFactory connectionFactory ) {
		
		SimpleMessageListenerContainer containerPedido = new SimpleMessageListenerContainer();
		
		containerPedido.setConnectionFactory(connectionFactory);
		containerPedido.setQueueNames("pedido.repuestos.bi");
		containerPedido.setMessageListener(new Consumidor());
		containerPedido.setAcknowledgeMode(AcknowledgeMode.AUTO);
		
		return containerPedido;		
	}
	
	
	@Bean
	public SimpleMessageListenerContainer containerFactura(ConnectionFactory connectionFactory ) {
		
		SimpleMessageListenerContainer containerFactura = new SimpleMessageListenerContainer();
		
		containerFactura.setConnectionFactory(connectionFactory);
		containerFactura.setQueueNames("factura.respuestos.bi");
		containerFactura.setMessageListener(new Consumidor());
		containerFactura.setAcknowledgeMode(AcknowledgeMode.AUTO);
		
		return containerFactura;		
	}
	
	
	@Bean
	public SimpleMessageListenerContainer containerPedidoOut(ConnectionFactory connectionFactory ) {
		
		SimpleMessageListenerContainer containerPedidoOut = new SimpleMessageListenerContainer();
		
		containerPedidoOut.setConnectionFactory(connectionFactory);
		containerPedidoOut.setQueueNames("pedido.repuestos.inventario.bi.out");
		containerPedidoOut.setMessageListener(new Consumidor());
		containerPedidoOut.setAcknowledgeMode(AcknowledgeMode.AUTO);
		
		return containerPedidoOut;		
	}
	
	
}
