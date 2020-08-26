package Musso.Tp_Integrador.modelo;

import Musso.Tp_Integrador.AppEmpresa;

public class PageRank {
	
	protected static final Double DAMPING_FACTOR = 0.85;
    protected static final Double PRECISION = 1.0e-4;
    protected static final Integer MAX_SIZE = AppEmpresa.getMaxPlantas();

    private Double[] pageRank;
    private Double[] tempArray;
    private Double sum;

    public PageRank(AppEmpresa appE) {
        this.pageRank = new Double[MAX_SIZE];
        this.sum=0.0;
        for(int i=0; i<MAX_SIZE; i++) {
            this.pageRank[i] = 1.0;
            this.sum += pageRank[i];
        }
    }

    public void calcular(Double[][] matriz, Double[] linkSum) {
//        Double[] linkSum = new Double[MAX_SIZE];
//        for(int i=0; i<matriz.length; i++) {
//            Double aux = 0.0;
//            for(int j=0; j<matriz.length; j++) {
//                aux += matriz[i][j];
//            }
//            linkSum[i] = aux;
//        }
        
        do {
            tempArray = pageRank;
            
            /** PR(i) = (1-d) + d * (PR(j)/n(j) )
             *  d - damping factor
             *  PR(j) - the PageRank of the page j pointing to page i
             *  n(j) - the number of links from j page
             *  **/
            for(int i=0; i<matriz.length; i++) {
                Double tempSum = 0.0;
                for(int j=0; j<matriz[i].length; j++) {
                    if(matriz[j][i]>0) {
                        tempSum += tempArray[j] / linkSum[j];
                    }
                }
                pageRank[i] = (1 - DAMPING_FACTOR) + DAMPING_FACTOR * tempSum;
            }            
        } while (difference(pageRank, tempArray) > PRECISION);
        
        this.setPagerank(pageRank);
    }
	
    protected Double difference(Double[] page, Double[] temp) {
        Double prec = 0.0;
        this.sum = 0.0;
        if (temp == null)
            return 1.0;
        for (int i=0; i<MAX_SIZE; i++) {
            prec += Math.abs(page[i] - temp[i]);
            this.sum += pageRank[i];
        }
        return prec;
    }

	public Double[] getPagerank() {
		return pageRank;
	}

	public void setPagerank(Double[] pageRank) {
		this.pageRank = pageRank;
	}
    
    
}
