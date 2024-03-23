/*18- Faça um programa que, dado um conjunto de N números, determine o menor valor, 
o maior valor e a soma dos valores. */
package EstruturasDeRepeticao;

import java.util.Scanner;

public class MaiorMenorSoma {
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

				System.out.println("Digite o " + (i + 1) + "º valor: ");
				valores[i] = input.nextInt();

				soma += valores[i];

				if (valores[i] > maior) {
					maior = valores[i];
				}
				if (valores[i] < menor) {
					menor = valores[i];
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
