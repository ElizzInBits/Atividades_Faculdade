package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class NumeroPrimoDivisivel {

    public static void main(String[] args) {

        String valor = JOptionPane.showInputDialog("Digite um número: ");
        int numero = Integer.parseInt(valor);

        boolean numeroPrimo = true;
        String divisores = "";

        if (numero <= 1) {
            numeroPrimo = false;
        } else {
            for (int i = 2; i <= numero / 2; i++) {
                if (numero % i == 0) {
                    numeroPrimo = false;
                    divisores += i + ", "; 
                }
            }
        }

        if (numeroPrimo) {
            JOptionPane.showMessageDialog(null, numero + " é um número primo");
        } else {
            JOptionPane.showMessageDialog(null, numero + " não é um número primo. \nÉ divisível por: " + divisores);
        }

    }
}