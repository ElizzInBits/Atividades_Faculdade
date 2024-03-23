/* Faça um programa que peça um número inteiro e determine se ele é ou não um número primo.
 Um número primo é aquele que é divisível somente por ele mesmo e por 1.*/
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class NumeroPrimo {

	public static void main(String[] args) {

		String valor = JOptionPane.showInputDialog("Digite um número: ");
		int numero = Integer.parseInt(valor);

		boolean numeroPrimo = true;

		if (numero <= 1) {
			numeroPrimo = false;
		} else {

			for (int i = 2; i <= numero / 2; i++) {
				if (numero % i == 0) {
					numeroPrimo = false;
					break;
				}
			}
		}

		if (numeroPrimo) {
			JOptionPane.showMessageDialog(null, numero + " é um número primo");
		} else if (numero == 1) {
			JOptionPane.showMessageDialog(null, numero + " é um número primo");

		} else {
			JOptionPane.showMessageDialog(null, numero + " não é um número primo");
		}

	}
}