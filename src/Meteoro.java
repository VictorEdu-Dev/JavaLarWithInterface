
public abstract class Meteoro {
	protected String identificador;
	protected GeradorXYJavaLar gerador;
	private int coordX;
	private int coordY;
	
	public Meteoro(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public void alterarVelocidade(AstroLinguagem astro) {
		astro.setVelocidadeDeTranslacao(1);
	}
	
	public int getCoordX() {
		return coordX;
	}

	public int getCoordY() {
		return coordY;
	}
	
	public String getIdentificador() {
		return identificador;
	}
}
