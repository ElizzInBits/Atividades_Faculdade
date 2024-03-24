/*40- Foi feita uma estatística em cinco cidades brasileiras para coletar dados sobre acidentes de trânsito. Foram obtidos os seguintes dados:
Código da cidade;
Número de veículos de passeio (em 1999);
Número de acidentes de trânsito com vítimas (em 1999). Deseja-se saber:
Qual o maior e menor índice de acidentes de transito e a que cidade pertence;
Qual a média de veículos nas cinco cidades juntas;
Qual a média de acidentes de trânsito nas cidades com menos de 2.000 veículos de passeio. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class EstatisticaTransito {
    public static void main(String[] args) {
        int[] codigosCidades = new int[5];
        int[] veiculosPasseio = new int[5];
        int[] acidentesVitimas = new int[5];
        
        double maiorIndice = 0.0;
        double menorIndice = Double.MAX_VALUE;
        double somaVeiculos = 0.0;
        double somaAcidentesPequenas = 0.0;
        int totalCidades = 0;
        
        boolean continuar = true;
        while (continuar && totalCidades < 5) {
            try {
                String codigoCidadeInput = JOptionPane.showInputDialog(null, "Digite o código da " + getCityIdentifier(totalCidades) + " (ou 'sair' para encerrar):");
                if (codigoCidadeInput == null || codigoCidadeInput.equalsIgnoreCase("sair")) {
                    continuar = false;
                    break;
                }
                int codigoCidade = Integer.parseInt(codigoCidadeInput);
                
                String veiculosPasseioInput = JOptionPane.showInputDialog(null, "Digite o número de veículos de passeio da " + getCityIdentifier(totalCidades) + " (em 1999):");
                int numVeiculosPasseio = Integer.parseInt(veiculosPasseioInput);
                
                String acidentesVitimasInput = JOptionPane.showInputDialog(null, "Digite o número de acidentes de trânsito com vítimas da " + getCityIdentifier(totalCidades) + " (em 1999):");
                int numAcidentesVitimas = Integer.parseInt(acidentesVitimasInput);
                
                codigosCidades[totalCidades] = codigoCidade;
                veiculosPasseio[totalCidades] = numVeiculosPasseio;
                acidentesVitimas[totalCidades] = numAcidentesVitimas;
                
                double indice = (double) numAcidentesVitimas / numVeiculosPasseio;
                somaVeiculos += numVeiculosPasseio;
                
                if (indice > maiorIndice) {
                    maiorIndice = indice;
                }
                
                if (indice < menorIndice) {
                    menorIndice = indice;
                }
                
                if (numVeiculosPasseio < 2000) {
                    somaAcidentesPequenas += numAcidentesVitimas;
                }
                
                totalCidades++;
                
                if (totalCidades == 5) {
                    JOptionPane.showMessageDialog(null, "Foram fornecidos dados para todas as cidades.");
                    break;
                }
                
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja fornecer dados para outra cidade?", "Continuar?", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.NO_OPTION) {
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
            }
        }
        
        double mediaVeiculos = somaVeiculos / totalCidades;
        double mediaAcidentesPequenas = (somaAcidentesPequenas > 0) ? somaAcidentesPequenas / totalCidades : 0;
        
        JOptionPane.showMessageDialog(null, "Maior índice de acidentes: " + maiorIndice + 
                                          "\nMenor índice de acidentes: " + menorIndice +
                                          "\nMédia de veículos nas cinco cidades: " + mediaVeiculos +
                                          "\nMédia de acidentes em cidades com menos de 2.000 veículos: " + mediaAcidentesPequenas);
    }
    
    private static String getCityIdentifier(int index) {
        return "Cidade " + (index + 1);
    }
}
