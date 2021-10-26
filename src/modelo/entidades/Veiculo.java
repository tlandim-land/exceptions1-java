package modelo.entidades;

public class Veiculo {
	
	private String modelo;
	
	// construtores da classe
	public Veiculo() {
	}
	
	public Veiculo(String modelo) {
		this.modelo = modelo;
	}

	// getters e setters 
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
