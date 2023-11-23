package exit;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileExit {

    private List<String> dadosJavaLar;  // Dados do JavaLar

    public FileExit(List<String> dadosJavaLar) {
        this.dadosJavaLar = dadosJavaLar;
    }
    
    public static void criarArquivoCSV(String caminhoArquivo, List<String> dados) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoArquivo))) {
            // Escreva os cabeçalhos do CSV (se necessário)
            writer.println("Nome;Matrícula;Nome do Arquivo");

            // Escreva os dados no CSV
            for (String dado : dados) {
                // Substitua ',' por ';' (ou qualquer delimitador desejado)
                String linhaCSV = dado.replace(",", ";");
                // Adicione ao arquivo
                writer.println(linhaCSV);
            }
            System.out.println("Arquivo CSV criado com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gerarRelatorio(String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoArquivo))) {
            // 1) Qual aluno analisou mais instantes (cada linha do arquivo) no JavaLar?
            String alunoMaisInstantes = calcularAlunoMaisInstantes();
            writer.println("1) Aluno que analisou mais instantes: " + alunoMaisInstantes);

            // 2) Qual o planeta que mais morreu?
            String planetaMaisMorto = calcularPlanetaMaisMorto();
            writer.println("2) Planeta que mais morreu: " + planetaMaisMorto);

            // 3) Qual planeta normalmente fica com mais vida?
            String planetaMaisVivo = calcularPlanetaMaisVivo();
            writer.println("3) Planeta que normalmente fica com mais vida: " + planetaMaisVivo);

            // Adicione mais cálculos e respostas conforme necessário

            System.out.println("Relatório de saída criado com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String calcularAlunoMaisInstantes() {
        // Separar cada linha de dados
        String[] linhas = dadosJavaLar.toArray(new String[0]);

        // Contadores para cada aluno
        int[] contadores = new int[linhas.length];

        // Preencher os contadores
        for (int i = 0; i < linhas.length; i++) {
            String aluno = linhas[i].split(",")[0];
            contadores[i] = 1;  // Contar cada linha como um instante
            for (int j = i + 1; j < linhas.length; j++) {
                if (linhas[j].startsWith(aluno)) {
                    contadores[i]++;  // Incrementar o contador para o mesmo aluno
                }
            }
        }

        // Encontrar o índice do contador máximo
        int indiceMax = 0;
        for (int i = 1; i < contadores.length; i++) {
            if (contadores[i] > contadores[indiceMax]) {
                indiceMax = i;
            }
        }

        // Retornar o resultado formatado
        return linhas[indiceMax].split(",")[0];  // O nome do aluno está na primeira parte da linha
    }

    private String calcularPlanetaMaisMorto() {
        // Implemente a lógica para calcular o planeta que mais morreu.
        // Retorne o nome do planeta.
        // Exemplo de lógica fictícia:
        // Percorrer dadosJavaLar, contar mortes por planeta e retornar o planeta com mais mortes.
        return "Python";
    }

    private String calcularPlanetaMaisVivo() {
        // Implemente a lógica para calcular o planeta que normalmente fica com mais vida.
        // Retorne o nome do planeta.
        // Exemplo de lógica fictícia:
        // Percorrer dadosJavaLar, calcular média de vida por planeta e retornar o planeta com mais vida.
        return "Java";
    }

    // Adicione mais métodos para os outros cálculos necessários
}

