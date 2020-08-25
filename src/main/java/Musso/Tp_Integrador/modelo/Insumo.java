package Musso.Tp_Integrador.modelo;

public class Insumo {

    public enum UnidadInsumo{ KG, CC, M, M2, M3, PIEZA, LITRO };
    private Integer id_insumo;
    private String nombre;
    private String descripcion;
    protected UnidadInsumo unidadDeMedida;
    
    
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Insumo(Integer id, UnidadInsumo unidad, String nombre) {
		this.id_insumo = id;
		this.unidadDeMedida = unidad;
		this.nombre = nombre;
	}


	public Double pesoPorUnidad() {
		return null;
	}
	
	Double unidadEnKG() {
		return null;
	}


	public Integer getId() {
		return this.id_insumo;
	}

	public void setId(Integer id) {
		this.id_insumo = id;
	}
	
	public void setUnidad(UnidadInsumo unidad) {
		this.unidadDeMedida = unidad;
	}
}
