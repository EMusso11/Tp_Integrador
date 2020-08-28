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
import Musso.Tp_Integrador.modelo.InsumoGeneral;

public class PanelAñadirInsumoGeneral extends JPanel {

	private PanelAñadirInsumoCorrecto panelAñadirInsumoLiquidoCorrecto;
	private Insumo insumo;
	private UnidadInsumo unidad;

	public PanelAñadirInsumoGeneral(AppEmpresa appE, JFrame frame) {
		super();
		armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("AÑADIR INSUMO GENERAL");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		insumo = new InsumoGeneral();
		
		JComponent labelNombre = new JLabel("Nombre");
		labelNombre.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelNombre.setForeground(Color.WHITE);		
		JTextField textNombre = new JTextField(20);
		insumo.setNombre(textNombre.getText());
		
		
		JComponent labelDescripcion = new JLabel("Descripcion");
		labelDescripcion.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDescripcion.setForeground(Color.WHITE);
		JTextArea areaDescripcion = new JTextArea(5, 40);
		areaDescripcion.setLineWrap(true);
		JScrollPane scrollDescripcion = new JScrollPane(areaDescripcion);
		insumo.setDescripcion(areaDescripcion.getText());
		
		JComponent labelUnidad = new JLabel("Unidad de Medida");
		labelUnidad.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelUnidad.setForeground(Color.WHITE);
		JComboBox<UnidadInsumo> boxUnidad = new JComboBox<UnidadInsumo>();
		for(UnidadInsumo unidad : UnidadInsumo.values()) {
			boxUnidad.addItem(unidad);
		}
		unidad = (UnidadInsumo) boxUnidad.getSelectedItem();
		insumo.setUnidadDeMedida(unidad);
		
		JComponent labelCosto = new JLabel("Costo por Unidad");
		labelCosto.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCosto.setForeground(Color.WHITE);
		JTextField textCosto = new JTextField("0.0", 6);
		insumo.setCosto(Double.valueOf(textCosto.getText()));
		
		JComponent labelPeso = new JLabel("Peso en KG");
		labelPeso.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPeso.setForeground(Color.WHITE);
		JTextField textPeso = new JTextField("0.0", 6);
		insumo.setPeso(Double.valueOf(textPeso.getText()));
		
		JButton buttonAñadir = new JButton("Añadir");
		buttonAñadir.addActionListener( a -> {
			appE.addInsumo(insumo);
//			System.out.println("OK");
			frame.setContentPane(panelAñadirInsumoLiquidoCorrecto = new PanelAñadirInsumoCorrecto(appE, frame));
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
		this.add(labelPeso);
		this.add(textPeso);
		this.add(buttonAñadir);
	}
}
