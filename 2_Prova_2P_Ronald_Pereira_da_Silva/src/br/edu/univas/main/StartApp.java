package br.edu.univas.main;

import java.util.Scanner;

import br.edu.univas.vo.*;

public class StartApp {
			
	static Scanner leitura = new Scanner(System.in);

	public static void main(String[] args) {
		ct[] contas = new ct[100];
		String operar;
		do {
			
			menu();
			operar = leitura.nextLine();
			if (operar.equals("1")) {
				cadastrarConta(contas);
			} else if (operar.equals("2")) {
				verSaldo(contas);
			} else if (operar.equals("3")) {
				break;
			} else {

			}
			
		} while (true);
		leitura.close();
	}

	public static void cadastrarConta(ct[] contas) {
		int i = 0;
		do {
			if (contas[i] == null) {
				ct conta = new ct();
				System.out.println("\n Cadastro de Conta: ");
				System.out.println("Digite uma breve descrição da conta: ");
				conta.desc = leitura.nextLine();
				System.out.println("Digite o valor da conta: ");
				conta.valor = leitura.nextFloat();
				leitura.nextLine();
				System.out.println("Digite a data de vencimento da conta: ");
				conta.data = leitura.nextLine();
				System.out.println("Digite o tipo de conta: Despesa ou Receita.");
				conta.tipo = leitura.nextLine();
				contas[i] = conta;
				break;
			}
			i++;
		} while (true);
	}

	public static void verSaldo(ct[] contas) {
		float receita = 0;
		float despesa = 0;
		for (int i = 0; i < 100; i++) {
			if (contas[i] != null) {
				ct conta = contas[i];
				if (conta.tipo.equals("Despesa")) {
					despesa = conta.valor + despesa;
				} else if (conta.tipo.equals("Receita")) {
					receita = conta.valor + receita;
				} else {

				}
			}
		}
		float saldo = receita - despesa;
		if (saldo > 0) {
			System.out.printf("\n Saldo Positivo: %.2f %n", saldo);
		} else if (saldo < 0) {
			System.out.printf("\n Saldo Negativo: %.2f %n", saldo);
		} else {
			System.out.println("\n Saldo Zerado!");
		}
	}

	public static void menu() {
		System.out.println("- MENU - \n");
		System.out.println("1 - Cadastro de conta");
		System.out.println("2 - Ver Saldo ");
		System.out.println("3 - Sair");
	}
}
