package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
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

		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR NUEVA PLANTA");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelDia = new JLabel("Planta de origen");
		

		JComponent buttonAñadir = new JButton("Añadir");
		JComponent buttonCancelar = new JButton("Cancelar");
	
		FlowLayout flw = new FlowLayout();
		this.setLayout(flw);
		this.add(labelPresentacion);
		this.add(buttonAñadir);
		this.add(buttonCancelar);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}