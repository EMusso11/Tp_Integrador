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

public class PanelA�adirInsumo2 extends JPanel {

	private JPanel panelInsumo;

	public PanelA�adirInsumo2(List<Planta> plantas, JFrame frame){
		super();
		this.armarPanel(plantas, frame);
	}
	
	public void armarPanel(List<Planta> plantas, JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("A�adir Insumo");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JButton buttonA�adir = new JButton("A�adir");
		JButton buttonCancelar = new JButton("Cancelar");
		
		buttonCancelar.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelA�adirInsumo(plantas, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		buttonA�adir.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelA�adirInsumo3(frame));
			frame.revalidate();
			frame.repaint();
		});
		
		this.add(labelPresentacion);
		this.add(buttonA�adir);
		this.add(buttonCancelar);
	}
}
