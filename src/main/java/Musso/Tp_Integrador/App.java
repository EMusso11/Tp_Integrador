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
	private JPanel panelMainPlanta;
	private JPanel panelMainCamion;
	private JMenuBar menuBar;
	private JTabbedPane tab;
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
	private JPanel panelCamion;
	
	public static void main(String[] args) {
		App app = new App();
		AppEmpresa appE = new AppEmpresa();
		
//		-----------------test---------------------
//		appE.addPlanta("Planta1");
//		appE.addPlanta("Planta2");
//		appE.addPlanta("Planta3");
//		appE.addPlanta("Planta4");
//		System.out.println("Exito. Plantas creadas.");
//		System.out.println(appE.getGrafo().getPlantas().size());
//		
//		System.out.println(appE.buscarPlanta("Puerto acopio").getNombre());
		
//		Ruta r1 = new Ruta(appE.buscarPlanta("Puerto acopio"), appE.buscarPlanta("Planta2"), 10.0, 1.0, 100.0);
//		Ruta r2 = new Ruta(appE.buscarPlanta("Planta2"), appE.buscarPlanta("Planta3"), 20.0, 2.0, 200.0);
//		Ruta r3 = new Ruta(appE.buscarPlanta("Planta3"), appE.buscarPlanta("Planta4"), 30.0, 3.0, 300.0);
//		Ruta r4 = new Ruta(appE.buscarPlanta("Planta1"), appE.buscarPlanta("Planta4"), 40.0, 4.0, 400.0);
//		appE.addRuta(r1);
//		appE.addRuta(r2);
//		appE.addRuta(r3);
//		appE.addRuta(r4);
//		System.out.println("Exito. Rutas creadas.");
		
		app.armarApp(appE);
	}

	private void armarApp(AppEmpresa appE) {
				
		
		this.frame = new JFrame("Empresa XXX");
		this.frame.setBackground(Color.lightGray);		
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.menuBar = new JMenuBar();
		
//		TODO en el panel principal muestro info de las plantas en forma de tabla
				this.tab = new JTabbedPane();
		this.tab.addTab("Plantas", panelMainPlanta = new PanelMainPlanta());
		this.tab.addTab("Camiones", panelMainCamion = new PanelMainCamion(appE.getCamiones()));
		this.frame.add(tab);
		
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
		this.menuItemVisualizarCamion = new JMenuItem("Visualizar Camiones");
		this.menuItemVisualizarCamion.addActionListener( a -> {
			this.frame.setContentPane(panelCamion = new PanelVisualizarCamion());
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuItemVisualizarCamion = new JMenuItem("Visualizar Camiones");
		this.menuItemBajaCamion.addActionListener( a -> {
			this.frame.setContentPane(panelCamion = new PanelVisualizarCamion());
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		
		this.menuCamion.add(menuItemAltaCamion); //agrego
		this.menuCamion.add(menuItemBajaCamion);
		this.menuCamion.add(menuItemBuscarCamion);
		this.menuCamion.add(menuItemVisualizarCamion);
		
		this.menuPlanta = new JMenu("Planta");
//		---------------------------------------------------------------- Planta
		// TODO PLANTA ORIGEN Y DESTINO VAN A SER COMBOBOX
		this.menuItemAñadirPlanta = new JMenuItem("Añadir Planta");
		this.menuItemAñadirPlanta.addActionListener( a -> {
			this.frame.setContentPane(panelCamion = new PanelAñadirPlanta());
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuItemAñadirPlanta = new JMenuItem("Añadir Ruta");
		this.menuItemAñadirPlanta.addActionListener( a -> {
			this.frame.setContentPane(panelCamion = new PanelAñadirRuta(appE.getGrafo().getPlantas()));
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
		this.menuItemInfoPlanta = new JMenuItem("Info. Planta");
		this.menuItemInfoPlanta.addActionListener( a -> {
			this.frame.setContentPane(panelCamion = new PanelInfoPlanta());
			this.frame.revalidate();
			this.frame.repaint();
		});
//		----------------------------------------------------------------
					
		this.menuPlanta.add(menuItemAñadirPlanta); //agrego
		this.menuPlanta.add(menuItemInfoPlanta);
		
		this.menuBar.add(menuArchivo);
		this.menuBar.add(menuCamion);
		this.menuBar.add(menuPlanta);
		this.frame.setJMenuBar(menuBar);

		this.frame.pack();
//		this.frame.setSize(800, 600);
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // abre en pantalla completa
//		this.frame.setUndecorated(true);
		this.frame.setVisible(true);
	}
	
	
}
