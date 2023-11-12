package planets.stars;
import planets.AstroLinguagem;

public class CPlusPlus extends AstroLinguagem {
	private String resumo;

	public CPlusPlus(String nome, int posX, int posY, int velocidadeDeTranslacao) {
		super(nome, posX, posY, velocidadeDeTranslacao);
		setLimitXLeft(2);
		setLimitXRigth(14);
		setLimitYUp(14);
		setLimitYDown(2);
		resumo = "O planeta C++ oferece controle total sobre"
				+ " a memória e alta performance. É usado"
				+ " em sistemas críticos.";
	}
	
	public String getResumo() {
		return resumo;
	}
}
