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

public class PanelA�adirPlanta extends JPanel {
	
	public PanelA�adirPlanta(){
		super();
		this.armarPanel();
	}

	public void armarPanel() {

		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("A�ADIR NUEVA PLANTA");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelDia = new JLabel("Planta de origen");
		

		JComponent buttonA�adir = new JButton("A�adir");
		JComponent buttonCancelar = new JButton("Cancelar");
	
		FlowLayout flw = new FlowLayout();
		this.setLayout(flw);
		this.add(labelPresentacion);
		this.add(buttonA�adir);
		this.add(buttonCancelar);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}