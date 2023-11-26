package union;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import constants.MessageJavaLar;
import constants.MeteorConstants;
import execute.Interceptador;
import frame.FWindow;
import panels.planets.LMeteor;
import panels.planets.LPlanet;
import planets.AstroLinguagem;
import util.ExtractArray;
import util.ManipulateArray;

public class EventsLNAE {
	private ArrayList<ArrayList<String>> values;
	private ArrayList<ArrayList<String>> valuesExtract;
	private ArrayList<String> colunasExtract;
	private int numberLine;

	private boolean shutdownRequested = false;

	public EventsLNAE() {
		valuesExtract = new ArrayList<>();
		values = new ArrayList<>();
		colunasExtract = new ArrayList<>();
	}

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

	public void handleButtonClick(FWindow window, Interceptador inter) {
		if (!values.isEmpty()) {

			if(valuesExtract.isEmpty())
				valuesExtract = ExtractArray.extractLastTwoColumns(values);

			ArrayList<String> colunas = values.get(numberLine);
			colunasExtract = valuesExtract.get(numberLine);
			setMetInSystem(inter, colunasExtract);
			setTimeInSystem(inter, colunas);

			//	System.out.println("Qtde de planetas no sistema: "+window.getPlanetarium().getDataMatrix().size());
			//	System.out.println("Qtde de plaentas no back: "+inter.getInit().getAstros().size());

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
			MessageJavaLar.NO_FILES_READ_MESSAGE.showMessage();
		}
	}

	private void setMetInSystem(Interceptador inter, ArrayList<String> colunas) {
		inter.insertMetJavaLar(Integer.valueOf(colunas.get(0)), Integer.valueOf(colunas.get(1)));
	}

	private void setTimeInSystem(Interceptador inter, ArrayList<String> colunas) {
		int coluna = 1;

		while (coluna < inter.getInit().getAstros().size()) {
			if(inter.getInit().getAstrosRemoved().size() != 0) {
				// Caso planetas sejam removidos do array no back, o array do arquivo deve ser atualizado
				values = ManipulateArray.removerColunaPorNome(values, inter.getInit().getAstrosRemoved());
			}
			inter.executarJavaLar(Integer.valueOf(colunas.get(coluna)), coluna);
			coluna++;
		}
	}


	private void removePlanetsInterface(FWindow window, Interceptador inter) {
		List<LPlanet> astrosToRemove = new ArrayList<>();

		for (LPlanet objeto : window.getPlanetarium().getDataMatrix()) {
			for (AstroLinguagem astro : inter.getInit().getAstrosRemoved()) {
				if (astro.getNome().equals(objeto.getNome())) {
					astrosToRemove.add(objeto);
					objeto.setVisible(false);
					Thread thread = new Thread(new Runnable() {
						public void run() {
							MessageJavaLar.ELEMENT_REMOVED.showMessageSpecial(objeto.getNome());
						}
					});
					thread.start();
					break;
				}
			}
		}

		window.getPlanetarium().getDataMatrix().removeAll(astrosToRemove);
	}

	private void movePlanetsInterface(FWindow window, Interceptador inter) {
		int sizeArrayPlanets = inter.getInit().getAstros().size();

		for (int i = 1; i < sizeArrayPlanets; i++) {

			int posX = inter.getInit().getAstro(i).getPosX();
			int posY = inter.getInit().getAstro(i).getPosY();

			window.getPlanetarium().getPanels()[posY][posX].add(window.getPlanetarium().getDataMatrix().get(i));
		}
		window.getPlanetarium().definePriorizy();
		window.revalidate();
		window.repaint();
	}

	private void includeMeteorInterface(FWindow window, Interceptador inter, ArrayList<String> colunasExtract) {
		int qtdBug = inter.getQtdeBugs();		
		int qtdDev = inter.getQtdeDevs();
		int counter1;
		int counter2;

		counter1 = inter.getQtdeBugs();
		counter2 = inter.getQtdeDevs();

		shutdownRequested = false;
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.schedule(() -> {
			if (!shutdownRequested) {
				MessageJavaLar.PROCESSING_SYSTEM.showMessage();
			}
		}, 1, TimeUnit.SECONDS);

		if(inter.getInit().getBugs() != null) { 
			for (int i = counter1; i > counter1-qtdBug; i--) {
				int posX = inter.getCoordMBugBack().get(i-1).getX();
				int posY = inter.getCoordMBugBack().get(i-1).getY();

				window.getPlanetarium().getDataBug().add(new LMeteor(MeteorConstants.BUG.getImageURL().toString(), posX, posY));

				window.getPlanetarium().addBugs();
			}
		} else {
			MessageJavaLar.ELEMENT_NOT_ADDED.showMessage();
		}


		if(inter.getInit().getDevs() != null) {
			for (int i = counter2; i > counter2-qtdDev; i--) {
				int posX = inter.getCoordMDevBack().get(i-1).getX();
				int posY = inter.getCoordMDevBack().get(i-1).getY();

				window.getPlanetarium().getDataDev().add(new LMeteor(MeteorConstants.DEV.getImageURL().toString(), posX, posY));

				window.getPlanetarium().addDevs();
			}
		} else {
			MessageJavaLar.ELEMENT_NOT_ADDED.showMessage();
		}

		removePlanetsInterface(window, inter);
		window.revalidate();
		window.repaint();
		shutdownRequested = true;
	}

//	private void removeMetColidatesInterface(FWindow window, List<Coordinates> coordinatesToRemove) {
//		System.out.println("tentou executar a remoção");
//		int i = 0;
//		while (i < coordinatesToRemove.size()) {
//			LMeteor bug = new LMeteor("bug", coordinatesToRemove.get(i).getX(), coordinatesToRemove.get(i).getY());
//			if (true) {
//				System.out.println("Removeu um bug: "+bug.getPosX()+" ,"+bug.getPosY());
//				window.getPlanetarium().getDataBug().remove(bug);
//			}
//			i--;
//		}
//	}

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

	public boolean setValues(ArrayList<ArrayList<String>> values) {
		this.values = values;
		return true;
	}

	public ArrayList<ArrayList<String>> getValuesExtract() {
		return valuesExtract;
	}

	public ArrayList<String> getColunasExtract() {
		return colunasExtract;
	}

}