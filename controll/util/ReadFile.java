package util;

import java.io.File;
import java.io.IOException;

public class ReadFile {
	protected File file;
	private final String url = "C:\\Central de Desenvolvimento\\Java\\Desktop\\Workspace\\JavaLarSystemInterface\\Arquivos\\fileExit";

	public ReadFile() {


		file = new File(url+ File.separator +"file.csv");

		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(file.exists())
			System.out.println("Arquivo criado!");

	}

	public void createFile(File file) {



	}

}
