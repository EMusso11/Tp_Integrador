package Musso.Tp_Integrador.modelo;

import java.util.*;

import Musso.Tp_Integrador.modelo.Insumo.UnidadInsumo;

public class Planta extends Vertice<Planta> {

    private String nombre;
    private Integer id_planta;

    private List<Camion> camiones;
    private Map<Integer, Stock> productos; // la clave es el id del producto

    public Planta() {}
    
    public Planta(String nombre, Integer id) {
        this.nombre = nombre;
        this.id_planta = id;
        this.camiones = new ArrayList<Camion>();
//        this.productos= new Map<Integer, Stock>();
    }
    
    public void registrarStock(Insumo insumo, Double cantidad, Double cantidadMinima, Planta puntoDePedido) {
    	Stock s = new Stock(insumo, cantidad, cantidadMinima, puntoDePedido);
    	productos.put(productos.size(), s);
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
	

}