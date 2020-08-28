package Musso.Tp_Integrador.gui;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.Planta;
import Musso.Tp_Integrador.modelo.Grafo;
import Musso.Tp_Integrador.modelo.GrafoPlantas;
import Musso.Tp_Integrador.modelo.Planta;
import Musso.Tp_Integrador.utilities.ModeloEncabezadoTabla;
import Musso.Tp_Integrador.utilities.ModeloTabla;

public class PanelMainPlanta extends JPanel {

	
	private JTable tablaVisualizarPlantas;
	private JScrollPane scrollPaneTabla;
	private JLabel labelPageRank;
	private JPanel panelPageRank;
	private JLabel labelCaminoMinimo;
	private JLabel labelCaminoMinimo2;
	private JPanel panelCaminoMinimo;
	private JLabel labelFlujoMaximo;
	private JTextField textFlujoMaximo;
	private JLabel labelFlujoMaximo2;

	private Double flujoMaximo = 0.0;
	private Planta planta1;
	private Planta planta2;
	
	private List<Planta> plantas;
	private Object[][] dataTabla;
	private String[] titulos = { };

	public PanelMainPlanta(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}


public void armarPanel(AppEmpresa appE, JFrame frame) {
		
		this.setBackground(Color.BLACK);
		JComponent labelPresentacion = new JLabel("PLANTAS");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);

		// PAGERANK
		labelPageRank = new JLabel("PageRank de Plantas");
		labelPageRank.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPageRank.setForeground(Color.WHITE);
		
		JButton buttonPageRank = new JButton("Ver");
		buttonPageRank.addActionListener( a -> {
			frame.setContentPane(panelPageRank = new PanelPageRank(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		// FLUJO MAXIMO
		labelFlujoMaximo = new JLabel("Flujo maximo entre : ");
		labelFlujoMaximo.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelFlujoMaximo.setForeground(Color.WHITE);
		
		JComboBox<Planta> boxPlanta1 = new JComboBox<Planta>();
		for(Planta p : appE.getPlantas()) {
			boxPlanta1.addItem(p);
		}
		planta1 = (Planta) boxPlanta1.getSelectedItem();
		
		labelFlujoMaximo2 = new JLabel(" y ");
		labelFlujoMaximo2.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelFlujoMaximo2.setForeground(Color.WHITE);
		
		JComboBox<Planta> boxPlanta2 = new JComboBox<Planta>();
		for(Planta p : appE.getPlantas()) {
			boxPlanta2.addItem(p);
		}
		planta2 = (Planta) boxPlanta2.getSelectedItem();
		
		boxPlanta1.addActionListener( a1 -> {
			flujoMaximo = appE.getGrafo().flujoMaximo(planta1, planta2);

			boxPlanta2.addActionListener( a2 -> {
				flujoMaximo = appE.getGrafo().flujoMaximo(planta1, planta2);
			});
		});
		
		JTextField textFlujoMaximo = new JTextField(flujoMaximo.toString(), 10);
		textFlujoMaximo.setText(flujoMaximo.toString());
		textFlujoMaximo.setEditable(false);
		

		
		// CAMINO MINIMO PANEL
		labelCaminoMinimo = new JLabel("Camino minimo entre plantas");
		labelCaminoMinimo.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCaminoMinimo.setForeground(Color.WHITE);
		
		JButton buttonCaminoMinimo = new JButton("Ver");
		buttonCaminoMinimo.addActionListener( a -> {
			frame.setContentPane(panelCaminoMinimo = new PanelCaminosMinimos(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		this.add(labelPresentacion);
		
		this.add(labelPageRank);
		this.add(buttonPageRank);

		this.add(labelFlujoMaximo);
		this.add(boxPlanta1);
		this.add(labelFlujoMaximo2);
		this.add(boxPlanta2);
		this.add(textFlujoMaximo);
		this.add(labelCaminoMinimo);
		this.add(buttonCaminoMinimo);
		
	}
}
