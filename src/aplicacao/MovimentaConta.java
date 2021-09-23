package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Conta;
import modelo.entidades.DominiosException;

public class MovimentaConta {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("ENTRE COM OS DADOS DA CONTA");
		System.out.print("DIGITE NUMERO DA CONTA: ");
		int numeroConta = sc.nextInt();
		
		System.out.print("DIGITE NOME TITULAR DA CONTA: ");
		sc.nextLine();
		String titular = sc.nextLine();

		System.out.print("DIGITE O SALDO INICIAL DA CONTA: ");
		double saldo = sc.nextDouble();

		System.out.print("DIGITE O LIMITE DE SAQUE DA CONTA: ");
		double limiteSaque = sc.nextDouble();
		
		Conta conta = new Conta(numeroConta, titular, saldo, limiteSaque);
		
		System.out.println();
		System.out.println(conta);
		System.out.println();
		
		try {
			System.out.print("DIGITE VALOR DE SAQUE DA CONTA: ");
			double valorSaque = sc.nextDouble();

			conta.atualizaSaldo(valorSaque);
			
			System.out.println();
			System.out.println(conta);
			System.out.println();
		}
		// erro saldo
		catch(DominiosException e) {
			System.out.println(e.getMessage());
		}
		// erro genérico
		catch(RuntimeException e) {
			System.out.println("ERRO INESPERADO");			
		}		
		sc.close();
	}
}
