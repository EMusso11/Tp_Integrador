package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;

public class PanelCamionEliminado extends JPanel {

	public PanelCamionEliminado(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame)  {
		
		this.setBackground(Color.BLACK);
		
		JComponent labelPresentacion = new JLabel("BAJA CAMION");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelCorrecto = new JLabel("Camion eliminado correctamente.");
		labelCorrecto.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCorrecto.setForeground(Color.WHITE);
		
		JButton buttonMenu = new JButton("Menu");
		
		frame.add(labelPresentacion);
		frame.add(labelCorrecto);
		frame.add(buttonMenu);
		
	}
}
