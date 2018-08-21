package repuestos.facturacion.infraestructura;

import java.util.Date;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repuestos.facturacion.model.Factura;

@Component
public class ConsumidorFactura implements MessageListener {
	
	@Autowired
	public Publicador publicador;
	@Autowired
	public Factura factura;
	
	public ConsumidorFactura(Publicador publicador, Factura factura) {
		this.factura = factura;
		this.publicador = publicador;
	}
	
	private int count = 0;
	
	@Override
	public void onMessage(Message message) {	
		
		System.out.println("Mensaje recibido Consumidor factura '"+new String(message.getBody())+"'");
		
		factura.setConsecutivo(1);
		factura.setIdCentroCostos(1);
		factura.setIdCliente(2);
		factura.setIdPedido(3);
		factura.setValorTotal(15000);	
		factura.setId(count++);
		factura.setFecha(new Date());
		StringBuilder respuesta = new StringBuilder();
		respuesta.append("Factura adicionada con la siguiente informacion: ")
		.append(" id: "+factura.getId())
		.append(" idPedido: "+factura.getIdPedido())
		.append(" idCliente: "+factura.getIdCliente())
		.append(" idCentroCostos: "+factura.getIdCentroCostos())
		.append(" valorTotal: "+factura.getValorTotal());
		System.out.println(respuesta.toString());
		publicador.publicarMensaje("factura.respuestos", "centrocosto", message.getBody().toString());
	}
	
}
