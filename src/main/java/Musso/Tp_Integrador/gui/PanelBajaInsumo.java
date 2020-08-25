package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.modelo.Insumo;

public class PanelBajaInsumo extends JPanel {
	
	public PanelBajaInsumo(JFrame frame, List<Insumo> insumos) {
		super();
		armarPanel(frame, insumos);
	}
	
	public void armarPanel(JFrame frame, List<Insumo> insumos) {
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("DAR DE BAJA INSUMO");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelInsumo = new JLabel("Insumo");
		labelInsumo.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelInsumo.setForeground(Color.WHITE);
		JComboBox<String> boxInsumos = new JComboBox<String>();
		for(Insumo ins : insumos) {
			boxInsumos.addItem(ins.toString());
		}
		
		this.add(labelPresentacion);
		this.add(labelInsumo);
		this.add(boxInsumos);
	}
}
