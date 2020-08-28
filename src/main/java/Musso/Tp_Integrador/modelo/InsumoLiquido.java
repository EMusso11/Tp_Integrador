package Musso.Tp_Integrador.modelo;

public class InsumoLiquido extends Insumo {
	
	private Double densidad;
	
	public InsumoLiquido() {}
    
    public InsumoLiquido(Integer id, UnidadInsumo unidad, String nombre) {
		super(id, unidad, nombre);
    }
    
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
			return 0.0;
    	}
    }
    
    public Double getDensidad() {
    	return this.densidad;
    }

	@Override
	public void setDensidad(Double densidad) {
		this.densidad = densidad;
	}

	@Override
	public void setPeso(Double peso) {
		return;
	}
	
	@Override
	public String getTipo() {
		return "Liquido";
	}

	
}