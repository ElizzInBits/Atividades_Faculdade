/*Supondo que a população de um país A seja da ordem de 80000 habitantes com uma taxa anual de crescimento de 3%
 e que a população de B seja 200000 habitantes com uma taxa de crescimento de 1.5%. 
 Faça um programa que calcule e escreva o número de anos necessários para que a população do país A ultrapasse 
 ou iguale a população do país B, mantidas as taxas de crescimento. */
 
package EstruturasDeRepeticao;

public class CrescimentoCidade {
    public static void main(String[] args) {
		
		double habitantesA = 80000;
		double habitantesB = 200000;
	    int quantidadeAnos = 0;
	
	    do {
	    	
	    	habitantesA += habitantesA * 0.03; 
	    	habitantesB += habitantesB * 0.015; 
	    	
	    	quantidadeAnos += 1;
	    	
	    }while(habitantesA <  habitantesB);
	    
	    System.out.println(quantidadeAnos);
				
	}
}
