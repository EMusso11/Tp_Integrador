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
	
	private List<Insumo> itemsSolicitados;
}
