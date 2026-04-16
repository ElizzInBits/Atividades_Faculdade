package dubles;

public class ProcessadorDeCompra {

    private IRegistradora registradora;

    public ProcessadorDeCompra(IRegistradora registradora) {
        this.registradora = registradora;
    }

    public void processar(Cliente cliente, IConta conta, double valor) {
        if (!cliente.isAtivo()) {
            throw new IllegalStateException("Cliente inativo.");
        }
        if (conta.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        conta.debitar(valor);
        registradora.registrar(cliente, valor);
    }
}
