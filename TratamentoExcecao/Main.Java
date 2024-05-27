package TratamentoExcecao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeSeguranca sistema = new SistemaDeSeguranca();
        sistema.adicionarUsuarioAutorizado("Elizabeth");
        sistema.adicionarUsuarioAutorizado("Montanha");
        sistema.adicionarUsuarioAutorizado("Gabriel Martins");
        sistema.adicionarUsuarioAutorizado("Tamires");
        sistema.adicionarUsuarioAutorizado("Cauan");
        sistema.adicionarUsuarioAutorizado("André");
        
        

        Scanner scanner = new Scanner(System.in);
        String usuario;

        System.out.println("Digite o nome do usuário para tentar acesso ou 'sair' para encerrar:");

        while (true) {
            System.out.print("Nome do usuário: ");
            usuario = scanner.nextLine();

            if (usuario.equalsIgnoreCase("sair")) {
                break;
            }

            sistema.tentarAcesso(usuario);
        }

        scanner.close();

        
        SistemaDeSeguranca.exibirLog();
    }
}
