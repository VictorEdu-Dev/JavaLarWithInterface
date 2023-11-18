package frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.sound.sampled.Clip;
import java.io.File;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import panels.*;

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
		verifyCloseOperation();
	}

	private void addComponents() {
		add(planetarium);
		add(buttonPanel);
	}

	private void initializePanels() {
		planetarium = new PSystem();
		buttonPanel = new PButtons();
	}

	// Configurações iniciais do frame
	private void adjustFrame() {
		setLayout(new FlowLayout());	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setTitle("Javalar System");
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(Color.decode("#FFFACD"));
		setVisible(true);
		playAudio();
	}

	// Verificar eventos de fechamento da janela
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
	private void playAudio() {
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
