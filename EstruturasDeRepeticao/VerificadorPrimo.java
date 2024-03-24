/*Os números primos possuem várias aplicações dentro da Computação, por exemplo na Criptografia.
 Um número primo é aquele que é divisível apenas por um e por ele mesmo. Faça um programa que 
 peça um número inteiro e determine se ele é ou não um número primo. */
 
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class VerificadorPrimo {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número para saber se é primo:");
        
        int numero = Integer.parseInt(input);
        
        boolean Primo = true;

        if (numero <= 1) {
            Primo = false; 
        } else if (numero > 2 && numero % 2 == 0) {
            Primo = false; 
        } else {
            for (int i = 3; i <= Math.sqrt(numero); i += 2) {
                if (numero % i == 0) {
                    Primo = false;
                    break;
                }
            }
        }

        if (Primo) {
            JOptionPane.showMessageDialog(null, numero + " é um número primo.");
        } else {
            JOptionPane.showMessageDialog(null, numero + " não é um número primo.");
        }
    }
}
