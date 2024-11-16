package edu.fiuba.algo3.modelo.Carta.EstadoCarta;

import edu.fiuba.algo3.modelo.PuntuacionTirada;
import edu.fiuba.algo3.modelo.Carta.ModificadorCarta.ModificadorCarta;

public class CartaModificada implements EstadoCarta {

    private final int puntuacion;
    private ModificadorCarta modificador;


    public CartaModificada(int puntuacion, ModificadorCarta modificador){
        this.puntuacion = puntuacion;
        this.modificador = modificador;
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, int puntuacionCarta) {
        modificador.modificar(puntuacionTirada, puntuacionCarta, puntuacion);
    }

    @Override
    public int puntosBase(int puntuacionValor) {
        return puntuacion;
    }
}
