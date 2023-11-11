
public final class Python extends AstroLinguagem {
	private String resumo;
	
	public Python(String nome, int posX, int posY, int velocidadeDeTranslacao) {
		super(nome, posX, posY, velocidadeDeTranslacao);
		setLimitXLeft(7);
		setLimitXRigth(9);
		setLimitYUp(9);
		setLimitYDown(7);
		resumo = "O planeta Python se destaca pela simplicidade "
				+ "e clareza. É ótimo para iniciantes e projetos "
				+ "rápidos.";
	}
	
	public String getResumo() {
		return resumo;
	}
}