/*32- Faça um programa que calcule o fatorial de um número inteiro fornecido pelo usuário. 
Ex.: 5!=5.4.3.2.1=120.  */

package EstruturasDeRepeticao;

import java.util.Scanner;

public class CalculoFatorial {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Digite um número para calcular o fatorial: ");
		int numero = input.nextInt();

		int fatorial = 1;
		String detalhesFatorial = numero + "! = ";

		for (int i = numero; i > 0; i--) {
			fatorial *= i;
			detalhesFatorial += i + (i == 1 ? " = " : " . ");
		}

		detalhesFatorial += fatorial;
		System.out.println("Fatorial de: " + numero);
		System.out.println(detalhesFatorial);

		input.close();
	}
}