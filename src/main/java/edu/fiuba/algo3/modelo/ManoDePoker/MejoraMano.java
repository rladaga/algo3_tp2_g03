package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.PuntuacionTirada;

public class MejoraMano {

    private int puntuacionAgregada;
    private int multiplicadorAgregado;

    public MejoraMano(){
        this.puntuacionAgregada = 0;
        this.multiplicadorAgregado = 0;
    }

    public void mejorarMano(int unaPuntuacion, int unMultiplicador){
        this.puntuacionAgregada += unaPuntuacion;
        this.multiplicadorAgregado += unMultiplicador;
    }

    public int agregarPuntuacionBase(int unaPuntuacion){
        return this.puntuacionAgregada + unaPuntuacion;
    }


    public int agregarMultiplicadorBase(int unMultiplicador){
        return this.multiplicadorAgregado + unMultiplicador;
    }
}
