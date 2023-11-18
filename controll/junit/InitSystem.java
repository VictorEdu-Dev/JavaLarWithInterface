package junit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import connection.DataBaseConnection;
import execute.Interceptador;
import frame.FWindow;
import util.ReadFile;

public class InitSystem {
	private Interceptador inter;
	private FWindow window;
	private DataBaseConnection database;
	private String[][] values;
	private int numberLine;

	public InitSystem() {
		inter = new Interceptador();
		// database = new DataBaseConnection("da_java.mysql.dbaas.com.br", "da_java", "da_java", "Tecnicas*2023@");
		window = new FWindow();

		runSystem();
	}

	private void runSystem() {
		eventBLNAE();
		eventBPPI();
	}

	private void eventBLNAE() {
	    window.getButtonPanel().getbLNAE().addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            values = ReadFile.readValues();
	        }
	    });
	}

	private void eventBPPI() {
		numberLine = 1;
		window.getButtonPanel().getbPPI().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (values != null) {
					// Itera por cada linha do array
					for (int linha = numberLine; linha < values.length; linha++) {
						String[] colunas = values[linha];

						// Chama o método iniciarMenu para cada valor na linha, passando valor e índice da linha
						for (int coluna = 1; coluna < colunas.length - 2; coluna++) {
							inter.iniciarMenu(Integer.valueOf(colunas[coluna]), coluna);
						}
					}

					movePlanets();
					
					if(numberLine ==  values.length) {
						values = null;
					}
					
					numberLine += 1;
				} else {
					JOptionPane.showMessageDialog(
							null, "Não há instantes a serem lidos. Por favor, leia um novo arquivo de entrada!", 
							"Arquivo não lido", JOptionPane.INFORMATION_MESSAGE
							);
				}
			}
		});
	}

	public void movePlanets() {
		for (int i = 1; i < 8; i++) {
			int posX = inter.getInit().getAstro(i).getPosX();
			int posY = inter.getInit().getAstro(i).getPosY();

			window.getPlanetarium().getPanels()[8][i + 8].remove(window);
			window.getPlanetarium().getPanels()[posY][posX].add(window.getPlanetarium().getDataMatrix().get(i));
		}

		window.getPlanetarium().revalidate();
		window.getPlanetarium().repaint();
		window.revalidate();
		window.repaint();
	}
}
