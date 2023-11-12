package planets.stars;
import planets.AstroLinguagem;

public class RubyOnRails extends AstroLinguagem{
	private String resumo;
	
	public RubyOnRails(String nome, int posX, int posY, int velocidadeDeTranslacao) {
		super(nome, posX, posY, velocidadeDeTranslacao);
		setLimitXLeft(5);
		setLimitXRigth(11);
		setLimitYUp(11);
		setLimitYDown(5);
		resumo = " O planeta Ruby valoriza a expressividade e "
				+ "é popular para desenvolvimento web.";
	}
	
	public String getResumo() {
		return resumo;
	}
}
