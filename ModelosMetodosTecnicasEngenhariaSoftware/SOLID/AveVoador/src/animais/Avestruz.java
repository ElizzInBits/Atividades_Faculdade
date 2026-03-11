package animais;

import voos.VooCurto;

public class Avestruz extends Ave {

    public Avestruz() {
        super(new VooCurto());
    }

    @Override
    public void emitirSom() {
        System.out.println("O avestruz emite algum som.");
    }

}