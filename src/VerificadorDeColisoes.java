import java.util.ArrayList;
import java.util.List;

public class VerificadorDeColisoes {
	private boolean verificador;
	
	
	public void verificarColisao(JavaLar init) {
	List<Meteoro> bugsToRemove = new ArrayList<>();
	List<Meteoro> devsToRemove = new ArrayList<>(); 
	List<AstroLinguagem> astrosCopy = new ArrayList<>(init.obterArrayDeAstros());
	
	// Verificar colisões entre bugs e planetas
    for (Meteoro bug : init.obterArrayDeBugs()) {
        for (AstroLinguagem astro : astrosCopy) {
            verificarColisao(astro, bug);
            //init.register.setAstrosLista(astro);
            if (verificador) {
                bugsToRemove.add(bug); // Adicionar bug à lista de remoção
                if(astro != null && astro.getVelocidadeDeTranslacao() <= 0) {
                	astro.setExplodiu(verificador); // primeiro registra que o planeta explodiu
    				init.obterArrayDeAstros().remove(astro); //remove do JavaLar
    				System.out.printf("%s explodiu!%n", astro.getNome());
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
		if(met.identificador.equals("DEV")) {
			colisaoDev(astro, met);
		} else if (met.identificador.equals("BUG")) {
			colisaoBug(astro, met);
		} else {
			return;
		}
	}

	// este verifica diretamente uma colisao bug-planeta
	private boolean colisaoBug(AstroLinguagem astro, Meteoro met) {
		if(astro.getPosX() == met.getCoordX() && astro.getPosY() == met.getCoordY()) {
			met.alterarVelocidade(astro);
			System.out.println("Alerta! Um bug colidiu com o planeta "+astro.getNome()+" na posição ("+astro.getPosX()+", "+astro.getPosY()+")");
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
			System.out.println("Alerta! Um Dev pousou em "+astro.getNome()+" na posiçãoo ("+astro.getPosX()+", "+astro.getPosY()+")");
			astro.setNumDevsColididos();
			verificador = true;
			return true;
		} else {
			verificador = false;
		return false;
		}
	}
}
