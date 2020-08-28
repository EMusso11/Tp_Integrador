package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;

public class PanelAñadirCamionCorrecto extends JPanel {

	private MenuPrincipal menuPrincipal;

	public PanelAñadirCamionCorrecto(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame)  {
		
		this.setBackground(Color.BLACK);
		
		JComponent labelPresentacion = new JLabel("ALTA CAMION");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelAñadirCorrecto = new JLabel("Añadido correctamente.");
		labelAñadirCorrecto.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelAñadirCorrecto.setForeground(Color.WHITE);
		
		JButton buttonMenu = new JButton("Menu");
		buttonMenu.addActionListener( a -> {
				frame.setContentPane(menuPrincipal = new MenuPrincipal(appE, frame));
				frame.revalidate();
				frame.repaint();
		});
		
		this.add(labelPresentacion);
		this.add(labelAñadirCorrecto);
		this.add(buttonMenu);
	}
}
