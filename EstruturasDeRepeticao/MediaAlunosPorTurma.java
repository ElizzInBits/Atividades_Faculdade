/*27- Faça um programa que calcule o número médio de alunos por turma. Para isto, peça a quantidade
 de turmas e a quantidade de alunos para cada turma. As turmas não podem ter mais de 40 alunos. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class MediaAlunosPorTurma {

	 public static void main(String[] args) {
	        int quantidadeTurmas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de turmas: "));
	        
	        int totalAlunos = 0;
	        
	        for (int i = 1; i <= quantidadeTurmas; i++) {
	            int alunosTurma = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de alunos para a turma " + i + ": "));
	            
	         
	            while (alunosTurma > 40) {
	                JOptionPane.showMessageDialog(null, "O número máximo de alunos por turma é 40 \nPor favor, digite novamente.");
	                alunosTurma = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de alunos para a turma " + i + ": "));
	            }
	            
	            totalAlunos += alunosTurma;
	        }
	        
	        int mediaAlunosTurma = (int) totalAlunos / quantidadeTurmas;
	        
	        JOptionPane.showMessageDialog(null, "O número médio de alunos por turma é: " + mediaAlunosTurma);
	    }
	}