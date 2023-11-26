package union;

import java.util.List;
import constants.MessageJavaLar;
import execute.Interceptador;
import frame.DRegister;
import frame.FWindow;
import util.ReadFile;

public class EventsJavaLar {

	private final EventsLNAE eventsLNAE;
	private final DRegister register;
	private final EventsGR eventsGR;
	private final ReadFile readFile;
	private final EventsLDOP readData;
	private final EventGAS generateFileOut;

	private List<List<Object>> dataRead;

	private FWindow window;
	private Interceptador inter;

	private boolean verifyNullValues;

	public EventsJavaLar() {
		eventsLNAE = new EventsLNAE();
		register = new DRegister();
		eventsGR = new EventsGR(this);
		readFile = new ReadFile();
		readData = new EventsLDOP(this);
		generateFileOut = new EventGAS();
	}

	protected void eventBLNAE() {
		window.getButtonPanel().getbLNAE().addActionListener(e -> {
			Thread thread = new Thread(() -> {
				verifyNullValues = false;
				if (register.isRegister()) {
					verifyNullValues = eventsLNAE.setValues(readFile.readValues());
				} else {
					MessageJavaLar.NO_USERS_MESSAGE.showMessage();
				}
			});
			thread.start();
		});
	}

	protected void eventBPPI() {
		eventsLNAE.setNumberLine(1);
		window.getButtonPanel().getbPPI().addActionListener(e -> {
			if (inter.getInit().getAstros().size() != 1) {
				eventsLNAE.handleButtonClick(window, inter);
			} else {
				MessageJavaLar.GAME_COMPLETED_MESSAGE.showMessage();
			}
		});
	}

	protected void eventBGR() {
		window.getButtonPanel().getbGR().addActionListener(e -> {
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
		});
	}

	protected void eventBLDOP() {
		window.getButtonPanel().getbLDOP().addActionListener(e -> {
			Thread thread = new Thread(() -> {
				setDataRead(readData.retrieveData());
			});
			thread.start();
		});
	}

	protected void eventBGAS() {
		window.getButtonPanel().getbGAS().addActionListener(e -> {
			Thread thread = new Thread(() -> {
				verifyNullValues = false;
				if(dataRead != null) {
					generateFileOut.setData(dataRead);
					verifyNullValues = generateFileOut.generateReport();
					if(verifyNullValues) {
						MessageJavaLar.SUCCESS_GENERATE_FILE_OUT.showMessageSpecial(generateFileOut.getOutputFile());
					}
				} else {
					MessageJavaLar.NO_USER_DATA_READ_MESSAGE.showMessage();
				}
			});
			thread.start();
		});
	}

	protected void eventBRegister() {
		window.getButtonPanel().getbRegister().addActionListener(e -> {
			Thread thread = new Thread(() -> {
				if (register.isRegister()) {
					MessageJavaLar.USER_REGISTERED_MESSAGE.showMessage();
				} else {
					register.initDialog();
				}
			});
			thread.start();
		});
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
