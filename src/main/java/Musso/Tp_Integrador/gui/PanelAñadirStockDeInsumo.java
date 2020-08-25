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
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.modelo.Planta;

public class PanelA�adirStockDeInsumo extends JPanel {

	private JMenuItem menuItemA�adirInsumo2;
	private PanelA�adirStockDeInsumo2 panelInsumo2;
	private PanelTablaStock panelTablaStock;

	public PanelA�adirStockDeInsumo(AppEmpresa appE, JFrame frame){
		super();
		this.armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {

		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("A�ADIR INSUMO");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelPlanta = new JLabel("Planta");
		labelPlanta.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPlanta.setForeground(Color.WHITE);
		
		String[] listPlantas = new String[appE.getPlantas().size()];
//		System.out.println(plantas.toString());
//		System.out.println(plantas.get(0).getNombre());
		for(int i=0; i<appE.getPlantas().size(); i++) 
			listPlantas[i] = appE.getPlantas().get(i).getNombre();
		JList<String> listNombrePlanta = new JList<String>(listPlantas);
		listNombrePlanta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton buttonSeleccionar = new JButton("Seleccionar");
//		----------------------------------------------------------------
		buttonSeleccionar.addActionListener( a -> {
			frame.setContentPane(panelInsumo2 = new PanelA�adirStockDeInsumo2(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		
		JButton buttonTablaStock = new JButton("Ver Tabla Stock");
//		----------------------------------------------------------------
		buttonTablaStock.addActionListener( a -> {
			frame.setContentPane(panelTablaStock = new PanelTablaStock(appE, frame));
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
		this.add(buttonTablaStock);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
	
}
