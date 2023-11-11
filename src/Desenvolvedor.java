import java.util.ArrayList;

public class Desenvolvedor extends Meteoro {
	protected ArrayList <Desenvolvedor> desenvolvedores;
	protected GeradorXYJavaLar gerador;
	
	public Desenvolvedor(int coordX, int coordY) {
		super(coordX, coordY);
		identificador = "DEV";
	}
	
	// gerador de desenvolvedores conforme uma quantidade desejada
		public ArrayList<Desenvolvedor> desenvolverSistema(int quantify) {
			gerador = new GeradorXYJavaLar(15, 1, 15, 1);
			desenvolvedores = new ArrayList<Desenvolvedor>();
			for(int i = 0; i < quantify; i++) {
				int[] coord = gerador.gerarCoordenadas();
				desenvolvedores.add(new Desenvolvedor(coord[0], coord[1]));
			}
			return desenvolvedores;
		}

}
