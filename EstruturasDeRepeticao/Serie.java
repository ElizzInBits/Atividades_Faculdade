/*49- Faça um programa que mostre os n termos da Série a seguir:
  S = 1/1 + 2/3 + 3/5 + 4/7 + 5/9 + ... + n/m.  */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class Serie {
	public static void main(String[] args) {

		int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número de termos da série:"));

		double soma = 0.0;

		int numerador = 1;
		int denominador = 1;
		for (int i = 1; i <= n; i++) {
			soma += (double) numerador / denominador;
			numerador++;
			denominador += 2;
		}

		JOptionPane.showMessageDialog(null, "Soma dos " + n + " termos da série: " + soma);
	}
}
