package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;

public class DataInsert  {
	private static Connection connection;
	
    private String nome;
    private int matricula;
    private String nomeArquivo;
    
    private boolean verifyConcludeOperation;

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
    private int vPython;
    private int vJavaScript;
    private int vRuby;
    private int vPHP;
    private int vCSharp;
    private int vCPlusPlus;
    private int vC;

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

    public void adicionarVelocidades(int python, int javaScript, int ruby, int php, int cSharp, int cPlusPlus, int c) {
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

    public void saveReport() {
    	int numColunas = 46;

    	String placeholders = String.join(", ", Collections.nCopies(numColunas, "?"));
    	
        String query = "INSERT INTO javalar (nome, matricula, nome_arquivo, " +
                "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, " +
                "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, " +
                "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, " +
                "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, " +
                "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, " +
                "bug_q1, bug_q2, bug_q3, bug_q4, " +
                "dev_q1, dev_q2, dev_q3, dev_q4) " +
                "VALUES (" + placeholders + ")";

        inserirRegistro(query, nome, matricula, nomeArquivo,
                bugPython, bugJavaScript, bugRuby, bugPHP, bugCSharp, bugCPlusPlus, bugC,
                devPython, devJavaScript, devRuby, devPHP, devCSharp, devCPlusPlus, devC,
                vPython, vJavaScript, vRuby, vPHP, vCSharp, vCPlusPlus, vC,
                dPython, dJavaScript, dRuby, dPHP, dCSharp, dCPlusPlus, dC,
                aPython, aJavaScript, aRuby, aPHP, aCSharp, aCPlusPlus, aC,
                bugQ1, bugQ2, bugQ3, bugQ4,
                devQ1, devQ2, devQ3, devQ4);
        try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void inserirRegistroEspecial(Object... parametros) {
    	String query = "INSERT INTO aluno (nome, matricula) VALUES (?, ?)";
    	
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
    
    public void inserirRegistro(String query, Object... parametros) {
        try (Connection conexao = connection;
             PreparedStatement stmt = conexao.prepareStatement(query)) {

            for (int i = 0; i < parametros.length; i++) {
                stmt.setObject(i + 1, parametros[i]);
            }

            stmt.executeUpdate();
            setVerifyConcludeOperation(true);
            
        } catch (SQLException e) {
            e.printStackTrace();
            setVerifyConcludeOperation(false);
        }
    }
    
    
    // Getters e setters para uso posterior
	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		DataInsert.connection = connection;
	}

	public String getNome() {
		return nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public int getBugPython() {
		return bugPython;
	}

	public void setBugPython(int bugPython) {
		this.bugPython = bugPython;
	}

	public int getBugJavaScript() {
		return bugJavaScript;
	}

	public void setBugJavaScript(int bugJavaScript) {
		this.bugJavaScript = bugJavaScript;
	}

	public int getBugRuby() {
		return bugRuby;
	}

	public void setBugRuby(int bugRuby) {
		this.bugRuby = bugRuby;
	}

	public int getBugPHP() {
		return bugPHP;
	}

	public void setBugPHP(int bugPHP) {
		this.bugPHP = bugPHP;
	}

	public int getBugCSharp() {
		return bugCSharp;
	}

	public void setBugCSharp(int bugCSharp) {
		this.bugCSharp = bugCSharp;
	}

	public int getBugCPlusPlus() {
		return bugCPlusPlus;
	}

	public void setBugCPlusPlus(int bugCPlusPlus) {
		this.bugCPlusPlus = bugCPlusPlus;
	}

	public int getBugC() {
		return bugC;
	}

	public void setBugC(int bugC) {
		this.bugC = bugC;
	}

	public int getDevPython() {
		return devPython;
	}

	public void setDevPython(int devPython) {
		this.devPython = devPython;
	}

	public int getDevJavaScript() {
		return devJavaScript;
	}

	public void setDevJavaScript(int devJavaScript) {
		this.devJavaScript = devJavaScript;
	}

	public int getDevRuby() {
		return devRuby;
	}

	public void setDevRuby(int devRuby) {
		this.devRuby = devRuby;
	}

	public int getDevPHP() {
		return devPHP;
	}

	public void setDevPHP(int devPHP) {
		this.devPHP = devPHP;
	}

	public int getDevCSharp() {
		return devCSharp;
	}

	public void setDevCSharp(int devCSharp) {
		this.devCSharp = devCSharp;
	}

	public int getDevCPlusPlus() {
		return devCPlusPlus;
	}

	public void setDevCPlusPlus(int devCPlusPlus) {
		this.devCPlusPlus = devCPlusPlus;
	}

	public int getDevC() {
		return devC;
	}

	public void setDevC(int devC) {
		this.devC = devC;
	}

	public double getvPython() {
		return vPython;
	}

	public void setvPython(int vPython) {
		this.vPython = vPython;
	}

	public double getvJavaScript() {
		return vJavaScript;
	}

	public void setvJavaScript(int vJavaScript) {
		this.vJavaScript = vJavaScript;
	}

	public double getvRuby() {
		return vRuby;
	}

	public void setvRuby(int vRuby) {
		this.vRuby = vRuby;
	}

	public double getvPHP() {
		return vPHP;
	}

	public void setvPHP(int vPHP) {
		this.vPHP = vPHP;
	}

	public double getvCSharp() {
		return vCSharp;
	}

	public void setvCSharp(int vCSharp) {
		this.vCSharp = vCSharp;
	}

	public double getvCPlusPlus() {
		return vCPlusPlus;
	}

	public void setvCPlusPlus(int vCPlusPlus) {
		this.vCPlusPlus = vCPlusPlus;
	}

	public double getvC() {
		return vC;
	}

	public void setvC(int vC) {
		this.vC = vC;
	}

	public int getdPython() {
		return dPython;
	}

	public void setdPython(int dPython) {
		this.dPython = dPython;
	}

	public int getdJavaScript() {
		return dJavaScript;
	}

	public void setdJavaScript(int dJavaScript) {
		this.dJavaScript = dJavaScript;
	}

	public int getdRuby() {
		return dRuby;
	}

	public void setdRuby(int dRuby) {
		this.dRuby = dRuby;
	}

	public int getdPHP() {
		return dPHP;
	}

	public void setdPHP(int dPHP) {
		this.dPHP = dPHP;
	}

	public int getdCSharp() {
		return dCSharp;
	}

	public void setdCSharp(int dCSharp) {
		this.dCSharp = dCSharp;
	}

	public int getdCPlusPlus() {
		return dCPlusPlus;
	}

	public void setdCPlusPlus(int dCPlusPlus) {
		this.dCPlusPlus = dCPlusPlus;
	}

	public int getdC() {
		return dC;
	}

	public void setdC(int dC) {
		this.dC = dC;
	}

	public int getaPython() {
		return aPython;
	}

	public void setaPython(int aPython) {
		this.aPython = aPython;
	}

	public int getaJavaScript() {
		return aJavaScript;
	}

	public void setaJavaScript(int aJavaScript) {
		this.aJavaScript = aJavaScript;
	}

	public int getaRuby() {
		return aRuby;
	}

	public void setaRuby(int aRuby) {
		this.aRuby = aRuby;
	}

	public int getaPHP() {
		return aPHP;
	}

	public void setaPHP(int aPHP) {
		this.aPHP = aPHP;
	}

	public int getaCSharp() {
		return aCSharp;
	}

	public void setaCSharp(int aCSharp) {
		this.aCSharp = aCSharp;
	}

	public int getaCPlusPlus() {
		return aCPlusPlus;
	}

	public void setaCPlusPlus(int aCPlusPlus) {
		this.aCPlusPlus = aCPlusPlus;
	}

	public int getaC() {
		return aC;
	}

	public void setaC(int aC) {
		this.aC = aC;
	}

	public int getBugQ1() {
		return bugQ1;
	}

	public void setBugQ1(int bugQ1) {
		this.bugQ1 = bugQ1;
	}

	public int getBugQ2() {
		return bugQ2;
	}

	public void setBugQ2(int bugQ2) {
		this.bugQ2 = bugQ2;
	}

	public int getBugQ3() {
		return bugQ3;
	}

	public void setBugQ3(int bugQ3) {
		this.bugQ3 = bugQ3;
	}

	public int getBugQ4() {
		return bugQ4;
	}

	public void setBugQ4(int bugQ4) {
		this.bugQ4 = bugQ4;
	}

	public int getDevQ1() {
		return devQ1;
	}

	public void setDevQ1(int devQ1) {
		this.devQ1 = devQ1;
	}

	public int getDevQ2() {
		return devQ2;
	}

	public void setDevQ2(int devQ2) {
		this.devQ2 = devQ2;
	}

	public int getDevQ3() {
		return devQ3;
	}

	public void setDevQ3(int devQ3) {
		this.devQ3 = devQ3;
	}

	public int getDevQ4() {
		return devQ4;
	}

	public void setDevQ4(int devQ4) {
		this.devQ4 = devQ4;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public boolean isVerifyConcludeOperation() {
		return verifyConcludeOperation;
	}

	public void setVerifyConcludeOperation(boolean verifyConcludeOperation) {
		this.verifyConcludeOperation = verifyConcludeOperation;
	}
	
	public void adicionarInfo(String nome, int matricula) {
		this.nome = nome;
        this.matricula = matricula;
	}
	
	public void addFileName(String fileName) {
		this.nomeArquivo = fileName;
	}
    
    
}

