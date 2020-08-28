package Musso.Tp_Integrador.modelo;

import java.time.LocalDate;

public class Camion {
   
	private String patente;
    private String marca;
    private String modelo;
    private Double kilometraje;
    private Double costoPorKm;
    private Double costoPorHora;
    private LocalDate fechaCompra;
    

	public Camion() {}
	
	public Camion(String patente) {
		this.patente = patente;
	}

    public Camion(String patente, String marca, String modelo,
			Double kilometraje, Double costoPorKm, Double costoPorHora,
			LocalDate fechaCompra) {
    	this.patente = patente;
    	this.marca = marca;
    	this.modelo = modelo;
    	this.kilometraje = kilometraje;
    	this.costoPorKm = costoPorKm;
    	this.costoPorHora = costoPorHora;
    	this.fechaCompra = fechaCompra;
    }

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(Double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public Double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(Double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	public Double getCostoPorHora() {
		return costoPorHora;
	}

	public void setCostoPorHora(Double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
    
	@Override
	public String toString() {
		return patente;
	}
   

}