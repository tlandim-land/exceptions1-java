package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.AluguelCarro;
import modelo.entidades.Veiculo;
import modelo.servicos.ServicoAluguel;
import modelo.servicos.TaxaBrasil;

public class AlugaCarro {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("ENTRE COM OS DADOS DO ALUGUEL");
				
		System.out.print("MODELO CARRO: ");
		String modelo = sc.nextLine();

		System.out.print("INICIO ALUGUEL (DD/MM/AAAA HH:SS): ");
		Date inicio = sdf.parse(sc.nextLine());
				
		System.out.print("FIM ALUGUEL (DD/MM/AAAA HH:SS): ");
		Date fim = sdf.parse(sc.nextLine());
		
		// instancia aluguel carro
		AluguelCarro alugaCarro = new AluguelCarro(inicio, fim, new Veiculo(modelo));
		
		System.out.print("PRECO POR HORA: ");
		double precoHora = sc.nextDouble();
		
		System.out.print("PRECO POR DIA: ");
		double precoDia = sc.nextDouble();
		
		// instancia servico aluguel carro
		ServicoAluguel servicoAluga = new ServicoAluguel(precoDia, precoHora, new TaxaBrasil());
				
		servicoAluga.processarFatura(alugaCarro);
		
		System.out.println("FATURA: ");
		System.out.println("PAGAMENTO BASICO: " + String.format("%.2f",alugaCarro.getFatura().getPagamentoBasico()));
		System.out.println("TAXA............: " + String.format("%.2f",alugaCarro.getFatura().getTaxa()));
		System.out.println("TOTAL PAGAMENTO.: " + String.format("%.2f",alugaCarro.getFatura().getTotalPagamento()));
		
		sc.close();
	}
}
