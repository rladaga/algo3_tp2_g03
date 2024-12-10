package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Joker.*;
import edu.fiuba.algo3.modelo.ManoDePoker.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.Tarot.TarotManoPoker;


public class EvaluadorMano {
    private final List<ManoDePoker> tiposDeMano;

    public EvaluadorMano() {
        tiposDeMano = new ArrayList<ManoDePoker>();
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

    private void aplicarValorCartas(ArrayList<Carta> mano, PuntuacionTirada puntuacion) {
        for (Carta carta : mano) {
            carta.modificarPuntuacion(puntuacion);
        }
    }

    private void aplicarJokers(ArrayList<Joker> Jokers, ManoDePoker tipo, PuntuacionTirada puntuacion, Descarte descarte) {
        for (Joker joker : Jokers) {
            joker.modificarPuntuacion(puntuacion, tipo, descarte);
        }
    }

    private int calcularPuntuacionTotal(ArrayList<Carta> mano, ManoDePoker tipo, ArrayList<Joker> jokers, Descarte descarte) {

        PuntuacionTirada puntuacion = new PuntuacionTirada(tipo.calcularPuntos(), tipo.calcularMultiplicador());

        aplicarValorCartas(mano, puntuacion);

        aplicarJokers(jokers, tipo, puntuacion, descarte);

        return puntuacion.obtenerPuntuacion();
    }

    public int evaluar(ArrayList<Carta> mano, ArrayList<Joker> jokers, Descarte descarte) {

        for (ManoDePoker tipo : tiposDeMano) {
            if (tipo.esValida(mano)) {
                return calcularPuntuacionTotal(mano, tipo, jokers, descarte);
            }
        }

        return 0;
    }

    public void aplicarMejoraManoDePoker(TarotManoPoker tarotManoPoker) {
        for (ManoDePoker tipo : tiposDeMano) {
            if (tipo.esIgual(tarotManoPoker.manoAAplicar())) {
                tarotManoPoker.aplicarEfecto(tipo);
            }
        }
    }
}
