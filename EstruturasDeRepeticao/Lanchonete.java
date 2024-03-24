/*43- O cardápio de uma lanchonete é o seguinte:
Especificação   Código  Preço
Cachorro Quente 100     R$ 1,20
Bauru Simples   101     R$ 1,30
Bauru com ovo   102     R$ 1,50
Hambúrguer      103     R$ 1,20
Cheeseburguer   104     R$ 1,30
Refrigerante    105     R$ 1,00
Faça um programa que leia o código dos itens pedidos e as 
quantidades desejadas. Calcule e mostre o valor a ser pago por 
item (preço * quantidade) e o total geral do pedido. Considere 
que o cliente deve informar quando o pedido deve ser encerrado. */

package EstruturasDeRepeticao;

import javax.swing.JOptionPane;

public class Lanchonete {
	public static void main(String[] args) {

		String[][] cardapio = { { "Cachorro Quente", "100", "1.20" }, { "Bauru Simples", "101", "1.30" },
				{ "Bauru com Ovo", "102", "1.50" }, { "Hambúrguer", "103", "1.20" }, { "Cheeseburguer", "104", "1.30" },
				{ "Refrigerante", "105", "1.00" } };

		StringBuilder mensagemCardapio = new StringBuilder();
		mensagemCardapio.append("Cardápio:\n");
		for (String[] item : cardapio) {
			mensagemCardapio.append(item[1]).append(": ").append(item[0]).append(" - R$ ").append(item[2]).append("\n");
		}
		mensagemCardapio.append("\n");

		double totalGeral = 0;

		while (true) {

			String codigoItem = JOptionPane.showInputDialog(null,
					mensagemCardapio.toString() + "Digite o código do item (ou 'S' para sair):");

			if (codigoItem.equalsIgnoreCase("S")) {
				break;
			}

			String quantidadeStr = JOptionPane.showInputDialog(null, "Digite a quantidade desejada:");
			int quantidade = Integer.parseInt(quantidadeStr);

			boolean itemEncontrado = false;
			double subtotal = 0;
			for (String[] item : cardapio) {
				if (item[1].equals(codigoItem)) {
					double preco = Double.parseDouble(item[2]);
					subtotal = preco * quantidade;
					totalGeral += subtotal;
					JOptionPane.showMessageDialog(null, "Item: " + item[0] + "\nQuantidade: " + quantidade
							+ "\nSubtotal: R$ " + String.format("%.2f", subtotal));
					itemEncontrado = true;
					break;
				}
			}

			if (!itemEncontrado) {
				JOptionPane.showMessageDialog(null, "Código do item inválido!");
			}
		}

		JOptionPane.showMessageDialog(null, "Total Geral do Pedido: R$ " + String.format("%.2f", totalGeral));
	}
}
