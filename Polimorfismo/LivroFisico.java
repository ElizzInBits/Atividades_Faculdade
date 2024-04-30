package Polimorfismo;

class LivroFisico extends Livro {
    private int quantidadePaginas;

    public LivroFisico(String titulo, String autor, double preco, int quantidadePaginas) {
        super(titulo, autor, preco);
        this.quantidadePaginas = quantidadePaginas;
    }

    public String toString() {
        return super.toString() + "\nTipo: Livro físico" + "\nQuantidade de páginas: " + quantidadePaginas;
    }

    public double calcularDesconto() {
        
        return preco * 0.05; // 5% de desconto para livro físico
    }
}
