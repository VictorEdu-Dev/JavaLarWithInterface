package planets.stars;
import planets.AstroLinguagem;

public final class Java extends AstroLinguagem {
	private String resumo;
	
	public Java(String nome, int posX, int posY, int velocidadeDeTranslacao) {
		super(nome, posX, posY, velocidadeDeTranslacao);
		resumo = "A estrela Java, centro do JavaLar, é conhecida "
				+ "por sua versatilidade e segurança. É uma escolha "
				+ "confiável para desenvolvimento de aplicativos robustos.";
	}

	public String getResumo() {
		return resumo;
	}
}
