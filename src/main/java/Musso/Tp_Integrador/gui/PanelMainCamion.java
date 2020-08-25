package Musso.Tp_Integrador.gui;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Camion;

public class PanelMainCamion extends JPanel {

	public PanelMainCamion(AppEmpresa appE) {
		super();
		this.armarPanel(appE);
	}

	public void armarPanel(AppEmpresa appE) {
		
		this.setBackground(Color.BLACK);		
		JLabel labelPresentacion = new JLabel("CAMIONES");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
//		TODO agregar info camiones
		this.add(labelPresentacion);
	}
}
