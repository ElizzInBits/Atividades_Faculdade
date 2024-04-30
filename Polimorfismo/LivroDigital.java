package Polimorfismo;

class LivroDigital extends Livro {
    private String formato;

    public LivroDigital(String titulo, String autor, double preco, String formato) {
        super(titulo, autor, preco);
        this.formato = formato;
    }

    public String toString() {
        return super.toString() + "\nTipo: Livro digital" + "\nFormato: " + formato;
    }

    public double calcularDesconto() {
        
        return preco * 0.2; // 20% de desconto para livro digital
    }
}
