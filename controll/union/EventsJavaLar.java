package union;

import java.util.List;

import javax.swing.JOptionPane;

import connection.DataSelect;
import constants.MessageJavaLar;
import execute.Interceptador;
import frame.DRegister;
import frame.FWindow;
import util.ReadFile;

public class EventsJavaLar {

	private EventsLNAE eventsLNAE;
	private DRegister register;
	private EventsGR eventsGR;
	private ReadFile readFile;
	private DataSelect readData;
	private EventGAS generateFileOut;

	private List<List<Object>> dataRead;

	private FWindow window;
	private Interceptador inter;

	private boolean verifyNullValues;

	public EventsJavaLar() {
		eventsLNAE = new EventsLNAE();
		eventsGR = new EventsGR(this);
		readFile = new ReadFile();
		register = new DRegister();
		readData = new DataSelect(this);
		generateFileOut = new EventGAS();
	}

	protected void eventBLNAE() {
		window.getButtonPanel().getbLNAE().addActionListener(e -> {
			lnae();
		});
	}

	private void lnae() {
		Thread thread = new Thread(() -> {
			verifyNullValues = false;

			if (register.isRegister()) {
				verifyNullValues = eventsLNAE.setValues(readFile.readValues());

			} else {
				MessageJavaLar.NO_USERS_MESSAGE.showMessage();
			}
		});
		thread.start();
	}

	protected void eventBPPI() {
		eventsLNAE.setNumberLine(1);
		window.getButtonPanel().getbPPI().addActionListener(e -> {

			ppi();
		});
	}

	private void ppi() {
		if (inter.getInit().getAstros().size() != 1) {
			eventsLNAE.handleButtonClick(window, inter);

		} else {
			MessageJavaLar.GAME_COMPLETED_MESSAGE.showMessage();
		}
	}

	protected void eventBGR() {
		window.getButtonPanel().getbGR().addActionListener(e -> {
			greport();
		});
	}

	private void greport() {
		Thread thread = new Thread(() -> {

			if(register.isRegister()) {
				eventsGR.insertData();

				if(eventsGR.isVerifyConcludeOperation()) {
					MessageJavaLar.SUCCESS_GENERATE_REPORT.showMessage();
				} else {
					MessageJavaLar.NOT_RUN_YET.showMessage();
				}

			} else {
				MessageJavaLar.NO_USERS_MESSAGE.showMessage();
			}
		});
		thread.start();
	}

	protected void eventBLDOP() {
		window.getButtonPanel().getbLDOP().addActionListener(e -> {

			ldop();
		});
	}

	private void ldop() {
		Thread thread = new Thread(() -> {
			
			setDataRead(readData.retrieveData());
		});
		thread.start();
	}

	protected void eventBGAS() {
		window.getButtonPanel().getbGAS().addActionListener(e -> {
			gas();
		});

	}

	private void gas() {
		Thread thread = new Thread(() -> {

			if(dataRead != null) {

				verifyNullValues = false;
				generateFileOut.setData(dataRead);
				verifyNullValues = generateFileOut.generateReport();

				if(verifyNullValues) {
					dataRead.clear();
					MessageJavaLar.SUCCESS_GENERATE_FILE_OUT.showMessageSpecial(generateFileOut.getOutputFile());

				}
			} else {
				MessageJavaLar.NO_USER_DATA_READ_MESSAGE.showMessage();
			}
		});
		thread.start();
	}

	protected void eventBRegister() {
		window.getButtonPanel().getbRegister().addActionListener(e -> {
			registerEvent();
		});
	}

	private void registerEvent() {
		Thread thread = new Thread(() -> {
			if (register.isRegister()) {
				MessageJavaLar.USER_REGISTERED_MESSAGE.showMessage();

			} else {
				if (register == null || !register.isVisible()) {
					register = new DRegister();
					register.initDialog();
				}
			}
		});
		thread.start();
	}

	protected void eventBRestart() {
		window.getButtonPanel().getbRestart().addActionListener(e -> {
			restart();
		});
	}

	private void restart() {
		Thread thread = new Thread(() -> {

			int restart = MessageJavaLar.RESTART_MESSAGE.showMessageReturn();
			if (restart == JOptionPane.YES_OPTION) {
				restartGame();
			}
		});
		thread.start();
	}

	private void restartGame() {
		if (window != null) {
			window.dispose();
		}
		new InitSystem();
	}

	public EventsGR getEventsGR() {
		return eventsGR;
	}

	public ReadFile getReadFile() {
		return readFile;
	}

	public EventsLNAE getEventsLNAE() {
		return eventsLNAE;
	}

	public DRegister getRegister() {
		return register;
	}

	public FWindow getWindow() {
		return window;
	}

	public Interceptador getInter() {
		return inter;
	}

	public void setWindow(FWindow window) {
		this.window = window;
	}

	public void setInter(Interceptador inter) {
		this.inter = inter;
	}

	public List<List<Object>> getDataRead() {
		return dataRead;
	}

	public void setDataRead(List<List<Object>> dataRead) {
		this.dataRead = dataRead;
	}

}
