/*A série de Fibonacci é formada pela seqüência 1,1,2,3,5,8,13,21,34,55,... 
Faça um programa capaz de gerar a série até o n−ésimo termo. */
package EstruturasDeRepeticao;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Para gerear a serie de Fibonacci, digite o valor de n: ");
		int valor = input.nextInt();
		
		int termo1 = 1;
		int termo2 = 1;
		int proximoTermo;
		
		System.out.println("Série de Fibonacci até o "+valor+"º termo:");
		
		
		for (int i = 1; i <= valor; i++) {
            if(i == 1) {
            	System.out.println(termo1 +" ");
                continue;
            }
            if(i == 2) {
            	System.out.println(termo2 +" ");
                continue;
            }
            proximoTermo = termo1 + termo2;
            termo1 = termo2;
            termo1 = proximoTermo;
            System.out.println(proximoTermo +" ");
        }
      input.close(); 
    }
}
