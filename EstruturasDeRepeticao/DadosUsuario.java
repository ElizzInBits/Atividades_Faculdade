/*3- Faça um programa que leia e valide as seguintes informações:
Nome: maior que 3 caracteres;
Idade: entre 0 e 150;
Salário: maior que zero;
Sexo: 'f' ou 'm';
Estado Civil: 's', 'c', 'v', 'd'; */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class DadosUsuario {
	public static void main(String[] args) {

		// Repetição nome
		String nome;
		do {
			nome = JOptionPane.showInputDialog("Informe seu nome: ");
			if (nome.length() <= 3) {
				JOptionPane.showMessageDialog(null, "Erro \nPor favor digite seu nome");
			}
		} while (nome.length() <= 3);

		// Repetição idade
		String idade;
		int idade1 = 0;
		do {
			idade = JOptionPane.showInputDialog("Informe sua idade: ");
			if (idade.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Erro \n Por Favor informe uma idade válida");
				continue;
			}
			idade1 = Integer.parseInt(idade);

			if (idade1 <= 0 || idade1 >= 150) {
				JOptionPane.showMessageDialog(null, "Erro \n Por Favor informe uma idade válida");
			}
		} while (idade1 <= 0 || idade1 >= 150 || idade.isEmpty());

		// Repetição salario
		String salario;
		double salario1 = 0;
		do {
			salario = JOptionPane.showInputDialog("Informe seu salario: ");
			if (salario.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Erro \nPor favor informe seu salario");
				continue;
			}
			salario1 = Double.parseDouble(salario);

			if (salario1 <= 0) {
				JOptionPane.showMessageDialog(null, "Erro \nPor favor informe seu salario");
			}
		} while (salario1 <= 0 || salario.isEmpty());

		// repetição sexo
		String sexo;
		do {
			sexo = JOptionPane.showInputDialog("Informe seu sexo \n[(F)- Feminino] \n[(M)- Masculino]: ");
			sexo = sexo.toLowerCase();
			if (!sexo.equals("f") && !sexo.equals("m")) {

				JOptionPane.showMessageDialog(null, "Erro \nPor favor insira corretamente");
			}

		} while (!sexo.equals("f") && !sexo.equals("m"));

		// Repetição estado civil
		String estadoCivil;
		do {
			estadoCivil = JOptionPane.showInputDialog("Informe seu estado civil"
					+ "\n[(S) - Solteiro] \n[(C) - Casado] \n[(V) - Viúvo] \n[(D) - Divorciado]");

			estadoCivil = estadoCivil.toLowerCase();

			estadoCivil = estadoCivil.toLowerCase();
            switch (estadoCivil) {
                case "s":
                case "c":
                case "v":
                case "d":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Erro \nPor favor informe corretamente (S/C/V/D)");
            }
        } while (!estadoCivil.equals("s") && !estadoCivil.equals("c") && !estadoCivil.equals("v")
                && !estadoCivil.equals("d"));
	}

}

