/*2-Faça um programa que leia um nome de usuário e a sua senha e não aceite a senha igual ao nome do usuário,
 mostrando uma mensagem de erro e voltando a pedir as informações. */

package EstruiturasDeRepeticao;

import javax.swing.JOptionPane;

public class NomeUsuarioSenha {
	public static void main(String[] args) {

		String nome, senha;

		nome = JOptionPane.showInputDialog("Informe o nome de usuário: ");
		senha = JOptionPane.showInputDialog("Informe a senha: ");

		while (nome.equals(senha)) {
			JOptionPane.showMessageDialog(null, "Invalido \nA senha não pode ser o mesmo que o nome de usuario");
			nome = JOptionPane.showInputDialog("Informe o nome de usuário: ");
			senha = JOptionPane.showInputDialog("Informe a senha: ");
		}

		if (!(senha.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Erro \n informe a senha");
			nome = JOptionPane.showInputDialog("Informe o nome de usuário: ");
			senha = JOptionPane.showInputDialog("Informe a senha: ");

			while (nome.equals(senha)) {
				JOptionPane.showMessageDialog(null, "Invalido \nA senha não pode ser o mesmo que o nome de usuario");
				nome = JOptionPane.showInputDialog("Informe o nome de usuário: ");
				senha = JOptionPane.showInputDialog("Informe a senha: ");
			}
		}
	}

}

