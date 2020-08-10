package Musso.Tp_Integrador;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Musso.Tp_Integrador.exceptions.CamionesNoEncontradosPorCriterioException;
import Musso.Tp_Integrador.modelo.*;

public class AppEmpresa {

    static GrafoPlantas plantas = new GrafoPlantas();
    private List<Camion> camiones;
    
    public static void main(String[] args) {
    	
    }
    
    public AppEmpresa() {
    	super();
    	this.addPlanta("Puerto acopio");
    }
        
    public void addPlanta(String nombre) {
    	Planta p = new Planta(nombre, plantas.getVertices().size());
    	plantas.addNodo(p);
    }
    
    public void addRuta(Ruta ruta) {
    	this.plantas.conectar(ruta.getPlantaOrigen(), ruta.getPlantaDestino(), ruta.getDistancia(), ruta.getDuracion(), ruta.getPesoMax());
    	
    }
    
    public void altaCamion(String patente, String marca, String modelo,
			Double kilometraje, Double costoPorKm, Double costoPorHora,
			LocalDate fechaCompra) {
    	Camion c = new Camion(patente, marca, modelo, kilometraje, costoPorKm, costoPorHora, fechaCompra);
    	camiones.add(c);
    }
    
    public void editarCamion() {
    	
    }
    
    public void bajaCamion(String patente) throws NoSuchElementException {
    	Predicate<Camion> p = (c) -> c.getPatente() == patente;
    	try {
    		camiones.remove(this.buscarCamion(p).orElseThrow());
    	} catch (NoSuchElementException e) {
    		e.getMessage();
    	}
    }
    
    /*
     * 
     * Busquedas
     * 
     * */
    
    public Optional<Camion> buscarCamionPorPatente(String patente) throws NoSuchElementException {
    	Predicate<Camion> p = (c) -> c.getPatente() == patente;
    	try {
    		return Optional.ofNullable(this.buscarCamion(p).orElseThrow());
    	} catch (NoSuchElementException e) {
    		e.getMessage();
    	}
		return null;
    }
    
    public List<Camion> buscarCamionPorModelo(String modelo) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getModelo() == modelo;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
    
    public List<Camion> buscarCamionPorMarca(String marca) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getMarca() == marca;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
    
    public List<Camion> buscarCamionPorKmMenores(String marca, Double deseado) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getKilometraje() <= deseado;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
   
    public List<Camion> buscarCamionPorKmMayores(String marca, Double deseado) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getKilometraje() > deseado;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
    
    public List<Camion> buscarCamionPorCostoPorKmMenores(String marca, Double deseado) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getCostoPorKm() <= deseado;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
    
    public List<Camion> buscarCamionPorCostoPorKmMayores(String marca, Double deseado) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getCostoPorKm() > deseado;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
    
    public List<Camion> buscarCamionPorCostoPorHoraMenores(String marca, Double deseado) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getCostoPorHora() <= deseado;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
    
    public List<Camion> buscarCamionPorCostoPorHoraMayores(String marca, Double deseado) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getCostoPorHora() > deseado;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
    
    public List<Camion> buscarCamionPorFechaCompra(LocalDate fechaCompra) throws CamionesNoEncontradosPorCriterioException {
    	Predicate<Camion> p = (c) -> c.getFechaCompra() == fechaCompra;
    	List<Camion> lista = new ArrayList<Camion>();
    	lista.addAll(this.buscarCamiones(p));
    	if(lista.isEmpty()) {
    		throw new CamionesNoEncontradosPorCriterioException("No se encontraron camiones por este criterio.");
    	}
		return lista;
    }
        
    
    public Optional<Camion> buscarCamion(Predicate<Camion> p) {
				return this.camiones.stream()
									.filter(p)
									.findFirst();
	}
    
    public List<Camion> buscarCamiones(Predicate<Camion> p) {
		return this.camiones.stream()
							.filter(p)
							.collect(Collectors.toList());
    }

	public static String[] getPlantas() {
		String[] p = new String[100];
		int i=0;
		for( Vertice<Planta> unaPlanta :  plantas.getVertices() ) {
			p[i] = unaPlanta.getValor().getNombre();
			i++;
		}
		return p;
	}

	public void setPlantas(GrafoPlantas plantas) {
		this.plantas = plantas;
	}

	public List<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}
    
    
    
    /*
     * 
     * 
     * 
     * */

//    public void registrarPlanta(String nombre, g.vertexSet().stream().count()+1,
//    							List<Planta> rutasPosibles) {
//        Planta origen = new Planta(nombre);
//        Ruta r = new Ruta();
//        for( Planta destino : rutasPosibles ) {
//            g.addVertex(destino);
//
//            r.setDistancia();
//            r.setDuracion();
//            r.setPesoMax();
//            g.addEdge(origen, destino, r);
//        }
//    }

}