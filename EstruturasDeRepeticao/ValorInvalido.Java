/*1 - Faça um programa que peça uma nota, entre zero e dez.
 Mostre uma mensagem caso o valor seja inválido e continue pedindo até que o usuário informe um valor válido.*/
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class ValorInvalido {

	public static void main(String[] args) {

		String valor = JOptionPane.showInputDialog("Informe uma nota de 0 a 10: ");
		
		double numero = Double.parseDouble(valor);
		
		boolean menor = numero < 0;
		boolean maior = numero > 10;
	
		double valor2;
		
		while (menor || maior) {
			JOptionPane.showMessageDialog(null, "Erro \nTente novamete!");
			
			String valor1 = JOptionPane.showInputDialog("Informe uma nota de 0 a 10: ");
			
			valor2 = Double.parseDouble(valor1);
		}
		JOptionPane.showMessageDialog(null, "Programa encerrado");
	}

}

