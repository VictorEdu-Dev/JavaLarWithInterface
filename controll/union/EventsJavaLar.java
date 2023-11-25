package union;

import javax.swing.JOptionPane;
import connection.DataBaseConnection;
import execute.Interceptador;
import frame.DRegister;
import frame.FWindow;
import util.ReadFile;

public class EventsJavaLar {

	private final EventsLNAE eventsLNAE;
	private final DRegister register;
	private final EventsGR eventsGR;
	private final ReadFile readFile;
	
	private FWindow window;
	private Interceptador inter;
	
	public EventsJavaLar() {
		eventsLNAE = new EventsLNAE();
		register = new DRegister();
		eventsGR = new EventsGR(this);
		readFile = new ReadFile();
	}

	protected void eventBLNAE(FWindow window) {
		window.getButtonPanel().getbLNAE().addActionListener(e -> {
			Thread thread = new Thread(() -> {
				if (register.isRegister()) {
					eventsLNAE.setValues(readFile.readValues());
				} else {
					JOptionPane.showMessageDialog(
							null, "Registre-se primeiro!",
							"Usuário não cadastrado", JOptionPane.INFORMATION_MESSAGE
							);
				}
			});
			thread.start();
		});
	}

	protected void eventBPPI(FWindow window, Interceptador inter) {
		eventsLNAE.setNumberLine(1);
		window.getButtonPanel().getbPPI().addActionListener(e -> {
			if (inter.getInit().getAstros().size() != 1) {
				eventsLNAE.handleButtonClick(window, inter);
			} else {
				JOptionPane.showMessageDialog(
						null, "Não há mais planetas no JavaLar. Por favor, inicie um novo jogo!",
						"Você zerou o jogo", JOptionPane.INFORMATION_MESSAGE
						);
			}
		});
	}

	protected void eventBGR(FWindow window, DataBaseConnection database) {
		window.getButtonPanel().getbGR().addActionListener(e -> {
			Thread thread = new Thread(() -> {
				eventsGR.insertData();
			});
			thread.start();
		});
	}

	protected void eventBRegister(FWindow window) {
		window.getButtonPanel().getbRegister().addActionListener(e -> {
			Thread thread = new Thread(() -> {
				if (register.isRegister()) {
					JOptionPane.showMessageDialog(null, "Já existe um usuário cadastrado!");
				} else {
					register.initDialog();
					register.setVisible(true);
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
	
}
