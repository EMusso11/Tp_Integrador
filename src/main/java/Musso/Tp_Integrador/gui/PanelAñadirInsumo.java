package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Planta;

public class PanelAñadirInsumo extends JPanel {

	private JPanel panelInsumoLiquido;
	private JPanel panelInsumoGeneral;

	public PanelAñadirInsumo(AppEmpresa appE, JFrame frame, Double peso){
		super();
		this.armarPanel(appE, frame, peso);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame, Double peso) {

		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR INSUMO");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelNombre = new JLabel("Tipo");
		labelNombre.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelNombre.setForeground(Color.WHITE);
		JTextField textNombre = new JTextField(10);
		String nombre = textNombre.getText();
		
		JComponent labelInsumo = new JLabel("Tipo");
		labelInsumo.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelInsumo.setForeground(Color.WHITE);
		JComboBox<String> boxTiposInsumos = new JComboBox<String>();

		boxTiposInsumos.addItem("General");
		boxTiposInsumos.addItem("Liquido");
				
		JButton buttonSeleccionar = new JButton("Seleccionar");

		buttonSeleccionar.addActionListener( a -> { 
			
			String itemSeleccionado = (String)boxTiposInsumos.getSelectedItem();
//			System.out.println(itemSeleccionado);
			
			switch(itemSeleccionado) {
			case "General":
				frame.setContentPane(panelInsumoGeneral = new PanelAñadirInsumoGeneral(appE, frame));
				frame.revalidate();
				frame.repaint();
				break;
			case "Liquido":
				frame.setContentPane(panelInsumoLiquido = new PanelAñadirInsumoLiquido(appE, frame));
				frame.revalidate();
				frame.repaint();
				break;
			}
		});
			

		this.add(labelPresentacion);
		this.add(labelInsumo);
		this.add(boxTiposInsumos);
		this.add(buttonSeleccionar);
	}
	
}
