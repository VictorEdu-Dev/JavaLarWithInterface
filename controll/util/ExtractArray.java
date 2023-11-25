package util;

import java.util.ArrayList;
import java.util.List;

import planets.AstroLinguagem;

public class ExtractArray {

	public ExtractArray() {
	}

	public static ArrayList<ArrayList<String>> extractLastTwoColumns(ArrayList<ArrayList<String>> originalValues) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();

		for (ArrayList<String> row : originalValues) {
			int size = row.size();
			if (size >= 2) {
				ArrayList<String> newRow = new ArrayList<>();
				newRow.add(row.remove(size - 2));
				newRow.add(row.remove(size - 2));

				result.add(newRow);
			}
		}
		return result;
	}

	public static ArrayList<ArrayList<String>> extractColumn(ArrayList<ArrayList<String>> originalValues, int columnToRemove) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();

		for (ArrayList<String> row : originalValues) {
			int size = row.size();
			if (size > columnToRemove) {
				row.remove(columnToRemove);
				result.add(row);
			}
		}

		return result;
	}

	public static ArrayList<ArrayList<String>> extractColumn(ArrayList<ArrayList<String>> originalValues, List<AstroLinguagem> objectsToRemove) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();

		// Obter os nomes a serem removidos
		ArrayList<String> namesToRemove = new ArrayList<>();
		for (AstroLinguagem obj : objectsToRemove) {
			namesToRemove.add(obj.getNome());
			System.out.println(obj.getNome());
		}

		// Iterar sobre as linhas originais
		for (ArrayList<String> row : originalValues) {
			ArrayList<String> newRow = new ArrayList<>();

			// Iterar sobre as colunas
			for (int i = 0; i < row.size(); i++) {
				// Verificar se o nome está na lista de nomes a serem removidos
				if (!namesToRemove.contains(originalValues.get(0).get(i))) {
					newRow.add(row.get(i));
				}
			}

			result.add(newRow);
		}
		
		return result;
	}

	public static ArrayList<String> removeColumnIfNotPresent(ArrayList<String> originalRow, ArrayList<String> columnsToKeep) {
	    ArrayList<String> resultRow = new ArrayList<>();

	    for (String column : originalRow) {
	        // Verificar se a coluna está presente na lista columnsToKeep
	        if (columnsToKeep.contains(column)) {
	            resultRow.add(column);
	        }
	    }

	    return resultRow;
	}

}
