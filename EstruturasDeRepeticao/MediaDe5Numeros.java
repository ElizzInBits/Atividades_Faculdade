/*8- Faça um programa que leia 5 números e informe a soma e a média dos números. */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class MediaDe5Numeros {
	public static void main(String[] args) {
		
		String valores = JOptionPane.showInputDialog("Digite 5 numeros: ");
		
		String [] valoresString = valores.split(" ");
		
		int [] numeros = new int[valoresString.length];
		
		for (int i = 0; i < valoresString.length; i++) {
			numeros[i] = Integer.parseInt(valoresString[i]);
			
		}
		
		int soma = 0;
		for(int num : numeros) {
			soma += num;
		}
		
		double media = (double) soma / numeros.length;
		
		JOptionPane.showMessageDialog(null,"A soma dos números é: " +soma+ "\n A média dos numeros é: "+media);
				
	}

}