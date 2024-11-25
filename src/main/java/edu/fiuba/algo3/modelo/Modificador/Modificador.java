package edu.fiuba.algo3.modelo.Modificador;

public abstract class Modificador {
    protected int valorModificacion;

    public Modificador(int valorModificacion) {
        this.valorModificacion = valorModificacion;
    }

    public abstract int modificar(int puntos);
}
