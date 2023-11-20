package execute.suport;
import execute.JavaLar;
import planets.AstroLinguagem;
import util.Calculus;

public class Translation {
	private Calculus calculo;
	private VerificadorDeColisoes verify;
	private int deslocamento;


	public void mover(AstroLinguagem astro, int tempo, JavaLar init) {
		verify = new VerificadorDeColisoes();
		calculo = new Calculus();
		deslocamento = calculo.calcularDeslocamento(astro.getVelocidadeDeTranslacao(), tempo);

		while (deslocamento > 0) {
			percorrerEsquerda(astro, init);
			percorrerAbaixo(astro, init);
			pecorrerDireita(astro, init);
			percorrerAcima(astro, init);
		}
	}



	private void percorrerAcima(AstroLinguagem astro, JavaLar init) {
		int appDeslocYUp = astro.getLimitYUp() - astro.getPosY(); // limite de delocamento em y para cima
		if(astro.getPosX() == astro.getLimitXRigth() && astro.getPosY() >= astro.getLimitYDown()) {
			if (deslocamento > appDeslocYUp) {
				for(int i = 0; i < appDeslocYUp; i++) {
					astro.setPosY(1); // desloca em Y
			//		verify.verificarColisao(init);
					deslocamento -= 1;
				}
			} else {
				for(int i = 0; i < deslocamento; i++) {
					astro.setPosY(1);
		//			verify.verificarColisao(init);
				}
				deslocamento = 0;
			}
		}
	}


	private void pecorrerDireita(AstroLinguagem astro, JavaLar init) {
		int appDeslocXRigth = astro.getLimitXRigth() - astro.getPosX(); // limite de delocamento em x para a direita
		if(astro.getPosX() < astro.getLimitXRigth() && astro.getPosY() == astro.getLimitYDown()) {
			if (deslocamento > appDeslocXRigth) {
				for(int i = 0; i < appDeslocXRigth; i++) {
					astro.setPosX(1); // desloca em X
				//	verify.verificarColisao(init);
					deslocamento -= 1;
				}
			} else {
				for(int i = 0; i < deslocamento; i++) {
					astro.setPosX(1);
				//	verify.verificarColisao(init);
				}
				deslocamento = 0;
			}
		}
	}


	private void percorrerAbaixo(AstroLinguagem astro, JavaLar init) {
		int appDeslocYDown = astro.getPosY() - astro.getLimitYDown(); // limite de delocamento em y para baixo
		if (astro.getPosX() == astro.getLimitXLeft() && astro.getPosY() <= astro.getLimitYUp()) {
			if (deslocamento > appDeslocYDown) {
				for(int i = 0; i < appDeslocYDown; i++) {
					astro.setPosY(-1); // desloca em Y
			//		verify.verificarColisao(init);
					deslocamento -= 1;
				}
			} else {
				for(int i = 0; i < deslocamento; i++) {
					astro.setPosY(-1);
			//		verify.verificarColisao(init);
				}
				deslocamento = 0;
			}
		}
	}


	private void percorrerEsquerda(AstroLinguagem astro, JavaLar init) {
		int appDeslocXLeft = astro.getPosX() - astro.getLimitXLeft(); // limite de delocamento em x para a esquerda
		if (astro.getPosX() > astro.getLimitXLeft() && astro.getPosY() == astro.getLimitYUp()) {
			if (deslocamento > appDeslocXLeft) {
				for(int i = 0; i < appDeslocXLeft; i++) {
					astro.setPosX(-1); // desloca em X
				//	verify.verificarColisao(init);
					deslocamento -= 1;
				}
			} else {
				for(int i = 0; i < deslocamento; i++) {
					astro.setPosX(-1);
				//	verify.verificarColisao(init);
				}
				deslocamento = 0;
			}
		}
	}
}
