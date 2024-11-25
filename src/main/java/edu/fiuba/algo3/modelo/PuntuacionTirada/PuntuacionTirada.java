package edu.fiuba.algo3.modelo.PuntuacionTirada;

import edu.fiuba.algo3.modelo.Modificador.*;

public class PuntuacionTirada {

    private Puntos puntos;
    private Multiplicador multiplicador;

    public PuntuacionTirada(int puntuacion, int multiplicador){
        this.puntos = new Puntos(puntuacion);
        this.multiplicador = new Multiplicador(multiplicador);
    }

    public void modificarPuntos(Modificador modificador) {
        this.puntos.modificar(modificador);
    }

    public void modificarMultiplicador(Modificador modificador) {
        this.multiplicador.modificar(modificador);
    }

    public int obtenerPuntuacion(){
        return this.puntos.multiplicarCon(this.multiplicador);
    }

    public int obtenerMultiplicador(){
        return this.multiplicador.obtenerMultiplicador();
    }

    public int obtenerPuntos() {
        return this.puntos.obtenerPuntos();
    }
}
