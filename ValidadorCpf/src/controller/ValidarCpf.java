package controller;

import javax.swing.JTextField;

public class ValidarCpf {

	String cpf;
	int[] digitoCpf = new int[11];
	int mult;
	int somaTotal1 = 0;
	int somaTotal2 = 0;
	int resto1;
	int resto2;
	int penultimo;
	int ultimo;
	boolean verificacao = false;

	// CADASTRAR CPF NA VARIAVEL
	public void cadastrarVariavel(JTextField txtCpf) {

		cpf = txtCpf.getText().trim();

		for (int i = 0; i <= 10; i++) {
			digitoCpf[i] = Character.getNumericValue(cpf.charAt(i));
		}

	}

	public boolean validarCpf() {

		// CALCULO PENULTIMO NUMERO DO CPF
		int k = 0;
		do {

			for (int b = 10; b >= 2; b--) {
				mult = digitoCpf[k] * b;

				somaTotal1 = somaTotal1 + mult;
				mult = 0;

				k++;
			}

		} while (k <= 8);

		resto1 = somaTotal1 % 11;
		
		if (resto1 == 0) {
			resto1 = 11;
		}
		
		penultimo = 11 - resto1;

		// CALCULO ULTIMO NUMERO DO CPF
		int j = 0;
		do {

			for (int b = 11; b >= 2; b--) {
				mult = digitoCpf[j] * b;

				somaTotal2 = somaTotal2 + mult;
				mult = 0;

				j++;
			}

		} while (j <= 9);

		resto2 = somaTotal2 % 11;

		if (resto2 == 0) {
			resto2 = 11;
		}

		ultimo = 11 - resto2;


		if (digitoCpf[9] == penultimo && digitoCpf[10] == ultimo) {
			verificacao = true;
			return true;
		} else {
			verificacao = false;
			return false;
		}

	}

}
