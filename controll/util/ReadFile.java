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
	
	public ReadFile() {
	}

	public static String[][] readValues() {
        List<String[]> valuesList = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(escolherArquivo()))) {
            String linha;

            while ((linha = buffer.readLine()) != null) {
                // Divide a linha em valores usando a vírgula como delimitador
                String[] lineValues = linha.split(",");
                // Adiciona a linha ao ArrayList
                valuesList.add(lineValues);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Converte o ArrayList para um array bidimensional
        String[][] valuesArray = new String[valuesList.size()][];
        valuesArray = valuesList.toArray(valuesArray);

        return valuesArray;
    }
	
	public static File escolherArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        
        // Configurar o filtro de extensão de arquivo
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        // Abre o diálogo de seleção de arquivo
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }
}
