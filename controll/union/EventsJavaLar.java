package union;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import execute.Interceptador;
import frame.FWindow;
import panels.planets.LMeteor;
import util.ExtractArray;
import util.ReadFile;

public class EventsJavaLar {

	private ArrayList<ArrayList<String>> values;
	private ArrayList<ArrayList<String>> valuesExtract;
	private ArrayList<String> colunasExtract;
	private int numberLine;
	private boolean isRead;

	public EventsJavaLar() {
		super();
		isRead = true;
	}

	protected void eventBLNAE(FWindow window) {
		window.getButtonPanel().getbLNAE().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				values = ReadFile.readValues();
				if(values != null && valuesExtract != null) {
					refactorExtractValue();
				}
			}
		});
	}

	protected void eventBPPI(FWindow window, Interceptador inter) {
		numberLine = 1;
		window.getButtonPanel().getbPPI().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(window, inter);
			}
		});
	}

	private void refactorExtractValue() {
	    if (valuesExtract != null) {
	        valuesExtract.clear();
	    }
	    if (colunasExtract != null) {
	        colunasExtract.clear();
	    }
	}


	private void handleButtonClick(FWindow window, Interceptador inter) {
		if (values != null) {
			// Isola duas colunas num array separado e os remove do array original
			if(isRead) {
				valuesExtract = ExtractArray.extractLastTwoColumns(values);
				isRead = false;
			}

			// Itera por cada linha do array
			for (int linha = numberLine; linha < values.size(); linha++) {
			    ArrayList<String> colunas = values.get(linha);
			    colunasExtract = valuesExtract.get(numberLine);
			    setTimeInSystem(inter, colunas);
			}

			
			setMetInSystem(inter, colunasExtract);
			
			includeMeteor(window, inter);
			movePlanets(window, inter);

			if (numberLine == values.size()) {
				values = null;
				numberLine = 0;
				isRead = true;
			}

			numberLine += 1;
		} else {
			JOptionPane.showMessageDialog(
					null, "Não há instantes a serem lidos. Por favor, leia um novo arquivo de entrada!",
					"Nenhum arquivo escolhido", JOptionPane.INFORMATION_MESSAGE
					);
		}
	}

	private void setMetInSystem(Interceptador inter, ArrayList<String> colunas) {
		inter.setBug(Integer.valueOf(colunas.get(0)));
		inter.setDev(Integer.valueOf(colunas.get(1)));
	}

	private void setTimeInSystem(Interceptador inter, ArrayList<String> colunas) {
		for (int coluna = 1; coluna < colunas.size(); coluna++) {
			inter.iniciarMenu(Integer.valueOf(colunas.get(coluna)), coluna);
		}
	}

	private void movePlanets(FWindow window, Interceptador inter) {
		for (int i = 1; i < 8; i++) {
			int posX = inter.getInit().getAstro(i).getPosX();
			int posY = inter.getInit().getAstro(i).getPosY();

			window.getPlanetarium().getPanels()[8][i + 8].remove(window);
			window.getPlanetarium().getPanels()[posY][posX].add(window.getPlanetarium().getDataMatrix().get(i));
		}

		window.revalidate();
		window.repaint();
	}

	private void includeMeteor(FWindow window, Interceptador inter) {
		int qtdBug = 0;
		qtdBug += inter.getInit().getQtdeBug() - qtdBug;
		int qtdDev = 0;
		qtdDev += inter.getInit().getQtdeDev() - qtdDev;
		
		for (int i = 0; i < qtdBug; i++) {
			int posX = inter.getInit().getBug(i).getCoordX();
			int posY = inter.getInit().getBug(i).getCoordY();
			
			window.getPlanetarium().getPanels()[posY][posX].add(new LMeteor("bug"));
			window.getPlanetarium().getPanels()[posY][posX].add(new LMeteor("bug"));
		}
		
		for (int i = 0; i < qtdDev; i++) {
			int posX = inter.getInit().getDev(i).getCoordX();
			int posY = inter.getInit().getDev(i).getCoordY();
			
			window.getPlanetarium().getPanels()[posY][posX].add(new LMeteor("dev"));
			window.getPlanetarium().getPanels()[posY][posX].add(new LMeteor("dev"));
		}
		window.revalidate();
		window.repaint();
	}

}
