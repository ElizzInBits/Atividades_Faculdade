/*50- Sendo H= 1 + 1/2 + 1/3 + 1/4 + ... + 1/N,
 Faça um programa que calcule o valor de H com N termos. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class CalculoH {
	public static void main(String[] args) {

		int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número de termos da série:"));

		double soma = 0.0;

		for (int i = 1; i <= n; i++) {
			soma += 1.0 / i;
		}

		JOptionPane.showMessageDialog(null, "O valor de H com " + n + " termos é: " + soma);
	}
}
