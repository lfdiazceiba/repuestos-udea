package repuestos.logistica.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import repuestos.logistica.infraestructura.Publicador;
import repuestos.logistica.modelo.Pedido;

@RestController
public class PedidosController {
	
    Publicador publicador = new Publicador();
	
	@RequestMapping(method = RequestMethod.POST, value="/pedidos")
    public @ResponseBody ResponseEntity<String> crearPedido(@RequestBody Pedido pedido){
		
		//TODO: Generar el pedido con id unico.
		Random random = new Random();
		int idPedido = random.nextInt(100000);
		
		//TODO Validar la entrada para no quemar el valor.
        publicador.publicarMensaje("pedido.repuestos", "inventario", "{ \"idPedido\":\""+idPedido+"\",	\"nombrePedido\":\"tornillo\", 	\"ciudadPedido\" : \"Medellin\", 	\"fechapedido\" : \"2018-07-15\", 	\"idCliente\" : \"1\", 	\"nombreCliente\" :\"Ana\" }");
        
        return new ResponseEntity<>("Su pedido ha sido creado por el numero:"+idPedido,HttpStatus.OK);
    }	
	
}