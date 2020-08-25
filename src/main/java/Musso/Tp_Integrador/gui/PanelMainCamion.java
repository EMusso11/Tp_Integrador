package Musso.Tp_Integrador.gui;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Camion;

public class PanelMainCamion extends JPanel {

	public PanelMainCamion(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame) {
		
		this.setBackground(Color.BLACK);		
		JLabel labelPresentacion = new JLabel("CAMIONES");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComboBox<String> boxCamiones = new JComboBox<String>();
		
		try {
			for(Camion c : appE.getCamiones()) {
				boxCamiones.addItem(c.toString());
			}
		} catch(NullPointerException ex) {
			boxCamiones.addItem("Vacio");
		}

		
		
//		TODO agregar info camiones
		this.add(labelPresentacion);
		this.add(boxCamiones);
	}
}
