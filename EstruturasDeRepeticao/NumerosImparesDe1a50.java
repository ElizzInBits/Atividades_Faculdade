/*9- Faça um programa que imprima na tela apenas os números ímpares entre 1 e 50.*/
package EstruturasDeRepeticao;

public class NumerosImparesDe1a50 {
	public static void main(String[] args) {

		int i, numeroImpar;

		for (i = 1; i <= 50; i++) {

			if (i % 2 == 1) {
				numeroImpar = i;

				System.out.println(numeroImpar);
			}

		}
	}
}