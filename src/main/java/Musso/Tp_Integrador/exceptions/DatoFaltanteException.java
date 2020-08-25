package Musso.Tp_Integrador.exceptions;

public class DatoFaltanteException extends NumberFormatException {

	public DatoFaltanteException(String msg) {
		super("Dato faltante o erroneo : "+msg+".");
	}
	
}
