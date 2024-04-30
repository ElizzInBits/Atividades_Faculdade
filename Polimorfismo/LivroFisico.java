package Polimorfismo;

class LivroFisico extends Livro {
	private int quantidadePaginas;

	public LivroFisico(String titulo, String autor, double preco, int quantidadePaginas) {
		super(titulo, autor, preco);
		this.quantidadePaginas = quantidadePaginas;
	}

	public String getTipo() {
		return "Livro físico";
	}

	public String toString() {
		return super.toString() + "\nQuantidade de páginas: " + quantidadePaginas;
	}
}
