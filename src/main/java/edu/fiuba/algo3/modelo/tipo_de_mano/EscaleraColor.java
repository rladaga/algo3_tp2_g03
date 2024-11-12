package edu.fiuba.algo3.modelo.tipo_de_mano;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class EscaleraColor implements TipoDeMano {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return new Escalera().esValida(mano) && new Color().esValida(mano);
    }

    @Override
    public int calcularPuntos() {
        return 100;
    }

    @Override
    public int calcularMultiplicador() {
        return 8;
    }

    @Override
    public TipoDeManoModificada aplicarMultiplicador(int multiplicador){
        TipoDeManoModificada tipoDeMano = new TipoDeManoModificada(this, multiplicador);
        return tipoDeMano;
    }

}