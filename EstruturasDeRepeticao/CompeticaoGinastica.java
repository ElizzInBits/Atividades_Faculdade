/*47- Em uma competição de ginástica, cada atleta recebe votos de sete jurados. 
A melhor e a pior nota são eliminadas. A sua nota fica sendo a média dos votos restantes.
 Você deve fazer um programa que receba o nome do ginasta e as notas dos sete jurados
alcançadas pelo atleta em sua apresentação e depois informe a sua média, conforme a 
descrição acima informada (retirar o melhor e o pior salto e depois calcular a média
 com as notas restantes). As notas não são informados ordenadas. */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class CompeticaoGinastica {
	public static void main(String[] args) {
		while (true) {
			String nomeGinasta = JOptionPane.showInputDialog(null,
					"Digite o nome do ginasta (ou 'sair' para encerrar):");
			if (nomeGinasta.equalsIgnoreCase("sair")) {
				break;
			}

			double melhorNota = Double.MIN_VALUE;
			double piorNota = Double.MAX_VALUE;
			double somaNotas = 0;

			for (int i = 0; i < 7; i++) {
				String notaStr = JOptionPane.showInputDialog(null, "Digite a nota do jurado " + (i + 1) + ":");
				double nota = Double.parseDouble(notaStr);

				somaNotas += nota;
				if (nota > melhorNota) {
					melhorNota = nota;
				}
				if (nota < piorNota) {
					piorNota = nota;
				}
			}

			double media = (somaNotas - melhorNota - piorNota) / 5;

			JOptionPane.showMessageDialog(null,
					"Atleta: " + nomeGinasta + "\nMelhor nota: " + melhorNota + "\nPior nota: " + piorNota + "\nMédia: "
							+ String.format("%.2f", media) + "\n\nResultado final:\nAtleta: " + nomeGinasta
							+ "\nMelhor nota: " + melhorNota + "\nPior nota: " + piorNota + "\nMédia: "
							+ String.format("%.2f", media));
		}
	}
}
