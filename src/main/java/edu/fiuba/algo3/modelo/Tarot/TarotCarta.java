package edu.fiuba.algo3.modelo.Tarot;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Modificador.Modificador;

public class TarotCarta extends Tarot {
    private int puntos;
    private Modificador modificador;

    public TarotCarta(int puntos, Modificador modificador) {
        this.puntos = puntos;
        this.modificador = modificador;
    }

    @Override
    public void aplicarEfecto(Carta carta){
        carta.aplicarTarot(puntos, modificador);
    }
}
