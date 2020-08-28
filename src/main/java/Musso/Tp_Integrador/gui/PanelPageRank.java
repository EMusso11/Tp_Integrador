package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
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
import Musso.Tp_Integrador.modelo.PageRank;
import Musso.Tp_Integrador.modelo.Planta;
import Musso.Tp_Integrador.utilities.ModeloEncabezadoTabla;
import Musso.Tp_Integrador.utilities.ModeloTabla;

public class PanelPageRank extends JPanel {
	
	private JTable tablaPageRank;
	private JScrollPane scrollPaneTabla;
	private ModeloTabla modelo;
	
	private Object[][] dataTabla;
	private String[] titulos = { "Nº", "Planta" };
	private List<Planta> plantas;
	
	
	public PanelPageRank(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}


	public void armarPanel(AppEmpresa appE, JFrame frame) {
		
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("PAGE RANK PLANTAS");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		this.tablaPageRank = new JTable();
		tablaPageRank.setBackground(Color.WHITE);
		
		scrollPaneTabla = new JScrollPane();
		
		
		
		try {
			
			plantas = appE.getPlantas();
			
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(frame, "No hay plantas añadidos hasta el momento.", "ALERTA", JOptionPane.WARNING_MESSAGE);
		}
					
		dataTabla = new Object[plantas.size()][6]; 
		for(int i=0; i<plantas.size(); i++) {
			dataTabla[i][0] = i;
			dataTabla[i][1] = appE.getGrafo().pageRank(appE).get(i);
		}
		
		modelo = new ModeloTabla(dataTabla, titulos);
		tablaPageRank.setModel(modelo);
		
		tablaPageRank.getTableHeader().setReorderingAllowed(false);
		tablaPageRank.setRowHeight(20);
		tablaPageRank.setGridColor(new java.awt.Color(0, 0, 0)); 

		tablaPageRank.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablaPageRank.getColumnModel().getColumn(1).setPreferredWidth(200);
		
		JTableHeader tableHeader = tablaPageRank.getTableHeader();
	    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
	    tablaPageRank.setTableHeader(tableHeader);
	    scrollPaneTabla.setViewportView(tablaPageRank);	
	    
	    tablaPageRank.setVisible(true);

		
		this.add(labelPresentacion);
		this.add(tablaPageRank);
	}
}