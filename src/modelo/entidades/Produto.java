package modelo.entidades;

public class Produto {
	
	String nome;
	Double valor;
	Integer quantidade;
	
	// construtores da classe
	public Produto() {
	}

	public Produto(String nome, Double valor, Integer quantidade) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	// getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	// metodos da classe
	public Double calculaTotal() {
		return valor * quantidade;
	}
}

