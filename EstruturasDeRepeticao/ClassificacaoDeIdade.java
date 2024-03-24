/*Faça um programa que peça para n pessoas a sua idade, ao final o programa devera verificar
 se a média de idade da turma varia entre 0 e 25,26 e 60 e maior que 60; e então, dizer se a 
 turma é jovem, adulta ou idosa, conforme a média calculada. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class ClassificacaoDeIdade {

	public static void main(String[] args) {
		
		String pessoasIdades = JOptionPane.showInputDialog("Digite as idades das pessoas (separadas por vírgula): ");
		
		String [] idades = pessoasIdades.split(",");
		
		int pessoasTotal = idades.length;
		int idadesSoma = 0;
		
		for (String idadeS : idades) {
			int idade = Integer.parseInt(idadeS.trim());
			idadesSoma += idade;
			
		}
		
		double idadeMedia = (double) idadesSoma / pessoasTotal;
		
		String mensagem;
		
		if (idadeMedia >= 0 && idadeMedia <= 25) {
			mensagem = "Turma Jovem";
		}
		else if (idadeMedia >= 26 && idadeMedia <= 60) {
			mensagem = "Turma Adulta";
		}
		else {
			mensagem = "Turma idosa";
		}
		
		JOptionPane.showMessageDialog(null, mensagem);
		

	}

}
