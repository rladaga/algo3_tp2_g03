package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public abstract class ManoDePoker {
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

    public abstract ManoDePoker aplicarMultiplicador(int multiplicador);
    public abstract boolean esIgual(ManoDePoker mano);
}