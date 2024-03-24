/*51- Faça um programa que mostre os n termos da Série a seguir:
  S = 1/1 + 2/3 + 3/5 + 4/7 + 5/9 + ... + n/m. 
Imprima no final a soma da série. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class SerieUltima {
	public static void main(String[] args) {

		int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número de termos da série:"));

		double soma = 0.0;

		int denominador = 1;
		for (int i = 1; i <= n; i++) {
			soma += (double) i / denominador;
			denominador += 2;
		}

		StringBuilder serie = new StringBuilder("Série: ");
		for (int i = 1; i <= n; i++) {
			serie.append(i).append("/").append((2 * i - 1));
			if (i != n) {
				serie.append(" + ");
			}
		}

		JOptionPane.showMessageDialog(null, serie.toString() + "\n\nA soma da série é: " + soma);
	}
}
