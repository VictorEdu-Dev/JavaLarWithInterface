package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataInsert  {
	private static Connection connection;
	
    private String nome;
    private String matricula;
    private String nomeArquivo;

    // Números de bugs e devs por planeta
    private int bugPython;
    private int bugJavaScript;
    private int bugRuby;
    private int bugPHP;
    private int bugCSharp;
    private int bugCPlusPlus;
    private int bugC;

    private int devPython;
    private int devJavaScript;
    private int devRuby;
    private int devPHP;
    private int devCSharp;
    private int devCPlusPlus;
    private int devC;

    // Velocidades de rotação e translação por planeta
    private double vPython;
    private double vJavaScript;
    private double vRuby;
    private double vPHP;
    private double vCSharp;
    private double vCPlusPlus;
    private double vC;

    // Quantidade de dias e anos por planeta
    private int dPython;
    private int dJavaScript;
    private int dRuby;
    private int dPHP;
    private int dCSharp;
    private int dCPlusPlus;
    private int dC;

    private int aPython;
    private int aJavaScript;
    private int aRuby;
    private int aPHP;
    private int aCSharp;
    private int aCPlusPlus;
    private int aC;

    // Quantidade de bugs por quadrante
    private int bugQ1;
    private int bugQ2;
    private int bugQ3;
    private int bugQ4;

    // Quantidade de devs por quadrante
    private int devQ1;
    private int devQ2;
    private int devQ3;
    private int devQ4;
    
    public DataInsert() {
    }
    
    public DataInsert(Connection connection) {
		DataInsert.connection = connection;
	}

    public DataInsert(String nome, String matricula, String nomeArquivo) {
        this.nome = nome;
        this.matricula = matricula;
        this.nomeArquivo = nomeArquivo;
    }

    public void adicionarBugs(int python, int javaScript, int ruby, int php, int cSharp, int cPlusPlus, int c) {
        this.bugPython = python;
        this.bugJavaScript = javaScript;
        this.bugRuby = ruby;
        this.bugPHP = php;
        this.bugCSharp = cSharp;
        this.bugCPlusPlus = cPlusPlus;
        this.bugC = c;
    }

    public void adicionarDevs(int python, int javaScript, int ruby, int php, int cSharp, int cPlusPlus, int c) {
        this.devPython = python;
        this.devJavaScript = javaScript;
        this.devRuby = ruby;
        this.devPHP = php;
        this.devCSharp = cSharp;
        this.devCPlusPlus = cPlusPlus;
        this.devC = c;
    }

    public void adicionarVelocidades(double python, double javaScript, double ruby, double php, double cSharp, double cPlusPlus, double c) {
        this.vPython = python;
        this.vJavaScript = javaScript;
        this.vRuby = ruby;
        this.vPHP = php;
        this.vCSharp = cSharp;
        this.vCPlusPlus = cPlusPlus;
        this.vC = c;
    }

    public void adicionarDias(int python, int javaScript, int ruby, int php, int cSharp, int cPlusPlus, int c) {
        this.dPython = python;
        this.dJavaScript = javaScript;
        this.dRuby = ruby;
        this.dPHP = php;
        this.dCSharp = cSharp;
        this.dCPlusPlus = cPlusPlus;
        this.dC = c;
    }

    public void adicionarAnos(int python, int javaScript, int ruby, int php, int cSharp, int cPlusPlus, int c) {
        this.aPython = python;
        this.aJavaScript = javaScript;
        this.aRuby = ruby;
        this.aPHP = php;
        this.aCSharp = cSharp;
        this.aCPlusPlus = cPlusPlus;
        this.aC = c;
    }

    public void adicionarBugsQuadrantes(int q1, int q2, int q3, int q4) {
        this.bugQ1 = q1;
        this.bugQ2 = q2;
        this.bugQ3 = q3;
        this.bugQ4 = q4;
    }

    public void adicionarDevsQuadrantes(int q1, int q2, int q3, int q4) {
        this.devQ1 = q1;
        this.devQ2 = q2;
        this.devQ3 = q3;
        this.devQ4 = q4;
    }

    public void gravarRelatorio(Connection connection) {
    	DataInsert.connection = connection;
        String query = "INSERT INTO javalar (nome, matricula, nome_arquivo, " +
                "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, " +
                "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, " +
                "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, " +
                "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, " +
                "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, " +
                "bug_q1, bug_q2, bug_q3, bug_q4, " +
                "dev_q1, dev_q2, dev_q3, dev_q4) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        inserirRegistro(query, nome, matricula, nomeArquivo,
                bugPython, bugJavaScript, bugRuby, bugPHP, bugCSharp, bugCPlusPlus, bugC,
                devPython, devJavaScript, devRuby, devPHP, devCSharp, devCPlusPlus, devC,
                vPython, vJavaScript, vRuby, vPHP, vCSharp, vCPlusPlus, vC,
                dPython, dJavaScript, dRuby, dPHP, dCSharp, dCPlusPlus, dC,
                aPython, aJavaScript, aRuby, aPHP, aCSharp, aCPlusPlus, aC,
                bugQ1, bugQ2, bugQ3, bugQ4,
                devQ1, devQ2, devQ3, devQ4);
    }
    
    public static void inserirRegistro(String query, Object... parametros) {
        try (Connection conexao = connection;
             PreparedStatement stmt = conexao.prepareStatement(query)) {

            for (int i = 0; i < parametros.length; i++) {
                stmt.setObject(i + 1, parametros[i]);
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> lerDadosOutrosParticipantes() {
        List<String> dadosOutrosParticipantes = new ArrayList<>();

        try {
            String query = "SELECT nome, matricula, nome_arquivo FROM javalar";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String matricula = resultSet.getString("matricula");
                String nomeArquivo = resultSet.getString("nome_arquivo");

                String dados = "Nome: " + nome + ", Matrícula: " + matricula + ", Arquivo: " + nomeArquivo;
                dadosOutrosParticipantes.add(dados);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dadosOutrosParticipantes;
    }
}

