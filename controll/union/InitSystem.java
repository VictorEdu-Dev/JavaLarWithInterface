package union;

import connection.DataBaseConnection;
import execute.Interceptador;
import frame.FWindow;

public class InitSystem extends EventsJavaLar {
	private Interceptador inter;
	private FWindow window;
	private DataBaseConnection database;

	public InitSystem() {
		super();
		inter = new Interceptador();
		// database = new DataBaseConnection("da_java.mysql.dbaas.com.br", "da_java", "da_java", "Tecnicas*2023@");
		window = new FWindow();

		runSystem();
	}

	private void runSystem() {
		eventBLNAE(window);
		eventBPPI(window, inter);
	}

	public Interceptador getInter() {
		return inter;
	}

	public FWindow getWindow() {
		return window;
	}

	public DataBaseConnection getDatabase() {
		return database;
	}
}
