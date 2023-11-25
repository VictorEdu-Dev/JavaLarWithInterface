package execute;

import java.util.ArrayList;
import java.util.List;

import execute.suport.Translation;
import planets.AstroLinguagem;
import planets.Meteoro;
import util.Calculus;
import util.Coordinates;

public class Interceptador extends Calculus {
	private JavaLar init;
	private Translation trans;
	private boolean verificador;

	public Interceptador() {
		init = new JavaLar();
		trans = new Translation();
	}
	
	public void executarJavaLar(int time, int index) {
		trans.mover(init.getAstros().get(index), time, init);
		verificador = init.verificarExistenciaDoSistema();
		init.getRegister().setNumInstantes(time);
	}
	
	public void insertMetJavaLar(int qtdeBugs, int qtdeDevs) {
		init.setBugs(qtdeBugs);
		init.setDevs(qtdeDevs);
	}

	public List<Integer[]> obterLocalizacaoPlanetaria() {
		List<Integer[]> localizacaoPlanetaria = new ArrayList<>();
		int coordenadaYJava = init.getAstro(0).getPosY();

		for (AstroLinguagem planeta : init.getAstros()) {
			Integer[] posicao = {planeta.getPosX(), planeta.getPosY()};

			if (planeta.getPosY() > coordenadaYJava && !planeta.equals(init.getAstro(0))) {
				localizacaoPlanetaria.add(posicao);
			} else if (planeta.getPosY() <= coordenadaYJava) {
				localizacaoPlanetaria.add(posicao);
			}
		}

		return localizacaoPlanetaria;
	}

	public List<Integer> obterQuantidades() {
		List<Integer> quantidades = new ArrayList<>();
		quantidades.add(init.getBugs().size());
		quantidades.add(init.getDevs().size());
		quantidades.add(init.obterArrayDeBugs().size());
		quantidades.add(init.obterArrayDeDevs().size());
		return quantidades;
	}

	public List<Coordinates> getCoordMBugBack() {
		List<Coordinates> coordMet = new ArrayList<>();
		for (int i = 0; i < init.obterArrayDeBugs().size(); i++) {
			int x = init.getBug(i).getCoordX();
			int y = init.getBug(i).getCoordY();
			
			coordMet.add(new Coordinates(x, y));
		}
		return coordMet;
	}
	
	public List<Coordinates> getCoordMDevBack() {
		List<Coordinates> coordMet = new ArrayList<>();
		for (int i = 0; i < init.obterArrayDeDevs().size(); i++) {
			int x = init.getDev(i).getCoordX();
			int y = init.getDev(i).getCoordY();
			
			coordMet.add(new Coordinates(x, y));
		}
		return coordMet;
	}

	public List<Integer[]> obterPosicaoPlanetas() {
		List<Integer[]> posicaoPlanetas = new ArrayList<>();
		for (int i = 0; i < init.getAstros().size(); i++) {
			Integer[] posicao = {init.getAstro(i).getPosX(), init.getAstro(i).getPosY()};
			posicaoPlanetas.add(posicao);
		}
		return posicaoPlanetas;
	}

	public List<Integer> obterVelocidades() {
		List<Integer> velocidades = new ArrayList<>();
		for (AstroLinguagem astro : init.getAstros()) {
			velocidades.add(astro.getVelocidadeDeTranslacao());
		}
		return velocidades;
	}

	
	// Getters e setters para uso posterior
	public int getQtdeBugs() {
		return init.getBugs().size();
	}
	
	public int getQtdeDevs() {
		return init.getDevs().size();
	}
	
	public void setBug(int qtde) {
		init.setBugs(qtde);
	}
	
	public void setDev(int qtde) {
		init.setDevs(qtde);
	}
	
	public boolean isVerificador() {
		return verificador;
	}

	public JavaLar getInit() {
		return init;
	}

	public Translation getTranslation() {
		return trans;
	}
	
	public List<Coordinates> bugsToRemove() {
		List<Coordinates> list = new ArrayList<>();
		for(Meteoro met : trans.getVerify().getBugsToRemoveCopy()) {
			list.add(new Coordinates(met.getCoordX(), met.getCoordY()));
		}
		return list;
	}
	
	public List<Coordinates> devsToRemove() {
		List<Coordinates> list = new ArrayList<>();
		for(Meteoro met : trans.getVerify().getDevsToRemoveCopy()) {
			list.add(new Coordinates(met.getCoordX(), met.getCoordY()));
		}
		return list;
	}
}
