package execute;

import java.util.ArrayList;
import java.util.List;

import execute.suport.Translation;
import planets.AstroLinguagem;
import util.Calculus;

public class Interceptador extends Calculus {
	private JavaLar init;
	private boolean verificador;

	public Interceptador() {
		this.init = new JavaLar();
	}

	public void iniciarMenu(int time, int index) {
		executarJavaLar(time, index);
		verificador = init.verificarExistenciaDoSistema();
		init.getRegister().setNumInstantes(time);
	}

	private void executarJavaLar(int time, int index) {
		Translation trans = new Translation();
		ArrayList<AstroLinguagem> arrayDeAstros = init.obterArrayDeAstros();
		AstroLinguagem astro = arrayDeAstros.get(index);
		trans.mover(astro, time, init);
	}

	public List<Integer[]> obterLocalizacaoPlanetaria() {
		List<Integer[]> localizacaoPlanetaria = new ArrayList<>();
		int coordenadaYJava = init.getAstro(0).getPosY();

		for (AstroLinguagem planeta : init.obterArrayDeAstros()) {
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
		quantidades.add(init.getQtdeBug());
		quantidades.add(init.getQtdeDev());
		quantidades.add(init.obterArrayDeBugs().size());
		quantidades.add(init.obterArrayDeDevs().size());
		return quantidades;
	}

	public List<Integer[]> obterCoordMet() {
		List<Integer[]> coordMet = new ArrayList<>();
		for (int i = 0; i < init.obterArrayDeBugs().size(); i++) {
			Integer[] coordenadas = {init.getBug(i).getCoordX(), init.getBug(i).getCoordY()};
			coordMet.add(coordenadas);
		}
		for (int i = 0; i < init.obterArrayDeDevs().size(); i++) {
			Integer[] coordenadas = {init.getDev(i).getCoordX(), init.getDev(i).getCoordY()};
			coordMet.add(coordenadas);
		}
		return coordMet;
	}

	public List<Integer[]> obterPosicaoPlanetas() {
		List<Integer[]> posicaoPlanetas = new ArrayList<>();
		for (int i = 0; i < init.obterArrayDeAstros().size(); i++) {
			Integer[] posicao = {init.getAstro(i).getPosX(), init.getAstro(i).getPosY()};
			posicaoPlanetas.add(posicao);
		}
		return posicaoPlanetas;
	}

	public List<Integer> obterVelocidades() {
		List<Integer> velocidades = new ArrayList<>();
		for (AstroLinguagem astro : init.obterArrayDeAstros()) {
			velocidades.add(astro.getVelocidadeDeTranslacao());
		}
		return velocidades;
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
}
