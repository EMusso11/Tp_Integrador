package Musso.Tp_Integrador.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public class PanelMainPlanta extends JPanel {

	private JLabel labelPresentacion = new JLabel("Plantas");
	private JLabel labelPresentacion2 = new JLabel("Plantas");
	private JButton button = new JButton("AAA");
	
	public PanelMainPlanta() {
		super();
		this.armarPanel();
	}
	
	public void armarPanel() {
		this.setBackground(Color.lightGray);
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.BLUE);
		labelPresentacion2.setFont(new Font("Calibri", Font.BOLD, 20));
		labelPresentacion2.setForeground(Color.RED);
		
		FlowLayout flw = new FlowLayout();
		this.setLayout(flw);
		this.add(labelPresentacion);
		this.add(labelPresentacion2);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
	
}
