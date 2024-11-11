package edu.fiuba.algo3.modelo;

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

    public void agregar(String valorAModificar, int valor){
        if(valorAModificar == "PUNTOS"){
            this.puntuacion += valor;
        }
        else if(valorAModificar == "MULTIPLICADOR"){
            this.multiplicador += valor;
        }
    }

    public void multiplicar(String valorAModificar, int valor){
        if(valorAModificar == "PUNTOS"){
            this.puntuacion *= valor;
        }
        else if(valorAModificar == "MULTIPLICADOR"){
            this.multiplicador *= valor;
        }
    }

    public void agregarPuntos(int puntos){
        puntuacion += puntos;
    }

    public void agregarMultiplicador(int multiplicador){
        puntuacion += multiplicador;
    }

    public void multiplicarPuntos(int factor){
        puntuacion *= factor;
    }

    public void multiplicarMultiplicador(int factor){
        puntuacion *= factor;
    }

    public int obtenerPuntuacion(){
        return puntuacion*multiplicador;
    }
}
