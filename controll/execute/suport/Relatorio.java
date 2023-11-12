package execute.suport;
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

	private void instantesSolicitados(Historico register) {
		// d) Quantos instantes foram solicitados pelo usuário
		System.out.println("\nInstantes solicitados pelo usuário:");
		System.out.println("	Número de instantes: " + register.getNumInstantes());

		System.out.println("=============================================================");
	}

	private void planetasExplodidos(Historico register) {
		// c) Se algum planeta explodiu ao longo da execução do sistema
		System.out.println("\nPlanetas que explodiram: ");
		for (AstroLinguagem planeta : register.getAstrosLista()) {
			if (planeta.getExplodiu() == true) {
				System.out.println("	"+planeta.getNome());
			}
		}
		System.out.println("=============================================================");
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
