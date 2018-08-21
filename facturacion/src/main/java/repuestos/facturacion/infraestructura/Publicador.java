package repuestos.facturacion.infraestructura;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publicador {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void publicarMensaje(String exchange, String routinKey, String mensaje) {
		rabbitTemplate.convertAndSend(exchange, routinKey, mensaje); // Publicamos un mensaje
	}
	
}
