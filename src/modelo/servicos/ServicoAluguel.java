package modelo.servicos;

import modelo.entidades.AluguelCarro;
import modelo.entidades.Fatura;

public class ServicoAluguel {
	
	private Double precoDia;
	private Double precoHora;
	
	//associacao da classe
	private TaxaServicos taxaServicos;
	
	//construtores da classe
	public ServicoAluguel() {
	}
	
	public ServicoAluguel(Double precoDia, Double precoHora, TaxaServicos taxaServicos) {
		this.precoDia = precoDia;
		this.precoHora = precoHora;
		this.taxaServicos = taxaServicos;
	}
	
	//metodos da classe
	public void processarFatura(AluguelCarro aluguelCarro) {
		long dI = aluguelCarro.getInicio().getTime();
		long dF = aluguelCarro.getFim().getTime();
		
		double horas = (double)(dF - dI) / 1000  / 60 / 60;
		
		// calcula pagamento basico
		double pagamentoBasico;
		
		if (horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoHora; 
		} else {
			pagamentoBasico = Math.ceil(horas / 24) * precoDia;
		}
		
		// calcula taxa de imposto
		double taxa = taxaServicos.taxa(pagamentoBasico);
		
		// instancia Fatura
		aluguelCarro.setFatura(new Fatura(pagamentoBasico, taxa));
	}
}
