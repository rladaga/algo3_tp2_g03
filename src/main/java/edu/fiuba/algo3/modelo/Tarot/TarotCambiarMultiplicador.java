package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.tipo_de_mano.TipoDeMano;
import edu.fiuba.algo3.modelo.tipo_de_mano.TipoDeManoModificada;

public class TarotCambiarMultiplicador extends Tarot {
    private int multiplicador;

    public TarotCambiarMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public TipoDeMano aplicarEfecto(TipoDeMano tipoDeMano){
        return tipoDeMano.aplicarMultiplicador(multiplicador);
    }
}
