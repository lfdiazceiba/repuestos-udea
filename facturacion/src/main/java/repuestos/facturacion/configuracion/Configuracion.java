package repuestos.facturacion.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import repuestos.facturacion.infraestructura.Publicador;
import repuestos.facturacion.model.Factura;

@Component
public class Configuracion {
	
	@Bean
	public Publicador publicador() {
		return new Publicador();
	}
	
	@Bean
	public Factura factura() {
		return new Factura();
	}

}
