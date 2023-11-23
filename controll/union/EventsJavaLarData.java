package union;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import execute.Interceptador;
import frame.FWindow;
import panels.planets.LMeteor;
import panels.planets.MeteorConstants;
import util.Coordinates;
import util.ExtractArray;

public class EventsJavaLarData {
	private ArrayList<ArrayList<String>> values;
	private ArrayList<ArrayList<String>> valuesExtract;
	private ArrayList<String> colunasExtract;
	private int numberLine;

	public EventsJavaLarData() {
		valuesExtract = new ArrayList<>();
		values = new ArrayList<>();
		colunasExtract = new ArrayList<>();
	}

	// Reinicia os arraylists
	public void refactorValue() {
		if (valuesExtract != null) {
			valuesExtract.clear();
		}
		if (colunasExtract != null) {
			colunasExtract.clear();
		}
		if (values != null) {
			values.clear();
		}
	}

	// -> RESOLVIDO
	public void handleButtonClick(FWindow window, Interceptador inter) {
		if (!values.isEmpty()) {
			System.out.println(numberLine);

			if(valuesExtract.isEmpty())
				valuesExtract = ExtractArray.extractLastTwoColumns(values);

			ArrayList<String> colunas = values.get(numberLine);
			colunasExtract = valuesExtract.get(numberLine);
			setTimeInSystem(inter, colunas);
			setMetInSystem(inter, colunasExtract);
			includeMeteorInterface(window, inter, colunasExtract);

			movePlanetsInterface(window, inter);

			if (numberLine == values.size()-1) {
				numberLine = 1;
				refactorValue();
				return;
			} else {
				numberLine += 1;
			}
		} else {
			JOptionPane.showMessageDialog(
					null, "Não há instantes a serem lidos. Por favor, leia um novo arquivo de entrada!",
					"Nenhum arquivo escolhido", JOptionPane.INFORMATION_MESSAGE
					);
		}
	}

	// -> RESOLVIDO
	// Envia a quantidade de bugs e devs ao back
	private void setMetInSystem(Interceptador inter, ArrayList<String> colunas) {
		inter.insertMetJavaLar(Integer.valueOf(colunas.get(0)), Integer.valueOf(colunas.get(1)));
	}

	// -> RESOLVIDO
	// Envia a quantidade de tempo por planeta ao back
	private void setTimeInSystem(Interceptador inter, ArrayList<String> colunas) {
		for (int coluna = 1; coluna < colunas.size(); coluna++) {
			inter.executarJavaLar(Integer.valueOf(colunas.get(coluna)), coluna);
		}
	}

	// -> RESOLVIDO
	// Geta o movimento do back e envia ao front
	private void movePlanetsInterface(FWindow window, Interceptador inter) {
		int sizeArrayPlanets = inter.getInit().getAstros().size();

		for (int i = 1; i < sizeArrayPlanets; i++) {

			int posX = inter.getInit().getAstro(i).getPosX();
			int posY = inter.getInit().getAstro(i).getPosY();

			//window.getPlanetarium().getPanels()[8][i+8].remove(window);
			window.getPlanetarium().getPanels()[posY][posX].add(window.getPlanetarium().getDataMatrix().get(i));
		}
		window.revalidate();
		window.repaint();
	}

	// -> RESOLVIDO
	// Geta bugs e devs do back e envia ao front
	private void includeMeteorInterface(FWindow window, Interceptador inter, ArrayList<String> colunasExtract) {
		int qtdBug = Integer.valueOf(colunasExtract.get(0));		
		int qtdDev = Integer.valueOf(colunasExtract.get(1));
		int counter1;
		int counter2;

		counter1 = inter.getQtdeBugs();
		counter2 = inter.getQtdeDevs();
		
		for (int i = counter1; i > counter1-qtdBug; i--) {
			int posX = inter.getCoordMBugBack().get(i-1).getX();
			int posY = inter.getCoordMBugBack().get(i-1).getY();

			window.getPlanetarium().getDataBug().add(new LMeteor(MeteorConstants.BUG.getImageURL().toString(), posX, posY));

//			window.getPlanetarium().getPanels()[posY][posX].add(window.getPlanetarium().getDataBug().get((counter1 - i)));
		}

		for (int i = counter2; i > counter1-qtdDev; i--) {
			int posX = inter.getCoordMDevBack().get(i-1).getX();
			int posY = inter.getCoordMDevBack().get(i-1).getY();

			window.getPlanetarium().getDataDev().add(new LMeteor(MeteorConstants.DEV.getImageURL().toString(), posX, posY));
			
			window.getPlanetarium().addMeteors();

//			window.getPlanetarium().getPanels()[posY][posX].add(window.getPlanetarium().getDataDev().get((counter2 - i)));
		}

		System.out.println();
		for(Coordinates coord : inter.getCoordMBugBack()) {
			System.out.println("Bugs in interface: "+ "X: "+coord.getX()+" Y: "+coord.getY());
		}
		
		for(LMeteor coord : window.getPlanetarium().getDataBug()) {
			System.out.println("Bugs in back: "+ "X: "+coord.getPosX()+" Y: "+coord.getPosY());
		}
		
		window.revalidate();
		window.repaint();
	}

	public static void removeMetColidates(List<Coordinates> interfaceCoordinates, List<Coordinates> coordinatesToRemove) {
		Iterator<Coordinates> iterator = interfaceCoordinates.iterator();
		while (iterator.hasNext()) {
			Coordinates interfaceCoord = iterator.next();
			if (coordinatesToRemove.contains(interfaceCoord)) {
				iterator.remove();
			}
		}

		System.out.println("Coordenadas restantes na interface após remoção: " + interfaceCoordinates);
	}

	// Getters e setters para uso posterior
	public int getNumberLine() {
		return numberLine;
	}

	public void setNumberLine(int numberLine) {
		this.numberLine = numberLine;
	}

	public ArrayList<ArrayList<String>> getValues() {
		return values;
	}

	public void setValues(ArrayList<ArrayList<String>> values) {
		this.values = values;
	}

	public ArrayList<ArrayList<String>> getValuesExtract() {
		return valuesExtract;
	}

	public ArrayList<String> getColunasExtract() {
		return colunasExtract;
	}

}