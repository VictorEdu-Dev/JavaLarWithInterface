package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import panels.PButtons;
import panels.PSystem;

@SuppressWarnings("serial")
public class FWindow extends JFrame {

	// Paineis princiapais
	private PSystem planetarium;
	private PButtons buttonPanel;

	public FWindow() {
		createWindow();
	}

	// Elementos do frame
	
	private void createWindow() {
		adjustFrame();
		initializePanels();
		addComponents();
		playAudio(50);
		verifyCloseOperation();
	}

	private void addComponents() {
		add(planetarium);
		add(buttonPanel);

		setVisible(true);
	}

	private void initializePanels() {
		planetarium = new PSystem();
		buttonPanel = new PButtons();
	}

	// Configurações iniciais do frame
	private void adjustFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new FlowLayout());
		setSize(800, 600);
		setTitle("Javalar System");
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(Color.decode("#132646"));
		setCustomUI(this, Color.LIGHT_GRAY);
	}

	// Muda aparência da da interface
	private static void setCustomUI(JFrame frame, Color color) {
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	// Verificar evento de fechamento da janela
	
	private void verifyCloseOperation() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(
						null, 
						"Deseja realmente sair?", 
						"Confirmação", 
						JOptionPane.YES_NO_OPTION
						);

				if (option == JOptionPane.YES_OPTION) {
					dispose();
				} else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	// Toca um áudio
	private void playAudio(int volume) {
		try {
			// Carrega o arquivo de áudio
			File arquivoAudio = new File(
					"C:\\Central de Desenvolvimento\\Java\\Desktop\\"
							+ "Workspace\\JavaLarSystemInterface\\"
							+ "Arquivos\\audio\\space.wav"
					);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(arquivoAudio);

			// Cria um clip de áudio
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);


			if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

				float minDecibels = gainControl.getMinimum();
				float maxDecibels = gainControl.getMaximum();
				float volumeInDecibels = minDecibels + (volume / 100.0f) * (maxDecibels - minDecibels);

				// Define o volume desejado em decibéis (por exemplo, -10.0F é mais silencioso, 10.0F é mais alto)
				gainControl.setValue(volumeInDecibels);
			} else {
				System.out.println("Controle de volume não suportado.");
			}

			// Reproduz o áudio
			clip.start();
			// Reproduz o áudio
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Getters para uso posterior
	public PSystem getPlanetarium() {
		return planetarium;
	}

	public PButtons getButtonPanel() {
		return buttonPanel;
	}
}
