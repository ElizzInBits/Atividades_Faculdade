/*33- O Departamento Estadual de Meteorologia lhe contratou para desenvolver um programa que leia 
as um conjunto indeterminado de temperaturas, e informe ao final a menor e a maior temperaturas 
informadas, bem como a média das temperaturas. */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class MonitoramentoMeteorologico {

    public static void main(String[] args) {
        double temperatura;
        double somaTemperaturas = 0;
        int contadorTemperaturas = 0;
        double menorTemperatura = Double.MAX_VALUE;
        double maiorTemperatura = Double.MIN_VALUE;
        String input;

        while (true) {
            input = JOptionPane.showInputDialog(null, "Digite uma temperatura ou 'sair' para finalizar:");
            if ("sair".equalsIgnoreCase(input)) {
                break;
            }

            try {
                temperatura = Double.parseDouble(input);

                somaTemperaturas += temperatura;
                contadorTemperaturas++;

                if (temperatura < menorTemperatura) {
                    menorTemperatura = temperatura;
                }

                if (temperatura > maiorTemperatura) {
                    maiorTemperatura = temperatura;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
            }
        }

        if (contadorTemperaturas > 0) {
            double mediaTemperaturas = somaTemperaturas / contadorTemperaturas;
            JOptionPane.showMessageDialog(null, "Menor temperatura: " + menorTemperatura +
                    "\nMaior temperatura: " + maiorTemperatura +
                    "\nMédia das temperaturas: " + mediaTemperaturas);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma temperatura foi inserida.");
        }
    }
}
