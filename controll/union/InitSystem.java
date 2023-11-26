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
		eventBLNAE();
		eventBPPI();
		eventBGR();
		eventBLDOP();
		eventBGAS();
		eventBRegister();
	}

	public DataBaseConnection getDatabase() {
		return database;
	}
}
