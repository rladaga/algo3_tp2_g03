package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public class EscaleraReal extends ManoDePoker {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return esColor(mano) && esEscaleraReal(mano);
    }

    @Override
    public int calcularPuntos() {
        return 100;
    }

    @Override
    public int calcularMultiplicador() {
        return 8;
    }

    private boolean esColor(ArrayList<Carta> mano) {
        return new Color().esValida(mano);
    }

    private boolean esEscaleraReal(ArrayList<Carta> mano) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (Carta carta : mano) {
            indices.add(carta.obtenerIndice());
        }
        return indices.contains(1) && indices.contains(10) && indices.contains(11) && indices.contains(12) && indices.contains(13);  // Inicia en 10(ordinal 8) para ser Escalera Real
    }

    @Override
    public ManoDePokerModificada aplicarMultiplicador(int multiplicador){
        ManoDePokerModificada tipoDeMano = new ManoDePokerModificada(this, multiplicador);
        return tipoDeMano;
    }
}
