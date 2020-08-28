package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;

public class PanelAñadirInsumoCorrecto extends JPanel {

	private JPanel PanelMain;
	private MenuPrincipal menuPrincipal;

	public PanelAñadirInsumoCorrecto(AppEmpresa appE, JFrame frame){
		super();
		this.armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR INSUMO");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
	
		JComponent labelPlanta = new JLabel("Añadido correctamente");
		labelPlanta.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPlanta.setForeground(Color.WHITE);
		
		JButton buttonVolver = new JButton("Menu");
//		----------------------------------------------------------------
		buttonVolver.addActionListener( a -> {
			frame.setContentPane(menuPrincipal = new MenuPrincipal(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		
		this.add(labelPresentacion);
		this.add(labelPlanta);
		this.add(buttonVolver);
		
	}

}
