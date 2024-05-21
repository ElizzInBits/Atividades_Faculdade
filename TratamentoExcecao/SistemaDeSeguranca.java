package TratamentoExcecao;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaDeSeguranca {
	private static final Logger logger = Logger.getLogger(SistemaDeSeguranca.class.getName());
	private Set<String> usuariosAutorizados;

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
}
