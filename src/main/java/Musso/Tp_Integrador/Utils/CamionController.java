package Musso.Tp_Integrador.Utils;

import Musso.Tp_Integrador.PanelCamion;
import Musso.Tp_Integrador.exceptions.ControllerException;
import Musso.Tp_Integrador.exceptions.DatosObligatoriosException;
import Musso.Tp_Integrador.exceptions.FormatoNumeroException;
import Musso.Tp_Integrador.modelo.Camion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class CamionController {
	
//	private CamionService camionService;
	private Camion c;
	private List<Camion> lista;
	private PanelCamion panel;
	
	public CamionController(PanelCamion p) {
//		this.camionService = new CamionService();
		this.lista = new ArrayList<Camion>();
		this.panel = p;
		c = new Camion();
	}
	
	public void actualizarModelo() throws DatosObligatoriosException,FormatoNumeroException,ControllerException {
		try {
			if(this.panel.getTxtPatente()!=null) {
				c.setPatente(this.panel.getTxtPatente().getText()); 
			} else {
//				throw new DatosObligatoriosException("Patente", "La patente es obligatoria");
				throw new DatosObligatoriosException();
			}
			
			if(this.panel.getTxtModelo()!=null) c.setModelo(this.panel.getTxtModelo().getText()); 
			if(this.panel.getTxtMarca()!=null) c.setMarca(this.panel.getTxtMarca().getText()); 
			if(this.panel.getTxtKm()!=null) c.setKm(Integer.valueOf(this.panel.getTxtKm().getText())); 
			//if(this.panel.getTxtFechaCompra()!=null) c.setPatente(this.panel.getFechaCompra.getText()); 
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			throw new FormatoNumeroException("Kilometros", "Debe ingresar un valor numerico");
		} catch(Exception e) {
			e.printStackTrace();
			throw new ControllerException("Error:"+e.getLocalizedMessage());
		}
	}
	
	public Camion guardar() throws DatosObligatoriosException, FormatoNumeroException, ControllerException {
		this.actualizarModelo();
		System.out.println("ACTUALIZADO "+c.toString());
		camionService.crearCamion(c);
		this.lista.clear();
		this.lista.addAll(camionService.buscarTodos()); 
		return null;
	}
	
	public List<Camion> listarTodos(){
		this.lista.clear();
		this.lista.addAll(camionService.buscarTodos()); 
		System.out.println("Resultado res   "+lista);
		return this.lista;
	}

}
