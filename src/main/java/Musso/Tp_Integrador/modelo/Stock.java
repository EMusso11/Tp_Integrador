package Musso.Tp_Integrador.modelo;

public class Stock {

	private Insumo insumo;
    private Double cantidad;
    private Double cantMinimaParaPedir;
    private Planta puntoDePedido;
    
    public Stock(Insumo insumo, Double cantidad, Double cantMinimaParaPedir, Planta puntoDePedido) {
    	this.insumo = insumo;
    	this.cantidad = cantidad;
    	this.cantMinimaParaPedir = cantMinimaParaPedir;
    	this.puntoDePedido = puntoDePedido;
    }

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCantMinimaParaPedir() {
		return cantMinimaParaPedir;
	}

	public void setCantMinimaParaPedir(Double cantMinimaParaPedir) {
		this.cantMinimaParaPedir = cantMinimaParaPedir;
	}

	public Planta getPuntoDePedido() {
		return puntoDePedido;
	}

	public void setPuntoDePedido(Planta puntoDePedido) {
		this.puntoDePedido = puntoDePedido;
	}
}
