package animais;

import voos.VooLongo;

public class Falcao extends Ave {

    public Falcao() {
        super(new VooLongo());
    }

    @Override
    public void emitirSom() {
        System.out.println("O falcao grita alto");
    }
}