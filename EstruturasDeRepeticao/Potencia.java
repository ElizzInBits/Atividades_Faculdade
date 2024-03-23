/*Faça um programa que peça dois números, base e expoente, calcule e mostre o primeiro número elevado ao segundo número. 
Não utilize a função de potência da linguagem. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class Potencia {

	public static void main(String[] args) {
	
		String baseMensagem = JOptionPane.showInputDialog("Digite o valor da base: ");
		String expoenteMensagem = JOptionPane.showInputDialog("Digite o valor do expoente: ");
		
		int base = Integer.parseInt(baseMensagem);		
		int expoente = Integer.parseInt(expoenteMensagem);	
		
		int resultado = 1;
		
		for(int i = 0; i < expoente; i++) {
			resultado *= base;		
		}
		JOptionPane.showMessageDialog(null, "O resultado é: "+resultado);

	}

}
