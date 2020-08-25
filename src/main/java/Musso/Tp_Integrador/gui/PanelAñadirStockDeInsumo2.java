package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.modelo.Planta;

public class PanelAñadirStockDeInsumo2 extends JPanel {

	private JPanel panelInsumo;

	public PanelAñadirStockDeInsumo2(AppEmpresa appE, JFrame frame){
		super();
		this.armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR INSUMO");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JButton buttonAñadir = new JButton("Añadir");
		JButton buttonCancelar = new JButton("Cancelar");
		
		buttonCancelar.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelAñadirStockDeInsumo(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		buttonAñadir.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelAñadirStockDeInsumo3(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		this.add(labelPresentacion);
		this.add(buttonAñadir);
		this.add(buttonCancelar);
	}
}
