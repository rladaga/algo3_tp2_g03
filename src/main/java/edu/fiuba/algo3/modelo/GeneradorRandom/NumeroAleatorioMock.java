package edu.fiuba.algo3.modelo.GeneradorRandom;

public class NumeroAleatorioMock implements GeneradorRandom {
    private int numeroGenerado;

    public NumeroAleatorioMock(int numeroGenerado) {
        this.numeroGenerado = numeroGenerado;
    }
    @Override
    public boolean validar(){
        return numeroGenerado == 1;
    }
}
