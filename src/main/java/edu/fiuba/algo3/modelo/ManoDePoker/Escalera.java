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

        return esEscalera(indices) || esEscaleraSuperiorConAs(indices);
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

    public boolean esEscaleraSuperiorConAs(ArrayList<Integer> indices) {
        return indices.size() == 5 &&
                indices.contains(1) && // AS
                indices.contains(10) && // 10
                indices.contains(11) && // Jota
                indices.contains(12) && // Reina
                indices.contains(13);  // Rey
    }


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
