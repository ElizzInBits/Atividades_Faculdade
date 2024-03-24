/*28 - Faça um programa que calcule o valor total investido por um colecionador em sua coleção de CDs e o valor 
médio gasto em cada um deles. O usuário deverá informar a quantidade de CDs e o valor para em cada um. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class InvestimentoCDs {

    public static void main(String[] args) {
        int quantidadeCDs = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de CDs: "));
        
        double totalInvestido = 0;

        for (int i = 1; i <= quantidadeCDs; i++) {
            String valorCDStr = JOptionPane.showInputDialog("Digite o valor do CD " + i + ": ");
            valorCDStr = valorCDStr.replace(",", ".");
            double valorCD = Double.parseDouble(valorCDStr);
            totalInvestido += valorCD;
        }

        double valorMedioPorCD = totalInvestido / quantidadeCDs;

        JOptionPane.showMessageDialog(null, "Valor total investido na coleção: R$ " + totalInvestido
                + "\nValor médio gasto em cada CD: R$ " + valorMedioPorCD);
    }
}
