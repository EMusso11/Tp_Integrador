package Musso.Tp_Integrador.modelo;

import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Map;

public class Planta extends Vertice<Planta> {

    private String nombre;
    private Integer id_planta;

    private List<Camion> camiones;
    private Map<Integer, Stock> productos; // la clave es el id_producto

    public Planta() {}

    public Planta(String nombre, Integer id) {
        this.nombre = nombre;
        this.id_planta = id;
        super.setValor(new Planta());
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

	
	}
    

}