package Musso.Tp_Integrador.gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Musso.Tp_Integrador.AppEmpresa;

public class MenuBarra extends JMenuBar {
	
	private JPanel menuPrincipal;
	private JMenu menuArchivo;
	private JMenuItem menuItemSalir;
	private JMenu menuCamion;
	private JMenuItem menuItemCamion;
	private JMenuItem menuItemAltaCamion;
	private JMenuItem menuItemBajaCamion;
	private JMenuItem menuItemBuscarCamion;
	private JMenuItem menuItemVisualizarCamion;
	private JMenu menuPlanta;
	private JMenuItem menuItemAņadirPlanta;
	private JMenuItem menuItemInfoPlanta;
	private JMenuItem menuItemAņadirStockDeInsumo;
	private JMenu menuInsumo;
	private JMenuItem menuItemAņadirInsumo;
	private JMenuItem menuItemBajaInsumo;
	private JMenuItem menuItemVisualizarInsumo;
	private JMenu menuOrdenDePedido;
	private JMenuItem menuItemRegistrarOrdenDePedido;
	private JMenuItem menuItemOrdenesCreadas;
	private JMenuItem menuItemOrdenesProcesadas;
	private JPanel panelCamion;
	private JPanel panelPlanta;
	private JPanel panelStockDeInsumo;
	private JPanel panelInsumo;
	private JPanel panelOrdenDePedido;
	
	MenuBarra(AppEmpresa appE, JFrame frame) {
		super();
		armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame) {

		menuArchivo = new JMenu("File");
		
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener( e -> System.exit(0));
		menuArchivo.add(menuItemSalir);
		
		menuCamion = new JMenu("Camion");
//		---------------------------------------------------------------- Camion
		menuItemAltaCamion = new JMenuItem("Alta Camion");
		menuItemAltaCamion.addActionListener( a -> {
			frame.setContentPane(panelCamion = new PanelAņadirCamion(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuItemBajaCamion = new JMenuItem("Baja Camion");
		menuItemBajaCamion.addActionListener( a -> {
			frame.setContentPane(panelCamion = new PanelBajaCamion(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuItemBuscarCamion = new JMenuItem("Buscar Camion");
		menuItemBuscarCamion.addActionListener( a -> {
			frame.setContentPane(panelCamion = new PanelBuscarCamion(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuCamion.add(menuItemAltaCamion);
		menuCamion.add(menuItemBajaCamion);
		menuCamion.add(menuItemBuscarCamion);
		
		menuPlanta = new JMenu("Planta");
//		---------------------------------------------------------------- Planta
		menuItemAņadirPlanta = new JMenuItem("Aņadir Planta");
		menuItemAņadirPlanta.addActionListener( a -> {
			frame.setContentPane(panelPlanta = new PanelAņadirPlanta());
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuItemAņadirPlanta = new JMenuItem("Aņadir Ruta");
		menuItemAņadirPlanta.addActionListener( a -> {
			frame.setContentPane(panelPlanta = new PanelAņadirRuta(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuItemAņadirStockDeInsumo = new JMenuItem("Aņadir Stock de Insumo");
		menuItemAņadirStockDeInsumo.addActionListener( a -> {
			frame.setContentPane(panelStockDeInsumo = new PanelAņadirStockDeInsumo(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuPlanta.add(menuItemAņadirPlanta);
		menuPlanta.add(menuItemAņadirStockDeInsumo);
		
		menuInsumo = new JMenu("Insumo");
//		---------------------------------------------------------------- Insumo
		menuItemAņadirInsumo = new JMenuItem("Aņadir Insumo");
		menuItemAņadirInsumo.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelAņadirInsumo(appE, frame, 0.0));
			frame.revalidate();
			frame.repaint();
		});
		
		menuItemBajaInsumo = new JMenuItem("Baja Insumo");
		menuItemBajaInsumo.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelBajaInsumo(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
		menuItemVisualizarInsumo = new JMenuItem("Ver Insumos");
		menuItemVisualizarInsumo.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelVisualizarInsumos(appE, frame));
			frame.revalidate();
			frame.repaint();
		});

		menuInsumo.add(menuItemAņadirInsumo);
		menuInsumo.add(menuItemBajaInsumo);
		menuInsumo.add(menuItemVisualizarInsumo);
		
		menuOrdenDePedido = new JMenu("Orden de Pedido");
//		---------------------------------------------------------------- Orden
		menuItemRegistrarOrdenDePedido = new JMenuItem("Registrar Orden");
		menuItemRegistrarOrdenDePedido.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelRegistrarOrden(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
		
//		menuItemOrdenesCreadas = new JMenuItem("Ordenes creadas");
//		menuItemOrdenesCreadas.addActionListener( a -> {
//			frame.setContentPane(panelInsumo = new PanelOrdenesCreadas(appE, frame));
//			frame.revalidate();
//			frame.repaint();
//		});
//		
//		menuItemOrdenesProcesadas = new JMenuItem("Ordenes procesadas");
//		menuItemOrdenesProcesadas.addActionListener( a -> {
//			frame.setContentPane(panelInsumo = new PanelOrdenesProcesadas(appE, frame));
//			frame.revalidate();
//			frame.repaint();
//		});
		
		menuOrdenDePedido.add(menuItemRegistrarOrdenDePedido);
//		menuOrdenDePedido.add(menuItemOrdenesCreadas);
//		menuOrdenDePedido.add(menuItemOrdenesProcesadas);
		
		this.add(menuArchivo);
		this.add(menuCamion);
		this.add(menuPlanta);
		this.add(menuInsumo);
		this.add(menuOrdenDePedido);
		frame.setJMenuBar(this);
	}

}
