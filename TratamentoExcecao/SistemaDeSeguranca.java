package TratamentoExcecao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SistemaDeSeguranca {
    private static final Logger logger = Logger.getLogger(SistemaDeSeguranca.class.getName());
    private Set<String> usuariosAutorizados;

    static {
        try {
            FileHandler fileHandler = new FileHandler("log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Não foi possível configurar o FileHandler", e);
        }
    }

    public SistemaDeSeguranca() {
        usuariosAutorizados = new HashSet<>();
    }

    public void adicionarUsuarioAutorizado(String usuario) {
        usuariosAutorizados.add(usuario);
    }

    public void removerUsuarioAutorizado(String usuario) {
        usuariosAutorizados.remove(usuario);
    }

    public void tentarAcesso(String usuario) {
        try {
            if (usuariosAutorizados.contains(usuario)) {
                logger.log(Level.INFO, "Acesso permitido para o usuário: {0}", usuario);
            } else {
                throw new AcessoNaoAutorizadoException("Acesso negado para o usuário: " + usuario);
            }
        } catch (AcessoNaoAutorizadoException e) {
            logger.log(Level.WARNING, e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Ocorreu um erro inesperado: {0}", e.getMessage());
        } finally {
            logger.log(Level.INFO, "Tentativa de acesso registrada para o usuário: {0}", usuario);
        }
    }

    public static void exibirLog() {
        try {
            Files.lines(Paths.get("log.txt")).forEach(System.out::println);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Não foi possível ler o arquivo de log", e);
        }
    }
}
