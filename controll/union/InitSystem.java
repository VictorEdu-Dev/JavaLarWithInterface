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
		window = new FWindow();
		
		
		setWindow(window);
		setInter(inter);
		runSystem();
	}

	private void runSystem() {
		eventBLNAE(window);
		eventBPPI(window, inter);
		eventBGR(window, database);
		eventBRegister(window);
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
