package edu.fiuba.algo3.modelo.PuntuacionTirada;

import edu.fiuba.algo3.modelo.Modificador.Modificador;

public class Puntos {
    private int valorPuntos;

    public Puntos(int puntos) {
        this.valorPuntos = puntos;
    }

    public void modificar(Modificador modificador){
        this.valorPuntos = modificador.modificar(this.valorPuntos);
    }

    public int multiplicarCon(Multiplicador unMultiplicador){
        return unMultiplicador.multiplicarCon(this.valorPuntos);
    }

    public int obtenerPuntos(){
        return this.valorPuntos;
    }
}
