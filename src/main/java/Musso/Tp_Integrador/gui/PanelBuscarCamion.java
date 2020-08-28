package Musso.Tp_Integrador.gui;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import Musso.Tp_Integrador.AppEmpresa;
import Musso.Tp_Integrador.exceptions.CamionesNoEncontradosPorCriterioException;
import Musso.Tp_Integrador.exceptions.camionNoEncontradoException;
import Musso.Tp_Integrador.modelo.Camion;
import Musso.Tp_Integrador.utilities.ModeloEncabezadoTabla;
import Musso.Tp_Integrador.utilities.ModeloTabla;

	public class PanelBuscarCamion extends JPanel {
		
	private JComboBox<CriterioBusqueda> boxSeleccionar;
	private JLabel labelCriterio;
	private JTextField textCriterio;
	private JButton buttonBuscar; 
	
	private JScrollPane scrollPaneTabla;
	private JTable tablaBuscarCamion;
	private ModeloTabla modelo;
	
	private String[] titulosTabla = { "Patente", "Marca", "Modelo", "Kilometraje", "Costo por Km", "Costo por Hora", "Fecha de Compra" };
	private Object[][] dataTabla;
	
	public enum CriterioBusqueda { PATENTE, MODELO, MARCA, KILOMETRAJE, COSTOPORKM, COSTOPORHORA, FECHACOMPRA };
	
	public PanelBuscarCamion(AppEmpresa appE, JFrame frame) {
		super();
		this.armarPanel(appE, frame);
	}

	public void armarPanel(AppEmpresa appE, JFrame frame)  {
		
		this.setBackground(Color.BLACK);
		
		JComponent labelPresentacion = new JLabel("BAJA CAMION");
		labelPresentacion.setFont(new Font("Calibri", Font.BOLD, 24));
		labelPresentacion.setForeground(Color.ORANGE);
		
		JComponent labelSeleccionarCriterio = new JLabel("Seleccionar Criterio de Busqueda");
		labelSeleccionarCriterio.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelSeleccionarCriterio.setForeground(Color.WHITE);
		boxSeleccionar = new JComboBox<CriterioBusqueda>();
		boxSeleccionar.addItem(null);
		for(CriterioBusqueda cb : CriterioBusqueda.values()) {
			boxSeleccionar.addItem(cb);
		}
		
		labelCriterio = new JLabel("Buscar");
		labelCriterio.setFont(new Font("Calibri", Font.ITALIC, 18));
		labelCriterio.setForeground(Color.WHITE);
		textCriterio = new JTextField(10);
		textCriterio.setEnabled(false);
		
		
		this.tablaBuscarCamion = new JTable();
		tablaBuscarCamion.setBackground(Color.WHITE);		
		tablaBuscarCamion.setVisible(false);
		
		scrollPaneTabla = new JScrollPane();
		
		buttonBuscar = new JButton("Buscar");
		
		boxSeleccionar.addActionListener( act1 -> {
			try {
				switch((CriterioBusqueda) boxSeleccionar.getSelectedItem()) {
				case PATENTE:
					textCriterio.setEnabled(true);
					tablaBuscarCamion.setVisible(false);
					buttonBuscar.addActionListener( act2 -> {
						try {
							Camion camion1 = appE.buscarCamionPorPatente(textCriterio.getText()).orElseThrow();
							
							dataTabla = new Object[1][7];
							
							dataTabla[0][0] = camion1.getPatente();
							dataTabla[0][1] = camion1.getMarca();
							dataTabla[0][2] = camion1.getModelo();
							dataTabla[0][3] = camion1.getKilometraje();
							dataTabla[0][4] = camion1.getCostoPorKm();
							dataTabla[0][5] = camion1.getCostoPorHora();
							dataTabla[0][6] = camion1.getFechaCompra();
							
							modelo = new ModeloTabla(dataTabla, titulosTabla);
							tablaBuscarCamion.setModel(modelo);
							
							tablaBuscarCamion.getTableHeader().setReorderingAllowed(false);
							tablaBuscarCamion.setRowHeight(20);//tamaño de las celdas
							tablaBuscarCamion.setGridColor(new java.awt.Color(0, 0, 0));
							
							//Se define el tamaño de largo para cada columna y su contenido
							tablaBuscarCamion.getColumnModel().getColumn(0).setPreferredWidth(400);
							tablaBuscarCamion.getColumnModel().getColumn(1).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(2).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(3).setPreferredWidth(300);
							tablaBuscarCamion.getColumnModel().getColumn(4).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(5).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(6).setPreferredWidth(400);
							
							JTableHeader tableHeader = tablaBuscarCamion.getTableHeader();
						    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
						    tablaBuscarCamion.setTableHeader(tableHeader);
						    scrollPaneTabla.setViewportView(tablaBuscarCamion);	
							
						} catch (NoSuchElementException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						}
					});
					tablaBuscarCamion.setVisible(true);
					break;
					
				case MODELO:
					textCriterio.setEnabled(true);
					tablaBuscarCamion.setVisible(false);
					buttonBuscar.addActionListener( act2 -> {
						try {
							List<Camion> camiones = appE.buscarCamionPorModelo(textCriterio.getText());
							dataTabla = new Object[camiones.size()][7]; 
							for(int i=0; i<camiones.size(); i++) {
								dataTabla[i][0] = camiones.get(i).getPatente();
								dataTabla[i][1] = camiones.get(i).getMarca();
								dataTabla[i][2] = camiones.get(i).getModelo();
								dataTabla[i][3] = camiones.get(i).getKilometraje();
								dataTabla[i][4] = camiones.get(i).getCostoPorKm();
								dataTabla[i][5] = camiones.get(i).getCostoPorHora();
								dataTabla[i][6] = camiones.get(i).getFechaCompra();
							}
							
							modelo = new ModeloTabla(dataTabla, titulosTabla);
							tablaBuscarCamion.setModel(modelo);
							
							tablaBuscarCamion.getTableHeader().setReorderingAllowed(false);
							tablaBuscarCamion.setRowHeight(25);
							tablaBuscarCamion.setGridColor(new java.awt.Color(0, 0, 0)); 

							tablaBuscarCamion.getColumnModel().getColumn(0).setPreferredWidth(400);
							tablaBuscarCamion.getColumnModel().getColumn(1).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(2).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(3).setPreferredWidth(300);
							tablaBuscarCamion.getColumnModel().getColumn(4).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(5).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(6).setPreferredWidth(400);
							
							JTableHeader tableHeader = tablaBuscarCamion.getTableHeader();
						    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
						    tablaBuscarCamion.setTableHeader(tableHeader);
						    scrollPaneTabla.setViewportView(tablaBuscarCamion);	
							
						} catch (NoSuchElementException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						} catch (CamionesNoEncontradosPorCriterioException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						}
					});
					tablaBuscarCamion.setVisible(true);
					break;
					
				case MARCA:
					textCriterio.setEnabled(true);
					buttonBuscar.addActionListener( act2 -> {
						try {
							List<Camion> camiones = appE.buscarCamionPorMarca(textCriterio.getText());
							dataTabla = new Object[camiones.size()][7]; 
							for(int i=0; i<camiones.size(); i++) {
								dataTabla[i][0] = camiones.get(i).getPatente();
								dataTabla[i][1] = camiones.get(i).getMarca();
								dataTabla[i][2] = camiones.get(i).getModelo();
								dataTabla[i][3] = camiones.get(i).getKilometraje();
								dataTabla[i][4] = camiones.get(i).getCostoPorKm();
								dataTabla[i][5] = camiones.get(i).getCostoPorHora();
								dataTabla[i][6] = camiones.get(i).getFechaCompra();
							}
							
							modelo = new ModeloTabla(dataTabla, titulosTabla);
							tablaBuscarCamion.setModel(modelo);
							
							tablaBuscarCamion.getTableHeader().setReorderingAllowed(false);
							tablaBuscarCamion.setRowHeight(20);
							tablaBuscarCamion.setGridColor(new java.awt.Color(0, 0, 0));
							
							tablaBuscarCamion.getColumnModel().getColumn(0).setPreferredWidth(400);
							tablaBuscarCamion.getColumnModel().getColumn(1).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(2).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(3).setPreferredWidth(300);
							tablaBuscarCamion.getColumnModel().getColumn(4).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(5).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(6).setPreferredWidth(400);
							
							JTableHeader tableHeader = tablaBuscarCamion.getTableHeader();
						    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
						    tablaBuscarCamion.setTableHeader(tableHeader);
						    scrollPaneTabla.setViewportView(tablaBuscarCamion);	
							
						} catch (NoSuchElementException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						} catch (CamionesNoEncontradosPorCriterioException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						}
					});
					tablaBuscarCamion.setVisible(true);
					break;
					
				case KILOMETRAJE:
					textCriterio.setEnabled(true);
					buttonBuscar.addActionListener( act2 -> {
						try {
							List<Camion> camiones = appE.buscarCamionPorKmMenores(Double.parseDouble(textCriterio.getText()));
							
							dataTabla = new Object[camiones.size()][7]; 
							for(int i=0; i<camiones.size(); i++) {
								dataTabla[i][0] = camiones.get(i).getPatente();
								dataTabla[i][1] = camiones.get(i).getMarca();
								dataTabla[i][2] = camiones.get(i).getModelo();
								dataTabla[i][3] = camiones.get(i).getKilometraje();
								dataTabla[i][4] = camiones.get(i).getCostoPorKm();
								dataTabla[i][5] = camiones.get(i).getCostoPorHora();
								dataTabla[i][6] = camiones.get(i).getFechaCompra();
							}
							
							modelo = new ModeloTabla(dataTabla, titulosTabla);
							tablaBuscarCamion.setModel(modelo);
							
							tablaBuscarCamion.getTableHeader().setReorderingAllowed(false);
							tablaBuscarCamion.setRowHeight(20);
							tablaBuscarCamion.setGridColor(new java.awt.Color(0, 0, 0));
							
							tablaBuscarCamion.getColumnModel().getColumn(0).setPreferredWidth(400);
							tablaBuscarCamion.getColumnModel().getColumn(1).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(2).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(3).setPreferredWidth(300);
							tablaBuscarCamion.getColumnModel().getColumn(4).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(5).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(6).setPreferredWidth(400);
							
							JTableHeader tableHeader = tablaBuscarCamion.getTableHeader();
						    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
						    tablaBuscarCamion.setTableHeader(tableHeader);
						    scrollPaneTabla.setViewportView(tablaBuscarCamion);	
							
						} catch (NoSuchElementException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						} catch (CamionesNoEncontradosPorCriterioException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						}
					});
					tablaBuscarCamion.setVisible(true);
					break;
					
				case COSTOPORKM:
					textCriterio.setEnabled(true);
					buttonBuscar.addActionListener( act2 -> {
						try {
							List<Camion> camiones = appE.buscarCamionPorCostoPorKmMenores(Double.parseDouble(textCriterio.getText()));

							dataTabla = new Object[camiones.size()][7]; 
							for(int i=0; i<camiones.size(); i++) {
								dataTabla[i][0] = camiones.get(i).getPatente();
								dataTabla[i][1] = camiones.get(i).getMarca();
								dataTabla[i][2] = camiones.get(i).getModelo();
								dataTabla[i][3] = camiones.get(i).getKilometraje();
								dataTabla[i][4] = camiones.get(i).getCostoPorKm();
								dataTabla[i][5] = camiones.get(i).getCostoPorHora();
								dataTabla[i][6] = camiones.get(i).getFechaCompra();
							}
							
							modelo = new ModeloTabla(dataTabla, titulosTabla);
							tablaBuscarCamion.setModel(modelo);
							
							tablaBuscarCamion.getTableHeader().setReorderingAllowed(false);
							tablaBuscarCamion.setRowHeight(20);
							tablaBuscarCamion.setGridColor(new java.awt.Color(0, 0, 0));
							
							tablaBuscarCamion.getColumnModel().getColumn(0).setPreferredWidth(400);
							tablaBuscarCamion.getColumnModel().getColumn(1).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(2).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(3).setPreferredWidth(300);
							tablaBuscarCamion.getColumnModel().getColumn(4).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(5).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(6).setPreferredWidth(400);
							
							JTableHeader tableHeader = tablaBuscarCamion.getTableHeader();
						    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
						    tablaBuscarCamion.setTableHeader(tableHeader);
						    scrollPaneTabla.setViewportView(tablaBuscarCamion);	
							
						} catch (NoSuchElementException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						} catch (CamionesNoEncontradosPorCriterioException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						}
					});
					tablaBuscarCamion.setVisible(true);
					break;
					
				case COSTOPORHORA:
					textCriterio.setEnabled(true);
					buttonBuscar.addActionListener( act2 -> {
						try {
							List<Camion> camiones = appE.buscarCamionPorCostoPorHoraMenores(Double.parseDouble(textCriterio.getText()));

							dataTabla = new Object[camiones.size()][7]; 
							for(int i=0; i<camiones.size(); i++) {
								dataTabla[i][0] = camiones.get(i).getPatente();
								dataTabla[i][1] = camiones.get(i).getMarca();
								dataTabla[i][2] = camiones.get(i).getModelo();
								dataTabla[i][3] = camiones.get(i).getKilometraje();
								dataTabla[i][4] = camiones.get(i).getCostoPorKm();
								dataTabla[i][5] = camiones.get(i).getCostoPorHora();
								dataTabla[i][6] = camiones.get(i).getFechaCompra();
							}
							
							modelo = new ModeloTabla(dataTabla, titulosTabla);
							tablaBuscarCamion.setModel(modelo);
							
							tablaBuscarCamion.getTableHeader().setReorderingAllowed(false);
							tablaBuscarCamion.setRowHeight(20);
							tablaBuscarCamion.setGridColor(new java.awt.Color(0, 0, 0));
							
							tablaBuscarCamion.getColumnModel().getColumn(0).setPreferredWidth(400);
							tablaBuscarCamion.getColumnModel().getColumn(1).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(2).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(3).setPreferredWidth(300);
							tablaBuscarCamion.getColumnModel().getColumn(4).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(5).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(6).setPreferredWidth(400);
							
							JTableHeader tableHeader = tablaBuscarCamion.getTableHeader();
						    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
						    tablaBuscarCamion.setTableHeader(tableHeader);
						    scrollPaneTabla.setViewportView(tablaBuscarCamion);	
							
						} catch (NoSuchElementException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						} catch (CamionesNoEncontradosPorCriterioException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						}
					});
					tablaBuscarCamion.setVisible(true);
					break;
					
				case FECHACOMPRA:
					textCriterio.setEnabled(true);
					buttonBuscar.addActionListener( act2 -> {
						try {
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							LocalDate date = LocalDate.parse(textCriterio.getText(), formatter);
							List<Camion> camiones = appE.buscarCamionPorFechaCompra(date);

							dataTabla = new Object[camiones.size()][7]; 
							for(int i=0; i<camiones.size(); i++) {
								dataTabla[i][0] = camiones.get(i).getPatente();
								dataTabla[i][1] = camiones.get(i).getMarca();
								dataTabla[i][2] = camiones.get(i).getModelo();
								dataTabla[i][3] = camiones.get(i).getKilometraje();
								dataTabla[i][4] = camiones.get(i).getCostoPorKm();
								dataTabla[i][5] = camiones.get(i).getCostoPorHora();
								dataTabla[i][6] = camiones.get(i).getFechaCompra();
							}
							
							modelo = new ModeloTabla(dataTabla, titulosTabla);
							tablaBuscarCamion.setModel(modelo);
							
							tablaBuscarCamion.getTableHeader().setReorderingAllowed(false);
							tablaBuscarCamion.setRowHeight(20);
							tablaBuscarCamion.setGridColor(new java.awt.Color(0, 0, 0));
							
							tablaBuscarCamion.getColumnModel().getColumn(0).setPreferredWidth(400);
							tablaBuscarCamion.getColumnModel().getColumn(1).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(2).setPreferredWidth(600);
							tablaBuscarCamion.getColumnModel().getColumn(3).setPreferredWidth(300);
							tablaBuscarCamion.getColumnModel().getColumn(4).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(5).setPreferredWidth(500);
							tablaBuscarCamion.getColumnModel().getColumn(6).setPreferredWidth(400);
							
							JTableHeader tableHeader = tablaBuscarCamion.getTableHeader();
						    tableHeader.setDefaultRenderer(new ModeloEncabezadoTabla());
						    tablaBuscarCamion.setTableHeader(tableHeader);
						    scrollPaneTabla.setViewportView(tablaBuscarCamion);	
							
						} catch (NoSuchElementException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						} catch (CamionesNoEncontradosPorCriterioException ex) {
							JOptionPane.showMessageDialog(frame, "No se han encontrado camiones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
						}
					});
					tablaBuscarCamion.setVisible(true);
					break;
					
				default:
					break;
				}
			} catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(frame, "Por favor, seleccione un criterio.", "ALERTA", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		
		
		
		this.add(labelPresentacion);
		this.add(labelSeleccionarCriterio);
		this.add(boxSeleccionar);
		this.add(labelCriterio);
		this.add(textCriterio);
		this.add(tablaBuscarCamion);
		this.add(scrollPaneTabla);
		this.add(buttonBuscar);
	}
}
