/*19- Altere o programa anterior para que ele aceite apenas números entre 0 e 1000. */
package EstruturasDeRepeticao;

import java.util.Scanner;

public class MaiorMenor2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Quantos valores você deseja inserir? ");
        int quantidadeValores = input.nextInt();

        if (quantidadeValores > 0) {
            int[] valores = new int[quantidadeValores];
            int maior = Integer.MIN_VALUE;
            int menor = Integer.MAX_VALUE;
            int soma = 0;

            for (int i = 0; i < valores.length; i++) {
                System.out.println("Digite o " + (i + 1) + "º valor (entre 0 e 1000): ");
                int valorInserido = input.nextInt();

                
                if (valorInserido >= 0 && valorInserido <= 1000) {
                    valores[i] = valorInserido;
                    soma += valorInserido;

                    if (valorInserido > maior) {
                        maior = valorInserido;
                    }
                    if (valorInserido < menor) {
                        menor = valorInserido;
                    }
                } else {
                    System.out.println("O valor inserido não está no intervalo permitido. Por favor, insira novamente.");
                    i--; 
                }
            }
            System.out.println("Maior valor = " + maior);
            System.out.println("Menor valor = " + menor);
            System.out.println("Soma de todos os valores = " + soma);
        } else {
            System.out.println("A quantidade de valores deve ser maior que zero");
        }

        input.close();
    }
}
