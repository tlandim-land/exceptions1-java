package aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Produto;

public class LeituraProduto {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Produto> lista = new ArrayList<>();
		
		System.out.print("DIGITE O CAMINHO PARA SALVAR ARQUIVO: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		String strFolder = path.getParent();
		
		boolean sucess = new File(strPath + "\\out").mkdir();

		String strFile = strFolder + "\\out\\summary.csv"; 
				
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String itemCsv = br.readLine();
			
			while(itemCsv != null) {
				
				String[] fields = itemCsv.split(",");
				String nome = fields[0];
				double valor = Double.parseDouble(fields[1]);
				int quantidade = Integer.parseInt(fields[2]);
				
				lista.add(new Produto(nome, valor, quantidade));
				
				System.out.println(itemCsv);
				
				itemCsv = br.readLine();
			}
		} 
		catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strFile))){
			for(Produto item : lista) {
				bw.write(item.getNome() + "," + String.format("%.2f", item.calculaTotal()));
				bw.newLine();
			}
			
			System.out.println(strFile + " CRIADO!");
		}
		catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}		
	}
}
