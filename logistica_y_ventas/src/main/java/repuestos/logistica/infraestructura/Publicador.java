package repuestos.logistica.infraestructura;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Publicador {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RabbitConf.class);
    RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);

    public void publicarMensaje(String exchange, String routinKey, String mensaje){
        rabbitTemplate.convertAndSend(exchange, routinKey, mensaje);
    }

    public void publicarMensajeAsk(String exchange, String routingKey, String mensaje){
        CompletableFuture.runAsync(()-> rabbitTemplate.convertAndSend(exchange, routingKey, mensaje));
    }
}