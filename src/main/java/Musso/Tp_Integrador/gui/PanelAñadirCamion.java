package Musso.Tp_Integrador.gui;

import java.awt.*;
import java.beans.FeatureDescriptor;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.exceptions.DatoFaltanteException;
import Musso.Tp_Integrador.modelo.Camion;

public class PanelAñadirCamion extends JPanel {
	
	Camion camion = new Camion();
	private Integer dia;
	private Month mes;
	private Integer año;
	private LocalDate fechaCompra;
	
	private MenuPrincipal menuPrincipal;
	private JTextField textPatente;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textKilometraje;
	private JTextField textCostoPorKm;
	private JTextField textCostoPorHora;
	private JPanel panelAñadirCamionCorrecto;
	
	public PanelAñadirCamion(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame)  {
		
		this.setBackground(Color.BLACK);
		
		JComponent labelPresentacion = new JLabel("AÑADIR CAMION");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelPatente = new JLabel("Patente");
		labelPatente.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPatente.setForeground(Color.WHITE);
		textPatente = new JTextField("AA 000 AA", 10);
		camion.setPatente(textPatente.getText());
		
		
		
		JComponent labelMarca = new JLabel("Marca - Modelo");
		labelMarca.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelMarca.setForeground(Color.WHITE);
		textMarca = new JTextField(10);
		camion.setMarca(textMarca.getText());
		JTextField textModelo = new JTextField(10);
		camion.setModelo(textModelo.getText());
		
		JComponent labelKilometraje = new JLabel("Kilometraje");
		labelKilometraje.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelKilometraje.setForeground(Color.WHITE);
		textKilometraje = new JTextField("0.0", 5);
		camion.setKilometraje(Double.valueOf(textKilometraje.getText()));
		
		JComponent labelCostoPorKm = new JLabel("Costo por Km");
		labelCostoPorKm.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCostoPorKm.setForeground(Color.WHITE);
		textCostoPorKm = new JTextField("0.0", 5);
		camion.setCostoPorKm(Double.valueOf(textCostoPorKm.getText()));
		
		
		JComponent labelCostoPorHora = new JLabel("Costo por Hora");
		labelCostoPorHora.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCostoPorHora.setForeground(Color.WHITE);
		textCostoPorHora = new JTextField("0.0", 5);
		camion.setCostoPorHora(Double.valueOf(textCostoPorHora.getText()));
		
		Integer[] dias = new Integer[31];
		for(int i=1; i<=31; i++) dias[i-1] = i;
		
		Integer[] años = new Integer[31];
		for(int i=0; i<=30; i++) años[i] = 2020-i;
		
		JComponent labelDia = new JLabel("Dia");
		labelDia.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDia.setForeground(Color.WHITE);
		JComboBox<Integer> boxFechaCompraDia = new JComboBox<Integer>(dias);
		dia = (Integer) boxFechaCompraDia.getSelectedItem();
		
		JComponent labelMes = new JLabel("Mes");
		labelMes.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelMes.setForeground(Color.WHITE);
		JComboBox<Month> boxFechaCompraMes = new JComboBox<Month>(Month.values());
		mes = (Month) boxFechaCompraMes.getSelectedItem();
		
		JComponent labelAño = new JLabel("Año");
		labelAño.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelAño.setForeground(Color.WHITE);
		JComboBox<Integer> boxFechaCompraAño = new JComboBox<Integer>(años);
		año = (Integer) boxFechaCompraDia.getSelectedItem();
		
		JButton buttonAñadir = new JButton("Añadir");
		JButton buttonCancelar = new JButton("Cancelar");
		
		buttonAñadir.addActionListener( a -> {
			try {
				
				camion.setPatente(textPatente.getText());
				camion.setMarca(textMarca.getText());
				camion.setModelo(textModelo.getText());
				
				if(camion.getPatente().equals("")) {
					throw new DatoFaltanteException("Patente");
				}
				if(camion.getMarca().equals("")) {
					throw new DatoFaltanteException("Marca");
				}
				if(camion.getModelo().equals("")) {
					throw new DatoFaltanteException("Modelo");
				}
				
				try {
					camion.setKilometraje(Double.valueOf(textKilometraje.getText()));
				} catch (NumberFormatException ex) {
					throw new DatoFaltanteException("Kilometraje");
				}
				
				try {
					camion.setCostoPorKm(Double.valueOf(textCostoPorKm.getText()));
				} catch (NumberFormatException ex) {
					throw new DatoFaltanteException("Costo por kilometro");
				}
				
				try {
					camion.setCostoPorHora(Double.valueOf(textCostoPorHora.getText()));
				} catch (NumberFormatException ex) {
					throw new DatoFaltanteException("Costo por hora");
				}
			} catch (DatoFaltanteException ex) {
				JOptionPane.showMessageDialog(frame, ex.getMessage(), "ALERTA", JOptionPane.WARNING_MESSAGE);
			}
			
			camion.setFechaCompra(LocalDate.of(dia, mes.getValue(), año));
			appE.addCamion(camion);
			
			frame.setContentPane(panelAñadirCamionCorrecto = new PanelAñadirCamionCorrecto(appE, frame));
			frame.revalidate();
			frame.repaint();		
		});
		
		buttonCancelar.addActionListener( a -> {
			frame.setContentPane(menuPrincipal = new MenuPrincipal(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		this.add(labelPresentacion);
		this.add(labelPatente);
		this.add(textPatente);
		this.add(labelMarca);
		this.add(textMarca);
		this.add(textModelo);
		this.add(labelKilometraje);
		this.add(textKilometraje);
		this.add(labelCostoPorKm);
		this.add(textCostoPorKm);
		this.add(labelCostoPorHora);
		this.add(textCostoPorHora);
		this.add(labelDia);
		this.add(boxFechaCompraDia);
		this.add(labelMes);
		this.add(boxFechaCompraMes);
		this.add(labelAño);
		this.add(boxFechaCompraAño);
		this.add(buttonAñadir);
		this.add(buttonCancelar);
	}
}
