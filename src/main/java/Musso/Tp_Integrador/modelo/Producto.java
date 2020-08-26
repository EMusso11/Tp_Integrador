package Musso.Tp_Integrador.modelo;

public class Producto {
	
	private Insumo insumo;
	private Double cantidad;
	
	public Double precio() {
		return insumo.getCosto() * cantidad;
	}
}
