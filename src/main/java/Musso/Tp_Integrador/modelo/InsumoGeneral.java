package Musso.Tp_Integrador.modelo;

public class InsumoGeneral extends Insumo{

	public InsumoGeneral() {}
	
	public InsumoGeneral(Integer id, UnidadInsumo unidad, String nombre) {
		super(id, unidad, nombre);
	}

	private Double peso;

    @Override
    public Double pesoPorUnidad() {
       return peso;
    }

	@Override
	public void setDensidad(Double densidad) {
		return;
	}

	@Override
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	@Override
	public String getTipo() {
		return "General";
	}
    
}