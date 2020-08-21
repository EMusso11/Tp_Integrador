package Musso.Tp_Integrador.modelo;

import java.util.*;

public class Planta extends Vertice<Planta> {

    private String nombre;
    private Integer id_planta;

    private List<Camion> camiones;
    private Map<Integer, Stock> productos; // la clave es el id_producto

    public Planta() {}
    
    public Planta(String nombre, Integer id) {
        this.nombre = nombre;
        this.id_planta = id;
        this.camiones = new ArrayList<Camion>();
//        this.productos= new Map<Integer, Stock>();
    }
    
    public void registrarStock(Producto producto, Integer id_insumo, String unidad, Double cantidad, Planta puntoDePedido) {
    	Stock s = new Stock(id_insumo, unidad, cantidad, puntoDePedido);
    	productos.put(producto.getId(), s);
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
		return "Planta [nombre=" + nombre + ", id_planta=" + id_planta + "]";
	}
	

}