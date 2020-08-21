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

public class PanelAņadirInsumo2 extends JPanel {

	private JPanel panelInsumo;

	public PanelAņadirInsumo2(List<Planta> plantas, JFrame frame){
		super();
		this.armarPanel(plantas, frame);
	}
	
	public void armarPanel(List<Planta> plantas, JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("Aņadir Insumo");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JButton buttonAņadir = new JButton("Aņadir");
		JButton buttonCancelar = new JButton("Cancelar");
		
		buttonCancelar.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelAņadirInsumo(plantas, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		buttonAņadir.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelAņadirInsumo3(frame));
			frame.revalidate();
			frame.repaint();
		});
		
		this.add(labelPresentacion);
		this.add(buttonAņadir);
		this.add(buttonCancelar);
	}
}
