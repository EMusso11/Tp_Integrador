package Musso.Tp_Integrador.modelo;

import java.util.*;

public class GrafoPlantas extends Grafo<Planta> {
	
	List<Ruta> rutas;
	List<Planta> plantas;
	
	public GrafoPlantas() {
		super();
	}

	public void conectar(Planta p1,Planta p2, Double a, Double b, Double c) {
		super.conectar(p1, p2);
		Ruta r = new Ruta(p1, p2, a, b, c);
		rutas.add(r);
	}
	
	public List<Vertice<Planta>> getValor() {
		return vertices;	
	}
	
//	TODO agrego plantas por un lado. Luego agrego rutas con sus datos 
//	Para cualquier operacion de rutas, uso los metodos de grafo con el valor que me interesa(km,peso,etc)
	
}
