package modelo.entidades;

public class Fatura {
	
	private Double pagamentoBasico;
	private Double taxa;
	
	//construtores
	public Fatura() {
	}
	
	public Fatura(Double pagamentoBasico, Double taxa) {
		this.pagamentoBasico = pagamentoBasico;
		this.taxa = taxa;
	}
	
	// getters e setters
	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}
	
	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}
	
	public Double getTaxa() {
		return taxa;
	}
	
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	// metodos da classe	
	public Double getTotalPagamento() {
		return getPagamentoBasico() + getTaxa(); 
	}		
}	
