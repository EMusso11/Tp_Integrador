package Musso.Tp_Integrador.modelo;

public class InsumoLiquido extends Insumo {
    
    public InsumoLiquido(Integer id, String unidad) {
		super(id, unidad);
	}

	private Double densidad;
    
    @Override
	public Double pesoPorUnidad() {
    	return densidad;
    }
}