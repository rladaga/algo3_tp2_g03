package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class Ronda{
    private int numeroRonda;
    private Descarte descartes;
    private Mano manos;
    private int puntajeObjetivo;
    private Tienda tienda;

    public Ronda(int numeroRonda, Descarte descartes, Mano manos, int puntajeObjetivo, Tienda tienda){
        this.numeroRonda = numeroRonda;
        this.descartes = descartes;
        this.manos = manos;
        this.puntajeObjetivo = puntajeObjetivo;
        this.tienda = tienda;
    }

    public boolean esPuntajeAlcanzado(PuntuacionTirada puntuacion) {
        return puntuacion.obtenerPuntuacion() < puntajeObjetivo;
    }

    public boolean resolverRonda(Jugador jugador, Descarte descartes, Mano manos) {
        PuntuacionTirada puntuacion = new PuntuacionTirada(0,0);
        while(!esPuntajeAlcanzado(puntuacion) && manos.permitirTirada()){
            //jugador.resolverTurno(this);
            manos.realizarTirada();
        }
        return esPuntajeAlcanzado(puntuacion);
    }


}


