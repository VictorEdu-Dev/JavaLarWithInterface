package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import panels.buttons.BMenuUser;

@SuppressWarnings("serial")
public class PButtons extends JPanel {
	private static final int width = 300;
	private static final int heigth = 708;

	private List<BMenuUser>  buttonMenu;

	public PButtons() {
		adjustPanel();
	}

	private void adjustPanel() {
		setLayout(new GridLayout(8, 1));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		setOpaque(false);
		setPreferredSize(new Dimension(width, heigth));

		addButtons();
	}

	// Adiciona botões ao layout
	private void addButtons() {
		createButtons();
		Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (BMenuUser bMenuUser : buttonMenu) {
                    add(bMenuUser);
                }
            }
        });
		 thread.start();
	}

	// Cria botões pelos seus métodos
	private void createButtons() {
		buttonMenu = new ArrayList<BMenuUser>();
		buttonMenu.add(0, new BMenuUser("PROCESSAR PRÓXIMO INSTANTE")); // Botão 1
		buttonMenu.add(1, new BMenuUser("LER NOVO ARQUIVO DE ENTRADA")); // Botão 2
		buttonMenu.add(2, new BMenuUser("GERAR RELATÓRIO")); // Botão 3
		buttonMenu.add(3, new BMenuUser("<html><center>LER DADOS DE <br> "
				+ "OUTROS PARTICIPANTES<center></html>")); // Botão 4
		buttonMenu.add(4, new BMenuUser("GERAR ARQUIVO DE SAÍDA")); // Botão 5
		buttonMenu.add(5, new BMenuUser("REGISTRAR USUÁRIO")); // Botão 6
		buttonMenu.add(6, new BMenuUser("REINICIAR JOGO")); // Botão 7
		buttonMenu.add(7, new BMenuUser("FECHAR", "#D1001F")); // Botão 8
	}

	// Getters para uso posterior
	public JButton getbPPI() {
		
		return buttonMenu.get(0);
	}

	public JButton getbLNAE() {
		return buttonMenu.get(1);
	}

	public JButton getbGR() {
		return buttonMenu.get(2);
	}

	public JButton getbLDOP() {
		return buttonMenu.get(3);
	}

	public JButton getbGAS() {
		return buttonMenu.get(4);
	}

	public JButton getbRegister() {
		return buttonMenu.get(5);
	}
	
	public JButton getbRestart() {
		return buttonMenu.get(6);
	}
	
	public JButton getbOut() {
		return buttonMenu.get(7);
	}
	
	public List<BMenuUser> getButtonMenu() {
		return buttonMenu;
	}
}
