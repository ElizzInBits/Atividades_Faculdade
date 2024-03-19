/*1 - Faça um programa que peça uma nota, entre zero e dez.
 Mostre uma mensagem caso o valor seja inválido e continue pedindo até que o usuário informe um valor válido.*/
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class ValorInvalido {

	public static void main(String[] args) {

		String valor;
		double nota;

		do {
			valor = JOptionPane.showInputDialog("Informe uma nota entre 0 e 10: ");
			nota = Double.parseDouble(valor);

			if (nota < 0 || nota > 10) {
				JOptionPane.showMessageDialog(null, "Valor errado, digite novamente");
			}

		} while (nota < 0 || nota > 10);
		JOptionPane.showMessageDialog(null, nota + " Programa encerrado");

	}

}

