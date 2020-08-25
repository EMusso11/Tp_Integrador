package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.modelo.Planta;

public class PanelTablaStock extends JPanel {

	public PanelTablaStock(AppEmpresa appE, JFrame frame){
		super();
		this.armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		this.setBackground(Color.BLACK);
		JComboBox<String> boxPlantas = new JComboBox<String>();
		for(Planta p : appE.getPlantas()) {
			boxPlantas.addItem(p.toString());
		}
		String plantaSeleccionada = (String)boxPlantas.getSelectedItem();
		JComponent labelPresentacion = new JLabel("TABLA DE INFORMACION - STOCK PLANTA "+plantaSeleccionada);
		//TODO buscar puntos de pedidos
		String[][] info = new String[50][];
		
//		fila 0
		int i=0;
		for(Planta p : appE.getPlantas()) {
			info[i][0] = p.getNombre();
			i++;
		}
		
//		fila 1
		i=0;
		for(Insumo ins : appE.getInsumos()) {
			info[i][0] = ins.getNombre();
			i++;
		}
		
		
		String[] names = { "NombrePlanta", "NombreInsumo", "StockInsumo", "PuntoDePedido", "StockTotal" };
		
		JTable tableStock = new JTable();
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		
		this.add(labelPresentacion);
	}
}
