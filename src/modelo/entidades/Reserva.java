package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numero;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// construtores da classe
	public Reserva() {
	}
	
	public Reserva(Integer numero, Date entrada, Date saida) {
		this.numero = numero;
		this.entrada = entrada;
		this.saida = saida;
	}
	
	// getters e setters
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Date getEntrada() {
		return entrada;
	}
	
	public Date getSaida() {
		return saida;
	}
	
	//metodos da classe
	public long duracao() {
		long diferenca = entrada.getTime() - saida.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizaDatas(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return "QUARTO: " + numero + 
				", DATA ENTRADA: " + sdf.format(entrada) + 
				", DATA SAIDA: " + sdf.format(saida) + 
				", " + duracao() + " NOITES";				
	}
}
