package execute;

import java.util.InputMismatchException;
import java.util.Scanner;

import execute.suport.Relatorio;

public class Menu {
	private JavaLar javaLar;
	private Interceptador interceptador;
	private Relatorio relatorio;
	private Scanner entrada;

	public Menu() {
		javaLar = new JavaLar();
		interceptador = new Interceptador();
		relatorio = new Relatorio();
		entrada = new Scanner(System.in);
		doWhileMenu();
	}

	private void doWhileMenu() {
		int op = 0;

		do {
			exibirMenu();

			try {
				op = entrada.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida. Insira um número inteiro.");
				entrada.nextLine();
			}

			processarOpcao(op);

			interceptador.iniciarMenu(javaLar);
			interceptador.verificarColisao(javaLar);
			interceptador.showPrint(javaLar);
			verificarSistema();
			relatorio.gerarRelatorio(javaLar.getRegister());

		} while (op != 4 && !javaLar.verificarExistenciaDoSistema());
	}

	private void exibirMenu() {
		System.out.println("Bem vindo ao JavaLar!");
		System.out.println("=====================");
		System.out.println("1. Inserir Tempo");
		System.out.println("2. Inserir Devs");
		System.out.println("3. Inserir Bugs");
		System.out.println("4. Sair");
	}

	private void processarOpcao(int op) {
		switch (op) {
		case 1:
			System.out.println("Digite a quantidade desejada: ");
			int t = entrada.nextInt();
			interceptador.setTime(t);
			break;
		case 2:
			System.out.println("Digite a quantidade desejada: ");
			javaLar.addDevs();
			break;
		case 3:
			System.out.println("Digite a quantidade desejada: ");
			javaLar.addBugs();
			break;
		}
	}

	private void verificarSistema() {
		if (javaLar.verificarExistenciaDoSistema()) {
			relatorio.gerarRelatorio(javaLar.getRegister());
		}
		System.out.println();
	}
}
