/*38- Um funcionário de uma empresa recebe aumento salarial anualmente: Sabe-se que:
Esse funcionário foi contratado em 1995, com salário inicial de R$ 1.000,00;
Em 1996 recebeu aumento de 1,5% sobre seu salário inicial;
A partir de 1997 (inclusive), os aumentos salariais sempre correspondem ao dobro do percentual
 do ano anterior. Faça um programa que determine o salário atual desse funcionário.
  Após concluir isto, altere o programa permitindo que o usuário digite o salário inicial 
  do funcionário. */
  
package EstruturasDeRepeticao;

import java.util.Scanner;

public class CalculoSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o salário inicial do funcionário: ");

        double salarioInicial = scanner.nextDouble();
        int anoContratacao = 1995;
        double salarioAtual = salarioInicial;
        
        for (int ano = 1996; ano <= 2024; ano++) {
            double aumentoPercentual = calcularAumentoPercentual(ano);
            double aumentoSalarial = salarioAtual * (aumentoPercentual / 100);
           
            salarioAtual += aumentoSalarial;
        }
        System.out.println("O salário atual do funcionário em 2024 é: R$ " + salarioAtual);
        scanner.close();
    }
    
    public static double calcularAumentoPercentual(int ano) {
        if (ano == 1996) {
            return 1.5;
        } else {
            return calcularAumentoPercentual(1996) + (ano - 1996) * 2;
        }
    }
}
