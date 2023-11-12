package planets.extern;
import java.util.ArrayList;

import planets.AstroLinguagem;
import planets.Meteoro;
import util.GeradorXYJavaLar;

public class Bug extends Meteoro {
	private ArrayList <Bug> bugs;
	protected GeradorXYJavaLar gerador;
	
	public Bug(int coordX, int coordY) {
		super(coordX, coordY);
		setIdentificador("BUG");
	}
	
	public void alterarVelocidade(AstroLinguagem astro) {
		astro.setVelocidadeDeTranslacao(-1);
	}
	
	// gerador de bugs conforme uma quantidade desejada
	public ArrayList<Bug> bugarSistema(int quantify) {
		gerador = new GeradorXYJavaLar(15, 1, 15, 1);
		bugs = new ArrayList<Bug>();
		for(int i = 0; i < quantify; i++) {
			int[] coord = gerador.gerarCoordenadas();
			bugs.add(new Bug(coord[0], coord[1]));
		}
		return bugs;
	}

}
