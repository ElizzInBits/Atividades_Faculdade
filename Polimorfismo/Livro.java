package Polimorfismo;

abstract class Livro {
    protected String titulo;
    protected String autor;
    protected double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public abstract double calcularDesconto();
  
    public double getPreco() {
        return preco;
    }

    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nPreço: R$" + preco;
    }
}