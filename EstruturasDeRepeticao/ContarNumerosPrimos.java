/* Encontrar números primos é uma tarefa difícil. Faça um programa que gera uma lista dos 
números primos existentes entre 1 e um número inteiro informado pelo usuário.*/
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class ContarNumerosPrimos {
	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog(null, "Digite um número:");
		int limite = Integer.parseInt(input);

		String primosEncontrados = "";

		for (int numero = 2; numero <= limite; numero++) {
			boolean primo = true;
			for (int divisor = 2; divisor <= Math.sqrt(numero); divisor++) {
				if (numero % divisor == 0) {
					primo = false;
					break;
				}
			}

			if (primo) {

				primosEncontrados += numero + ", ";
			}
		}

		if (primosEncontrados.length() > 0) {
			primosEncontrados = primosEncontrados.substring(0, primosEncontrados.length() - 2);
		}

		JOptionPane.showMessageDialog(null, "Números primos até " + limite + ":\n" + primosEncontrados);
	}
}
