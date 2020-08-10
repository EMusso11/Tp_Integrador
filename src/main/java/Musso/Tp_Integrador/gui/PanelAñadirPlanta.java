package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAñadirPlanta extends JPanel {
	
	public PanelAñadirPlanta(){
		super();
		this.armarPanel();
	}

	public void armarPanel() {

		this.setBackground(Color.lightGray);
		JComponent labelPresentacion = new JLabel("Agregar nueva planta");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.BLUE);
		
		JComponent labelDia = new JLabel("Planta de origen");
	
		FlowLayout flw = new FlowLayout();
		this.setLayout(flw);
		this.add(labelPresentacion);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}