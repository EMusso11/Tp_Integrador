package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Musso.Tp_Integrador.AppEmpresa;

public class MenuPrincipal extends JPanel {

	private JPanel panelMainPlanta;
	private JPanel panelMainCamion;
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
	private JMenuItem menuItemA�adirPlanta;
	private JMenuItem menuItemInfoPlanta;
	private JMenuItem menuItemA�adirStockDeInsumo;
	private JMenu menuInsumo;
	private JMenuItem menuItemA�adirInsumo;
	private JMenuItem menuItemBajaInsumo;
	private JMenuItem menuItemVisualizarInsumo;
	private JPanel panelCamion;
	private JPanel panelPlanta;
	private JPanel panelStockDeInsumo;
	private JPanel panelInsumo;

	public MenuPrincipal(AppEmpresa appE, JFrame frame){
		super();
		this.armarPanel(appE, frame);
	}
	
	public void armarPanel(AppEmpresa appE, JFrame frame) {

		frame.setBackground(Color.BLACK);
		
//		TODO en el panel principal muestro info de las plantas en forma de tabla - CU06
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Plantas", panelMainPlanta = new PanelMainPlanta(appE, frame));
		tabs.addTab("Camiones", panelMainCamion = new PanelMainCamion(appE, frame));
		ImageIcon img1 = new ImageIcon("img/planta.png");
		ImageIcon img2 = new ImageIcon("img/camion.png");
		tabs.setIconAt(0, img1);
		tabs.setIconAt(1, img2);
		
		menuBar = new JMenuBar();
		menuArchivo = new JMenu("File");
		
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener( e -> System.exit(0));
		menuArchivo.add(menuItemSalir);
		
		menuCamion = new JMenu("Camion");
//		---------------------------------------------------------------- Camion
		menuItemAltaCamion = new JMenuItem("Alta Camion");
		menuItemAltaCamion.addActionListener( a -> {
//			SIEMPRE VINCULAR CON FRAME
			frame.setContentPane(panelCamion = new PanelA�adirCamion(appE, frame));
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
			frame.setContentPane(panelCamion = new PanelBuscarCamion());
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuCamion.add(menuItemAltaCamion);
		menuCamion.add(menuItemBajaCamion);
		menuCamion.add(menuItemBuscarCamion);
		
		menuPlanta = new JMenu("Planta");
//		---------------------------------------------------------------- Planta
		menuItemA�adirPlanta = new JMenuItem("A�adir Planta");
		menuItemA�adirPlanta.addActionListener( a -> {
			frame.setContentPane(panelPlanta = new PanelA�adirPlanta());
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuItemA�adirPlanta = new JMenuItem("A�adir Ruta");
		menuItemA�adirPlanta.addActionListener( a -> {
			frame.setContentPane(panelPlanta = new PanelA�adirRuta(appE.getGrafo().getPlantas()));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuItemA�adirStockDeInsumo = new JMenuItem("A�adir Stock de Insumo");
		menuItemA�adirStockDeInsumo.addActionListener( a -> {
			frame.setContentPane(panelStockDeInsumo = new PanelA�adirStockDeInsumo(appE, frame));
			frame.revalidate();
			frame.repaint();
		});
//		----------------------------------------------------------------
		menuPlanta.add(menuItemA�adirPlanta);
		menuPlanta.add(menuItemA�adirStockDeInsumo);
		
		menuInsumo = new JMenu("Insumo");
//		---------------------------------------------------------------- Insumo
		menuItemA�adirInsumo = new JMenuItem("A�adir Insumo");
		menuItemA�adirInsumo.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelA�adirInsumo(appE, frame, 0.0));
			frame.revalidate();
			frame.repaint();
		});
		
		menuItemBajaInsumo = new JMenuItem("Baja Insumo");
		menuItemBajaInsumo.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelBajaInsumo(frame, appE.getInsumos()));
			frame.revalidate();
			frame.repaint();
		});
		
		menuItemVisualizarInsumo = new JMenuItem("Ver Insumos");
		menuItemVisualizarInsumo.addActionListener( a -> {
			frame.setContentPane(panelInsumo = new PanelVisualizarInsumo(frame));
			frame.revalidate();
			frame.repaint();
		});
		
		menuInsumo.add(menuItemA�adirInsumo);
		menuInsumo.add(menuItemBajaInsumo);
		menuInsumo.add(menuItemVisualizarInsumo);
		
		menuBar.add(menuArchivo);
		menuBar.add(menuCamion);
		menuBar.add(menuPlanta);
		menuBar.add(menuInsumo);

		
		frame.setJMenuBar(menuBar);
		frame.add(tabs);
		frame.setVisible(true);
	}
}
