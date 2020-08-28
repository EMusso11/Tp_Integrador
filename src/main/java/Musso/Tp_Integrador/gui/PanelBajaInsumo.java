package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Insumo;

public class PanelBajaInsumo extends JPanel {
	
	private MenuPrincipal menuPrincipal;

	public PanelBajaInsumo(AppEmpresa appE, JFrame frame) {
		super();
		armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {
		
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("DAR DE BAJA INSUMO");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelInsumo = new JLabel("Insumo");
		labelInsumo.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelInsumo.setForeground(Color.WHITE);
		JComboBox<Insumo> boxInsumos = new JComboBox<Insumo>();

		try {
			for(Insumo ins : appE.getInsumos()) {
				boxInsumos.addItem(ins);
			}
			
			List<Insumo> newIns = appE.getInsumos();
			newIns.remove(boxInsumos.getSelectedItem());
			appE.setInsumos(newIns);
			
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(frame, "No hay insumos añadidos hasta el momento.", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} finally {
			frame.setContentPane(menuPrincipal = new MenuPrincipal(appE, frame));
			frame.revalidate();
			frame.repaint();
		}
		
		
		this.add(labelPresentacion);
		this.add(labelInsumo);
		this.add(boxInsumos);
	}
}
