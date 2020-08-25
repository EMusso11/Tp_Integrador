package Musso.Tp_Integrador;

import java.awt.Color;
import java.awt.MenuBar;
import javax.swing.*;

import Musso.Tp_Integrador.gui.*;
import Musso.Tp_Integrador.modelo.GrafoPlantas;
import Musso.Tp_Integrador.modelo.Planta;
import Musso.Tp_Integrador.modelo.Ruta;

public class App {
	
	private JFrame frame;
	private JPanel menuPrincipal;
	private JMenuBar menuBar;
	private JMenu menuArchivo;
	private JMenuItem menuItemSalir;
	private JMenu menuCamion;
	private JMenuItem menuItemCamion;
	private JMenuItem menuItemAltaCamion;
	private JMenuItem menuItemBajaCamion;
	private JMenuItem menuItemBuscarCamion;
	private JMenuItem menuItemVisualizarCamion;
	private JMenu menuPlanta;
	private JMenuItem menuItemAñadirPlanta;
	private JMenuItem menuItemInfoPlanta;
	private JMenuItem menuItemAñadirStockDeInsumo;
	private JMenu menuInsumo;
	private JMenuItem menuItemAñadirInsumo;
	private JMenuItem menuItemBajaInsumo;
	private JMenuItem menuItemVisualizarInsumo;
	private JPanel panelCamion;
	private JPanel panelPlanta;
	private JPanel panelStockDeInsumo;
	private JPanel panelInsumo;
	
	public static void main(String[] args) {
		App app = new App();
		AppEmpresa appE = new AppEmpresa();
		app.armarApp(appE);
		
//		-----------------test---------------------
		appE.addPlanta("Planta1");
		appE.addPlanta("Planta2");
		appE.addPlanta("Planta3");
		appE.addPlanta("Planta4");
//		System.out.println("Exito. Plantas creadas.");
//		System.out.println(appE.getGrafo().getPlantas().size());
		
//		System.out.println(appE.buscarPlanta("Puerto acopio").getNombre());
		
		Ruta r1 = new Ruta(appE.buscarPlanta("Puerto acopio"), appE.buscarPlanta("Planta2"), 10.0, 1.0, 100.0);
		Ruta r2 = new Ruta(appE.buscarPlanta("Planta2"), appE.buscarPlanta("Planta3"), 20.0, 2.0, 200.0);
		Ruta r3 = new Ruta(appE.buscarPlanta("Planta3"), appE.buscarPlanta("Planta4"), 30.0, 3.0, 300.0);
		Ruta r4 = new Ruta(appE.buscarPlanta("Planta1"), appE.buscarPlanta("Planta4"), 40.0, 4.0, 400.0);
		appE.addRuta(r1);
		appE.addRuta(r2);
		appE.addRuta(r3);
		appE.addRuta(r4);
//		System.out.println("Exito. Rutas creadas.");
//		------------------------------------------
		
	}

	private void armarApp(AppEmpresa appE) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		this.frame = new JFrame("Empresa XXX");
		this.frame.setBackground(Color.BLACK);
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		
		this.menuPrincipal = new MenuPrincipal(appE, frame);
		
		this.menuBar = new JMenuBar();
		this.menuArchivo = new JMenu("File");
		this.menuItemSalir = new JMenuItem("Salir");
		this.menuItemSalir.addActionListener( e -> System.exit(0));
		this.menuArchivo.add(menuItemSalir);
		
		this.menuCamion = new JMenu("Camion");
//		---------------------------------------------------------------- Camion
		this.menuItemAltaCamion = new JMenuItem("Alta Camion");
		this.menuItemAltaCamion.addActionListener( a -> {
//			SIEMPRE VINCULAR CON FRAME
			this.frame.setContentPane(panelCamion = new PanelAltaCamion());
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuItemBajaCamion = new JMenuItem("Baja Camion");
		this.menuItemBajaCamion.addActionListener( a -> {
			this.frame.setContentPane(panelCamion = new PanelBajaCamion());
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuItemBuscarCamion = new JMenuItem("Buscar Camion");
		this.menuItemBuscarCamion.addActionListener( a -> {
			this.frame.setContentPane(panelCamion = new PanelBuscarCamion());
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuCamion.add(menuItemAltaCamion);
		this.menuCamion.add(menuItemBajaCamion);
		this.menuCamion.add(menuItemBuscarCamion);
		
		this.menuPlanta = new JMenu("Planta");
//		---------------------------------------------------------------- Planta
		this.menuItemAñadirPlanta = new JMenuItem("Añadir Planta");
		this.menuItemAñadirPlanta.addActionListener( a -> {
			this.frame.setContentPane(panelPlanta = new PanelAñadirPlanta());
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuItemAñadirPlanta = new JMenuItem("Añadir Ruta");
		this.menuItemAñadirPlanta.addActionListener( a -> {
			this.frame.setContentPane(panelPlanta = new PanelAñadirRuta(appE.getGrafo().getPlantas()));
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuItemAñadirStockDeInsumo = new JMenuItem("Añadir Stock de Insumo");
		this.menuItemAñadirStockDeInsumo.addActionListener( a -> {
			this.frame.setContentPane(panelStockDeInsumo = new PanelAñadirStockDeInsumo(appE, this.frame));
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuPlanta.add(menuItemAñadirPlanta);
		this.menuPlanta.add(menuItemAñadirStockDeInsumo);
		
		this.menuInsumo = new JMenu("Insumo");
//		---------------------------------------------------------------- Insumo
		this.menuItemAñadirInsumo = new JMenuItem("Añadir Insumo");
		this.menuItemAñadirInsumo.addActionListener( a -> {
			this.frame.setContentPane(panelInsumo = new PanelAñadirInsumo(appE, frame, 0.0)); //TODO funcion peso
			this.frame.revalidate();
			this.frame.repaint();
		});
		
		this.menuItemBajaInsumo = new JMenuItem("Baja Insumo");
		this.menuItemBajaInsumo.addActionListener( a -> {
			this.frame.setContentPane(panelInsumo = new PanelBajaInsumo(frame, appE.getInsumos()));
			this.frame.revalidate();
			this.frame.repaint();
		});
		
		this.menuItemVisualizarInsumo = new JMenuItem("Ver Insumos");
		this.menuItemVisualizarInsumo.addActionListener( a -> {
			this.frame.setContentPane(panelInsumo = new PanelVisualizarInsumo(frame));
			this.frame.revalidate();
			this.frame.repaint();
		});
		
		this.menuInsumo.add(menuItemAñadirInsumo);
		this.menuInsumo.add(menuItemBajaInsumo);
		this.menuInsumo.add(menuItemVisualizarInsumo);
		
		this.menuBar.add(menuArchivo);
		this.menuBar.add(menuCamion);
		this.menuBar.add(menuPlanta);
		this.menuBar.add(menuInsumo);

		
		this.frame.setJMenuBar(menuBar);
		this.frame.pack();
//		this.frame.setSize(800, 600);
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.frame.setVisible(true);
//		----------------------------------------------------------------
		

		
	}
	
	
}
