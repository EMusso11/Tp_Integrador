package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.App;
import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.GrafoPlantas;
import Musso.Tp_Integrador.modelo.Planta;

public class PanelAñadirRuta extends JPanel {
	
	public PanelAñadirRuta(List<Planta> list){
		super();
		this.armarPanel(list);
	}

	public void armarPanel(List<Planta> plantas) {

		this.setBackground(Color.lightGray);
		JComponent labelPresentacion = new JLabel("Añadir nueva ruta");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.BLUE);
		
		JComponent labelPlantaOrigen = new JLabel("Planta de origen");
		labelPlantaOrigen.setFont(new Font("Calibri", Font.ITALIC, 18));
		
		String[] plantasBox = new String[30];
		int i=0;
		for( Planta unaPlanta : plantas ) {
			plantasBox[i] = unaPlanta.getNombre();
			i++;
		}
		JComboBox<String> boxPlantaOrigen = new JComboBox<String>(plantasBox);
		
		JComponent labelPlantaDestino = new JLabel("Planta destino");
		labelPlantaDestino.setFont(new Font("Calibri", Font.ITALIC, 18));
		JComboBox<String> boxPlantaDestino = new JComboBox<String>(plantasBox);
		
	
		FlowLayout flw = new FlowLayout();
		this.setLayout(flw);
		this.add(labelPresentacion);
		this.add(labelPlantaOrigen);
		this.add(boxPlantaOrigen);
		this.add(labelPlantaDestino);
		this.add(boxPlantaDestino);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}
