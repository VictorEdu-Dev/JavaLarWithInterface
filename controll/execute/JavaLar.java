package execute;

import java.util.ArrayList;
import execute.suport.Historico;
import planets.AstroLinguagem;
import planets.Meteoro;
import planets.extern.Bug;
import planets.extern.Desenvolvedor;
import planets.stars.CLanguage;
import planets.stars.CPlusPlus;
import planets.stars.CSharp;
import planets.stars.Java;
import planets.stars.JavaScript;
import planets.stars.PHP;
import planets.stars.Python;
import planets.stars.RubyOnRails;
import util.Coordinates;

public class JavaLar {
	private ArrayList<AstroLinguagem> astros; // contémm os planetas já iniciados no construtor
	private ArrayList<Meteoro> bugs; // estão no mesmo plano dos planetas
	private ArrayList<Meteoro> devs; // estão no mesmo plano dos planetas
	private ArrayList<AstroLinguagem> astrosRemoved;
	private Historico register;
	
	public JavaLar() {
		astros = new ArrayList<AstroLinguagem>();
		bugs = new ArrayList<Meteoro>();
		devs = new ArrayList<Meteoro>();
		setAstrosRemoved(new ArrayList<>());
		register = new Historico();
		iniciarSistema();
	}

	// cria o sistema javalar
	private void iniciarSistema() {
		// insert name, posX, posY and velox
		astros.add(new Java("Java", 8, 8, 0));
		astros.add(new Python("Python", 8, 9, 4));
		astros.add(new JavaScript("JavaScript", 8, 10, 3));
		astros.add(new RubyOnRails("Ruby on Rails", 8, 11, 2));
		astros.add(new PHP("PHP", 8, 12, 2));
		astros.add(new CSharp("C#", 8, 13, 1));
		astros.add(new CPlusPlus("C++", 8, 14, 2));
		astros.add(new CLanguage("C", 8, 15, 10));
		register.setAstrosLista(astros);
	}
	
	public ArrayList<Coordinates> getCoordinatesPlanets() {
		int sizeArrayPlanets = getAstros().size();
		ArrayList<Coordinates> listCoord = new ArrayList<>();
		for (int i = 0; i < sizeArrayPlanets; i++) {
			int x = getAstros().get(i).getPosX();
			int y = getAstros().get(i).getPosY();
			listCoord.add(new Coordinates(x, y));
		}
		return listCoord;
	}
	
	public ArrayList<AstroLinguagem> getAstros() {
		return astros;
	}
	
	public ArrayList<Meteoro> obterArrayDeBugs() {
		return bugs;
	}
	
	public ArrayList<Meteoro> obterArrayDeDevs() {
		return devs;
	}
	
	public boolean verificarExistenciaDoSistema() {
		if(astros.size() == 1 && astros.get(0) instanceof Java) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setBugs(int bugsQtde) {
		bugs.addAll(new Bug(0, 0).bugarSistema(bugsQtde));
	}

	public void setDevs(int devsQtde) {
		devs.addAll(new Desenvolvedor(0, 0).desenvolverSistema(devsQtde));
	}
	
	public Meteoro getBug(int index) {
		return bugs.get(index);
	}
	
	public Meteoro getDev(int index) {
		return devs.get(index);
	}
	
	public AstroLinguagem getAstro(int index) {
		return astros.get(index);
	}
	
	public void removerPlaneta(int posicao) {
		astros.remove(posicao);
	}

	public ArrayList<Meteoro> getBugs() {
		return bugs;
	}

	public ArrayList<Meteoro> getDevs() {
		return devs;
	}
	
	public Historico getRegister() {
		return register;
	}

	public ArrayList<AstroLinguagem> getAstrosRemoved() {
		return astrosRemoved;
	}

	public void setAstrosRemoved(ArrayList<AstroLinguagem> astrosRemoved) {
		this.astrosRemoved = astrosRemoved;
	}
	
}
