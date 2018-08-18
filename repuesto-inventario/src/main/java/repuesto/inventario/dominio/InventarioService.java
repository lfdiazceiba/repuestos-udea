package repuesto.inventario.dominio;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class InventarioService implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		System.out.println("mesaje es  "+message.getBody());
		
	}
	
	

}
