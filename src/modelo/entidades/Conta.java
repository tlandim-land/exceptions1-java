package modelo.entidades;

public class Conta {
	private Integer numeroConta;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	// construtores da classe
	public Conta() {
	}
	
	public Conta(Integer numeroConta, String titular, Double saldo, Double limiteSaque) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;		
	}
	
	// getters e setters 
	public Integer getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Double getLimiteSaque() {
		return limiteSaque;
	}
	
	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	//metodos da classe
	
	public void atualizaSaldo(double valor) {
		validaSaque(valor);
		saldo -= valor;
	}
	
	public void validaSaque(double valor) {
		if (valor > saldo) {
			throw new DominiosException("ERRO! SAQUE NÃO AUTORIZADO, VALOR MAIOR QUE SALDO");		
		}
		
		if (valor > limiteSaque) {
			throw new DominiosException("ERRO! SAQUE NÃO AUTORIZADO, VALOR MAIOR QUE LIMITE SAQUE");		
		}
	}
	
	@Override
	public String toString() {
		return "SALDO ATUALIZADO: " + 
		String.format("%.2f", saldo);
	}
}
