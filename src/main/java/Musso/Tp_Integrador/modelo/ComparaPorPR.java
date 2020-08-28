package Musso.Tp_Integrador.modelo;

import java.util.Comparator;

public class ComparaPorPR implements Comparator<Planta> {
	
	@Override
	public int compare(Planta p1, Planta p2) {
		return p1.getPageRank().compareTo(p2.getPageRank()); 
	}

	
}
