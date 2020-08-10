package Musso.Tp_Integrador.modelo;

import java.util.*;

public class GrafoPlantas extends Grafo<Planta> {
	
	List<Ruta> rutas;
	List<Planta> plantas;
	
	public GrafoPlantas() {
		super();
		rutas = new ArrayList<Ruta>();
		plantas = new ArrayList<Planta>();
	}

	public void conectar(Planta p1,Planta p2, Double a, Double b, Double c) {
		super.conectar(p1, p2);
		Ruta r = new Ruta(p1, p2, a, b, c);
		rutas.add(r);
	}
	
	public void addPlanta(Planta p) {
    	plantas.add(p);
    	super.addNodo(p);
    }

    public void addRuta(Ruta ruta) {
    	this.conectar(ruta.getPlantaOrigen(), ruta.getPlantaDestino(), ruta.getDistancia(), ruta.getDuracion(), ruta.getPesoMax());
    }
	
	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public List<Planta> getPlantas() {
		List<Planta> lista = new ArrayList<Planta>();
		for( Planta unaPlanta : plantas ) {
			lista.add(unaPlanta.getValor());
		}
		return lista;
	}

	public Planta getPlantasAt(Integer i) {
		for(Planta p : plantas) {
			return p;
		}
		return null;
	}
	
	public void setPlantas(List<Planta> plantas) {
		this.plantas = plantas;
	}
	
	
	
//	TODO agrego plantas por un lado. Luego agrego rutas con sus datos 
//	Para cualquier algoritmo de rutas, uso los metodos de grafo con el valor que me interesa(km,peso,etc)
	
}
