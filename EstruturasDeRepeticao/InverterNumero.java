/*48- Faça um programa que peça um numero inteiro positivo e em seguida mostre este numero invertido. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class InverterNumero {
	public static void main(String[] args) {

		String numeroStr = JOptionPane.showInputDialog(null, "Digite um número inteiro positivo:");

		char[] digitos = numeroStr.toCharArray();

		int inicio = 0;
		int fim = digitos.length - 1;
		while (inicio < fim) {

			char temp = digitos[inicio];
			digitos[inicio] = digitos[fim];
			digitos[fim] = temp;

			inicio++;
			fim--;
		}

		String numeroInvertido = new String(digitos);

		JOptionPane.showMessageDialog(null, "Número invertido: " + numeroInvertido);
	}
}
