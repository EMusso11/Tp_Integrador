package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.modelo.Insumo.UnidadInsumo;

public class PanelAñadirInsumoGeneral extends JPanel {

	public PanelAñadirInsumoGeneral(AppEmpresa appE, JFrame frame, String nombre) {
		super();
		armarPanel(appE, frame, nombre);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame, String nombre) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR INSUMO GENERAL");
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
		
		JComponent labelCosto = new JLabel("Costo por Unidad");
		labelCosto.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCosto.setForeground(Color.WHITE);
		JTextField textCosto = new JTextField(6);
		
		JComponent labelPeso = new JLabel("Peso en KG");
		labelPeso.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPeso.setForeground(Color.WHITE);
		JTextField textDensidad = new JTextField(6);
		
		JButton buttonAñadir = new JButton("Añadir");
		
		
		
//		if(faltaDato) {
//			throw new faltaDatoException();
//		}
		
//		Insumo insumo = new Insumo(appE.getInsumos().size(), unidad, nombre);
//		appE.addInsumo(insumo);
		
		this.add(labelPresentacion);
		this.add(labelDescripcion);
		this.add(scrollDescripcion);
		this.add(labelUnidad);
		this.add(boxUnidad);
		this.add(labelCosto);
		this.add(textCosto);
		this.add(labelPeso);
		this.add(textDensidad);
	}
}
