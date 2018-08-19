package repuestos.facturacion.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Factura {
	
	private int id;
	private int idCliente;
	private int idPedido;
	private int idCentroCostos;
	private int consecutivo;
	private double valorTotal;
	private Date fecha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdCentroCostos() {
		return idCentroCostos;
	}
	public void setIdCentroCostos(int idCentroCostos) {
		this.idCentroCostos = idCentroCostos;
	}
	public int getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
