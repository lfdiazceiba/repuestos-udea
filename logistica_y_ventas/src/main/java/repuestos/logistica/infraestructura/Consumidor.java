package repuestos.logistica.infraestructura;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Consumidor implements MessageListener {
	
    Publicador publicador = new Publicador();

    @Override
    public void onMessage(Message message) {
    	System.out.println("KAKASHI: Entró un nuevo mensaje ");
    	
    	//TODO: Validar la repuesta que se encuentre disponible lo pedido. 
    	//      Supongamos que esta bien y mandamos a facturacion 
    	publicador.publicarMensaje("pedido.repuestos", "facturacion", message.toString());
    }
}
