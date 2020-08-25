package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.modelo.Insumo.UnidadInsumo;
import Musso.Tp_Integrador.modelo.InsumoLiquido;

public class PanelAñadirInsumoLiquido extends JPanel {
	
	private Double peso;
	private UnidadInsumo unidad;
	private Double densidad;
	private PanelAñadirInsumoLiquido panelInsumoLiquido;
	private MenuPrincipal menuPrincipal;
	private panelAñadirInsumoCorrecto panelAñadirInsumoLiquidoCorrecto;
	private Insumo insumo;

	public PanelAñadirInsumoLiquido(AppEmpresa appE, JFrame frame) {
		super();
		armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR INSUMO LIQUIDO");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		insumo = new InsumoLiquido();
		
		JComponent labelNombre = new JLabel("Nombre");
		labelNombre.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelNombre.setForeground(Color.WHITE);		
		JTextField textNombre = new JTextField(20);
		String nombre = textNombre.getText();
		insumo.setNombre(nombre);
		
		JComponent labelDescripcion = new JLabel("Descripcion");
		labelDescripcion.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDescripcion.setForeground(Color.WHITE);		
		JTextArea areaDescripcion = new JTextArea(5, 40);
		areaDescripcion.setLineWrap(true);
		JScrollPane scrollDescripcion = new JScrollPane(areaDescripcion);
		String descripcion = areaDescripcion.getText();
		insumo.setDescripcion(descripcion);
		
		peso = 0.0;
		
		JComponent labelPeso = new JLabel("Peso en KG");
		labelPeso.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPeso.setForeground(Color.WHITE);
		JTextField textPeso = new JTextField(6);
		textPeso.setEditable(false);
		textPeso.setText(peso.toString());
		
		JComponent labelCosto = new JLabel("Costo por Unidad");
		labelCosto.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCosto.setForeground(Color.WHITE);
		JTextField textCosto = new JTextField("0.0", 6);
		textCosto.setEditable(true);
		Double costoPorUnidad = Double.valueOf(textCosto.getText());
//		System.out.println(Double.valueOf(textCosto.getText()));
		insumo.setCosto(costoPorUnidad);
		
		textCosto.addActionListener( a -> {
			insumo.setCosto(costoPorUnidad);
			peso = insumo.pesoPorUnidad();
			textPeso.setText(peso.toString());
		});
		
		JComponent labelUnidad = new JLabel("Unidad de Medida");
		labelUnidad.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelUnidad.setForeground(Color.WHITE);
		JComboBox<UnidadInsumo> boxUnidad = new JComboBox<UnidadInsumo>();
		for(UnidadInsumo unidad : UnidadInsumo.values()) {
			boxUnidad.addItem(unidad);
		}
		unidad = (UnidadInsumo) boxUnidad.getSelectedItem();
		insumo.setUnidadDeMedida(unidad);
		
		boxUnidad.addActionListener( a -> {
			unidad = (UnidadInsumo) boxUnidad.getSelectedItem();
			insumo.setUnidadDeMedida(unidad);
			peso = insumo.pesoPorUnidad();
			textPeso.setText(peso.toString());
		});
		
		JComponent labelDensidad = new JLabel("Densidad");
		labelDensidad.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDensidad.setForeground(Color.WHITE);
		JTextField textDensidad = new JTextField("0.0", 6);
		densidad = Double.valueOf(textDensidad.getText());
		insumo.setDensidad(densidad);
//		System.out.println(Double.valueOf(textCosto.getText()));
		textDensidad.addActionListener( a -> {
			Double densidad = Double.valueOf(textDensidad.getText());
			insumo.setDensidad(densidad);
			peso = insumo.pesoPorUnidad();
			textPeso.setText(peso.toString());
		});
				
		JButton buttonAñadir = new JButton("Añadir");
		buttonAñadir.addActionListener( a -> {
			appE.addInsumo(insumo);
			frame.setContentPane(panelAñadirInsumoLiquidoCorrecto = new panelAñadirInsumoCorrecto(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		this.add(labelPresentacion);
		this.add(labelNombre);
		this.add(textNombre);
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
		this.add(buttonAñadir);
	}

}

