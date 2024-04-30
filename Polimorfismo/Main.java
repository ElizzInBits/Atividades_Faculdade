package Polimorfismo;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new LivroFisico("O Universo Numa Casca de Noz", "Stephen Hawking", 299.20, 224);
        Livro livro2 = new LivroDigital("O Iluminado", "Stephen King", 90.00, "PDF");

        System.out.println("Detalhes do livro físico:");
        System.out.println(livro1);

        System.out.println("\nDetalhes do livro digital:");
        System.out.println(livro2);
    }
}

