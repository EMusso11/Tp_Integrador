package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.modelo.OrdenDePedido;
import Musso.Tp_Integrador.modelo.OrdenDePedido.EstadoOrden;
import Musso.Tp_Integrador.modelo.Planta;

public class PanelRegistrarOrden extends JPanel {

	private JLabel labelPresentacion;
	private JLabel labelNroDeOrden;
	private JTextField textNroDeOrden;
	private JComboBox<Planta> boxPlanta;
	private JLabel labelPlanta;
	private Integer dia;
	private Month mes;
	private Integer año;
	private JLabel labelDia;
	private JComboBox<Integer> boxFechaDia;
	private JLabel labelMes;
	private JComboBox<Month> boxFechaMes;
	private JLabel labelAño;
	private JComboBox<Integer> boxFechaAño;
	private JLabel labelEstado;
	private OrdenDePedido ordenPedido;
	private JLabel labelFechaSolicitud;
	private JLabel labelFechaEntrega;
	private JLabel labelDia2;
	private JComboBox<Integer> boxFechaDia2;
	private Integer dia2;
	private JLabel labelMes2;
	private JComboBox<Month> boxFechaMes2;
	private Month mes2;
	private JLabel labelAño2;
	private JComboBox<Integer> boxFechaAño2;
	private Integer año2;
	private JComboBox<EstadoOrden> boxEstado;
	private JButton buttonAñadir;
	private JButton buttonCancelar;
	private MenuPrincipal menuPrincipal;

	public PanelRegistrarOrden(AppEmpresa appE, JFrame frame) {
		super();
		armarPanel(appE, frame);
	}

	private void armarPanel(AppEmpresa appE, JFrame frame) {
		
		this.setBackground(Color.BLACK);
		
		labelPresentacion = new JLabel("REGISTRAR ORDEN");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		labelNroDeOrden = new JLabel("Nro. de orden");
		labelNroDeOrden.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelNroDeOrden.setForeground(Color.WHITE);
		textNroDeOrden= new JTextField("0", 6);
		
		labelPlanta = new JLabel("Planta de Destino");
		labelPlanta.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelPlanta.setForeground(Color.WHITE);
		boxPlanta = new JComboBox<Planta>();
		for(Planta p : appE.getPlantas()) {
			boxPlanta.addItem(p);
		}
		
		labelFechaSolicitud = new JLabel("Fecha de Solicitud");
		labelFechaSolicitud.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelFechaSolicitud.setForeground(Color.WHITE);
		
		Integer[] dias = new Integer[31];
		for(int i=1; i<=31; i++) dias[i-1] = i;
		
		Integer[] años = new Integer[31];
		for(int i=0; i<=30; i++) años[i] = 2020-i;
		
		labelDia = new JLabel("Dia");
		labelDia.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDia.setForeground(Color.WHITE);
		boxFechaDia = new JComboBox<Integer>(dias);
		dia = (Integer) boxFechaDia.getSelectedItem();
		
		labelMes = new JLabel("Mes");
		labelMes.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelMes.setForeground(Color.WHITE);
		boxFechaMes = new JComboBox<Month>(Month.values());
		mes = (Month) boxFechaMes.getSelectedItem();
		
		labelAño = new JLabel("Año");
		labelAño.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelAño.setForeground(Color.WHITE);
		boxFechaAño = new JComboBox<Integer>(años);
		año = (Integer) boxFechaDia.getSelectedItem();
		
		labelFechaEntrega = new JLabel("Fecha de Entrega");
		labelFechaEntrega.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelFechaEntrega.setForeground(Color.WHITE);
		
		labelDia2 = new JLabel("Dia");
		labelDia2.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelDia2.setForeground(Color.WHITE);
		boxFechaDia2 = new JComboBox<Integer>(dias);
		dia2 = (Integer) boxFechaDia2.getSelectedItem();
		
		labelMes2 = new JLabel("Mes");
		labelMes2.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelMes2.setForeground(Color.WHITE);
		boxFechaMes2 = new JComboBox<Month>(Month.values());
		mes2 = (Month) boxFechaMes2.getSelectedItem();
		
		labelAño2 = new JLabel("Año");
		labelAño2.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelAño2.setForeground(Color.WHITE);
		boxFechaAño2 = new JComboBox<Integer>(años);
		año2 = (Integer) boxFechaDia2.getSelectedItem();
		
		labelEstado = new JLabel("Estado");
		labelEstado.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelEstado.setForeground(Color.WHITE);
		boxEstado = new JComboBox<EstadoOrden>();
		for(EstadoOrden est : EstadoOrden.values()) {
			boxEstado.addItem(est);
		}
		

		buttonAñadir = new JButton("Añadir");
		buttonAñadir.addActionListener( a -> {
			ordenPedido = new OrdenDePedido();
			ordenPedido.setNroDePedido(Integer.parseInt(textNroDeOrden.getText()));
			ordenPedido.setPlantaDestino((Planta)boxPlanta.getSelectedItem());
			ordenPedido.setFechaSolicitud(LocalDate.of(dia, mes.getValue(), año));
			ordenPedido.setEstado((EstadoOrden) boxEstado.getSelectedItem());
			frame.setContentPane(menuPrincipal = new MenuPrincipal(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener( a -> {
			frame.setContentPane(menuPrincipal = new MenuPrincipal(appE, frame));
			frame.revalidate();
			frame.repaint();
		});


		this.add(labelPresentacion);
		this.add(labelNroDeOrden);
		this.add(textNroDeOrden);
		this.add(labelPlanta);
		this.add(boxPlanta);
		this.add(labelFechaSolicitud);
		this.add(labelDia);
		this.add(boxFechaDia);
		this.add(labelMes);
		this.add(boxFechaMes);
		this.add(labelAño);
		this.add(boxFechaAño);
		this.add(labelFechaEntrega);
		this.add(labelDia2);
		this.add(boxFechaDia2);
		this.add(labelMes2);
		this.add(boxFechaMes2);
		this.add(labelAño2);
		this.add(boxFechaAño2);
		this.add(labelEstado);
		this.add(boxEstado);
		this.add(buttonAñadir);
		this.add(buttonCancelar);
		
	}
	

}
