package edu.fiuba.algo3.modelo.Modificador;

public class Multiplicar extends Modificador {

    public Multiplicar(int valorModificacion) {
        super(valorModificacion);
    }

    @Override
    public int modificar(int puntos) {
        return this.valorModificacion * puntos;
    }
}
