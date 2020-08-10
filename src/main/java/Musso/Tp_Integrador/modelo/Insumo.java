package Musso.Tp_Integrador.modelo;

public class Insumo {

//    public enum UnidadInsumo{ KG, M3, M2, PIEZA, GRAMO, METRO, LITRO };

    private Integer id_insumo;
    private String descripcion;
    protected String unidadDeMedida;
    
    
	public Insumo(Integer id, String unidad) {
		this.id_insumo = id;
		this.unidadDeMedida = unidad;
	}


	public Double pesoPorUnidad() {
		return null;
	}


	public Integer getId() {
		return this.id_insumo;
	}

	public void setId(Integer id) {
		this.id_insumo = id;
	}
	
	public void setUnidad(String unidad) {
		this.unidadDeMedida = unidad;
	}
}
