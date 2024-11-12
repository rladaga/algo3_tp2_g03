package edu.fiuba.algo3.modelo.tipo_de_mano;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.Collections;

public class EscaleraReal implements TipoDeMano {
    @Override
    public boolean esValida(ArrayList<Carta> mano) {
        return esEscaleraColor(mano) && esEscaleraReal(mano);
    }

    @Override
    public int calcularPuntos() {
        return 100;
    }

    @Override
    public int calcularMultiplicador() {
        return 8;
    }

    private boolean esEscaleraColor(ArrayList<Carta> mano) {
        return new EscaleraColor().esValida(mano);
    }

    private boolean esEscaleraReal(ArrayList<Carta> mano) {
        ArrayList<Integer> valoresOrdenados = new ArrayList<>();
        for (Carta carta : mano) {
            valoresOrdenados.add(carta.getValor().getPuntoBase());
        }
        Collections.sort(valoresOrdenados);
        return valoresOrdenados.get(0) == 8;  // Inicia en 10(ordinal 8) para ser Escalera Real
    }

    @Override
    public TipoDeManoModificada aplicarMultiplicador(int multiplicador){
        TipoDeManoModificada tipoDeMano = new TipoDeManoModificada(this, multiplicador);
        return tipoDeMano;
    }
}
