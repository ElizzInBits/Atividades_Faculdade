/*44-Em uma eleição presidencial existem quatro candidatos. Os votos são informados por meio de código. Os códigos utilizados são:
1 , 2, 3, 4  - Votos para os respectivos candidatos 
(você deve montar a tabela ex: 1 - Jose/ 2- João/etc)
5 - Voto Nulo
6 - Voto em Branco
Faça um programa que calcule e mostre:
O total de votos para cada candidato;
O total de votos nulos;
O total de votos em branco;
A percentagem de votos nulos sobre o total de votos;
A percentagem de votos em branco sobre o total de votos. Para finalizar o conjunto de votos tem-se o valor zero. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class EleicaoPresidencial {
	public static void main(String[] args) {
        
        String[][] candidatos = {
            {"1", "José"},
            {"2", "João"},
            {"3", "Maria"},
            {"4", "Ana"}
        };
        
        StringBuilder mensagemCandidatos = new StringBuilder();
        mensagemCandidatos.append("Candidatos:\n");
        for (String[] candidato : candidatos) {
            mensagemCandidatos.append(candidato[0]).append(" - ").append(candidato[1]).append("\n");
        }
        mensagemCandidatos.append("5 - Voto Nulo\n");
        mensagemCandidatos.append("6 - Voto em Branco\n\n");
        
        
        int[] votosCandidatos = new int[4]; 
        int votosNulos = 0;
        int votosBrancos = 0;
        int totalVotos = 0;
        
       
        while (true) {
         
            String votoStr = JOptionPane.showInputDialog(null, mensagemCandidatos.toString() + "Digite o número do candidato (ou '0' para finalizar):");
            int voto = Integer.parseInt(votoStr);
            
            
            if (voto == 0) {
                break;
            }
            
            
            totalVotos++;
            
           
            switch (voto) {
                case 1:
                case 2:
                case 3:
                case 4:
                    
                    votosCandidatos[voto - 1]++;
                    break;
                case 5:
                    
                    votosNulos++;
                    break;
                case 6:
                    
                    votosBrancos++;
                    break;
                default:
                   
                    JOptionPane.showMessageDialog(null, "Voto inválido!");
            }
        }
        
        
        double percentualNulos = (double) votosNulos / totalVotos * 100;
        double percentualBrancos = (double) votosBrancos / totalVotos * 100;
        
        
        StringBuilder resultados = new StringBuilder();
        resultados.append("Resultados da Eleição:\n");
        for (int i = 0; i < candidatos.length; i++) {
            resultados.append("Candidato ").append(candidatos[i][1]).append(": ").append(votosCandidatos[i]).append(" votos\n");
        }
        resultados.append("Votos Nulos: ").append(votosNulos).append(" votos\n");
        resultados.append("Votos em Branco: ").append(votosBrancos).append(" votos\n");
        resultados.append("Percentagem de Votos Nulos: ").append(String.format("%.2f", percentualNulos)).append("%\n");
        resultados.append("Percentagem de Votos em Branco: ").append(String.format("%.2f", percentualBrancos)).append("%");
        
        JOptionPane.showMessageDialog(null, resultados.toString(), "Resultado da Eleição", JOptionPane.INFORMATION_MESSAGE);
    }
}