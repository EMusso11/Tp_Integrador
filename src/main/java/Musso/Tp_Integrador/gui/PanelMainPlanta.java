package Musso.Tp_Integrador.gui;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Grafo;
import Musso.Tp_Integrador.modelo.GrafoPlantas;
import Musso.Tp_Integrador.modelo.Planta;

public class PanelMainPlanta extends JPanel {

	
	public PanelMainPlanta(AppEmpresa appE) {
		super();
		this.armarPanel(appE);
	}


	public void armarPanel(AppEmpresa appE) {
		
		this.setBackground(Color.BLACK);		
		JLabel labelPresentacion = new JLabel("PLANTAS");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
//		TODO agregar info de plantas		
//		String[] columns = { "ID", "Nombre", "Productos", "KG Insumo Liq", "KG Insumo Gral" };
//		String[][] data = new String[30][30];
//		int i=0;
//		for(Planta unaPlanta: plantas ) {
//			data[i][0] = unaPlanta.getId_planta().toString();
//			data[i][1] = unaPlanta.getNombre();
//			data[i][2] = unaPlanta.getCantProductos().toString();
//			data[i][3] = unaPlanta.getInsLiquidos().toString();
//			data[i][4] = unaPlanta.getInsGrales().toString();
//			data[i][2] = "a";
//			data[i][3] = "b";
//			data[i][4] = "c";
//			
//			i++;
//		}
		
//		JTable tablePlantas = new JTable(data, columns);
		
		
	
		this.add(labelPresentacion);
	}
	
}
