/*Altere o programa anterior permitindo ao usuário informar as populações e as taxas de crescimento iniciais.
 Valide a entrada e permita repetir a operação. */
package EstruturasDeRepeticao; 

import java.util.Scanner;

public class CrescimentoCidade2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double habitantesA = 80000;
		double habitantesB = 200000;
		int quantidadeAnos = 0;

		System.out.println("Informe a quantidade de habitantes da cidade A: ");
		habitantesA = input.nextDouble();
		System.out.println("Agora informe o percentual de crescimento da cidade A: ");
		double percentualA = input.nextInt();

		System.out.println("Informe a quantidade de habitantes da cidade B: ");
		habitantesB = input.nextDouble();
		System.out.println("Agora informe o percentual de crescimento da cidade B: ");
		double percentualB = input.nextInt();

		if (habitantesA > habitantesB) {
			System.out.println("A populção A já é maior que a população B");
		} else {
			while (habitantesA <= habitantesB)
				;

			habitantesA += habitantesA * (percentualA / 100);
			habitantesB += habitantesB * (percentualB / 100);

			quantidadeAnos++;

			System.out.println("Serão necessários " + quantidadeAnos +
					" Até que a populçao A ultrapasse a pupulação B");

		}

		input.close();
	}
}