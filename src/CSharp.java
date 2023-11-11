
public class CSharp extends AstroLinguagem{
	private String resumo;
	
	public CSharp(String nome, int posX, int posY, int velocidadeDeTranslacao) {
		super(nome, posX, posY, velocidadeDeTranslacao);
		setLimitXLeft(3);
		setLimitXRigth(13);
		setLimitYUp(13);
		setLimitYDown(3);
		resumo = "O planeta C# é a linguagem de "
				+ "programação da Microsoft, focada em desenvolvimento "
				+ "Windows e .NET. É popular por sua "
				+ "sintaxe moderna e recursos avançados.";
	}
	
	public String getResumo() {
		return resumo;
	}
}
