package modelo.servicos;

public class TaxaBrasil implements TaxaServicos{

	//metodos da classe
	public Double taxa(double quantia) {
		if (quantia >=  100.0) {
			return quantia * 0.15; 
		} else {
			return quantia * 0.20;
		}
	}	
}
