package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Planta;

public class PanelAñadirInsumo extends JPanel {

	private JMenuItem menuItemAñadirInsumo2;
	private PanelAñadirInsumo2 panelInsumo2;

	public PanelAñadirInsumo(List<Planta> plantas, JFrame frame){
		super();
		this.armarPanel(plantas, frame);
	}
	
	public void armarPanel(List<Planta> plantas, JFrame frame) {

		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("Añadir Insumo");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelPlanta = new JLabel("Planta");
		labelPlanta.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPlanta.setForeground(Color.WHITE);
		
		String[] listPlantas = new String[plantas.size()];
//		System.out.println(plantas.toString());
//		System.out.println(plantas.get(0).getNombre());
		for(int i=0; i<plantas.size(); i++) 
			listPlantas[i] = plantas.get(i).getNombre();
		JList<String> listNombrePlanta = new JList<String>(listPlantas);
		listNombrePlanta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton buttonSeleccionar = new JButton("Seleccionar");
//		----------------------------------------------------------------
		buttonSeleccionar.addActionListener( a -> {
			frame.setContentPane(panelInsumo2 = new PanelAñadirInsumo2(plantas, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		
		
		FlowLayout flw = new FlowLayout();
		this.setLayout(flw);
		this.add(labelPresentacion);
		this.add(labelPlanta);
		this.add(listNombrePlanta);
		this.add(buttonSeleccionar);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
	
}
