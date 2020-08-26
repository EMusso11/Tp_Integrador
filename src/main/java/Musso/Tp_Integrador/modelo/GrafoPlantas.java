package Musso.Tp_Integrador.modelo;

import java.util.*;

import Musso.Tp_Integrador.AppEmpresa;

public class GrafoPlantas extends Grafo<Planta> {
	
	private List<Ruta> rutas;
	private List<Planta> plantas;
	private PageRank pageRank;
	
	private Double[] linkSum;
	
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
	
	public Double flujoMaximo(Planta a, Planta b) {
		Grafo tmp = this.grafoSimple();
		return tmp.flujoMaximo(a, b);
	}

	public Grafo grafoSimple() {
		Grafo g = new Grafo();
		for(Planta p : this.plantas) {
			g.addNodo(p);
		}
		for(Ruta r : this.rutas) {
			g.conectar(r.getInicio(), r.getFin(), r.getPesoMax());
		}
		return g;
	}
	
	public List<Double> pageRank(AppEmpresa appE) {
		List<Double> lista = new ArrayList<Double>();
		
		pageRank = new PageRank(appE);
		linkSum = new Double[AppEmpresa.MAX_PLANTAS];
		for(int i=0; i<this.getPlantas().size(); i++) {
			linkSum[i] = Double.valueOf(this.gradoSalida(this.getPlantas().get(i)));
		}
		pageRank.calcular(this.toMatrix(), linkSum);
		
		for(Double pr : pageRank.getPagerank()) {
			lista.add(pr);
		}
		
		return lista;
	}
	
	public Double[][] toMatrix() {
		Double[][] matriz = new Double[AppEmpresa.MAX_PLANTAS][AppEmpresa.MAX_PLANTAS];
		
		for(int i=0; i<plantas.size(); i++) {
			for(int j=0; j<plantas.size(); j++) {
				matriz[i][j] = 1.0;
			}
		}
		
		return matriz;
	}
	
//	public List<Planta> pageRankPlantas() {
//		Double exact = 0.25; // cuando corto
//		Planta[] plantas = new Planta[App.maxPlantas];
//		Integer[] pr = new Integer[App.maxPlantas]; // pagerank por numero de planta en la lista. Despues veo a que planta pertenece cada numero
//		
//		int i=0;
//		for(Planta unaPlanta : this.plantas) {
//			plantas[i] = unaPlanta;
//			i++;
//		}
//		
//		i=0;
//		do{
//			for(j=0; j<this.plantas.lenght; j++) {
//				pageRank(planta[j], i);
//			}
//			i++;
//		}while(anterior-actual>exact);
//		
//		//TODO sort por critero de pageRank
//		this.plantas.sort();
//	}
	
//	public Double pageRank(Planta p, Integer iteracion) {
//	// (1-d)+d.sum(PRi / Ci)
//	Double fact = 0.5;
//	List<Planta> entrantes =;
//	Double sumatoria = 0;
//	for(Planta unaPlanta : this.getAdyacentes(p)) {
//		if(iteracion==1)
//			sumatoria += 1 / gradoSalida(unaPlanta);
//		else
//			sumatoria += pageRank(unaPlanta, iteracion) / gradoSalida(unaPlanta);
//	}
//	Double pr = fact + fact * (sumatoria);
//	return pr;
//}
	
//	public Double[] pageRankPlantas() {
//		//GRAFO -> this
//		//ALPHA -> exact
//		Double exact = 0.25;
//		//PERSONALIZATION -> dictionary
//		Double[] dictionary = new Double[App.maxPlantas];
//		Double[] x = new Double[App.maxPlantas];
//		//ITERACIONES -> iters
//		Integer iters = 10;
//		//TOLERANCIA -> 
//		//START -> nstart
//		
//		for(int i=0; i<iters; i++) {
//			Double sumatoria = 0.0;
//			for(int k=0; k<App.maxPlantas; k++) { x[k]=0.0; }
//			
//			for(int j=0; j<this.plantas.size(); j++) { // colgantes son los nodos que tienen grado de salida 0
//				if(dictionary[j].esColgante()) // el nodo que representa
//					sumatoria += dictionary[j];
//			}
//			Double dunglesum = exact * sumatoria;
//			
//			for(int j=0; j<x.length; j++) {
//				for() {
//					
//				}
//			}
//			
//			return x;
//		}	
//		
//	}
//	
//	public Boolean esColgante(Planta unaPlanta) {
//		if(this.gradoSalida(unaPlanta)==0)
//			return true;
//		return false;
//	}
	

	
	public Double[][] caminoMinimo() {
		Grafo g = this.grafoSimple();
		return g.floyd();
	}
	
	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

//	public List<Planta> getPlantas() {
//		List<Planta> lista = new ArrayList<Planta>();
//		for( Planta unaPlanta : plantas ) {
//			lista.add(unaPlanta.getValor());
//		}
//		return lista;
//	}
	
	public List<Planta> getPlantas() {
		return plantas;
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
	
}
