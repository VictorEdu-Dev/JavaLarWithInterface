import Utilidades.*;

public class Calculus {
	private Utilities potencia;
	
	// distancia entre dois pontos em relação a origem
	public double calcularDistance(AstroLinguagem astroA, AstroLinguagem astroB) {
		potencia = new Utilities();
		int A = astroB.getPosX() - astroA.getPosX();
		int B =  astroB.getPosY() - astroA.getPosY();
		double sumAB = potencia.potentiation(A, 2) + potencia.potentiation(B, 2);
		double dis = calcularRoot(sumAB);
		return dis;
	}
	
	// calcular a raiz quadrada
	public double calcularRoot(double numero) {
		if (numero <= 0) {
			return 0.0;
		}
		
		double estimativa = numero / 2;
	    double erro = 1e-15; // Define a precisão desejada
	    
		    while (true) {
		    	double novaEstimativa = 0.5 * (estimativa + numero / estimativa);
		            
		    	if (estimativa - novaEstimativa < erro && novaEstimativa - estimativa < erro) {
		    		return novaEstimativa;
		    		}
	
		    	estimativa = novaEstimativa;
		    }
	}
	
	// calcula a velocidade de um planeta após n unidades de tempo
	public double calcularVelocidadeEscalar(double deslocamento, double tempo) {
		double velocidadeEscalar = deslocamento / tempo;
		return velocidadeEscalar;
	}
	
	// calcula o deslocamento total com base em velocidade e tempo dados
	public int calcularDeslocamento(int velocidadeInicial, int tempo) {
		int deslocamento = (velocidadeInicial * tempo);
		return deslocamento;
	}
}
