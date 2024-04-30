package Polimorfismo;

class LivroDigital extends Livro {
	private String formato;

	public LivroDigital(String titulo, String autor, double preco, String formato) {
		super(titulo, autor, preco);
		this.formato = formato;
	}

	public String getTipo() {
		return "Livro digital";
	}

	public String toString() {
		return super.toString() + "\nFormato: " + formato;
	}
}
