/*2-Faça um programa que leia um nome de usuário e a sua senha e não aceite a senha igual ao nome do usuário,
 mostrando uma mensagem de erro e voltando a pedir as informações. */

 package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class NomeUsuarioSenha {
	public static void main(String[] args) {

		String nome, senha;

		do {
			nome = JOptionPane.showInputDialog("Informe o seu nome de usuário: ");
			senha = JOptionPane.showInputDialog("Informe a sua senha: ");

			if (senha.length() > 0) {

				if (nome.equals(senha)) {
					JOptionPane.showMessageDialog(null,
							"Invalido! \nA senha não pode ser igual ao nome de usuário\nDigite outra.");
				} else {
					JOptionPane.showMessageDialog(null, "Programa encerrado");
					break; // Aqui o loop é encerrado quando a senha for inserida corretamente
				}
			}

		} while (true);  // cria um loop infinito que é interrompido pela instrução break quando uma condição é atendida.

	}

}

