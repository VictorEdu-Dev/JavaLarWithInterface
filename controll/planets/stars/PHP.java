package planets.stars;
import planets.AstroLinguagem;

public class PHP extends AstroLinguagem {
	private String resumo;
	
	public PHP(String nome, int posX, int posY, int velocidadeDeTranslacao) {
		super(nome, posX, posY, velocidadeDeTranslacao);
		setLimitXLeft(4);
		setLimitXRigth(12);
		setLimitYUp(12);
		setLimitYDown(4);
		resumo = "O planeta PHP é usado principalmente para "
				+ "desenvolvimento web dinâmico.";
	}
	
	public String getResumo() {
		return resumo;
	}
}
