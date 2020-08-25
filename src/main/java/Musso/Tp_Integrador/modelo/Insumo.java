package Musso.Tp_Integrador.modelo;

public abstract class Insumo {

    public enum UnidadInsumo{ KG, CC, M, M2, M3, PIEZA, LITRO };
    private Integer id_insumo;
    private String nombre;
    private String descripcion;
    protected UnidadInsumo unidadDeMedida;
    private Double costo;
    
	public Insumo() {}
    
    public Insumo(Integer id, UnidadInsumo unidad, String nombre) {
		this.id_insumo = id;
		this.unidadDeMedida = unidad;
		this.nombre = nombre;
	}
    
	public Double getCosto() {
		return costo;
	}


	public void setCosto(Double costo) {
		this.costo = costo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
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

	public Integer getId_insumo() {
		return id_insumo;
	}


	public void setId_insumo(Integer id_insumo) {
		this.id_insumo = id_insumo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public UnidadInsumo getUnidadDeMedida() {
		return unidadDeMedida;
	}


	public void setUnidadDeMedida(UnidadInsumo unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	public abstract void setDensidad(Double densidad);

	public abstract void setPeso(Double peso);
	
}
