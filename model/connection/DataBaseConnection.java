package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	private String host;
	private String user;
	private String password;
	private String database;
	private Connection connection;

	// Construtor a ser inicializado quando um objeto é instanciado
	public DataBaseConnection(String host, String database, String user, String password) {
		setHost(host);
		setDatabase(database);
		setUser(user);
		setPassword(password);
		connectDatabase();
	}
	
	public DataBaseConnection() {
		setHost("da_java.mysql.dbaas.com.br");
		setDatabase("da_java");
		setUser("da_java");
		setPassword("Tecnicas*2023@");
		connectDatabase();
	}
	
	// Construtor sem parâmetros
//	public DataBaseConnection() {
//		setHost("127.0.0.1");
//		setDatabase("barracahotdog");
//		setUser("Victor");
//		setPassword("Vv,11111");
//		connectDatabase();
//	}

	// Tenta iniciar uma conexão com o banco
	private void connectDatabase() {
		System.out.println("Tentando se conectar ao banco de dados...");
		String url ="jdbc:mysql://" + this.host + "/" + this.database+"?verifyServerCertificate=false&useSSL=true";
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Conexão bem-sucedida!");
			}
		} catch (SQLException ex) {
			System.out.println("Conexão com MYSQL não realizada");
			ex.printStackTrace();
		}
	}

	public static int getNextIndex(Connection connection, String tabela, String colunaIndice) {
		int proximoIndice = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT MAX(" + colunaIndice + ") FROM " + tabela;
			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				proximoIndice = resultSet.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proximoIndice;
	}


	// Getters e Seterrs para uso posterior
	public Connection getConnection() {
		return connection;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
}
