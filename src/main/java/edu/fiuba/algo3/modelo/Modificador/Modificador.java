package edu.fiuba.algo3.modelo.Modificador;

public abstract class Modificador {
    protected float valorModificacion;

    public Modificador(float valorModificacion) {
        this.valorModificacion = valorModificacion;
    }

    public abstract int modificar(int puntos);
}
