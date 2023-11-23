package union;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.DataBaseConnection;
import connection.DataInsert;
import execute.Interceptador;
import frame.FWindow;
import util.ReadFile;

public class EventsJavaLar {

	private EventsJavaLarData data;
	private DataInsert database;

	public EventsJavaLar() {
		 data = new EventsJavaLarData();
		 database = new DataInsert(); 
	}

	protected void eventBLNAE(FWindow window) {
		window.getButtonPanel().getbLNAE().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				data.setValues(ReadFile.readValues());
			}
		});
	}

	protected void eventBPPI(FWindow window, Interceptador inter) {
		data.setNumberLine(1);
		window.getButtonPanel().getbPPI().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				data.handleButtonClick(window, inter);
			}
		});
	}
	
	protected void eventBGR(FWindow window, DataBaseConnection data) {
		window.getButtonPanel().getbGR().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				database.gravarRelatorio(data.getConnection());
			}
		});
	}
}
