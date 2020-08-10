package Musso.Tp_Integrador.gui;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import Musso.Tp_Integrador.modelo.Camion;

public class PanelMainCamion extends JPanel {

	private JLabel labelPresentacion = new JLabel("Camiones");
	private JLabel labelPresentacion2 = new JLabel("Camiones");
	private JButton button = new JButton("AAA");
	
	public PanelMainCamion(List<Camion> camiones) {
		super();
		this.armarPanel(camiones);
	}

	public void armarPanel(List<Camion> camiones) {
		this.setBackground(Color.lightGray);
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.BLUE);
		
//		TODO agregar info camiones
		
//		TODO empiezo poniendo en orden Flow y luego lo organizo al final
		
//		GridBagLayout gbl = new GridBagLayout();
//		this.setLayout(gbl);
//		GridBagConstraints constraints = new GridBagConstraints();
//		constraints.gridx = 0;
//		constraints.gridy = 0;
//		constraints.gridwidth = 11;
//		this.add(labelPresentacion, constraints);

		FlowLayout flw = new FlowLayout();
		this.setLayout(flw);
		this.add(labelPresentacion);
		this.add(labelPresentacion2);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
//		BorderLayout bly = new BorderLayout();
//		this.setLayout(bly);
//		this.add(labelPresentacion, BorderLayout.CENTER);
//		this.add(labelPresentacion2, BorderLayout.EAST);
	}
}
