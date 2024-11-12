package edu.fiuba.algo3.modelo.tipo_de_mano;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public interface TipoDeMano {
    boolean esValida(ArrayList<Carta> mano);
    int calcularPuntos();
    int calcularMultiplicador();


    default int cuentaRepeticiones(ArrayList<Carta> mano, int repeticionesDeseadas) {
        int contador = 0; // Contador para los grupos encontrados
        for (Carta carta : mano) { // Itera sobre cada carta en la mano
            int ocurrencias = 0; // Contador para las repeticiones de una carta específica
            for (Carta otraCarta : mano) { // Compara la carta actual con cada otra carta en la mano
                if (carta.getValor().equals(otraCarta.getValor())) { // Si el valor de las cartas es igual
                    ocurrencias++; // Se incrementa el contador de repeticiones
                }
            }
            if (ocurrencias == repeticionesDeseadas) { // Si se encuentra la cantidad deseada de repeticiones
                contador++; // Incrementa el contador de grupos encontrados
            }
        }
        return contador / repeticionesDeseadas;  // Ajuste para contar solo los grupos únicos
    }

    TipoDeMano aplicarMultiplicador(int multiplicador);
}