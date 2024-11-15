package edu.fiuba.algo3.modelo.Tarot;
import edu.fiuba.algo3.modelo.Carta.Carta;

public class TarotCambiarPuntos extends Tarot {
    private int puntos;

    public TarotCambiarPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public void aplicarEfecto(Carta carta){
        carta.aplicarTarot(puntos);
    }
}
