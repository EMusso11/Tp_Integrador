package Musso.Tp_Integrador.modelo;

public class InsumoGeneral extends Insumo{

    public InsumoGeneral(Integer id, String unidad) {
		super(id, unidad);
	}

	private Double peso;

    @Override
    public Double pesoPorUnidad() {
       return peso;
    }
    
}