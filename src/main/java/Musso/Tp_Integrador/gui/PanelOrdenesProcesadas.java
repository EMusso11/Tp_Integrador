package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.OrdenDePedido;
import Musso.Tp_Integrador.modelo.OrdenDePedido.EstadoOrden;

public class PanelOrdenesProcesadas extends JPanel {
	
	private JComboBox<OrdenDePedido> boxSeleccionarOrden;
	private JPanel panelOrdenesProcesadas2;
//	private JCheckBox ;
	private JCheckBox[] checkEntregada;
	private OrdenDePedido ord; 
	private Integer i;

	public PanelOrdenesProcesadas(AppEmpresa appE, JFrame frame) {
		super();
		armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame)  {
		
		this.setBackground(Color.BLACK);
		
		JComponent labelPresentacion = new JLabel("ORDENES PROCESADAS");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		this.add(labelPresentacion);
		
//		JComponent labelSeleccionar = new JLabel("Seleccionar orden");
//		labelSeleccionar.setFont(new Font("Calibri", Font.ITALIC, 18));
//		labelSeleccionar.setForeground(Color.WHITE);
		
		OrdenDePedido ord1 = new OrdenDePedido(appE.getPlantas().get(1), LocalDate.now(), 1);
		OrdenDePedido ord2 = new OrdenDePedido(appE.getPlantas().get(2), LocalDate.now(), 2);
		ord1.setEstado(EstadoOrden.PROCESADA);
		ord2.setEstado(EstadoOrden.PROCESADA);
		List<OrdenDePedido> ordenes = new ArrayList<OrdenDePedido>();
		ordenes.add(ord1);
		ordenes.add(ord2);
//		appE.setOrdenesDePedido(ordenes);
		
		for(i=0; i<ordenes.size(); i++) { //TODO CAMBIAR POR PROCESADAS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			ord = ordenes.get(i);
			checkEntregada[i] = new JCheckBox("Orden Nº "+ord.getNroDePedido());
			checkEntregada[i].addChangeListener( a -> {
				ord.cambiarEstado(ord.getEstado());
				this.add(checkEntregada[i]);
			});
		}
	}
}
