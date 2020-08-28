package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;

public class PanelA�adirCamionCorrecto extends JPanel {

	private MenuPrincipal menuPrincipal;

	public PanelA�adirCamionCorrecto(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame)  {
		
		this.setBackground(Color.BLACK);
		
		JComponent labelPresentacion = new JLabel("ALTA CAMION");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelA�adirCorrecto = new JLabel("A�adido correctamente.");
		labelA�adirCorrecto.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelA�adirCorrecto.setForeground(Color.WHITE);
		
		JButton buttonMenu = new JButton("Menu");
		buttonMenu.addActionListener( a -> {
				frame.setContentPane(menuPrincipal = new MenuPrincipal(appE, frame));
				frame.revalidate();
				frame.repaint();
		});
		
		this.add(labelPresentacion);
		this.add(labelA�adirCorrecto);
		this.add(buttonMenu);
	}
}
