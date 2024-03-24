package EstruturasDeRepeticao;

import java.util.Scanner;

public class PadariaSrManoel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Preço do pão: R$ ");
        String precoPaoStr = input.nextLine().replace(",", ".");
        double precoPao = Double.parseDouble(precoPaoStr);

        System.out.println("Panificadora Pão de Ontem - Tabela de preços");

        for (int i = 1; i <= 50; i++) {
            double preco = i * precoPao;
            System.out.println(i + " - R$ " + String.format("%.2f", preco).replace(".", ","));
        }

        input.close();
    }
}
