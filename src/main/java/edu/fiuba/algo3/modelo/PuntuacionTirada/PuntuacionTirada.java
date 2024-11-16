package edu.fiuba.algo3.modelo.PuntuacionTirada;

public class PuntuacionTirada {

    private int puntuacion;
    private int multiplicador;

    public PuntuacionTirada(int puntuacion, int multiplicador){
        this.puntuacion = puntuacion;
        this.multiplicador = multiplicador;
    }

    public PuntuacionTirada() {
        this.puntuacion = 0;
        this.multiplicador = 0;
    }

    public void sumarPuntos(int puntos){
        this.puntuacion += puntos;
    }

    public void sumarMultiplicador(int multiplicador){
        this.multiplicador += multiplicador;
    }

    public void multiplicarPuntos(int factor){
        this.puntuacion *= factor;
    }

    public void multiplicarMultiplicador(int factor){
        this.multiplicador *= factor;
    }

    public int obtenerPuntuacion(){
        return this.puntuacion*this.multiplicador;
    }
}
