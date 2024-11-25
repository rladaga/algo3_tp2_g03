package edu.fiuba.algo3.modelo.Carta.Valor;

public abstract class Valor {
    private int puntosBase;

    public Valor(int puntosBase) {
        this.puntosBase = puntosBase;
    }

    public int puntosBase() {
        return puntosBase;
    }

    public abstract int numeracion();

    public boolean compararCon(Valor unValor) {
        return this.equals(unValor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Valor unValor = (Valor) obj;
        return Double.compare(this.numeracion(), unValor.numeracion()) == 0;
    }

}
