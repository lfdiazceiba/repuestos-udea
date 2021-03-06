package repuestos.facturacion.infraestructura;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repuestos.facturacion.model.Factura;


@Configuration
public class Configuracion {

	@Bean
	public ConnectionFactory connectionFactory() {

		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("lion-01.rmq.cloudamqp.com"); // localhost para el aplicativo local
//		connectionFactory.setPort(5672); // no va para la nube
		connectionFactory.setUsername("yxborocx");
		connectionFactory.setPassword("1l-8TJ0eNK7Tg3aLBXXmPyScMdqaHuwy");
		connectionFactory.setChannelCheckoutTimeout(1000000);
		connectionFactory.setRequestedHeartBeat(300); // Mantiene limpias los canales tcp abiertas en rabbit
		connectionFactory.setVirtualHost("yxborocx"); // va para la nube
		return connectionFactory;

	}	
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		return rabbitTemplate;
	}
	
	@Bean
	public Publicador publicador() {
		return new Publicador();
	}
	
	@Bean
	public Factura factura() {
		return new Factura();
	}
	
	@Bean
	public SimpleMessageListenerContainer containerFactura(ConnectionFactory connectionFactory, Factura factura,
			Publicador publicador) {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		simpleMessageListenerContainer.setQueueNames("factura.respuestos.centrocosto");
		simpleMessageListenerContainer.setMessageListener(new ConsumidorCentroCosto(publicador, factura));
		simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
		return simpleMessageListenerContainer;		
	}
	
	@Bean
	public SimpleMessageListenerContainer containerPedido(ConnectionFactory connectionFactory, Factura factura,
			Publicador publicador) {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		simpleMessageListenerContainer.setQueueNames("pedido.repuestos.facturacion");
		simpleMessageListenerContainer.setMessageListener(new ConsumidorFactura(publicador, factura));
		simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
		return simpleMessageListenerContainer;		
	}	

}
