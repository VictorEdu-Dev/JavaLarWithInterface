package execute;
import java.util.InputMismatchException;
import java.util.Scanner;

import execute.suport.Relatorio;

public class Menu {
	protected Interceptador process;
	protected JavaLar init;
	protected Scanner entrada;
	protected Relatorio report;
	private boolean verificadorDeExistenciaDeSistema;

	public Menu() {
		doWhileMenu();
	}

	private void doWhileMenu() {
		init = new JavaLar();
		process = new Interceptador();
		report = new Relatorio();
		entrada = new Scanner(System.in);
		int op = 0;

		do {	
			System.out.println("Bem vindo ao JavaLar!");
			System.out.println("=====================");
			System.out.println("1. Inserir Tempo");
			System.out.println("2. Inserir Devs");
			System.out.println("3. Inserir Bugs");
			System.out.println("4. Sair");

			try {
				op = entrada.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida. Insira um número inteiro.");
				entrada.nextLine();
			}

			switch(op) {
			case 1: {
				System.out.println("Digite a quantidade desejada: ");
				int t = entrada.nextInt();
				process.setTime(t);
				break;
			}				
			case 2: {
				System.out.println("Digite a quantidade desejada: ");
				init.addDevs();
				break;
			}
			case 3: {
				System.out.println("Digite a quantidade desejada: ");
				init.addBugs();
				break;
			}
			}
			
			process.iniciarMenu(init);
			process.verificarColisao(init);
			process.showPrint(init);
			verificarSistema();
			report.gerarRelatorio(init.getRegister());
		} while (op != 4 && verificadorDeExistenciaDeSistema != true);
	}

	private void verificarSistema() {
		this.verificadorDeExistenciaDeSistema = init.verificarExistenciaDoSistema();
		if(verificadorDeExistenciaDeSistema == true)
			report.gerarRelatorio(init.getRegister());
		System.out.println();
	}
}