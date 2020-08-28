package Musso.Tp_Integrador.modelo;

import java.util.*;

import Musso.Tp_Integrador.modelo.Insumo.UnidadInsumo;

public class Planta extends Vertice<Planta> {

    private String nombre;
    private Integer id_planta;
    private Double pageRank;

    private List<Camion> camiones;
    private List<Stock> productos;

    public Planta() {}
    
    public Planta(String nombre, Integer id) {
        this.nombre = nombre;
        this.id_planta = id;
        this.camiones = new ArrayList<Camion>();
        this.productos= new ArrayList<Stock>();
    }
    
    public void registrarStock(Insumo insumo, Double cantidad, Double cantidadMinima, Planta puntoDePedido) {
    	Stock s = new Stock(insumo, cantidad, cantidadMinima, puntoDePedido);
    	productos.add(s);
    }
    
    public Planta getValor() {
    	return super.getValor();
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_planta() {
		return id_planta;
	}

	public void setId_planta(Integer id_planta) {
		this.id_planta = id_planta;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public void setPageRank(Double double1) {
		this.pageRank = double1;
	}
	
	public Double getPageRank() {
		return this.pageRank;
	}

	public List<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}

	public List<Stock> getProductos() {
		return productos;
	}

	public void setProductos(List<Stock> productos) {
		this.productos = productos;
	}

	
	
}