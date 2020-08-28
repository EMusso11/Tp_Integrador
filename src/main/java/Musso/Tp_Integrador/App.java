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
import Musso.Tp_Integrador.modelo.Insumo.UnidadInsumo;
import Musso.Tp_Integrador.modelo.InsumoGeneral;
import Musso.Tp_Integrador.modelo.InsumoLiquido;
import Musso.Tp_Integrador.modelo.OrdenDePedido;
import Musso.Tp_Integrador.modelo.Planta;
import Musso.Tp_Integrador.modelo.Ruta;
import Musso.Tp_Integrador.modelo.Stock;
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
		
		Ruta r1 = new Ruta(appE.buscarPlanta("Puerto acopio"), appE.buscarPlanta("Planta2"), 10.0, 1.0, 100.0);
		Ruta r2 = new Ruta(appE.buscarPlanta("Planta2"), appE.buscarPlanta("Planta3"), 20.0, 2.0, 200.0);
		Ruta r3 = new Ruta(appE.buscarPlanta("Planta3"), appE.buscarPlanta("Planta4"), 30.0, 3.0, 300.0);
		Ruta r4 = new Ruta(appE.buscarPlanta("Planta1"), appE.buscarPlanta("Planta4"), 40.0, 4.0, 400.0);
		appE.addRuta(r1);
		appE.addRuta(r2);
		appE.addRuta(r3);
		appE.addRuta(r4);

		Camion camion1 = new Camion("AA 999 AA", "Volkswagen", "Constellation", 20000.0, 1.0, 1.0, LocalDate.now());
		Camion camion2 = new Camion("BB 999 BB", "Scania", "114", 30000.0, 1.0, 1.0, LocalDate.now());
//		appE.addCamion(camion1);
//		appE.addCamion(camion2);
		
		List<Insumo> insumos = new ArrayList<Insumo>();
		
		Insumo ins1 = new InsumoGeneral(1, UnidadInsumo.M3, "Aluminio");
		ins1.setDescripcion("Este insumo es utilizado como materia prima para la produccion de puertas");
		ins1.setCosto(100.0);		
		Insumo ins2 = new InsumoLiquido(2, UnidadInsumo.LITRO, "Leche");
		ins2.setDescripcion("Este insumo es utilizado como materia prima para la produccion de yogurt");
		ins2.setCosto(20.0);		
		
		Stock s = new Stock(ins1, 20.0, 10.0, appE.getPlantas().get(2));
		List<Stock> s2 = new ArrayList<Stock>();
		appE.getPlantas().get(0).setProductos(s2);
//		insumos.add(ins1);
//		insumos.add(ins2);
		
		
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
