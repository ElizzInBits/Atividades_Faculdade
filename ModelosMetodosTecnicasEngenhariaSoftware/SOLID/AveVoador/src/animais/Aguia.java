package animais;

import voos.VooAguiaCareca;

public class Aguia extends Ave {

    public Aguia() {
        super(new VooAguiaCareca());
    }

    @Override
    public void emitirSom() {
        System.out.println("A aguia faz algum tipo de som");
    }
}

;