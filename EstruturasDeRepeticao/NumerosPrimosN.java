/*23- Faça um programa que mostre todos os primos entre 1 e N sendo N um número inteiro fornecido pelo usuário. 
O programa deverá mostrar também o número de divisões que ele executou para encontrar os números primos. 
Serão avaliados o funcionamento, o estilo e o número de testes (divisões) executados. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class NumerosPrimosN {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número:");
        int numero = Integer.parseInt(input);

        int contarDivisoes = 0;
  
		StringBuilder primos = new StringBuilder("Números primos entre 1 e " + numero + ":\n");

        for (int i = 2; i <= numero; i++) {
            boolean EPrimo = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                contarDivisoes++;
                if (i % j == 0) {
                    EPrimo = false;
                    break;
                }
            }
            if (EPrimo) {
                primos.append(i).append(", ");
            }
        }

        if (primos.length() > 0) {
            primos.delete(primos.length() - 2, primos.length());
        }
        JOptionPane.showMessageDialog(null, primos.toString() + "\nNúmero total de divisões realizadas: " + contarDivisoes);
    }
}
