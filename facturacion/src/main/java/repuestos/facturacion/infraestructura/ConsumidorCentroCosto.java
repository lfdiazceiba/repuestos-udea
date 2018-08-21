package repuestos.facturacion.infraestructura;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repuestos.facturacion.model.Factura;

@Component
public class ConsumidorCentroCosto implements MessageListener {
	
	@Autowired
	public Publicador publicador;
	@Autowired
	public Factura factura;
	
	public ConsumidorCentroCosto(Publicador publicador, Factura factura) {
		this.factura = factura;
		this.publicador = publicador;
	}

	@Override
	public void onMessage(Message message) {
		System.out.println("Mensaje recibido Consumidor Centro costos '"+new String(message.getBody())+"'");
		factura.setIdPedido(2);
		factura.setIdCentroCostos(3);
		publicador.publicarMensaje("pedido.repuestos", "facturacion", message.getBody().toString());
		System.out.println("Factura con id "+factura.getId()+" actualizada con su centro de costos"+factura.getIdCentroCostos());
		
	}

}
