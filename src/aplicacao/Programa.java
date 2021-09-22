package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.DominiosException;
import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("DIGITE O NUMERO DO QUARTO: ");
			int numero = sc.nextInt();
			
			System.out.print("DIGITE DATA ENTRADA <DD/MM/AAAA>: ");
			Date entrada = sdf.parse(sc.next());
			
			System.out.print("DIGITE DATA SAIDA <DD/MM/AAAA>: ");
			Date saida = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("RESERVA " + reserva);
			System.out.println();
			
			System.out.println("ENTRE COM DATAS PARA ATUALIZAÇÃO DA RESERVA");
			
			System.out.print("DIGITE DATA ENTRADA <DD/MM/AAAA>: ");
			entrada = sdf.parse(sc.next());
			
			System.out.print("DIGITE DATA SAIDA <DD/MM/AAAA>: ");
			saida = sdf.parse(sc.next());
			
			reserva.atualizaDatas(entrada, saida);
					
			System.out.println("RESERVA " + reserva);
			System.out.println();
		}		
		catch(ParseException e) {
			System.out.println("FORMATO DE DATA INVALIDA");
		}
		catch(DominiosException e) {
			System.out.println("ERRO NA RESERVA " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("ERRO INESPERADO");			
		}
		
		sc.close();	
	}
}
