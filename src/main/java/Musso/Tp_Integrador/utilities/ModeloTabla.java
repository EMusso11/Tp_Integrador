package Musso.Tp_Integrador.utilities;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

//	private String[] titulos;
//	private Object[][] datos;
	
	public ModeloTabla(Object[][] datos, String[] titulos) {
		super();
//		this.titulos=titulos;
//		this.datos=datos;
		this.setDataVector(datos, titulos);
	}
	
	@Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
	
}
