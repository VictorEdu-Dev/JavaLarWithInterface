package util;

import java.util.ArrayList;

public class ExtractArray {
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
}
