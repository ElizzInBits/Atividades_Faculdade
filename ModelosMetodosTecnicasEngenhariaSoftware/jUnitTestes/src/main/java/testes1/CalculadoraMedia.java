package testes1;

import java.util.List;

public class CalculadoraMedia {

    private List<Double> notas;

    public CalculadoraMedia(List<Double> notas) {
        this.notas = notas;
    }

    public double calcularMedia() {
        if (notas == null || notas.isEmpty()) {
            throw new IllegalArgumentException("A lista de notas não pode ser nula ou vazia.");
        }

        double soma = 0;
        for (Double nota : notas) {
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException("Nota inválida: " + nota);
            }
            soma += nota;

        }
        return soma / notas.size();

    }
}