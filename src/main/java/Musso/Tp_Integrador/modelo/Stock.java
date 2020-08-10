package Musso.Tp_Integrador.modelo;
public class Stock {

	private Insumo insumo;
    private Double cantidad;
    private Planta puntoDePedido;
    
    public Stock(Integer id, String unidad, Double cantidad, Planta puntoDePedido) {
    	Insumo i = new Insumo(id, unidad);
    	i.setId(id);
    	i.setUnidad(unidad);
    	this.insumo = i;
    	this.cantidad = cantidad;
    	this.puntoDePedido = puntoDePedido;
    }
}