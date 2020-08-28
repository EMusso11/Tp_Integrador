package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Musso.Tp_Integrador.App;
import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.GrafoPlantas;
import Musso.Tp_Integrador.modelo.Planta;
import Musso.Tp_Integrador.modelo.Ruta;

public class PanelAñadirRuta extends JPanel {
	
	private Ruta r;
	private JPanel PanelAñadirRutaCorrecto;
	
	public PanelAñadirRuta(AppEmpresa appE, JFrame frame){
		super();
		this.armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame) {

		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR NUEVA RUTA");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelPlantaOrigen = new JLabel("Planta de origen");
		labelPlantaOrigen.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPlantaOrigen.setForeground(Color.WHITE);
		JComboBox<Planta> boxPlantaOrigen = new JComboBox<Planta>();
		
		JComponent labelPlantaDestino = new JLabel("Planta destino");
		labelPlantaDestino.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPlantaDestino.setForeground(Color.WHITE);
		JComboBox<Planta> boxPlantaDestino = new JComboBox<Planta>();
		
		String[] plantasBox = new String[appE.getPlantas().size()];
		int i=0;
		for( Planta unaPlanta : appE.getPlantas() ) {
			boxPlantaOrigen.addItem(unaPlanta);
			boxPlantaDestino.addItem(unaPlanta);
			i++;
		}
		
		JComponent labelDistancia = new JLabel("Distancia");
		labelDistancia.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDistancia.setForeground(Color.WHITE);
		JTextField textDistancia = new JTextField("0.0", 6);
		Double dist = Double.parseDouble(textDistancia.getText());
		
		JComponent labelDuracion = new JLabel("Duracion Estimada en Horas");
		labelDuracion.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDuracion.setForeground(Color.WHITE);
		JTextField textDuracion = new JTextField("0.0", 6);
		Double dur = Double.parseDouble(textDuracion.getText());
		
		JComponent labelPesoMax = new JLabel("Peso Maximo Soportado");
		labelPesoMax.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPesoMax.setForeground(Color.WHITE);
		JTextField textPesoMax = new JTextField("0.0", 6);
		Double max = Double.parseDouble(textPesoMax.getText());
		
		Planta p1 = (Planta) boxPlantaOrigen.getSelectedItem();
		Planta p2 = (Planta) boxPlantaOrigen.getSelectedItem();
		r = new Ruta(p1, p2, dist, dur, max);
		
		JButton buttonAñadir = new JButton("Añadir");
		buttonAñadir.addActionListener( a -> {
			appE.addRuta(r);
			
			frame.setContentPane(PanelAñadirRutaCorrecto = new PanelAñadirRutaCorrecto(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		

		this.add(labelPresentacion);
		this.add(labelPlantaOrigen);
		this.add(boxPlantaOrigen);
		this.add(labelPlantaDestino);
		this.add(boxPlantaDestino);
		this.add(labelDistancia);
		this.add(textDistancia);
		this.add(labelDuracion);
		this.add(textDuracion);
		this.add(labelPesoMax);
		this.add(textPesoMax);
		this.add(buttonAñadir);
		
	}
}
