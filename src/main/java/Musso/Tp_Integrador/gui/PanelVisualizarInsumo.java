package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelVisualizarInsumo extends JPanel {

	public PanelVisualizarInsumo(JFrame frame) {
		super();
		armarPanel(frame);
	}
	
	public void armarPanel(JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("VER INSUMOS");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		
		
		this.add(labelPresentacion);
		
	}
}
