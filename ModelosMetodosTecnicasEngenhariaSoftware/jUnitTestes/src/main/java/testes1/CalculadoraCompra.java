package testes1;

import java.util.List;

public class CalculadoraCompra {

    private List<Double> itens;
    private double desconto;

    public CalculadoraCompra(List<Double> itens, double desconto) {
        this.itens = itens;
        this.desconto = desconto;
    }

    public CalculadoraCompra(List<Double> itens) {
        this(itens, 0);
    }

    public double calcularTotal() {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("A lista de itens não pode ser vazia.");
        }
        if (desconto < 0) {
            throw new IllegalArgumentException("Desconto inválido: " + desconto);
        }

        double soma = 0;
        for (Double item : itens) {
            if (item < 0) {
                throw new IllegalArgumentException("Preço inválido: " + item);
            }
            soma += item;
        }

        return desconto > 0 ? soma - desconto : soma;
    }
}
