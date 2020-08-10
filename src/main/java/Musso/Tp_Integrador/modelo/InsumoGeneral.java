package Musso.Tp_Integrador.modelo;

public class InsumoGeneral extends Insumo{

    private Double peso;

    @Override
    public Double pesoPorUnidad() {
       return peso;
    }
    
}