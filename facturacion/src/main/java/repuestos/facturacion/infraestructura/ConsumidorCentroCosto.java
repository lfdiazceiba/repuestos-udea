package repuestos.facturacion.infraestructura;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repuestos.facturacion.model.Factura;

@Component
public class ConsumidorCentroCosto implements MessageListener {
	

//	@Autowired
	private Publicador publicador =new Publicador();
	@Autowired
	private Factura factura;

	@Override
	public void onMessage(Message message) {
		System.out.println("Mensaje recibido Consumidor Centro costos"+new String(message.getBody()));
		if(factura == null) {
			factura = new Factura();
			factura.setIdPedido(2);
			factura.setIdCentroCostos(3);
		}	
		
//		CentroCostos centroCostos = null;
//		try {
//			centroCostos = (CentroCostos) Util.deserialize(message.getBody());
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
		factura.setIdCentroCostos(4);
//		factura.setIdCentroCostos(centroCostos.getId());
		
		publicador.publicarMensaje("pedido.repuestos", "facturacion", factura.getIdPedido());
		System.out.println("Factura con id "+factura.getId()+" actualizada con su centro de costos"+factura.getIdCentroCostos());
		
	}

}
