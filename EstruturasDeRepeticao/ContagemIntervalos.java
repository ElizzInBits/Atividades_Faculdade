/*42- Faça um programa que leia uma quantidade indeterminada de números positivos e 
conte quantos deles estão nos seguintes intervalos: [0-25], [26-50], [51-75] e [76-100].
 A entrada de dados deverá terminar quando for lido um número negativo. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class ContagemIntervalos {
	public static void main(String[] args) {

		int intervalo1 = 0; // [0-25]
		int intervalo2 = 0; // [26-50]
		int intervalo3 = 0; // [51-75]
		int intervalo4 = 0; // [76-100]

		while (true) {

			String input = JOptionPane.showInputDialog(null, "Digite um número positivo (ou negativo para sair):");
			double numero = Double.parseDouble(input);

			if (numero < 0) {
				break;
			}

			if (numero >= 0 && numero <= 25) {
				intervalo1++;
			} else if (numero >= 26 && numero <= 50) {
				intervalo2++;
			} else if (numero >= 51 && numero <= 75) {
				intervalo3++;
			} else if (numero >= 76 && numero <= 100) {
				intervalo4++;
			}
		}

		String resultado = "Quantidade de números nos intervalos:\n" + "[0-25]: " + intervalo1 + "\n" + "[26-50]: "
				+ intervalo2 + "\n" + "[51-75]: " + intervalo3 + "\n" + "[76-100]: " + intervalo4;

		JOptionPane.showMessageDialog(null, resultado, "Contagem de Intervalos", JOptionPane.INFORMATION_MESSAGE);
	}
}
