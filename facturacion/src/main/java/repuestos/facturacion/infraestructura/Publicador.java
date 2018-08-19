package repuestos.facturacion.infraestructura;

import java.util.concurrent.CompletableFuture;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Publicador {

	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RabbitConf.class);
	RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);
	
	public void publicarMensaje(String exchange, String routinKey, int idPedido) {
		rabbitTemplate.convertAndSend(exchange, routinKey, idPedido); // Publicamos un mensaje
	}
	
	// Publicar mensajes de forma asincrona
	public void publicarMessageAsk(String exchange, String routinKey, String mensaje) {
		CompletableFuture.runAsync(() -> rabbitTemplate.convertAndSend(exchange, routinKey, mensaje));		
	}
	
}
