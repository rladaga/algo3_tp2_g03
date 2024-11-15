package edu.fiuba.algo3.modelo.Carta.Estado;

import edu.fiuba.algo3.modelo.PuntuacionTirada;
import edu.fiuba.algo3.modelo.Modificador.Modificador;

public class Modificado implements Estado{

    private final int puntuacion;
    private Modificador modificador;


    public Modificado(int puntuacion, Modificador modificador){
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
