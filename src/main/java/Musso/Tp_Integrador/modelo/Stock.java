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
}