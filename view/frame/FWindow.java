package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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


		planetarium = new PSystem();
		buttonPanel = new PButtons();


		add(planetarium);
		add(buttonPanel);


		setVisible(true);

		
		verifyCloseOperation();
	}
	
	
	// Configurações iniciais do frame
	private void adjustFrame() {
		setLayout(new FlowLayout());	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setTitle("Javalar System");
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(Color.decode("#FFFACD"));
	}

	// Verificar eventos de fechamento da janela
	private void verifyCloseOperation() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);

				if (option == JOptionPane.YES_OPTION) {
					dispose();
				} else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	// Getters para uso posterior
	public PSystem getPlanetarium() {
		return planetarium;
	}

	public PButtons getButtonPanel() {
		return buttonPanel;
	}
}
