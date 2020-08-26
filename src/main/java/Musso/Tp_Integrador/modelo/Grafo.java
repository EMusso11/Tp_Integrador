package Musso.Tp_Integrador.modelo;

import java.util.*;
import java.util.stream.*;

import Musso.Tp_Integrador.AppEmpresa;

public class Grafo<T> {
	protected List<Arista<T>> aristas;
	protected List<Vertice<T>> vertices;

	public Grafo(){
		this.aristas = new ArrayList<Arista<T>>();
		this.vertices = new ArrayList<Vertice<T>>();
	}

	public void addNodo(T nodo){
		this.addNodo(new Vertice<T>(nodo));
	}

	public void addNodo(Vertice<T> nodo){
		this.vertices.add(nodo);
	}
	
	public void conectar(T n1,T n2){
		this.conectar(getNodo(n1), getNodo(n2), 0.0);
	}

	public void conectar(T n1,T n2,Number valor){
		this.conectar(getNodo(n1), getNodo(n2), valor);
	}

	private void conectar(Vertice<T> nodo1,Vertice<T> nodo2,Number valor) {
		this.aristas.add(new Arista<T>(nodo1,nodo2,valor));
	}
	
	public Vertice<T> getNodo(T valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<T>(valor)));
	}

	public List<T> getAdyacentes(T valor){ 
		Vertice<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	

	private List<Vertice<T>> getAdyacentes(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}
	
	public void imprimirAristas(){
		System.out.println(this.aristas.toString());
	}

	public Integer gradoEntrada(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getFin().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getInicio().equals(vertice)) ++res;
		}
		return res;
	}

	public List<T> recorridoAnchura(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		//estructuras auxiliares
		Queue<Vertice<T>> pendientes = new LinkedList<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pendientes.add(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<T> actual = pendientes.poll();
			List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
	
	public List<T> recorridoProfundidad(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pendientes.push(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<T> actual = pendientes.pop();
			List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
 	
	public List<T> recorridoTopologico(){
		List<T> resultado = new ArrayList<T>();
		Map<Vertice<T>,Integer> gradosVertice = new HashMap<Vertice<T>,Integer>();
		for(Vertice<T> vert : this.vertices){
			gradosVertice.put(vert, this.gradoEntrada(vert));
		}
		while(!gradosVertice.isEmpty()){
		
			List<Vertice<T>> nodosSinEntradas = gradosVertice.entrySet()
							.stream()
							.filter( x -> x.getValue()==0)
							.map( p -> p.getKey())
							.collect( Collectors.toList());
			
            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");
            
			for(Vertice<T> v : nodosSinEntradas){
            	resultado.add(v.getValor());
            	gradosVertice.remove(v);
            	for(Vertice<T> ady: this.getAdyacentes(v)){
            		gradosVertice.put(ady,gradosVertice.get(ady)-1);
            	}
            }
		}
		
		System.out.println(resultado);
		return resultado;
 	}
        
    private boolean esAdyacente(Vertice<T> v1,Vertice<T> v2){
    	List<Vertice<T>> ady = this.getAdyacentes(v1);
        for(Vertice<T> unAdy : ady){
        	if(unAdy.equals(v2)) return true;
        }
        return false;
    }

    public Boolean hayCamino(Vertice<T> v1,Vertice<T> v2) {
    	List<Vertice<T>> adyacentes = getAdyacentes(v1);
    	for(Vertice<T> vAdy : adyacentes) {
    		if(vAdy.equals(v2)) {
    			return true;
    		} else {
    			return hayCamino(vAdy, v2);
    		}
    	}
    	return false;
    }
    
    List<Vertice<T>> camino = new ArrayList<Vertice<T>>();
    public Double flujoMaximo(Vertice<T> a, Vertice<T> b) {
		Double result = 0.0;
		Grafo<T> g = this;
		camino = g.encontrarCamino(a, b);
			
		do {
			camino = g.encontrarCamino(a, b);
			Double minor =  (Double) g.getAristas().stream()
												.filter( a1 -> camino.contains(a1.getInicio()) && camino.contains(a1.getFin()) )
												.map( a1 -> a1.getValor() ).min(null).get();			
			result += minor;		
			
			g.getAristas().stream()
						.filter( a1 -> camino.contains(a1.getInicio()) && camino.contains(a1.getFin()) )
						.forEach( a1 -> a1.setValor(a1.getValor().floatValue()-minor) );
		} while(camino!=null);
		
		return result;
	}
    
    public Boolean hayCaminoMayorACero(Vertice<T> v1,Vertice<T> v2) {
		Boolean mayCero = false;
    	List<Vertice<T>> adyacentes = getAdyacentes(v1);
    	for(Vertice<T> vAdy : adyacentes) {
			mayCero = aristas.stream()
							.filter( a1 -> a1.getInicio().equals(vAdy) && a1.getFin().equals(v2) )
							.filter( a1 -> (int)a1.getValor() > 0).count() > 0;
    		if(vAdy.equals(v2) && mayCero) {
    			return true;
    		} else {
    			return hayCamino(vAdy, v2);
    		}
    	}
    	return false;
    }
	
	public List<Vertice<T>> encontrarCamino(Vertice<T> a, Vertice<T> b) {
		List<Vertice<T>> result = new ArrayList<Vertice<T>>();
		if(!hayCaminoMayorACero(a, b))
			return null;
		
		if(a.equals(b)) {
			result.add(b);
			return result;
		}			
		
		result.add(a);
		for(Vertice<T> ady : vertices) { // va a travéz de los nodos adyacentes y toma el primero que soporte mas que cero kg
			Boolean mayCero = aristas.stream()
									.filter( a1 -> a1.getInicio().equals(ady) && a1.getFin().equals(a) )
									.filter( a1 -> (int)a1.getValor()>0).count() > 0;
			if(!mayCero) {
				return result;
			}
			if(encontrarCamino(ady, b).contains(b)) {
				result.addAll(encontrarCamino(ady, b));
				return result;
			}
		}	
		return null;		
	}
	
	public Double[][] grafoMatrizAdyacente() {
		Double[][] result = new Double[AppEmpresa.MAX_PLANTAS][AppEmpresa.MAX_PLANTAS];
		for(int i=0; i<this.vertices.size(); i++) 
			for(int j=0; j<this.vertices.size(); j++)
				result[i][j] = Double.POSITIVE_INFINITY;
				
		for(int i=0; i<this.vertices.size(); i++) {
			for(int j=0; j<this.vertices.size(); j++) {
				Integer i2 = i;
				Integer j2 = j;
				Double peso = aristas.stream()
									.filter( a1 -> a1.getInicio().equals(vertices.get(i2)) && a1.getFin().equals(vertices.get(j2)) )
									.mapToDouble( a1 -> (int)a1.getValor() )
									.sum();
				result[i][j] = peso;
			}
		}
		return result;
	}
	
	public Double[][] floyd() {
		Double[][] result = this.grafoMatrizAdyacente();
		for(int k=0; k<this.vertices.size(); k++)
		for(int i=0; i<this.vertices.size(); i++)
			if(result[i][k]!=Double.POSITIVE_INFINITY)
			for(int j=0; j<this.vertices.size(); j++)
				if(result[k][j]!=Double.POSITIVE_INFINITY)
					result[i][j]=Math.min(result[i][j], result[i][k]+result[k][j]);
		
		return result;
	}

	public List<Arista<T>> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista<T>> aristas) {
		this.aristas = aristas;
	}

	public List<Vertice<T>> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice<T>> vertices) {
		this.vertices = vertices;
	}
    
    

}