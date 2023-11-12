package junit;

import connection.DataBaseConnection;
import frame.JUnit;

public class Main {
	public static void main(String[] args) {
		new DataBaseConnection(
				"da_java.mysql.dbaas.com.br", 
				"da_java", 
				"da_java", "Tecnicas*2023@"
				);
		new JUnit();
	}
}
