package edu.fiuba.algo3.modelo.GeneradorRandom;

public class NumeroAleatorio implements GeneradorRandom {
    private int probabilidad;

    public NumeroAleatorio(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    @Override
    public boolean validar(){
        int numero = (int) (Math.random() * probabilidad) + 1;
        return numero == 1;
    }
}
