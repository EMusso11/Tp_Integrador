package Musso.Tp_Integrador.modelo;

public class InsumoGeneral extends Insumo{

    public InsumoGeneral(Integer id, UnidadInsumo unidad, String nombre) {
		super(id, unidad, nombre);
	}

	private Double peso;

    @Override
    public Double pesoPorUnidad() {
       return peso;
    }
    
}