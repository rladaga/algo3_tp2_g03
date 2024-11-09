package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

enum Manos {
    CARTA_ALTA(5, 1),
    PAR(10, 2),
    DOBLE_PAR(20, 2),
    TRIO(30, 3),
    ESCALERA(30, 4),
    COLOR(35, 4),
    FULL_HOUSE(40, 4),
    POKER(60, 7),
    ESCALERA_COLOR(100, 8),
    ESCALERA_REAL(100, 8);

    private final int puntos;
    private final int multiplicador;

    Manos(int puntos, int multiplicador) {
        this.puntos = puntos;
        this.multiplicador = multiplicador;
    }

    public int puntuacion() {
        return puntos;
    }

    public int multiplicador() {
        return multiplicador;
    }

}


public class EvaluadorMano {

    public EvaluadorMano(){};

    public int evaluar(ArrayList<Carta> mano){
        int valorBase = 0;

       for (Carta carta : mano) {
           valorBase += carta.obtenerPuntuacion();
       }



       return valorBase;
    }


}






