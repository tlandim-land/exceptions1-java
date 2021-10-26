package aplicacao;

import java.io.File;
import java.util.Scanner;

public class LeituraArquivo {

	public static void main(String[] args) {
		// READ
		/* - - - File com Scanner
		File file = new File("C:\\Users\\tland\\OneDrive\\Área de Trabalho\\LANDIM\\projetos_ECLIPSE\\projetos_novos\\arqread.txt");
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
		catch (IOException e) {
			System.out.println("ERRO : " + e.getMessage());
		}		
		finally {
			if (sc != null) {
				sc.close();
			}
		}*/
		
		/* - - - BufferedReader / FileReader 
		String path = ("C:\\Users\\tland\\OneDrive\\Área de Trabalho\\LANDIM\\projetos_ECLIPSE\\projetos_novos\\arqread.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} 
		catch (IOException e) {
			System.out.println("ERRO : " + e.getMessage());
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
				
				if (fr != null) {
					fr.close();
				}				
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/		

		/* - - - BufferedReader / FileReader + limpo 
		String path = ("C:\\Users\\tland\\OneDrive\\Área de Trabalho\\LANDIM\\projetos_ECLIPSE\\projetos_novos\\arqread.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} 
		catch (IOException e) {
			System.out.println("ERRO : " + e.getMessage());
		}
		*/
		
		/* WRITE
		String[] lines = new String[] {"GOOD MORNING","GOOD AFTERNOON", "GOOD NIGHT"}; 
		
		String path = ("C:\\Users\\tland\\OneDrive\\Área de Trabalho\\LANDIM\\projetos_ECLIPSE\\projetos_novos\\arqwrite.txt");
													// sem parametro true > recria arquivo do zero 
													// com parametro true > inclui no final do arquivo 
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch (IOException e) {
			System.out.println("ERRO" + e.getMessage());
		}
		*/
		
		//* WRITE com manipulação de pastas
		Scanner sc = new Scanner(System.in);
		
		System.out.print("DIGITE O CAMINHO PARA SALVAR ARQUIVO : ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("PASTAS :");
		
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile);

		System.out.println("ARQUIVOS :");
		
		for (File file : files) {
			System.out.println(file);
		}
		
		boolean sucess = new File(strPath + "\\pastateste").mkdir();
		System.out.println("DIRETORIO CRIADO COM SUCESSO " + sucess);
		
		//FUNÇÕES
		//getName ( pega nome do arquivo do local que está sendo consultado )
		//getParent ( pega nome da pasta do arquivo do local que está sendo consultado )
		//getPath ( pega nome do arquivo + nome da pasta do arquivo do local que está sendo consultado )
		
		sc.close();
	}		
}
