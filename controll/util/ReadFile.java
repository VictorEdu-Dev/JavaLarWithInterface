package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;

public class ReadFile {
	private String value;
	private final String url = "C:\\Central de Desenvolvimento\\Java\\Desktop\\Workspace\\JavaLarSystemInterface\\Arquivos\\tba2\\";

	public ReadFile() {

		readFile();
	}

	public void readFile() {
		try (BufferedReader buffer =  new BufferedReader(new FileReader(url+File.separator+"AE_10.csv"))) {
			String linha;
//			String[] cabecalhos = buffer.readLine().split(",");

			while((linha = buffer.readLine()) != null) {
				String[] columns = linha.split(",");

				value = columns[2];
				
				int valueInetger = Integer.parseInt(value);
				

				System.out.println(valueInetger);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
