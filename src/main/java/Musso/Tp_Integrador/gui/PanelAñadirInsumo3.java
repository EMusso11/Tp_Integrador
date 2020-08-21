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

public class PanelAñadirInsumo3 extends JPanel {

	
	private JPanel PanelMain;

	public PanelAñadirInsumo3(JFrame frame){
		super();
		this.armarPanel(frame);
	}
	
	public void armarPanel(JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("Añadir Insumo");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
	
		JComponent labelPlanta = new JLabel("Añadido correctamente");
		labelPlanta.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPlanta.setForeground(Color.WHITE);
		
		JButton buttonVolver = new JButton("Menu");
//		----------------------------------------------------------------
//		buttonVolver.addActionListener( a -> {
//			frame.setContentPane(panelMain = new PanelMain());
//			frame.revalidate();
//			frame.repaint();
//		});
//		----------------------------------------------------------------
		
		this.add(labelPresentacion);
		this.add(labelPlanta);
		this.add(buttonVolver);
		
	}
}
