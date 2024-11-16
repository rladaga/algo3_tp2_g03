package edu.fiuba.algo3.modelo.Tarot;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.EstrategiaModificacion;

public class TarotCarta extends Tarot {
    private int puntos;
    private EstrategiaModificacion modificador;

    public TarotCarta(int puntos, EstrategiaModificacion modificador) {
        this.puntos = puntos;
        this.modificador = modificador;
    }

    @Override
    public void aplicarEfecto(Carta carta){
        carta.aplicarTarot(puntos, modificador);
    }
}
