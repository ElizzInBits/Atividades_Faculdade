package animais;

import voos.VooLongo;

public class Gaviao extends Ave {

    public Gaviao() {
        super(new VooLongo());
    }

    @Override
    public void emitirSom() {
        System.out.println("O gavião faz um som.");
    }

}