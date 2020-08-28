package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;
import javax.swing.table.JTableHeader;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.modelo.Planta;
import Musso.Tp_Integrador.modelo.Stock;
import Musso.Tp_Integrador.utilities.ModeloEncabezadoTabla;
import Musso.Tp_Integrador.utilities.ModeloTabla;

public class PanelTablaStock extends JPanel {

	private JLabel labelPresentacion;
	private Planta plantaSeleccionada;
	private ModeloTabla modelo;
	private JTable tablaStock;
	private JScrollPane scrollPaneTabla;
	
	private Object[][] dataTabla;
	private String[] titulosTabla = { "Insumo", "Cantidad", "Pedido Minimo", "Punto de Pedido" };

	public PanelTablaStock(AppEmpresa appE, JFrame frame){
		super();
		this.armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		
		this.setBackground(Color.BLACK);
		
		labelPresentacion = new JLabel("TABLA DE INFORMACION - STOCK PLANTA : ");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
				
		JComboBox<Planta> boxPlantas = new JComboBox<Planta>();
		for(Planta p : appE.getPlantas()) {
			boxPlantas.addItem(p);
		}
		
		this.tablaStock = new JTable();
		tablaStock.setBackground(Color.WHITE);
		
		scrollPaneTabla = new JScrollPane();
		
//		plantaSeleccionada = appE.getPlantas().get(0);
		plantaSeleccionada = (Planta)boxPlantas.getSelectedItem();
		
		List<Stock> productos = plantaSeleccionada.getProductos();
		
		try {
			dataTabla = new Object[productos.size()][6]; 
			for(int i=0; i<productos.size(); i++) {
				dataTabla[i][0] = productos.get(i).getInsumo();
				dataTabla[i][1] = productos.get(i).getCantidad();
				dataTabla[i][2] = productos.get(i).getCantMinimaParaPedir();
				dataTabla[i][3] = productos.get(i).getPuntoDePedido();
			}
			
			modelo = new ModeloTabla(dataTabla, titulosTabla);
			tablaStock.setModel(modelo);
			
			tablaStock.getTableHeader().setReorderingAllowed(false);
			tablaStock.setRowHeight(20);
			tablaStock.setGridColor(new java.awt.Color(0, 0, 0)); 
	
			tablaStock.getColumnModel().getColumn(0).setPreferredWidth(100);
			tablaStock.getColumnModel().getColumn(1).setPreferredWidth(200);
			tablaStock.getColumnModel().getColumn(2).setPreferredWidth(500);
			tablaStock.getColumnModel().getColumn(3).setPreferredWidth(200);
			
			JTableHeader tableHeader = tablaStock.getTableHeader();
		    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
		    tablaStock.setTableHeader(tableHeader);
		    scrollPaneTabla.setViewportView(tablaStock);	
		    
		    tablaStock.setVisible(true);
		    
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(frame, "No hay stock de productos en la planta.", "ALERTA", JOptionPane.WARNING_MESSAGE);
		}
		

		this.add(labelPresentacion);
		this.add(boxPlantas);
		this.add(tablaStock);
		this.add(scrollPaneTabla);
		
	}
}
