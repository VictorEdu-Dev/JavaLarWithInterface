package union;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import constants.MessageJavaLar;

public class EventGAS {
	private List<List<Object>> data;
	private String outputFile;

	public EventGAS() {
	}

	public boolean generateReport() {
		try {
			outputFile = chooseOutputFile();

			if (outputFile != null) {
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
					writer.write("1) Qual aluno analisou mais instantes no JavaLar?\n");
					analyzeMostInstances(writer);

					writer.write("\n2) Qual o planeta que mais morreu?\n");
					analyzeMostDeaths(writer);

					writer.write("\n3) Qual planeta normalmente fica com mais vida?\n");
					analyzeMostLife(writer);

					writer.write("\n4) Qual quadrante os bugs se concentram?\n");
					analyzeBugQuadrant(writer);

					writer.write("\n5) Qual quadrante os devs concentram?\n");
					analyzeDevQuadrant(writer);

					writer.write("\n6) Qual foi o total de instantes analisados pela turma?\n");
					analyzeTotalInstances(writer);

					writer.write("\n7) Qual é a média de velocidade de cada planeta?\n");
					analyzeAverageSpeed(writer);

					writer.write("\n8) Qual foi a quantidade total de bugs ocorridos?\n");
					analyzeTotalBugs(writer);

					writer.write("\n9) Qual foi a quantidade total de dev ocorridas?\n");
					analyzeTotalDevs(writer);

					writer.write("\n10) Quantidade total de horas passadas, somando as horas de todos os planetas\n");
					analyzeTotalHours(writer);

					writer.write("\n11) Quantidade de anos totais passados, somando os dias de todos os planetas.\n");
					analyzeTotalYears(writer);
					
					return true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	private void analyzeMostInstances(BufferedWriter writer) throws IOException {
		String mostFrequentStudent = null;
		String matricula = null;
		int maxCount = 0;

		for (List<Object> row : data) {
			String studentName = (String) row.get(0);
			int count = countOccurrences(data, studentName, 0);

			if (count > maxCount) {
				mostFrequentStudent = studentName;
				maxCount = count;
			}
		}

		if (mostFrequentStudent != null) {
			matricula = getMatricula(data, mostFrequentStudent);
			writer.write("O aluno que apareceu mais vezes é: " + matricula + " - " + mostFrequentStudent + "\n");
			writer.write("Número de instantes analisados: " + maxCount + "\n");
		} else {
			writer.write("Não há dados para análise.\n");
		}
	}

	private int countOccurrences(List<List<Object>> data, String target, int columnIndex) {
		int count = 0;
		for (List<Object> row : data) {
			String value = (String) row.get(columnIndex);
			if (value.equals(target)) {
				count++;
			}
		}
		return count;
	}

	private String getMatricula(List<List<Object>> data, String studentName) {
		for (List<Object> row : data) {
			String name = (String) row.get(0);
			if (name.equals(studentName)) {
				return (String) row.get(1);
			}
		}
		return null;
	}


	private void analyzeMostDeaths(BufferedWriter writer) throws IOException {
		if (data.isEmpty() || data.get(0).size() < 2) {
			writer.write("Não há dados para análise.\n");
			return;
		}

		int numColumns = data.get(0).size();
		String mostDeathsPlanet = null;
		int maxDeaths = 0;

		for (int i = 1; i < numColumns; i++) {
			if (!((String) data.get(0).get(i)).startsWith("v")) {
				continue;  // Ignora colunas que não começam com "v"
			}

			int deathCount = 0;

			for (int j = 1; j < data.size(); j++) {
				Object value = data.get(j).get(i);

				if (value instanceof Integer) {
					int intValue = (Integer) value;
					if (intValue == 0) {
						deathCount++;
					}
				}
			}

			if (deathCount > maxDeaths) {
				mostDeathsPlanet = (String) data.get(0).get(i);
				maxDeaths = deathCount;
			}
		}

		if (mostDeathsPlanet != null) {
			writer.write("O planeta que mais morreu é: " + mostDeathsPlanet + "\n");
			writer.write("Número de mortes: " + maxDeaths + "\n");
		} else {
			writer.write("Não há dados para análise.\n");
		}
	}


	private void analyzeMostLife(BufferedWriter writer) throws IOException {
		if (data.isEmpty() || data.get(0).size() < 2) {
			writer.write("Não há dados para análise.\n");
			return;
		}

		int numColumns = data.get(0).size();
		String mostLifePlanet = null;
		int maxPositiveCounts = 0;

		for (int i = 1; i < numColumns; i++) {
			int positiveCounts = 0;

			for (int j = 1; j < data.size(); j++) {
				String columnName = (String) data.get(0).get(i);
				if (columnName.startsWith("v")) {
					Object value = data.get(j).get(i);

					if (value instanceof Integer) {
						int intValue = (Integer) value;
						if (intValue > 0) {
							positiveCounts++;
						}
					}
				}
			}

			if (positiveCounts > maxPositiveCounts) {
				mostLifePlanet = data.get(0).get(i).toString();
				maxPositiveCounts = positiveCounts;
			}
		}

		if (mostLifePlanet != null) {
			writer.write("O planeta com mais vida (com base na quantidade de vezes que o número é maior que zero) é: " + mostLifePlanet + "\n");
			writer.write("Quantidade de vezes com vida: " + maxPositiveCounts + "\n");
		} else {
			writer.write("Não há dados para análise.\n");
		}
	}


	private void analyzeBugQuadrant(BufferedWriter writer) throws IOException {
		if (data.isEmpty() || data.get(0).size() < 8) {
			writer.write("Não há dados suficientes para análise dos quadrantes de bugs.\n");
			return;
		}

		int numColumns = data.get(0).size();
		int[] bugQuadrantCounts = new int[4];

		for (int i = 1; i < numColumns; i++) {
			String columnName = (String) data.get(0).get(i);
			if (columnName.startsWith("bug_q")) {
				for (int j = 1; j < data.size(); j++) {
					Object value = data.get(j).get(i);

					if (value instanceof Integer) {
						int bugCount = (Integer) value;
						int quadrant = Integer.parseInt(columnName.substring(columnName.length() - 1));
						bugQuadrantCounts[quadrant - 1] += bugCount;
					}
				}
			}
		}

		int maxBugQuadrant = 0;
		int maxBugCount = bugQuadrantCounts[0];

		for (int i = 1; i < bugQuadrantCounts.length; i++) {
			if (bugQuadrantCounts[i] > maxBugCount) {
				maxBugQuadrant = i;
				maxBugCount = bugQuadrantCounts[i];
			}
		}

		writer.write("O quadrante com maior concentração de bugs é o Quadrante " + (maxBugQuadrant + 1) + "\n");
		writer.write("Quantidade total de bugs no quadrante: " + maxBugCount + "\n");
	}

	private void analyzeDevQuadrant(BufferedWriter writer) throws IOException {
		if (data.isEmpty() || data.get(0).size() < 8) {
			writer.write("Não há dados suficientes para análise dos quadrantes de desenvolvimento.\n");
			return;
		}

		int numColumns = data.get(0).size();
		int[] devQuadrantCounts = new int[4];

		for (int i = 1; i < numColumns; i++) {
			String columnName = (String) data.get(0).get(i);
			if (columnName.startsWith("dev_q")) {
				for (int j = 1; j < data.size(); j++) {
					Object value = data.get(j).get(i);

					if (value instanceof Integer) {
						int devCount = (Integer) value;
						int quadrant = Integer.parseInt(columnName.substring(columnName.length() - 1));
						devQuadrantCounts[quadrant - 1] += devCount;
					}
				}
			}
		}

		int maxDevQuadrant = 0;
		int maxDevCount = devQuadrantCounts[0];

		for (int i = 1; i < devQuadrantCounts.length; i++) {
			if (devQuadrantCounts[i] > maxDevCount) {
				maxDevQuadrant = i;
				maxDevCount = devQuadrantCounts[i];
			}
		}

		writer.write("O quadrante com maior concentração de desenvolvimento é o Quadrante " + (maxDevQuadrant + 1) + "\n");
		writer.write("Quantidade total de desenvolvimento no quadrante: " + maxDevCount + "\n");
	}


	private void analyzeTotalInstances(BufferedWriter writer) throws IOException {
		if (data.isEmpty() || data.get(0).size() < 1) {
			writer.write("Não há dados para análise.\n");
			return;
		}

		int totalInstances = 0;

		// Encontrar a coluna "nome_arquivo"
		int columnIndex = -1;
		List<Object> header = data.get(0);
		for (int i = 0; i < header.size(); i++) {
			if ("nome_arquivo".equals(header.get(i))) {
				columnIndex = i;
				break;
			}
		}

		if (columnIndex == -1) {
			writer.write("Coluna 'nome_arquivo' não encontrada.\n");
			return;
		}

		for (int i = 1; i < data.size(); i++) {
			Object value = data.get(i).get(columnIndex);

			if (value instanceof String) {
				String fileName = (String) value;

				if (fileName.startsWith("AE_")) {
	                fileName = fileName.substring(3);
	            }
				
				if (fileName.endsWith(".csv")) {
					fileName = fileName.substring(0, fileName.length() - 4);
				}

				// Verificar se o restante da string contém apenas dígitos
				if (fileName.matches("\\d+")) {
					totalInstances += Integer.parseInt(fileName);
				} else {
					writer.write("Formato inválido de número no arquivo '" + fileName + "'.\n");
					return;
				}
			}
		}

		if (totalInstances > 0) {
			writer.write("Quantidade total de instantes analisados pela turma: " + totalInstances + "\n");
		} else {
			writer.write("Não há dados para análise.\n");
		}
	}



	private void analyzeAverageSpeed(BufferedWriter writer) throws IOException {
	    if (data.isEmpty() || data.get(0).size() < 2) {
	        writer.write("Não há dados para análise.\n");
	        return;
	    }

	    List<String> planetNames = new ArrayList<>();
	    Map<String, Integer> planetColumnMap = new HashMap<>();
	    Map<String, Double> totalVelocities = new HashMap<>();
	    Map<String, Integer> velocityCounts = new HashMap<>();

	    // Identificar colunas relacionadas à velocidade
	    List<Object> header = data.get(0);
	    for (int i = 1; i < header.size(); i++) {
	        String columnName = (String) header.get(i);
	        if (columnName.startsWith("v")) {
	            planetNames.add(columnName);
	            planetColumnMap.put(columnName, i);
	            totalVelocities.put(columnName, 0.0);
	            velocityCounts.put(columnName, 0);
	        }
	    }

	    if (planetNames.isEmpty()) {
	        writer.write("Não há colunas de velocidade para análise.\n");
	        return;
	    }

	    for (int i = 1; i < data.size(); i++) {
	        List<Object> row = data.get(i);

	        for (String planetName : planetNames) {
	            int columnIndex = planetColumnMap.get(planetName);

	            if (columnIndex < row.size()) {
	                Object value = row.get(columnIndex);

	                if (value instanceof Integer) {
	                    int velocity = (int) value;
	                    totalVelocities.put(planetName, totalVelocities.get(planetName) + velocity);
	                    velocityCounts.put(planetName, velocityCounts.get(planetName) + 1);
	                }
	            }
	        }
	    }

	    for (String planetName : planetNames) {
	        double totalVelocity = totalVelocities.get(planetName);
	        int velocityCount = velocityCounts.get(planetName);

	        if (velocityCount > 0) {
	            double averageVelocity = totalVelocity / velocityCount;
	            writer.write("Planeta: " + planetName + " - Velocidade Média: " + averageVelocity + "\n");
	        } else {
	            writer.write("Planeta: " + planetName + " - Sem dados de velocidade.\n");
	        }
	    }
	}


	private void analyzeTotalBugs(BufferedWriter writer) throws IOException {
	    if (data.isEmpty() || data.get(0).size() < 2) {
	        writer.write("Não há dados para análise.\n");
	        return;
	    }

	    List<String> bugColumns = new ArrayList<>();

	    List<Object> header = data.get(0);
	    for (int i = 1; i < header.size(); i++) {
	        String columnName = (String) header.get(i);
	        if (columnName.startsWith("bug") && columnName.contains("_") && !columnName.endsWith("q")) {
	            bugColumns.add(columnName);
	        }
	    }

	    if (bugColumns.isEmpty()) {
	        writer.write("Não há colunas de bugs para análise.\n");
	        return;
	    }

	    int totalBugs = 0;

	    for (int i = 1; i < data.size(); i++) {
	        List<Object> row = data.get(i);

	        for (String bugColumn : bugColumns) {
	            int columnIndex = header.indexOf(bugColumn);

	            if (columnIndex >= 0 && columnIndex < row.size()) {
	                Object value = row.get(columnIndex);

	                if (value instanceof Integer) {
	                    totalBugs += (Integer) value;
	                }
	            }
	        }
	    }

	    writer.write("Quantidade total de bugs ocorridos: " + totalBugs + "\n");
	}


	private void analyzeTotalDevs(BufferedWriter writer) throws IOException {
	    if (data.isEmpty() || data.get(0).size() < 2) {
	        writer.write("Não há dados para análise.\n");
	        return;
	    }

	    List<String> devColumns = new ArrayList<>();

	    List<Object> header = data.get(0);
	    for (int i = 1; i < header.size(); i++) {
	        String columnName = (String) header.get(i);
	        if (columnName.startsWith("dev") && columnName.contains("_") && !columnName.endsWith("q")) {
	            devColumns.add(columnName);
	        }
	    }

	    if (devColumns.isEmpty()) {
	        writer.write("Não há colunas de desenvolvimento para análise.\n");
	        return;
	    }

	    int totalDevs = 0;

	    // Iterar sobre os dados e calcular a quantidade total de desenvolvimento
	    for (int i = 1; i < data.size(); i++) {
	        List<Object> row = data.get(i);

	        for (String devColumn : devColumns) {
	            int columnIndex = header.indexOf(devColumn);

	            if (columnIndex >= 0 && columnIndex < row.size()) {
	                Object value = row.get(columnIndex);

	                if (value instanceof Integer) {
	                    totalDevs += (Integer) value;
	                }
	            }
	        }
	    }

	    writer.write("Quantidade total de dev ocorridas: " + totalDevs + "\n");
	}


	private void analyzeTotalHours(BufferedWriter writer) throws IOException {
	    if (data.isEmpty() || data.get(0).size() < 2) {
	        writer.write("Não há dados para análise.\n");
	        return;
	    }

	    List<String> dayColumns = new ArrayList<>();

	    List<Object> header = data.get(0);
	    for (int i = 1; i < header.size(); i++) {
	        String columnName = (String) header.get(i);
	        if (columnName.startsWith("d")) {
	            dayColumns.add(columnName);
	        }
	    }

	    if (dayColumns.isEmpty()) {
	        writer.write("Não há colunas de horas para análise.\n");
	        return;
	    }

	    int totalHours = 0;

	    for (int i = 1; i < data.size(); i++) {
	        List<Object> row = data.get(i);

	        for (String dayColumn : dayColumns) {
	            int columnIndex = header.indexOf(dayColumn);

	            if (columnIndex >= 0 && columnIndex < row.size()) {
	                Object value = row.get(columnIndex);

	                if (value instanceof Integer) {
	                    totalHours += (Integer) value;
	                }
	            }
	        }
	    }

	    writer.write("Quantidade total de horas passadas: " + totalHours + "\n");
	}


	private void analyzeTotalYears(BufferedWriter writer) throws IOException {
	    if (data.isEmpty() || data.get(0).size() < 2) {
	        writer.write("Não há dados para análise.\n");
	        return;
	    }

	    List<String> yearColumns = new ArrayList<>();

	    List<Object> header = data.get(0);
	    for (int i = 1; i < header.size(); i++) {
	        String columnName = (String) header.get(i);
	        if (columnName.startsWith("a")) {
	            yearColumns.add(columnName);
	        }
	    }

	    if (yearColumns.isEmpty()) {
	        writer.write("Não há colunas de anos para análise.\n");
	        return;
	    }

	    int totalYears = 0;

	    for (int i = 1; i < data.size(); i++) {
	        List<Object> row = data.get(i);

	        for (String yearColumn : yearColumns) {
	            int columnIndex = header.indexOf(yearColumn);

	            if (columnIndex >= 0 && columnIndex < row.size()) {
	                Object value = row.get(columnIndex);

	                if (value instanceof Integer) {
	                    totalYears += (Integer) value;
	                }
	            }
	        }
	    }

	    writer.write("Quantidade de anos totais passados: " + totalYears + "\n");
	}


	private String chooseOutputFile() {
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Salvar relatório");
			fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto (.txt)", "txt"));

			int userSelection = fileChooser.showSaveDialog(null);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				return fileChooser.getSelectedFile().getAbsolutePath() + ".txt";
			} else {
				MessageJavaLar.OPERATION_CANCELED.showMessage();
				throw new IOException("Operação de salvar relatório cancelada pelo usuário.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public List<List<Object>> getData() {
		return data;
	}

	public void setData(List<List<Object>> data) {
		this.data = data;
	}
}
