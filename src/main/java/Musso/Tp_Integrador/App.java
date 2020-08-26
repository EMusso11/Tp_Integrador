package Musso.Tp_Integrador;

import java.awt.Color;
import java.awt.MenuBar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Musso.Tp_Integrador.gui.*;
import Musso.Tp_Integrador.modelo.Camion;
import Musso.Tp_Integrador.modelo.GrafoPlantas;
import Musso.Tp_Integrador.modelo.Insumo;
import Musso.Tp_Integrador.modelo.InsumoGeneral;
import Musso.Tp_Integrador.modelo.OrdenDePedido;
import Musso.Tp_Integrador.modelo.Planta;
import Musso.Tp_Integrador.modelo.Ruta;
import Musso.Tp_Integrador.modelo.OrdenDePedido.EstadoOrden;

public class App {
	
	private JFrame frame;
	private MenuPrincipal menuPrincipal;
	
	public static void main(String[] args) {
		App app = new App();
		AppEmpresa appE = new AppEmpresa();
		
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
		
		System.out.println(appE.getGrafo().pageRank(appE));
		
//		Camion c1 = new Camion("AA 111 AA");
//		Camion c2 = new Camion("BB 222 BB");
//		Camion c3 = new Camion("CC 333 CC");
//		appE.addCamion(c1);
//		appE.addCamion(c2);
//		appE.addCamion(c3);
		
		
//		------------------------------------------
		
		app.armarApp(appE);
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
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
//		----------------------------------------------------------------
		

		
	}
	
	
}
