package Musso.Tp_Integrador.gui;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Camion;
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.utilities.ModeloEncabezadoTabla;
import Musso.Tp_Integrador.utilities.ModeloTabla;

public class PanelMainCamion extends JPanel {

	private JTable tablaVisualizarCamiones;
	private JScrollPane scrollPaneTabla;
	private ModeloTabla modelo;
	List<Camion> camiones;
	
	private Object[][] dataTabla;
	private String[] titulosTabla = { "Patente", "Marca", "Modelo", "Kilometraje", "Costo por Km", "Costo por Hora", "Fecha de Compra" };
	
	

	public PanelMainCamion(AppEmpresa appE, JFrame frame) {
		super();
		armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("CAMIONES");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		this.tablaVisualizarCamiones = new JTable();
		tablaVisualizarCamiones.setBackground(Color.WHITE);
		
		scrollPaneTabla = new JScrollPane();
		
		camiones = new ArrayList<Camion>();
		
		try {
			Camion camion1 = new Camion("AA 999 AA", "Volkswagen", "Constellation", 20000.0, 1.0, 1.0, LocalDate.now());
			Camion camion2 = new Camion("BB 999 BB", "Scania", "114", 30000.0, 1.0, 1.0, LocalDate.now());
			camiones.add(camion1);
			camiones.add(camion2);
//			camiones = appE.getCamiones();
			
		} catch(NullPointerException ex) {
			camiones = new ArrayList<Camion>();
			camiones.add(new Camion("Vacio"));
		}
		
		dataTabla = new Object[camiones.size()][7];
			
			for(int i=0; i<camiones.size(); i++) {
				dataTabla[i][0] = camiones.get(i).getPatente();
				dataTabla[i][1] = camiones.get(i).getMarca();
				dataTabla[i][2] = camiones.get(i).getModelo();
				dataTabla[i][3] = camiones.get(i).getKilometraje();
				dataTabla[i][4] = camiones.get(i).getCostoPorKm();
				dataTabla[i][5] = camiones.get(i).getCostoPorHora();
				dataTabla[i][6] = camiones.get(i).getFechaCompra();
			}
			
		
			
			modelo = new ModeloTabla(dataTabla, titulosTabla);
			tablaVisualizarCamiones.setModel(modelo);
			
			tablaVisualizarCamiones.getTableHeader().setReorderingAllowed(false);
			tablaVisualizarCamiones.setRowHeight(25);
			tablaVisualizarCamiones.setGridColor(new java.awt.Color(0, 0, 0)); 

			tablaVisualizarCamiones.getColumnModel().getColumn(0).setPreferredWidth(200);
			tablaVisualizarCamiones.getColumnModel().getColumn(1).setPreferredWidth(300);
			tablaVisualizarCamiones.getColumnModel().getColumn(2).setPreferredWidth(300);
			tablaVisualizarCamiones.getColumnModel().getColumn(3).setPreferredWidth(150);
			tablaVisualizarCamiones.getColumnModel().getColumn(4).setPreferredWidth(250);
			tablaVisualizarCamiones.getColumnModel().getColumn(5).setPreferredWidth(250);
			tablaVisualizarCamiones.getColumnModel().getColumn(6).setPreferredWidth(200);

			JTableHeader tableHeader = tablaVisualizarCamiones.getTableHeader();
		    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
		    tablaVisualizarCamiones.setTableHeader(tableHeader);
		    scrollPaneTabla.setViewportView(tablaVisualizarCamiones);
		
		
		this.add(labelPresentacion);
		this.add(tablaVisualizarCamiones);
		this.add(scrollPaneTabla);
		
	}
}
