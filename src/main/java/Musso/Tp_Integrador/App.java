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
	private MenuPrincipal menuPrincipal;
//	private JPanel menuPrincipal;
//	private JMenuBar menuBar;
//	private JMenu menuArchivo;
//	private JMenuItem menuItemSalir;
//	private JMenu menuCamion;
//	private JMenuItem menuItemCamion;
//	private JMenuItem menuItemAltaCamion;
//	private JMenuItem menuItemBajaCamion;
//	private JMenuItem menuItemBuscarCamion;
//	private JMenuItem menuItemVisualizarCamion;
//	private JMenu menuPlanta;
//	private JMenuItem menuItemAñadirPlanta;
//	private JMenuItem menuItemInfoPlanta;
//	private JMenuItem menuItemAñadirStockDeInsumo;
//	private JMenu menuInsumo;
//	private JMenuItem menuItemAñadirInsumo;
//	private JMenuItem menuItemBajaInsumo;
//	private JMenuItem menuItemVisualizarInsumo;
//	private JPanel panelCamion;
//	private JPanel panelPlanta;
//	private JPanel panelStockDeInsumo;
//	private JPanel panelInsumo;
	
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
		
		frame = new JFrame("Empresa XXX");
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		
		menuPrincipal = new MenuPrincipal(appE, frame);
		
//		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
//		----------------------------------------------------------------
		

		
	}
	
	
}
