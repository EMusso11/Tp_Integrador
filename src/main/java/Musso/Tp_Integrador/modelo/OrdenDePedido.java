package Musso.Tp_Integrador.modelo;

import java.time.LocalDate;
import java.util.List;

public class OrdenDePedido {
	
	public enum EstadoOrden { PROCESADA, CREADA, ENTREGADA, CANCELADA };

	private Integer nroDePedido;
	private Planta plantaDestino;
	private LocalDate fechaSolicitud;
	private LocalDate fechaEntrega;
	private EstadoOrden estado;
	private Envio detalleEnvio;
	
	private List<Producto> itemsSolicitados;
	
	public OrdenDePedido() {}
	
	public OrdenDePedido(Planta planta, LocalDate fechaEntrega, List<Producto> itemsSolicitados) {
		this.plantaDestino = planta;
		this.fechaEntrega = fechaEntrega;
		this.itemsSolicitados = itemsSolicitados;
	}

	public OrdenDePedido(Planta planta, LocalDate now, Integer nro) {
		this.plantaDestino = planta;
		this.fechaEntrega = fechaEntrega;
		this.nroDePedido = nro;		
	}

	public void registrarOrdenDePedido(Planta planta, LocalDate fechaEntrega, List<Producto> itemsSolicitados) {
		OrdenDePedido orden = new OrdenDePedido(planta, fechaEntrega, itemsSolicitados);
		orden.setEstado(EstadoOrden.CREADA);
	}
	
	public void cambiarEstado(EstadoOrden estado) {
		switch(estado) {
		case PROCESADA:
			this.setEstado(EstadoOrden.ENTREGADA);
		case ENTREGADA:
			this.setEstado(EstadoOrden.PROCESADA);
		}
	}

	public Integer getNroDePedido() {
		return nroDePedido;
	}

	public void setNroDePedido(Integer nroDePedido) {
		this.nroDePedido = nroDePedido;
	}

	public Planta getPlantaDestino() {
		return plantaDestino;
	}

	public void setPlantaDestino(Planta plantaDestino) {
		this.plantaDestino = plantaDestino;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public EstadoOrden getEstado() {
		return estado;
	}

	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}

	public Envio getDetalleEnvio() {
		return detalleEnvio;
	}

	public void setDetalleEnvio(Envio detalleEnvio) {
		this.detalleEnvio = detalleEnvio;
	}

	public List<Producto> getItemsSolicitados() {
		return itemsSolicitados;
	}

	public void setItemsSolicitados(List<Producto> itemsSolicitados) {
		this.itemsSolicitados = itemsSolicitados;
	}
	
	
}
