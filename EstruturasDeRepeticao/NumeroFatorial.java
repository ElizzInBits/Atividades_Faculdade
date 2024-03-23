/*13- Faça um programa que calcule o fatorial de um número inteiro fornecido pelo usuário. Ex.: 5!=5.4.3.2.1=120 */
package EstruturasDeRepeticao;

import java.util.Scanner;

public class NumeroFatorial {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("Entre com um número para calcular o fatorial:");
		int numero = input.nextInt();
		
		
		int fatorial = 1;
		
		for(int i = 2 ; i <= numero; i++) {
			fatorial *= i;
			
			System.out.println(numero + "! = " +fatorial) ;
		}

		input.close();
	}
	
}
