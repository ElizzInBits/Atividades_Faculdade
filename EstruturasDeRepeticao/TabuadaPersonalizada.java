/* 36- Desenvolva um programa que faça a tabuada de um número qualquer inteiro que será digitado pelo usuário,
] mas a tabuada não deve necessariamente iniciar em 1 e terminar em 10, o valor inicial e final devem ser
informados também pelo usuário, conforme exemplo abaixo:*/
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class TabuadaPersonalizada {

	public static void main(String[] args) {

		int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Montar a tabuada de:"));

		int comeca = Integer.parseInt(JOptionPane.showInputDialog(null, "Começar por:"));

		int termina = Integer.parseInt(JOptionPane.showInputDialog(null, "Terminar em:"));
		

		String mensagem = "Vou montar a tabuada de " + numero + " começando em " + comeca + " e terminando em "
				+ termina + ":\n\n";

		
		for (int i = comeca; i <= termina; i++) {
			int resultado = numero * i;
			mensagem += numero + " X " + i + " = " + resultado + "\n";
		}

		
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
