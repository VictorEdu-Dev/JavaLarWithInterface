package planets.stars;
import planets.AstroLinguagem;

public class CLanguage extends AstroLinguagem {
	private String resumo;
	
	public CLanguage(String nome, int posX, int posY, int velocidadeDeTranslacao) {
		super(nome, posX, posY, velocidadeDeTranslacao);
		setLimitXLeft(1);
		setLimitXRigth(15);
		setLimitYUp(15);
		setLimitYDown(1);
		resumo = "O planeta C é uma linguagem de "
				+ "programação clássica, conhecida por sua eficiência e "
				+ "controle de baixo nível. É amplamente "
				+ "usado em sistemas operacionais e aplicativos de "
				+ "alto desempenho.";
	}
	
	public String getResumo() {
		return resumo;
	}
}
