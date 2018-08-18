package repuesto.inventario.configuracion;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repuesto.inventario.dominio.InventarioService;



@Configuration
public class InventarioConfig {
	
	@Bean 
	public InventarioService inventarioService() {
		return new InventarioService();
	}
	
	@Bean
    public SimpleMessageListenerContainer container(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("pedido.repuestos.inventario");
        container.setMessageListener(inventarioService());
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return container;
    }




	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("lion-01.rmq.cloudamqp.com");
		connectionFactory.setUsername("yxborocx");
		connectionFactory.setPassword("1l-8TJ0eNK7Tg3aLBXXmPyScMdqaHuwy");
		connectionFactory.setChannelCheckoutTimeout(1000);
		connectionFactory.setRequestedHeartBeat(300);
		connectionFactory.setVirtualHost("yxborocx");
		return connectionFactory;
	}

  @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return  rabbitTemplate;
    }

}
