package Musso.Tp_Integrador.modelo;

public class Ruta extends Arista<Ruta> {
	
    private Planta plantaOrigen;
    private Planta plantaDestino;
    private Double distancia; //en KM
    private Double duracion;  //en HS
    private Double pesoMax;
    
    public Ruta() {};
    
    public Ruta(Planta origen, Planta destino, Double dist, Double dur, Double max) {
    	this.plantaOrigen = origen;
    	this.plantaDestino = destino;
    	this.distancia = dist;
    	this.duracion = dur;
    	this.pesoMax = max;
    }
    
	public Planta getPlantaOrigen() {
		return plantaOrigen;
	}
	public void setPlantaOrigen(Planta plantaOrigen) {
		this.plantaOrigen = plantaOrigen;
	}
	public Planta getPlantaDestino() {
		return plantaDestino;
	}
	public void setPlantaDestino(Planta plantaDestino) {
		this.plantaDestino = plantaDestino;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public Double getDuracion() {
		return duracion;
	}
	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}
	public Double getPesoMax() {
		return pesoMax;
	}
	public void setPesoMax(Double pesoMax) {
		this.pesoMax = pesoMax;
	}
    
    
    
}