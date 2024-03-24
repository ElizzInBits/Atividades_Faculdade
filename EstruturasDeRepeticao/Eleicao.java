/*26- Numa eleição existem três candidatos. Faça um programa que peça o número total de eleitores.
 Peça para cada eleitor votar e ao final mostrar o número de votos de cada candidato. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class Eleicao {

	public static void main(String[] args) {
		
		int eleitoresTotal = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de eleitores: "));
		
		int [] votos = new int[3];
		
		for (int i = 0; i < eleitoresTotal; i++) {
			int voto = Integer.parseInt(JOptionPane.showInputDialog("Eleitor" +(i+1)+ "\n Digite o número do candidato (1, 2 ou 3):"));
			
			
			if (voto >= 1 && voto <= 3) {
				
				votos[voto - 1]++;
			}
			else {
				JOptionPane.showMessageDialog(null, "Voto invalido \nPor favor tente novamente");
				
			}
		}
		int maxVotos = votos[0];
		int candidatoVencedor = 1;
		boolean empate = false;
		
		for (int i = 1; i < votos.length; i++) {
			if (votos[i] > maxVotos) {
				maxVotos = votos[i];
				candidatoVencedor = i + 1;
				empate = false;			
			}
			else if (votos[i] == maxVotos) {
				empate = true;
				
			}
		}
		
		
		String resultado = "Resultado da Eleição:\n"
                + "Candidato 1: " + votos[0] + " votos\n"
                + "Candidato 2: " + votos[1] + " votos\n"
                + "Candidato 3: " + votos[2] + " votos";

		if (!empate) {
			resultado += "\nCandidato " +candidatoVencedor+ " venceu a eleição com " +maxVotos+ " 2votos";			
		}
		else {
			resultado += "\nHouve um empate";
		} 
		JOptionPane.showMessageDialog(null, resultado);
	}

}

