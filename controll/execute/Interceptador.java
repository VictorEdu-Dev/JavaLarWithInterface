package execute;
import execute.suport.Translation;
import execute.suport.VerificadorDeColisoes;
import planets.AstroLinguagem;
import util.Calculus;

public class Interceptador extends Calculus {
	private Translation mover;
	private VerificadorDeColisoes verify;
	private boolean verificador;
	private int time;

	public Interceptador() {
		mover = new Translation();
	}

	public void iniciarMenu(JavaLar init) {
		printSymbol(42, "=");
		exibirCoordMet(init);
		printSymbol(42, "=");
		executarJavaLar(init, time);
		printSymbol(42, "=");
		verificador = init.verificarExistenciaDoSistema();
		init.getRegister().setNumInstantes(time);
	}

	private void executarJavaLar(JavaLar init, int time) {
		System.out.println();
		System.out.println("ANDAMENTO DO JAVALAR ");
		for (int i = 0; i < init.obterArrayDeAstros().size(); i++) {
			mover.mover(init.getAstro(i), time, init);
		}
		System.out.println();
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public void showPrint(JavaLar init) {
		exibirPosicaoPlanetas(init);
		printSymbol(42, "=");
		exibirDistanciaEucliana(init);
		printSymbol(42, "=");
		exibirVelocidades(init);
		printSymbol(42, "=");
		exibirInfoMet(init);
		printSymbol(42, "=");
		exibirLocalizacaoPlanetaria(init);
	}

	private void exibirLocalizacaoPlanetaria(JavaLar init) {
		int numPlanetasAoNorte = 0;
		int numPlanetasAoSul = 0;
		int coordenadaYJava = init.getAstro(0).getPosY();

		for (AstroLinguagem planeta : init.obterArrayDeAstros()) {
			if (planeta.getPosY() > coordenadaYJava && !planeta.equals(init.getAstro(0))) {
				numPlanetasAoNorte++;
			} else if (planeta.getPosY() <= coordenadaYJava) {
				numPlanetasAoSul++;
			}
		}

		System.out.println("==========================================");
		System.out.println("Número de planetas ao norte: " + numPlanetasAoNorte);
		System.out.println("Número de planetas ao sul: " + numPlanetasAoSul);
		System.out.println("==========================================");
	}

	private void exibirDistanciaEucliana(JavaLar init) {
		double distancia;

		for (AstroLinguagem astroA : init.obterArrayDeAstros()) {
			for (AstroLinguagem astroB : init.obterArrayDeAstros()) {
				if (astroA != astroB && astroA != init.getAstro(0) && astroB != init.getAstro(0)) {
					distancia = calcularDistance(astroA, astroB);
					System.out.printf("DISTÂNCIA ENTRE (%S) E (%S):%n", astroA.getNome(), astroB.getNome());
					System.out.printf("%.2f dist%n", distancia);
				}
			}
			System.out.println();
		}
	}

	public void verificarColisao(JavaLar init) {
		verify = new VerificadorDeColisoes();
		verify.verificarColisao(init);
	}

	private void exibirInfoMet(JavaLar init) {
		System.out.println("Número de bugs adicionados: " + init.getQtdeBug());
		System.out.println("Número de desenvolvedores adicionados: " + init.getQtdeDev());
		printSymbol(42, "*");
		System.out.println("Quantidade de bugs atualmente: " + init.obterArrayDeBugs().size());
		System.out.println("Quantidade de desenvolvedores atualmente: " + init.obterArrayDeDevs().size());
		System.out.println();
	}

	private void exibirCoordMet(JavaLar init) {
		System.out.println();
		System.out.println("POSIÇÃO DOS BUGS INSERIDOS: ");
		for (int i = 0; i < init.obterArrayDeBugs().size(); i++) {
			System.out.println("(" + init.getBug(i).getCoordX() + ", " + init.getBug(i).getCoordY() + ")");
		}
		System.out.println();
		System.out.println("POSIÇÃO DOS DESENVOLVEDORES INSERIDOS: ");
		for (int i = 0; i < init.obterArrayDeDevs().size(); i++) {
			System.out.println("(" + init.getDev(i).getCoordX() + ", " + init.getDev(i).getCoordY() + ")");
		}
		System.out.println();
	}

	private void exibirPosicaoPlanetas(JavaLar init) {
		System.out.println();
		System.out.println("POSIÇÃO DOS PLANETAS APÓS " + time + " und");
		for (int i = 0; i < init.obterArrayDeAstros().size(); i++) {
			System.out.printf(init.getAstro(i).getNome());
			System.out.println(": (" + init.getAstro(i).getPosX() + ", " + init.getAstro(i).getPosY() + ")");
		}
		System.out.println();
	}

	private void exibirVelocidades(JavaLar init) {
		System.out.println("VELOCIDADE DOS PLANETAS: ");
		for (AstroLinguagem astro : init.obterArrayDeAstros()) {
			System.out.printf(astro.getNome() + ": " + astro.getVelocidadeDeTranslacao() + " pos/und%n");
		}
		System.out.println();
	}

	public boolean getVerificador() {
		return verificador;
	}

	private void printSymbol(int num, String symbol) {
		for (int i = 0; i < num; i++) {
			System.out.print(symbol);
		}
		System.out.println();
	}
}
