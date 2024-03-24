/*24- Faça um programa que calcule o mostre a média aritmética de N notas. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class MediaN {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Informe a quantidade de notas: ");
		int quantidadeNotas = Integer.parseInt(input);
		
		double soma = 0;
		
		for (int i = 1; i <= quantidadeNotas; i++) {
			String notas = JOptionPane.showInputDialog("Digite a nota " +i+": ");
			double nota = Double.parseDouble(notas);
			
			soma += nota;
			
		}
		
		double media = soma / quantidadeNotas;
		JOptionPane.showMessageDialog(null, "A media das notas é: "+media);
	}

}
