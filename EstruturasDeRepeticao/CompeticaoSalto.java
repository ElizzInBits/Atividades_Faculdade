/*46- Em uma competição de salto em distância cada atleta tem direito a cinco saltos. 
No final da série de saltos de cada atleta, o melhor e o pior resultados são eliminados. 
O seu resultado fica sendo a média dos três valores restantes. Você deve fazer um
 programa que receba o nome e as cinco distâncias alcançadas pelo atleta em seus saltos 
 e depois informe a média dos saltos conforme a descrição acima informada (retirar o melhor
  e o pior salto e depois calcular a média). Faça uso de uma lista para armazenar os saltos.
   Os saltos são informados na ordem da execução, portanto não são ordenados. 
   O programa deve ser encerrado quando não for informado o nome do atleta */
   
package EstruturasDeRepeticao;


import javax.swing.JOptionPane;

public class CompeticaoSalto {
    public static void main(String[] args) {
        while (true) {
            String nomeAtleta = JOptionPane.showInputDialog(null, "Digite o nome do atleta (ou 'sair' para encerrar):");
            if (nomeAtleta.equalsIgnoreCase("sair")) {
                break;
            }
            
            double melhorSalto = Double.MIN_VALUE;
            double piorSalto = Double.MAX_VALUE;
            double somaSaltos = 0;
            
            for (int i = 0; i < 5; i++) {
                String saltoStr = JOptionPane.showInputDialog(null, "Digite a distância do salto " + (i + 1) + " (em metros):");
                double salto = Double.parseDouble(saltoStr);
                
                somaSaltos += salto;
                if (salto > melhorSalto) {
                    melhorSalto = salto;
                }
                if (salto < piorSalto) {
                    piorSalto = salto;
                }
            }
            
            
            double media = (somaSaltos - melhorSalto - piorSalto) / 3;
            
          
            JOptionPane.showMessageDialog(null, "Atleta: " + nomeAtleta +
                                                  "\nMelhor salto: " + melhorSalto + " m" +
                                                  "\nPior salto: " + piorSalto + " m" +
                                                  "\nMédia dos demais saltos: " + String.format("%.1f", media) + " m" +
                                                  "\n\nResultado final:\n" + nomeAtleta + ": " + String.format("%.1f", media) + " m");
        }
    }
}
