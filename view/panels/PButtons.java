package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PButtons extends JPanel {
	private static final int width = 300;
	private static final int heigth = 708;
	
	private JButton bPPI;
	private JButton bLNAE;
	private JButton bGR;
	private JButton bLDOP;
	private JButton bGAS;
	
	public PButtons() {
		adjustPanel();
	}

	private void adjustPanel() {
		setLayout(new GridLayout(5, 1));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setOpaque(false);
		setPreferredSize(new Dimension(width, heigth));
		
		initializeObjectButtons();
		addButtons();
	}
	
	// Instanciar objetos botões
	private void initializeObjectButtons() {
		bPPI = new JButton();
		bLNAE = new JButton();
		bGR = new JButton();
		bLDOP = new JButton();
		bGAS = new JButton();
	}
	
	// Adiciona botões ao layout
	private void addButtons() {
		createButtons();
		add(bPPI);
		add(bLNAE);
		add(bGR);
		add(bLDOP);
		add(bGAS);
	}
	
	// Cria botões pelos seus métodos
	private void createButtons() {
		createBPPI();
		createBLNAE();
		createBGR();
		createBLDOP();
		createBGAS();
	}
	
	// Atribui características aos botões
	private void createBPPI() {
		bPPI.setText("PROCESSAR PRÓXIMO INSTANTE");
		bPPI.setFont(new Font("Arial", Font.BOLD, 14));
		bPPI.setForeground(Color.BLACK);
		bPPI.setBackground(Color.decode("#E0FFFF"));
	}

	private void createBLNAE() {
		bLNAE.setText("LER NOVO ARQUIVO DE ENTRADA");
		bLNAE.setFont(new Font("Arial", Font.BOLD, 14));
		bLNAE.setForeground(Color.BLACK);
		bLNAE.setBackground(Color.decode("#E0FFFF"));
	}
	
	private void createBGR() {
		bGR.setText("GERAR RELATÓRIO");
		bGR.setFont(new Font("Arial", Font.BOLD, 14));
		bGR.setForeground(Color.BLACK);
		bGR.setBackground(Color.decode("#E0FFFF"));
	}
	
	private void createBLDOP() {
		bLDOP.setText("<html><center>LER DADOS DE <br> "
				+ "OUTROS PARTICIPANTES<center></html>");
		bLDOP.setVerticalAlignment(JButton.CENTER);
		bLDOP.setHorizontalTextPosition(JButton.CENTER);
		bLDOP.setFont(new Font("Arial", Font.BOLD, 14));
		bLDOP.setForeground(Color.BLACK);
		bLDOP.setBackground(Color.decode("#E0FFFF"));
	}
	
	private void createBGAS() {
		bGAS.setText("GERAR ARQUIVO DE SAÍDA");
		bGAS.setFont(new Font("Arial", Font.BOLD, 14));
		bGAS.setForeground(Color.BLACK);
		bGAS.setBackground(Color.decode("#E0FFFF"));
	}

	
	// Getters para uso posterior
	public JButton getbPPI() {
		return bPPI;
	}

	public JButton getbLNAE() {
		return bLNAE;
	}

	public JButton getbGR() {
		return bGR;
	}

	public JButton getbLDOP() {
		return bLDOP;
	}

	public JButton getbGAS() {
		return bGAS;
	}
}
