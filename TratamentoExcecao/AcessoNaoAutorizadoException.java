package TratamentoExcecao;

public class AcessoNaoAutorizadoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AcessoNaoAutorizadoException(String mensagem) {
        super(mensagem);
    }
}
