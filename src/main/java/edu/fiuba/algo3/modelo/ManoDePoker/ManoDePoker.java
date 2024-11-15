package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public abstract class ManoDePoker {
    public abstract boolean esValida(ArrayList<Carta> mano);
    public abstract int calcularPuntos();
    public abstract int calcularMultiplicador();


    protected int cuentaRepeticiones(ArrayList<Carta> mano, int repeticionesDeseadas) {
        int contador = 0; // Contador para los grupos encontrados
        for (Carta carta : mano) { // Itera sobre cada carta en la mano
            int ocurrencias = 0; // Contador para las repeticiones de una carta específica
            for (Carta otraCarta : mano) { // Compara la carta actual con cada otra carta en la mano
                if (carta.compararValor(otraCarta)) { // Si el valor de las cartas es igual
                    ocurrencias++; // Se incrementa el contador de repeticiones
                }
            }
            if (ocurrencias == repeticionesDeseadas) { // Si se encuentra la cantidad deseada de repeticiones
                contador++; // Incrementa el contador de grupos encontrados
            }
        }
        return contador / repeticionesDeseadas;  // Ajuste para contar solo los grupos únicos
    }

    public abstract ManoDePoker aplicarMultiplicador(int multiplicador);
}