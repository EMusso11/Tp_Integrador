package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Musso.Tp_Integrador.modelo.Insumo.UnidadInsumo;

public class PanelAñadirInsumoLiquido extends JPanel {

	public PanelAñadirInsumoLiquido(JFrame frame, Double peso, String nombre) {
		super();
		armarPanel(frame, peso, nombre);
	}
	
	public void armarPanel(JFrame frame, Double peso, String nombre) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR INSUMO LIQUIDO");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelDescripcion = new JLabel("Descripcion");
		labelDescripcion.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDescripcion.setForeground(Color.WHITE);		
		JTextArea areaDescripcion = new JTextArea(5, 40);
		areaDescripcion.setLineWrap(true);
		JScrollPane scrollDescripcion = new JScrollPane(areaDescripcion);
		
		
		
		
		JComponent labelUnidad = new JLabel("Unidad de Medida");
		labelUnidad.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelUnidad.setForeground(Color.WHITE);
		JComboBox<String> boxUnidad = new JComboBox<String>();
		for(UnidadInsumo unidad : UnidadInsumo.values()) {
			boxUnidad.addItem(unidad.toString());
		}
		
		JComponent labelCosto = new JLabel("Costo por Unidad"); // TODO listener -> al modificar, modifico el peso
		labelCosto.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCosto.setForeground(Color.WHITE);
		JTextField textCosto = new JTextField(6);
		
		JComponent labelDensidad = new JLabel("Densidad"); // TODO listener -> al modificar, modifico el peso
		labelDensidad.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDensidad.setForeground(Color.WHITE);
		JTextField textDensidad = new JTextField(6);
		
		peso = 0.0; //TODO eliminar
		
		JComponent labelPeso = new JLabel("Peso en KG");
		labelPeso.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPeso.setForeground(Color.WHITE);
		JTextField textPeso = new JTextField(6);
		textPeso.setEditable(false);
		textPeso.setText(peso.toString());
		
		this.add(labelPresentacion);
		this.add(labelDescripcion);
		this.add(scrollDescripcion);
		this.add(labelUnidad);
		this.add(boxUnidad);
		this.add(labelCosto);
		this.add(textCosto);
		this.add(labelDensidad);
		this.add(textDensidad);
		this.add(labelPeso);
		this.add(textPeso);
	}

}
