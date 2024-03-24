/*45- Desenvolver um programa para verificar a nota do aluno em uma prova com 10 questões, o programa deve perguntar ao aluno a resposta de cada questão e ao final comparar com o gabarito da prova e assim calcular o total de acertos e a nota (atribuir 1 ponto por resposta certa). Após cada aluno utilizar o sistema deve ser feita uma pergunta se outro aluno vai utilizar o sistema. Após todos os alunos terem respondido informar:
Maior e Menor Acerto;
Total de Alunos que utilizaram o sistema;
A Média das Notas da Turma */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class VerificarNota {
	public static void main(String[] args) {

		String[] gabarito = { "A", "B", "C", "D", "E", "E", "D", "C", "B", "A" };

		StringBuilder mensagemTabela = new StringBuilder();
		mensagemTabela.append("Tabela de Respostas:\n");
		mensagemTabela.append("A - Alternativa A\n");
		mensagemTabela.append("B - Alternativa B\n");
		mensagemTabela.append("C - Alternativa C\n");
		mensagemTabela.append("D - Alternativa D\n");
		mensagemTabela.append("E - Alternativa E\n");

		int totalAlunos = 0;
		int maiorAcerto = 0;
		int menorAcerto = 10;
		int totalAcertosTurma = 0;

		while (true) {

			String[] respostasAluno = new String[10];

			for (int i = 0; i < 10; i++) {
				String resposta = JOptionPane.showInputDialog(null,
						mensagemTabela.toString() + "Digite a resposta da questão " + (i + 1) + ":");
				respostasAluno[i] = resposta.toUpperCase();
			}

			int acertos = 0;
			for (int i = 0; i < 10; i++) {
				if (respostasAluno[i].equals(gabarito[i])) {
					acertos++;
				}
			}

			totalAlunos++;
			totalAcertosTurma += acertos;
			if (acertos > maiorAcerto) {
				maiorAcerto = acertos;
			}
			if (acertos < menorAcerto) {
				menorAcerto = acertos;
			}

			int resposta = JOptionPane.showConfirmDialog(null, "Outro aluno vai utilizar o sistema?", "Continuar?",
					JOptionPane.YES_NO_OPTION);
			if (resposta == JOptionPane.NO_OPTION) {
				break;
			}
		}

		double mediaNotasTurma = (double) totalAcertosTurma / totalAlunos;

		JOptionPane.showMessageDialog(null, "Maior Acerto: " + maiorAcerto + "\nMenor Acerto: " + menorAcerto
				+ "\nTotal de Alunos: " + totalAlunos + "\nMédia das Notas da Turma: " + mediaNotasTurma);
	}
}
