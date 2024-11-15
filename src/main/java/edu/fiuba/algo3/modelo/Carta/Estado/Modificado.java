package edu.fiuba.algo3.modelo.Carta.Estado;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public class Modificado implements Estado{

    private final int puntuacion;


    public Modificado(int puntuacion){
        this.puntuacion = puntuacion;
    }
    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, int puntuacionCarta) {
        puntuacionTirada.agregarPuntos(puntuacion);
    }

    @Override
    public int puntosBase(int puntuacionValor) {
        return puntuacion;
    }
}
