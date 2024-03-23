/*Desenvolva um gerador de tabuada, capaz de gerar a tabuada de qualquer número inteiro entre 1 a 10.
 O usuário deve informar de qual numero ele deseja ver a tabuada. */
package EstruturasDeRepeticao;

import java.util.Scanner;

public class TabuadaDeUmNumero {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe um número para saber a sua tabuada: ");
		int numero = input.nextInt();
		
		System.out.println("A tabuada do número " + numero + " é: ");
		for(int i = 1; i <= 10; i++) {

			int calculo = i * numero;			
			System.out.println(i + " X " + numero + " = " + calculo);
			
		}
		input.close();
	}

}
