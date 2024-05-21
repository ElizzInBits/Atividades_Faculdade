package TratamentoExcecao;

public class Main {
	public static void main(String[] args) {
		SistemaDeSeguranca sistema = new SistemaDeSeguranca();
		sistema.adicionarUsuarioAutorizado("Tamires");
		sistema.adicionarUsuarioAutorizado("Montanha");

		sistema.tentarAcesso("Tamires"); // Acesso permitido
		sistema.tentarAcesso("Gabriel Martins"); // Acesso negado
		sistema.tentarAcesso("Montanha"); // Acesso permitido
	}
}
