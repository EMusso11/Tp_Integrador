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
	private JMenuBar menuBar;

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
		
		menuBar = new MenuBarra(appE, frame);
		
		frame.add(tabs);
		frame.setVisible(true);
	}
}
