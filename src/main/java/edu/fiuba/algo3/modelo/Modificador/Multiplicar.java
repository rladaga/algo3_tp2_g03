package edu.fiuba.algo3.modelo.Modificador;

public class Multiplicar extends Modificador {

    public Multiplicar(float valorModificacion) {
        super(valorModificacion);
    }

    @Override
    public int modificar(int puntos) {
        return (int)(this.valorModificacion * (float) puntos);
    }
}
