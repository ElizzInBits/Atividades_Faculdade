package TioPauloHeranca;

public class Main {
	public static void main(String[] args) {
		Herdeiro filho1 = new Herdeiro("Gabriel Martins", 40, "Casado", "Filho", 0.35);
		Herdeiro filho2 = new Herdeiro("Maria Luísa", 35, "Solteiro", "Filha", 0.35);
		Herdeiro neta1 = new Herdeiro("Maria Eduarda", 25, "Solteira", "Neta", 0.1);
		Herdeiro neta2 = new Herdeiro("Elizabeth", 20, "Solteira", "Neta", 0.1);
		Herdeiro sobrinho = new Herdeiro("Cauan", 30, "Solteiro", "Sobrinho", 0.1);

		Bem casa = new Bem(800000, "Casa", "Ótimo estado");
		Bem carro = new Bem(50000, "Carro", "Bom estado");
		Bem joias = new Bem(200000, "Jóias", "Excelente estado");
		Bem dinheiro = new Bem(1000000, "Dinheiro", "Em mãos");

		Testamento testamento = new Testamento();
		testamento.adicionarBem(casa);
		testamento.adicionarBem(carro);
		testamento.adicionarBem(joias);
		testamento.adicionarBem(dinheiro);
		testamento.adicionarHerdeiro(filho1, 0.35);
		testamento.adicionarHerdeiro(filho2, 0.35);
		testamento.adicionarHerdeiro(neta1, 0.1);
		testamento.adicionarHerdeiro(neta2, 0.1);
		testamento.adicionarHerdeiro(sobrinho, 0.1);

		testamento.calcularHeranca();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("TESTAMENTO DO TIO PAULO");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("Herança de " + filho1.getNome() + ": R$" + filho1.getParteHeranca());
		System.out.println("Herança de " + filho2.getNome() + ": R$" + filho2.getParteHeranca());
		System.out.println("Herança de " + neta1.getNome() + ": R$" + neta1.getParteHeranca());
		System.out.println("Herança de " + neta2.getNome() + ": R$" + neta2.getParteHeranca());
		System.out.println("Herança de " + sobrinho.getNome() + ": R$" + sobrinho.getParteHeranca());

	}
}
