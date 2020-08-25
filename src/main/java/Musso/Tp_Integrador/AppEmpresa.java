package Musso.Tp_Integrador;

import java.awt.LayoutManager;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Musso.Tp_Integrador.exceptions.CamionesNoEncontradosPorCriterioException;
import Musso.Tp_Integrador.modelo.*;

public class AppEmpresa {
	
	public static final int maxPlantas = 30; //define la maxima cant de plantas para la cual esta diseñado el sistema

    private GrafoPlantas grafo = new GrafoPlantas();
    private List<Camion> camiones;
    private List<Insumo> insumos;
    
    public AppEmpresa() {
    	Planta p = new Planta("Puerto acopio", 0);
    	grafo.addPlanta(p);
    }
    
    public void addPlanta(String nombre) {
    	Integer id = grafo.getPlantas().size();
    	Planta p = new Planta(nombre, id);
    	grafo.addPlanta(p);
    }
    
    public void addRuta(Ruta r) {
    	grafo.addRuta(r);
    }
    
     
    public GrafoPlantas getGrafo() {
		return grafo;
	}

	public void setGrafo(GrafoPlantas grafo) {
		this.grafo = grafo;
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
    
    public Planta buscarPlanta(String nombre) {
		return grafo.getPlantas().stream()
							.filter( p1 -> p1.getNombre().equals(nombre) )
							.findFirst().orElse(null);
    }

    
    public List<Camion> buscarCamiones(Predicate<Camion> p) {
		return this.camiones.stream()
							.filter(p)
							.collect(Collectors.toList());
    }
    
	public List<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}

	public List<Planta> getPlantas() {
		return grafo.getPlantas();
	}

	public List<Insumo> getInsumos() {
		return this.insumos;
	}

	public void addInsumo(Insumo insumo) {
		this.insumos.add(insumo);		
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