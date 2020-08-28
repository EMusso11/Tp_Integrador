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
	private Integer a�o;
	private JLabel labelDia;
	private JComboBox<Integer> boxFechaDia;
	private JLabel labelMes;
	private JComboBox<Month> boxFechaMes;
	private JLabel labelA�o;
	private JComboBox<Integer> boxFechaA�o;
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
	private JLabel labelA�o2;
	private JComboBox<Integer> boxFechaA�o2;
	private Integer a�o2;
	private JComboBox<EstadoOrden> boxEstado;
	private JButton buttonA�adir;
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
		
		Integer[] a�os = new Integer[31];
		for(int i=0; i<=30; i++) a�os[i] = 2020-i;
		
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
		
		labelA�o = new JLabel("A�o");
		labelA�o.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelA�o.setForeground(Color.WHITE);
		boxFechaA�o = new JComboBox<Integer>(a�os);
		a�o = (Integer) boxFechaDia.getSelectedItem();
		
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
		
		labelA�o2 = new JLabel("A�o");
		labelA�o2.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelA�o2.setForeground(Color.WHITE);
		boxFechaA�o2 = new JComboBox<Integer>(a�os);
		a�o2 = (Integer) boxFechaDia2.getSelectedItem();
		
		labelEstado = new JLabel("Estado");
		labelEstado.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelEstado.setForeground(Color.WHITE);
		boxEstado = new JComboBox<EstadoOrden>();
		for(EstadoOrden est : EstadoOrden.values()) {
			boxEstado.addItem(est);
		}
		

		buttonA�adir = new JButton("A�adir");
		buttonA�adir.addActionListener( a -> {
			ordenPedido = new OrdenDePedido();
			ordenPedido.setNroDePedido(Integer.parseInt(textNroDeOrden.getText()));
			ordenPedido.setPlantaDestino((Planta)boxPlanta.getSelectedItem());
			ordenPedido.setFechaSolicitud(LocalDate.of(dia, mes.getValue(), a�o));
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
		this.add(labelA�o);
		this.add(boxFechaA�o);
		this.add(labelFechaEntrega);
		this.add(labelDia2);
		this.add(boxFechaDia2);
		this.add(labelMes2);
		this.add(boxFechaMes2);
		this.add(labelA�o2);
		this.add(boxFechaA�o2);
		this.add(labelEstado);
		this.add(boxEstado);
		this.add(buttonA�adir);
		this.add(buttonCancelar);
		
	}
	

}
