package Musso.Tp_Integrador.modelo;
public class InsumoLiquido extends Insumo{
    
    private Double densidad;
    
    @Override
	public Double pesoPorUnidad() {
    	return densidad;
    }
}