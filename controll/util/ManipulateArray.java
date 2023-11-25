package util;

import java.util.ArrayList;
import planets.AstroLinguagem;

public class ManipulateArray {

	public static ArrayList<ArrayList<String>> removerColunaPorNome(ArrayList<ArrayList<String>> originalValues, ArrayList<AstroLinguagem> colunas) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        ArrayList<ArrayList<String>> originalCopy = new ArrayList<>(originalValues);

        for (AstroLinguagem coluna : colunas) {
            int colunaIndex = originalCopy.get(0).indexOf(coluna.getNome());

            if (colunaIndex != -1) {
                for (ArrayList<String> row : originalCopy) {
                    if (row.size() > colunaIndex) {
                        row.remove(colunaIndex);
                    }
                }
            }
        }

        for (ArrayList<String> row : originalCopy) {
            result.add(new ArrayList<>(row));
        }

        return result;
    }

	public static ArrayList<String> obterProximaLinha(ArrayList<ArrayList<String>> values) {
		if (values.size() > 0 && !values.get(0).isEmpty()) {
			ArrayList<String> proximaLinha = new ArrayList<>();
			for (ArrayList<String> row : values) {
				if (!row.isEmpty()) {
					proximaLinha.add(row.remove(0));
				}
			}
			return proximaLinha;
		}
		return new ArrayList<>(); // Retorna uma lista vazia se não houver mais linhas
	}

}
