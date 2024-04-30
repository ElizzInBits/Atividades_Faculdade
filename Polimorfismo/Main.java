package Polimorfismo;

public class Main {
    public static void main(String[] args) {
        Livro livro1Fisico = new LivroFisico("O Universo Numa Casca de Noz", "Stephen Hawking", 250.00, 224);
        Livro livro1PDF = new LivroDigital("O Universo Numa Casca de Noz", "Stephen Hawking", 150.00, "PDF");

        Livro livro2Fisico = new LivroFisico("O Iluminado", "Stephen King", 70.00, 224);
        Livro livro2PDF = new LivroDigital("O Iluminado", "Stephen King", 60.00, "PDF");

        System.out.println("Detalhes do livro físico 1:");
        System.out.println(livro1Fisico);
        System.out.println("Desconto: R$" + livro1Fisico.calcularDesconto());
        System.out.println("Preço final: R$" + (livro1Fisico.getPreco() - livro1Fisico.calcularDesconto()));

        System.out.println("\nDetalhes do livro PDF 1:");
        System.out.println(livro1PDF);
        System.out.println("Desconto: R$" + livro1PDF.calcularDesconto());
        System.out.println("Preço final: R$" + (livro1PDF.getPreco() - livro1PDF.calcularDesconto()));

        System.out.println("\nDetalhes do livro físico 2:");
        System.out.println(livro2Fisico);
        System.out.println("Desconto: R$" + livro2Fisico.calcularDesconto());
        System.out.println("Preço final: R$" + (livro2Fisico.getPreco() - livro2Fisico.calcularDesconto()));

        System.out.println("\nDetalhes do livro PDF 2:");
        System.out.println(livro2PDF);
        System.out.println("Desconto: R$" + livro2PDF.calcularDesconto());
        System.out.println("Preço final: R$" + (livro2PDF.getPreco() - livro2PDF.calcularDesconto()));
    }
}