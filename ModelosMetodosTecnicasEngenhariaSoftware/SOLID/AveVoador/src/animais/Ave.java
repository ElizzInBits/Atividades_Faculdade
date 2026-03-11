package animais;

import voos.Voador;

public abstract class Ave implements Animal{

    protected Voador tipoVoo;

    public Ave(Voador tipoVoo) {
        this.tipoVoo = tipoVoo;

    }

    public void voar() {
        tipoVoo.voar();
    }

}