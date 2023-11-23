package execute.suport;

import java.util.ArrayList;
import java.util.List;
import execute.JavaLar;
import planets.AstroLinguagem;
import planets.Meteoro;

public class VerificadorDeColisoes {
	private boolean verificador;
	private List<Meteoro> bugsToRemove;
	private List<Meteoro> devsToRemove; 

	public void verificarColisao(JavaLar init) {
		bugsToRemove = new ArrayList<>();
		devsToRemove = new ArrayList<>(); 
		List<AstroLinguagem> astrosCopy = new ArrayList<>(init.getAstros());

		// Verificar colisões entre bugs e planetas
		for (Meteoro bug : init.obterArrayDeBugs()) {
			for (AstroLinguagem astro : astrosCopy) {
				verificarColisao(astro, bug);
				//init.register.setAstrosLista(astro);
				if (verificador) {
					bugsToRemove.add(bug); // Adicionar bug à lista de remoção
					if(astro != null && astro.getVelocidadeDeTranslacao() <= 0) {
						astro.setExplodiu(verificador); // primeiro registra que o planeta explodiu
						init.getAstros().remove(astro); //remove do JavaLar
						init.getRegister().setAstrosLista(astro); // depois registra o planeta
						init.getRegister().addAtualizacaoList(astro); 
					}
				}
			}
		}

		// Verificar colisões entre desenvolvedores e planetas
		for (Meteoro dev : init.obterArrayDeDevs()) {
			for (AstroLinguagem astro : astrosCopy) {
				verificarColisao(astro, dev);
				if (verificador) {
					devsToRemove.add(dev); // Adicionar desenvolvedor à lista de remoção
				}
			}
		}
		// Remover elementos das listas originais
		init.obterArrayDeBugs().removeAll(bugsToRemove);
		init.obterArrayDeDevs().removeAll(devsToRemove);
	}

	// identifica o corpo estranho e chama funções de verificar colisao
	private void verificarColisao(AstroLinguagem astro, Meteoro met) {
		if(met.getIdentificador().equals("DEV")) {
			colisaoDev(astro, met);
		} else if (met.getIdentificador().equals("BUG")) {
			colisaoBug(astro, met);
		} else {
			return;
		}
	}

	// este verifica diretamente uma colisao bug-planeta
	private boolean colisaoBug(AstroLinguagem astro, Meteoro met) {
		if(astro.getPosX() == met.getCoordX() && astro.getPosY() == met.getCoordY()) {
			met.alterarVelocidade(astro);
			astro.setNumBugsColididos();
			verificador = true;
			return true;
		} else {
			verificador = false;
			return false;
		}
	}


	// este verifica diretamente uma colisao dev-planeta
	private boolean colisaoDev(AstroLinguagem astro, Meteoro met) {
		if(astro.getPosX() == met.getCoordX() && astro.getPosY() == met.getCoordY()) {
			met.alterarVelocidade(astro);
			astro.setNumDevsColididos();
			verificador = true;
			return true;
		} else {
			verificador = false;
			return false;
		}
	}

	// Getters e setters para uso posterior
	public boolean isVerificador() {
		return verificador;
	}

	public List<Meteoro> getBugsToRemove() {
		return bugsToRemove;
	}

	public List<Meteoro> getDevsToRemove() {
		return devsToRemove;
	}
}