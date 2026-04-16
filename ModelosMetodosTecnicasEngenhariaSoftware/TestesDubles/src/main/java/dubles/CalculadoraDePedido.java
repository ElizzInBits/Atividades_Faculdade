package dubles;

public class CalculadoraDePedido {

    private IMotorDesconto motorDesconto;

    public CalculadoraDePedido(IMotorDesconto motorDesconto) {
        this.motorDesconto = motorDesconto;
    }

    public double calcularValorFinal(IPedido pedido) {
        double valorBruto = pedido.getValorBruto();
        double percentualDesconto = motorDesconto.calcularDesconto(pedido);
        return valorBruto - (valorBruto * percentualDesconto);
    }
}
