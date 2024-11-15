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

    //TODO: arreglar esto (volarlo)
    public void agregar(String valorAModificar, int valor){
        if(valorAModificar == "PUNTOS"){
            this.puntuacion += valor;
        }
        else if(valorAModificar == "MULTIPLICADOR"){
            this.multiplicador += valor;
        }
    }
    //TODO: arreglar esto (volarlo)
    public void multiplicar(String valorAModificar, int valor) {
        if (valorAModificar == "PUNTOS") {
            this.puntuacion *= valor;
        } else if (valorAModificar == "MULTIPLICADOR") {
            this.multiplicador *= valor;
        }
    }

    public void agregarPuntos(int puntos){
        this.puntuacion += puntos;
    }

    public void agregarMultiplicador(int multiplicador){
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
