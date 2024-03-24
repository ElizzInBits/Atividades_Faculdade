/*39- Faça um programa que leia dez conjuntos de dois valores, o primeiro representando o número do aluno
 e o segundo representando a sua altura em centímetros. Encontre o aluno mais alto e o mais baixo. Mostre 
 o número do aluno mais alto e o número do aluno mais baixo, junto com suas alturas. */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class AlunoMaisAlto_Baixo {
	public static void main(String[] args) {

		int alunoMaisAlto = 0, alunoMaisBaixo = 0;
		double alturaMaisAlta = 0, alturaMaisBaixa = 0;

		boolean continuar = true;

		while (continuar) {
			String entrada = JOptionPane.showInputDialog(null,
					"Digite o número do próximo aluno (ou 'sair' para encerrar):");

			if (entrada == null || entrada.equalsIgnoreCase("sair")) {
				continuar = false;
				break;
			}

			int numeroAluno;
			try {
				numeroAluno = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Entrada inválida. Por favor, digite um número de aluno válido ou 'sair'.");
				continue;
			}

			String alturaInput = JOptionPane.showInputDialog(null, "Digite a altura do aluno em centímetros:");
			double alturaAluno;
			try {
				alturaAluno = Double.parseDouble(alturaInput);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Altura inválida. Por favor, digite uma altura válida.");
				continue;
			}

			if (alunoMaisAlto == 0 || alturaAluno > alturaMaisAlta) {
				alunoMaisAlto = numeroAluno;
				alturaMaisAlta = alturaAluno;
			}

			if (alunoMaisBaixo == 0 || alturaAluno < alturaMaisBaixa) {
				alunoMaisBaixo = numeroAluno;
				alturaMaisBaixa = alturaAluno;
			}
		}

		String mensagemResultado = "";
		if (alunoMaisAlto != 0 && alunoMaisBaixo != 0) {
			mensagemResultado += "O aluno mais alto é o número " + alunoMaisAlto + " com " + alturaMaisAlta
					+ " cm de altura.\n";
			mensagemResultado += "O aluno mais baixo é o número " + alunoMaisBaixo + " com " + alturaMaisBaixa
					+ " cm de altura.";
		} else {
			mensagemResultado += "Nenhum aluno registrado.";
		}
		JOptionPane.showMessageDialog(null, mensagemResultado);
	}
}
