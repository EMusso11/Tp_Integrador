package Musso.Tp_Integrador.modelo;

public class InsumoLiquido extends Insumo {
    
    public InsumoLiquido(Integer id, UnidadInsumo unidad, String nombre) {
		super(id, unidad, nombre);
	}

	private Double densidad;
    
    @Override
	public Double pesoPorUnidad() {
    	switch(this.unidadDeMedida) {
    	case KG:
    		return 1.0;
    	case CC:
    		return densidad;
    	case LITRO:
    		return densidad / 1000;
		default:
			return null;
    	}
    }
}