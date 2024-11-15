package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;
import java.util.Collections;

public class Escalera extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        // Crear una lista con los índices de las cartas
        ArrayList<Integer> indices = new ArrayList<>();
        for (Carta carta : mano) {
            // Usar el nombre de la carta para obtener el índice en el enum
            int indice = carta.obtenerIndice();
            if (indice != -1) {
                indices.add(indice);
            }
        }
        // Ordenar los índices en orden ascendente
        Collections.sort(indices);

        return esEscalera(indices);
    }

    private boolean esEscalera(ArrayList<Integer> indices) {

        // Comparamos cada par de números adyacentes
        for (int i = 0; i < indices.size() - 1; i++) {
            if (indices.get(i + 1) - indices.get(i) != 1) {
                return false;
            }
        }
        return true;
    }
/*
    private boolean esEscaleraConAs(ArrayList<Integer> indices) {
        // Verifica si contiene exactamente [0,1,2,3,12] (2,3,4,5,A)
        return indices.size() == 5 &&
                indices.contains(0) && // 2
                indices.contains(1) && // 3
                indices.contains(2) && // 4
                indices.contains(3) && // 5
                indices.contains(12);  // As
    }
*/

    @Override
    public int calcularPuntos() {
        return 30;
    }

    @Override
    public int calcularMultiplicador() {
        return 4;
    }

    @Override
    public ManoDePokerModificada aplicarMultiplicador(int multiplicador){
        ManoDePokerModificada tipoDeMano = new ManoDePokerModificada(this, multiplicador);
        return tipoDeMano;
    }
}
