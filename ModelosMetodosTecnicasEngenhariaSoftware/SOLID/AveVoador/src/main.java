import animais.*;

public class main {

    public static void main(String[] args) {

        System.out.println("=== Águia ===");
        Ave aguia = new Aguia();
        aguia.voar();
        aguia.emitirSom();

        System.out.println("\n=== Galinha ===");
        Ave galinha = new Galinha();
        galinha.voar();
        galinha.emitirSom();

        System.out.println("\n=== Avestruz ===");
        Ave avestruz = new Avestruz();
        avestruz.voar();
        avestruz.emitirSom();

        System.out.println("\n=== Falcão ===");
        Ave falcao = new Falcao();
        falcao.voar();
        falcao.emitirSom();

        System.out.println("\n=== Gavião ===");
        Ave gaviao = new Gaviao();
        gaviao.voar();
        gaviao.emitirSom();

    }

}