import java.util.ArrayList;

public class Historico {
	private ArrayList<AstroLinguagem> astros;
	private int numInstantes;
	
	public Historico() {
		astros = new ArrayList<>();
	}

	public ArrayList<AstroLinguagem> getAstrosLista() {
		return astros;
	}

	public void addAtualizacaoList(AstroLinguagem astro) {
		this.astros.set(astros.indexOf(astro), astro).setExplodiu(true);
	}
	
	public void setAstrosLista(AstroLinguagem astro) {
		this.astros.set(astros.indexOf(astro), astro);
	}
	
	public void setAstrosLista(ArrayList<AstroLinguagem> astro) {
		this.astros.addAll(astro);
	}
	
	public int getNumInstantes() {
		return numInstantes;
	}

	public void setNumInstantes(int numInstantes) {
		this.numInstantes += numInstantes;
	}
	
}
