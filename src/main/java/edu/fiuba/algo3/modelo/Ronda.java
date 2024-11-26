package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class Ronda{
    private int cantidadDescartes;
    private int cantidadManos;
    private int puntajeObjetivo;

    public Ronda(int cantidadDescartes, int cantidadManos, int puntajeObjetivo){
        this.cantidadDescartes = cantidadDescartes;
        this.cantidadManos = cantidadManos;
        this.puntajeObjetivo = puntajeObjetivo;
    }

    public boolean esPuntajeAlcanzado(PuntuacionTirada puntuacion) {
        return puntuacion.obtenerPuntuacion() < puntajeObjetivo;
    }

    public boolean resolverRonda(Jugador jugador, Descarte descartes, Mano manos) {
        manos.setearLimiteManos(cantidadManos);
        descartes.setearLimiteDescartes(cantidadDescartes);
        PuntuacionTirada puntuacion = new PuntuacionTirada(0,0);
        while(!esPuntajeAlcanzado(puntuacion) && manos.permitirTirada()){
            //jugador.resolverTurno(this);
            manos.realizarTirada();
        }
        return esPuntajeAlcanzado(puntuacion);
    }


}


