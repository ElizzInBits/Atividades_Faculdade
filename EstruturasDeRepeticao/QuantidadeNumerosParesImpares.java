/*Faça um programa que peça 10 números inteiros, calcule e mostre a quantidade de números
 pares e a quantidade de números impares. */
package EstruturasDeRepeticao;

import java.util.Scanner;

public class QuantidadeNumerosParesImpares {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Digite 10 numeros (separados por espaço): ");
		String valores = input.nextLine();

		String[] valoresString = valores.split(" ");

		int[] numeros = new int[valoresString.length];

		int numerosPares = 0;
		int numerosImpares = 0;

		for (int i = 0; i < valoresString.length; i++) {
			numeros[i] = Integer.parseInt(valoresString[i]);

			if (numeros[i] % 2 == 0) {
				numerosPares++;

			} else {
				numerosImpares++;
			}

		}
		System.out.println("Quantidade de numeros pares: " + numerosPares);
		System.out.println("Quantidade de numeros ímpares: " + numerosImpares);

		input.close();

	}

}
