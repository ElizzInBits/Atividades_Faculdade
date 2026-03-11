package animais;

import voos.VooCurto;

public class Galinha extends Ave {

    public Galinha() {
        super(new VooCurto());
    }

    @Override
    public void emitirSom() {
        System.out.println("Cócóricó!");
    }

}