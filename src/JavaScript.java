
public class JavaScript extends AstroLinguagem{
	private String resumo;
	
	public JavaScript(String nome, int posX, int posY, int velocidadeDeTranslacao) {
		super(nome, posX, posY, velocidadeDeTranslacao);
		setLimitXLeft(6);
		setLimitXRigth(10);
		setLimitYUp(10);
		setLimitYDown(6);
		resumo = "O planeta JavaScript é a linguagem dos"
				+ " navegadores e é usada para criar interatividade "
				+ "em sites";
	}
	
	public String getResumo() {
		return resumo;
	}
}