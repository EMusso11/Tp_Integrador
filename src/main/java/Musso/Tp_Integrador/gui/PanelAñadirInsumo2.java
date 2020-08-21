package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.modelo.Planta;

public class PanelAñadirInsumo2 extends JPanel {

	private JPanel panelInsumo;

	public PanelAñadirInsumo2(List<Planta> plantas, JFrame frame){
		super();
		this.armarPanel(plantas, frame);
	}
	
	public void armarPanel(List<Planta> plantas, JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("Añadir Insumo");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JButton buttonAñadir = new JButton("Añadir");
		JButton buttonCancelar = new JButton("Cancelar");
		
		buttonCancelar.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelAñadirInsumo(plantas, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		buttonAñadir.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelAñadirInsumo3(frame));
			frame.revalidate();
			frame.repaint();
		});
		
		this.add(labelPresentacion);
		this.add(buttonAñadir);
		this.add(buttonCancelar);
	}
}
