/*37- Uma academia deseja fazer um senso entre seus clientes para descobrir o mais alto, 
o mais baixo, a mais gordo e o mais magro, para isto você deve fazer um programa que pergunte
 a cada um dos clientes da academia seu código, sua altura e seu peso. O final da digitação 
 de dados deve ser dada quando o usuário digitar 0 (zero) no campo código. 
 Ao encerrar o programa também deve ser informados os códigos e valores do clente mais alto,
  do mais baixo, do mais gordo e do mais magro, além da média das alturas e dos pesos dos 
clientes */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class AnaliseAcademia {

	public static void main(String[] args) {

		int codigoMaisAlto = 0, codigoMaisBaixo = 0, codigoMaisGordo = 0, codigoMaisMagro = 0;
		double alturaMaisAlto = Double.MIN_VALUE, alturaMaisBaixo = Double.MAX_VALUE;
		double pesoMaisGordo = Double.MIN_VALUE, pesoMaisMagro = Double.MAX_VALUE;

		double somaAlturas = 0, somaPesos = 0;
		int quantidadeClientes = 0;

		StringBuilder dadosClientes = new StringBuilder();

		while (true) {

			int codigo = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Digite o código do cliente (ou 0 para encerrar):"));
			if (codigo == 0) {
				break;
			}

			double altura = Double
					.parseDouble(JOptionPane.showInputDialog(null, "Digite a altura do cliente (em metros):"));

			double peso = Double
					.parseDouble(JOptionPane.showInputDialog(null, "Digite o peso do cliente (em quilogramas):"));

			if (altura > alturaMaisAlto) {
				alturaMaisAlto = altura;
				codigoMaisAlto = codigo;
			}
			if (altura < alturaMaisBaixo) {
				alturaMaisBaixo = altura;
				codigoMaisBaixo = codigo;
			}
			if (peso > pesoMaisGordo) {
				pesoMaisGordo = peso;
				codigoMaisGordo = codigo;
			}
			if (peso < pesoMaisMagro) {
				pesoMaisMagro = peso;
				codigoMaisMagro = codigo;
			}

			somaAlturas += altura;
			somaPesos += peso;
			quantidadeClientes++;

			dadosClientes.append("Código: ").append(codigo).append(", Altura: ").append(altura).append("m")
					.append(", Peso: ").append(peso).append("kg\n");
		}

		double mediaAlturas = somaAlturas / quantidadeClientes;
		double mediaPesos = somaPesos / quantidadeClientes;

		JOptionPane.showMessageDialog(null,
				"Dados dos Clientes:\n" + dadosClientes.toString() + "\nCliente mais alto (Código): " + codigoMaisAlto
						+ " (Altura: " + alturaMaisAlto + "m)" + "\nCliente mais baixo (Código): " + codigoMaisBaixo
						+ " (Altura: " + alturaMaisBaixo + "m)" + "\nCliente mais gordo (Código): " + codigoMaisGordo
						+ " (Peso: " + pesoMaisGordo + "kg)" + "\nCliente mais magro (Código): " + codigoMaisMagro
						+ " (Peso: " + pesoMaisMagro + "kg)" + "\nMédia de altura dos clientes: " + mediaAlturas + "m"
						+ "\nMédia de peso dos clientes: " + mediaPesos + "kg");
	}
}
