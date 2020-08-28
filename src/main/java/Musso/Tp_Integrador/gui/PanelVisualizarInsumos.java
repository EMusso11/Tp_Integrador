package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Camion;
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.modelo.Insumo.UnidadInsumo;
import Musso.Tp_Integrador.modelo.InsumoGeneral;
import Musso.Tp_Integrador.modelo.InsumoLiquido;
import Musso.Tp_Integrador.utilities.ModeloEncabezadoTabla;
import Musso.Tp_Integrador.utilities.ModeloTabla;

public class PanelVisualizarInsumos extends JPanel {

	private JTable tablaVisualizarInsumos;
	private JScrollPane scrollPaneTabla;
	private ModeloTabla modelo;
	
	private Object[][] dataTabla;
	private String[] titulosTabla = { "ID", "Nombre", "Descripcion", "Unidad", "Costo", "Tipo" };

	public PanelVisualizarInsumos(AppEmpresa appE, JFrame frame) {
		super();
		armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("VER INSUMOS");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		this.tablaVisualizarInsumos = new JTable();
		tablaVisualizarInsumos.setBackground(Color.WHITE);
		
		scrollPaneTabla = new JScrollPane();
		
		List<Insumo> insumos = appE.getInsumos();		
	
		try {
			dataTabla = new Object[insumos.size()][6]; 
			for(int i=0; i<insumos.size(); i++) {
				dataTabla[i][0] = insumos.get(i).getId();
				dataTabla[i][1] = insumos.get(i).getNombre();
				dataTabla[i][2] = insumos.get(i).getDescripcion();
				dataTabla[i][3] = insumos.get(i).getUnidadDeMedida();
				dataTabla[i][4] = insumos.get(i).getCosto();
				dataTabla[i][5] = insumos.get(i).getTipo();
			}
			
			modelo = new ModeloTabla(dataTabla, titulosTabla);
			tablaVisualizarInsumos.setModel(modelo);
			
			tablaVisualizarInsumos.getTableHeader().setReorderingAllowed(false);
			tablaVisualizarInsumos.setRowHeight(20);
			tablaVisualizarInsumos.setGridColor(new java.awt.Color(0, 0, 0)); 
	
			tablaVisualizarInsumos.getColumnModel().getColumn(0).setPreferredWidth(100);
			tablaVisualizarInsumos.getColumnModel().getColumn(1).setPreferredWidth(200);
			tablaVisualizarInsumos.getColumnModel().getColumn(2).setPreferredWidth(500);
			tablaVisualizarInsumos.getColumnModel().getColumn(3).setPreferredWidth(200);
			tablaVisualizarInsumos.getColumnModel().getColumn(4).setPreferredWidth(200);
			tablaVisualizarInsumos.getColumnModel().getColumn(5).setPreferredWidth(200);
			
			JTableHeader tableHeader = tablaVisualizarInsumos.getTableHeader();
		    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
		    tablaVisualizarInsumos.setTableHeader(tableHeader);
		    scrollPaneTabla.setViewportView(tablaVisualizarInsumos);	
		    
		    tablaVisualizarInsumos.setVisible(true);
		    
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(frame, "No hay insumos añadidos hasta el momento.", "ALERTA", JOptionPane.WARNING_MESSAGE);
		}
		
		
		this.add(labelPresentacion);
		this.add(tablaVisualizarInsumos);
		this.add(scrollPaneTabla);
		
	}
}
