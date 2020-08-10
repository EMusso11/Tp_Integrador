package Musso.Tp_Integrador.gui;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

import Musso.Tp_Integrador.Utils.CamionController;

public class PanelAltaCamion extends JPanel {
	
	public PanelAltaCamion(){
		super();
		this.armarPanel();
	}

	public void armarPanel() {
		this.setBackground(Color.lightGray);
		JComponent labelPresentacion = new JLabel("Alta Camion");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.BLUE);
		
		JComponent labelPatente = new JLabel("Patente");
		labelPatente.setFont(new Font("Calibri", Font.ITALIC, 18));
		JTextField textPatente = new JTextField("AA 000 AA", 10);
//		textPatente.setSize();
		
		JComponent labelMarca = new JLabel("Marca - Modelo");
		labelMarca.setFont(new Font("Calibri", Font.ITALIC, 18));
		JTextField textMarca = new JTextField(10);
		JTextField textModelo = new JTextField(10);
		
		JComponent labelKm = new JLabel("Kilometraje");
		labelKm.setFont(new Font("Calibri", Font.ITALIC, 18));
		JTextField textKm = new JTextField(5);
		
		JComponent labelCostoPorKm = new JLabel("Costo por Km");
		labelCostoPorKm.setFont(new Font("Calibri", Font.ITALIC, 18));
		JTextField textCostoPorKm = new JTextField(5);
		
		JComponent labelCostoPorHora = new JLabel("Costo por Hora");
		labelCostoPorHora.setFont(new Font("Calibri", Font.ITALIC, 18));
		JTextField textCostoPorHora = new JTextField(5);
		
		Integer[] dias = new Integer[30];
		for(int i=1; i<30; i++) dias[i-1] = i;
		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
							"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
		Integer[] años = new Integer[31];
		for(int i=0; i<=30; i++) años[i] = 2020-i;
		
		JComponent labelDia = new JLabel("Dia");
		labelDia.setFont(new Font("Calibri", Font.ITALIC, 18));
		JComboBox<Integer> boxFechaCompraDia = new JComboBox<Integer>(dias);
		JComponent labelMes = new JLabel("Mes");
		labelMes.setFont(new Font("Calibri", Font.ITALIC, 18));
		JComboBox<String> boxFechaCompraMes = new JComboBox<String>(meses);
		JComponent labelAño = new JLabel("Año");
		labelAño.setFont(new Font("Calibri", Font.ITALIC, 18));
		JComboBox<Integer> boxFechaCompraAño = new JComboBox<Integer>(años);
		
		
		FlowLayout flw = new FlowLayout();
		this.setLayout(flw);
		
		this.add(labelPresentacion);
		this.add(labelPatente);
		this.add(textPatente);
		this.add(labelMarca);
		this.add(textMarca);
		this.add(textModelo);
		this.add(labelKm);
		this.add(textKm);
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
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}
