/*7-Faça um programa que leia 5 números e informe o maior número. */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class MaiorNumero {
    public static void main(String[] args) {
       
        String valor = JOptionPane.showInputDialog("Digite 5 numeros para saber qual é o maior deles: ");

        String[] numerosString = valor.split(" ");

        int[] numeros = new int[numerosString.length];

        for (int i = 0; i < numerosString.length; i++) { 
            numeros[i] = Integer.parseInt(numerosString[i]);
        }

        int maiorNumero = Integer.MIN_VALUE;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > maiorNumero) {
                maiorNumero = numeros[i];
            }
        }

        JOptionPane.showMessageDialog(null, "O maior número é: " + maiorNumero);
    }
} 
   
