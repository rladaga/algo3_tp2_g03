package edu.fiuba.algo3.modelo.PuntuacionTirada;

import edu.fiuba.algo3.modelo.Modificador.Modificador;

public class Multiplicador {
    private int valorMultiplicador;

    public Multiplicador(int multiplicador) {
        this.valorMultiplicador = multiplicador;
    }

    public void modificar(Modificador modificador) {
        this.valorMultiplicador = modificador.modificar(this.valorMultiplicador);
    }

    public int multiplicarCon(int valorPuntos){
        return this.valorMultiplicador*valorPuntos;
    }

    public int obtenerMultiplicador(){
        return this.valorMultiplicador;
    }
}
