package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.List;
import java.util.ArrayList;

public class ReadFile {
	private File file;
    private String fileName;

    public ReadFile() {
    }

	public ArrayList<ArrayList<String>> readValues() {
        List<ArrayList<String>> valuesList = new ArrayList<>();

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(escolherArquivo()));
            String linha;

            while ((linha = buffer.readLine()) != null) {
                // Divide a linha em valores usando a vírgula como delimitador
                String[] lineValues = linha.split(",");
                // Converte o array de strings para um ArrayList e adiciona à lista
                ArrayList<String> lineList = new ArrayList<>();
                for (String value : lineValues) {
                    lineList.add(value);
                }
                valuesList.add(lineList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(valuesList);
    }

	public File escolherArquivo() {
		JFileChooser fileChooser = new JFileChooser();

		// Configurar o filtro de extensão de arquivo
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
		fileChooser.setFileFilter(filter);

		// Abre o diálogo de seleção de arquivo
		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			fileName = file.getName();
			return file;
		}

		return null;
	}
	
	public File getFile() {
        return file;
    }

    public String getNomeArquivo() {
        return fileName;
    }
}
