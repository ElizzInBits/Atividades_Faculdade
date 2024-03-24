package EstruturasDeRepeticao;

import java.util.Scanner;

public class ConvenienciaSrManoel {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double compraTotal;
        int contador;
        char opcao;

        System.out.println("Lojas Tabajara");

        do {
            System.out.print("Quantos produtos deseja registrar? ");
            int quantidadeProdutos = input.nextInt();
            compraTotal = 0;
            contador = 0;

            System.out.println("Por favor, comece a registrar os produtos.");

            while (contador < quantidadeProdutos) {
                contador++;
                System.out.print("Produto " + contador + ": R$ ");
                double preco = input.nextDouble();

                if (preco == 0) {
                    contador--;
                    break;
                }

                compraTotal += preco;
            }

            System.out.println("Total: R$ " + String.format("%.2f", compraTotal));

            System.out.print("Dinheiro: R$ ");
            double dinheiroRecebido = input.nextDouble();

            double troco = dinheiroRecebido - compraTotal;
            System.out.println("Troco: R$ " + String.format("%.2f", troco));

            do {
                System.out.print("Deseja registrar outra compra? (S/N): ");
                opcao = input.next().charAt(0);
            } while (opcao != 'S' && opcao != 's' && opcao != 'N' && opcao != 'n');

        } while (opcao == 'S' || opcao == 's');

        input.close();
    }
}
