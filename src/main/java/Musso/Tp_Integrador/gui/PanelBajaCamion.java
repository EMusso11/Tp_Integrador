package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Camion;

public class PanelBajaCamion extends JPanel {

	private JPanel panelCamionEliminado;
	private JComboBox<Camion> boxCamiones;
	private JPanel menuPrincipal;
	
	public PanelBajaCamion(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame)  {
		
		this.setBackground(Color.BLACK);
		
		JComponent labelPresentacion = new JLabel("BAJA CAMION");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelSeleccionar = new JLabel("Seleccionar Camion");
		labelSeleccionar.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelSeleccionar.setForeground(Color.WHITE);
		
		try {
			boxCamiones = new JComboBox<Camion>();
			for(Camion c : appE.getCamiones()) {
				boxCamiones.addItem(c);
			}
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(frame, "No hay camiones añadidos hasta el momento.", "ALERTA", JOptionPane.WARNING_MESSAGE);
		} finally {
			frame.setContentPane(menuPrincipal = new MenuPrincipal(appE, frame));
			frame.revalidate();
			frame.repaint();
		}
		
		JButton buttonEliminar = new JButton("Eliminar");
		buttonEliminar.addActionListener( a -> {
			frame.setContentPane(panelCamionEliminado = new PanelCamionEliminado(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		
		frame.add(labelPresentacion);
		frame.add(labelSeleccionar);
		frame.add(boxCamiones);
		frame.add(buttonEliminar);
	}
}
