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
	
	public List<Planta> pageRank(AppEmpresa appE) {
		List<Double> listaPr = new ArrayList<Double>();
		List<Planta> listaPlantas = plantas;		
		
		pageRank = new PageRank(appE);
		linkSum = new Double[AppEmpresa.MAX_PLANTAS];
		for(int i=0; i<this.getPlantas().size(); i++) {
			linkSum[i] = Double.valueOf(this.gradoSalida(this.getPlantas().get(i)));
		}
		pageRank.calcular(this.toMatrix(), linkSum);
		
		for(int i=0; i<plantas.size(); i++ ) {
			listaPlantas.get(i).setPageRank(pageRank.getPagerank()[i]);
		}
		
		listaPlantas.sort(new ComparaPorPR());
		return listaPlantas;
	}
	
	public Double[][] toMatrix() {
		Double[][] matriz = new Double[plantas.size()][plantas.size()];
		
		for(int i=0; i<plantas.size(); i++) {
			for(int j=0; j<plantas.size(); j++) {
				if(hayCamino(plantas.get(i), plantas.get(j)))
					matriz[i][j] = 1.0;
				else
					matriz[i][j] = 0.0;
			}
		}
		return matriz;
	}
	
	public Double[][] caminosMinimos() {
		Grafo g = this.grafoSimple();
		return g.floyd();
	}
	
	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}
	
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
