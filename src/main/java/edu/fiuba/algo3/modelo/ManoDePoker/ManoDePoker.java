package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public abstract class ManoDePoker {
    protected MejoraMano mejoraMano;

    public abstract boolean esValida(ArrayList<Carta> mano);
    public abstract int calcularPuntos();
    public abstract int calcularMultiplicador();


    protected int cuentaRepeticiones(ArrayList<Carta> mano, int repeticionesDeseadas) {
        int gruposEncontrados = 0;
        for (Carta carta : mano) {
            int cartaRepetida = 0;

            for (Carta otraCarta : mano) { 
                if (carta.compararValor(otraCarta)) { 
                    cartaRepetida++; 
                }
            }

            if (cartaRepetida == repeticionesDeseadas) {
                gruposEncontrados++;
            }
        }
        
        return gruposEncontrados / repeticionesDeseadas;
    }

    public abstract boolean esIgual(ManoDePoker mano);

    public void agregarMejora(int puntuacion, int multiplicador) {
        mejoraMano.mejorarMano(puntuacion, multiplicador);
    }
}