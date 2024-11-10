package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import edu.fiuba.algo3.modelo.tipo_de_mano.*;


public class EvaluadorMano {
    private final List<TipoDeMano> tiposDeMano;

    public EvaluadorMano() {
        tiposDeMano = new ArrayList<TipoDeMano>();
        tiposDeMano.add(new EscaleraReal());
        tiposDeMano.add(new EscaleraColor());
        tiposDeMano.add(new Poker());
        tiposDeMano.add(new FullHouse());
        tiposDeMano.add(new Color());
        tiposDeMano.add(new Escalera());
        tiposDeMano.add(new Trio());
        tiposDeMano.add(new DoblePar());
        tiposDeMano.add(new Par());
        tiposDeMano.add(new CartaAlta());
    }

    private int calcularValorCartas(ArrayList<Carta> mano) {
        int valorBase = 0;

        for (Carta carta : mano) {
            valorBase += carta.obtenerPuntuacion();
        }

        return valorBase;
    }

    private int calcularPuntuacionTotal(int valorBase, TipoDeMano tipo) {
        int puntosPorMano = tipo.calcularPuntos();
        int multiplicador = tipo.calcularMultiplicador();
        return (valorBase + puntosPorMano) * multiplicador;
    }

    public int evaluar(ArrayList<Carta> mano) {

        int valorBase = calcularValorCartas(mano);

        for (TipoDeMano tipo : tiposDeMano) {
            if (tipo.esValida(mano)) {
                return calcularPuntuacionTotal(valorBase, tipo);
            }
        }
        return 0;
    }
}







