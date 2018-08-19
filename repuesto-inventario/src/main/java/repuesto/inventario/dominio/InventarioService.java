package repuesto.inventario.dominio;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class InventarioService implements MessageListener {

	private RabbitTemplate rabbitTemplate;
	
	@Override
	public void onMessage(Message message) {
		
		System.out.println("mesaje es  "+new String(message.getBody()));
		publicarMensaje("mensaje recibido");
		
	}
	
	public void publicarMensaje(String mensaje){
        rabbitTemplate.convertAndSend("pedido.repuestos.out", "inventario.out", mensaje);
    }
	

	public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
}
