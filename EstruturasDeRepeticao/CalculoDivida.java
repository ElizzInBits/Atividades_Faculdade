/*41- Faça um programa que receba o valor de uma dívida e mostre uma tabela com os seguintes
 dados: valor da dívida, valor dos juros, quantidade de parcelas e valor da parcela. */
package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class CalculoDivida {
	public static void main(String[] args) {

		String inputDivida = JOptionPane.showInputDialog(null, "Digite o valor da dívida:");
		double valorDivida = Double.parseDouble(inputDivida);

		StringBuilder tabela = new StringBuilder();
		tabela.append("Valor da Dívida | Valor dos Juros | Quantidade de Parcelas | Valor da Parcela\n");

		for (int parcelas : new int[] { 1, 3, 6, 9, 12 }) {
			double valorJuros = valorDivida * getPercentualJuros(parcelas);
			double valorTotal = valorDivida + valorJuros;
			double valorParcela = valorTotal / parcelas;

			tabela.append(String.format("R$ %.2f        | R$ %.2f          | %d                       | R$ %.2f%n",
					valorTotal, valorJuros, parcelas, valorParcela));
		}

		JOptionPane.showMessageDialog(null, tabela.toString(), "Tabela de Parcelamento da Dívida",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private static double getPercentualJuros(int parcelas) {
		switch (parcelas) {
		case 1:
			return 0;
		case 3:
			return 0.10;
		case 6:
			return 0.15;
		case 9:
			return 0.20;
		case 12:
			return 0.25;
		default:
			return 0;
		}
	}
}
