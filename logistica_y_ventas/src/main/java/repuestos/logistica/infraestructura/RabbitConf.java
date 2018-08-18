package repuestos.logistica.infraestructura;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {

    @Bean
    public ConnectionFactory connectionFactory(){
    	CachingConnectionFactory connectionFactory = new CachingConnectionFactory( "lion-01.rmq.cloudamqp.com");
		connectionFactory.setUsername("yxborocx");
		connectionFactory.setPassword("1l-8TJ0eNK7Tg3aLBXXmPyScMdqaHuwy");
		connectionFactory.setChannelCheckoutTimeout(1000);  //Ok
		connectionFactory.setRequestedHeartBeat(300);   //ok
		connectionFactory.setVirtualHost("yxborocx");
		return connectionFactory;
    }
    
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return  rabbitTemplate;
    }
}
