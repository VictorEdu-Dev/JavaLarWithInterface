package execute.suport;
import java.util.ArrayList;
import java.util.List;

import planets.AstroLinguagem;

// import java.util.List;

public class Relatorio {

	public void gerarRelatorio(Historico register) {
		numBugsDevsColids(register);

		planetasExplodidos(register);

		instantesSolicitados(register);

		resumoPlanetas(register);
	}

	private void resumoPlanetas(Historico register) {
		// f) Pequeno resumo sobre cada planeta-linguagem
		System.out.println("\nDescrição sobre cada planeta-linguagem:");
		for (AstroLinguagem planeta : register.getAstrosLista()) {
			System.out.println(planeta.getNome());
			System.out.println("	"+planeta.getResumo());
			System.out.println("=============================================================");
		}
	}

	private int instantesSolicitados(Historico register) {
		return register.getNumInstantes();
	}

	private List<String> planetasExplodidos(Historico register) {
		List<String> planets = new ArrayList<>(); 
		for (AstroLinguagem planeta : register.getAstrosLista()) {
			if (planeta.getExplodiu() == true) {
				planets.add(planeta.getNome());
			}
		}
		return planets;
	}

	private void numBugsDevsColids(Historico register) {
		// a) Número de bugs e desenvolvedores que cada planeta colidiu
		System.out.println();
		System.out.println("RELATÓRIO DO SISTEMA JAVALAR");
		System.out.println("=============================================================");
		System.out.println("Número de bugs e desenvolvedores que cada planeta colidiu:");
		for (AstroLinguagem astro : register.getAstrosLista()) {
			System.out.println(astro.getNome());
			System.out.println("	Bugs colididos: " + astro.getNumBugsColididos());
			System.out.println("	Desenvolvedores colididos: " + astro.getNumDevsColididos());
			System.out.println("=============================================================");
		}
	}

}
