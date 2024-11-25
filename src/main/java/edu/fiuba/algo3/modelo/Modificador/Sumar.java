package edu.fiuba.algo3.modelo.Modificador;

public class Sumar extends Modificador {
    public Sumar(int valorModificacion) {
        super(valorModificacion);
    }

    @Override
    public int modificar(int valor) {
        return valor + valorModificacion;
    }
}
