/*11 - Altere o programa anterior para mostrar no final a soma dos números. */
package EstruturasDeRepeticao;

import java.util.Scanner;

public class NumerosNoIntervaloSoma {
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

				int soma = 0;

				if (numero1 < numero2) {
					for (int i = numero1; i <= numero2; i++) {
						System.out.println(i);
						soma += i;

					}
				} else if (numero1 > numero2) {
					for (int i = numero2; i <= numero1; i++) {
						System.out.println(i);
						soma += i;

					}
				}
				System.out.println("A soma dos números é: " + soma);
			} else {
				System.out.println("Os números são iguais");

			}

		}

		input.close();

	}
}
