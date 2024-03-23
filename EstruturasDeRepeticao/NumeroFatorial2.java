package EstruturasDeRepeticao;

import java.util.Scanner;

public class NumeroFatorial2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("Entre com um número para calcular o fatorial (limite: 0 a 15):");
			int numero = input.nextInt();

			if (numero >= 0 && numero <= 15) {
				int fatorial = 1;

				for (int i = 2; i <= numero; i++) {
					fatorial *= i;
				}

				System.out.println(numero + "! = " + fatorial);
			} else {
				System.out.println("O número deve ser um inteiro positivo e menor que 16. Por favor, tente novamente.");
				continue;
			}

			System.out.println("Deseja calcular o fatorial de outro número? (s/n)");
			char resposta = input.next().charAt(0);

			if (resposta != 's' && resposta != 'S') {
				break;
			}
		}

		input.close();
	}
}