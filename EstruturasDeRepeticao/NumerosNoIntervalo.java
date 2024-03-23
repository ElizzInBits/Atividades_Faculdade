/*Faça um programa que receba dois números inteiros e gere os números inteiros que estão no intervalo compreendido por eles. */

package EstruturasDeRepeticao;

import java.util.Scanner;

public class NumerosNoIntervalo {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean numerosIguais = true;

		while (numerosIguais) {
			System.out.println("Informe dois numeros: ");
			String valores = input.nextLine();

			String[] numeros = valores.split(" ");

			int numero1 = Integer.parseInt(numeros[0]);
			int numero2 = Integer.parseInt(numeros[1]);

			if (numero1 != numero2) {
				numerosIguais = false;
			}

			if (numero1 < numero2) {
				for (int i = numero1; i <= numero2; i++) {
					System.out.println(i);
				}
			} else if (numero1 > numero2) {
				for (int i = numero2; i <= numero1; i++) {
					System.out.println(i);

				}
			} else {
				System.out.println("Os números são iguais");
			}
		}

		input.close();

	}
}
