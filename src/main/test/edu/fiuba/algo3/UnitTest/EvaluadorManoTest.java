package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EvaluadorMano;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.Joker.JokerCombinado;
import edu.fiuba.algo3.modelo.Joker.JokerMano;
import edu.fiuba.algo3.modelo.ManoDePoker.Color;
import edu.fiuba.algo3.modelo.ManoDePoker.Poker;
import edu.fiuba.algo3.modelo.Modificador.Multiplicar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluadorManoTest {

    @Test
    public void test01SeEvaluaUnaManoCorrectamenteYSeObtieneElPuntajeEsperado() {
        EvaluadorMano evaluadorMano = new EvaluadorMano();
        ArrayList<Carta> mano = new ArrayList<>();
        ArrayList<Joker> jokers = new ArrayList<>();
        Descarte descarte = new Descarte(3);

        mano.add(new Carta(new Corazon(), new Dos()));
        mano.add(new Carta(new Picas(), new Dos()));
        mano.add(new Carta(new Diamante(), new Dos()));
        mano.add(new Carta(new Trebol(), new Dos()));
        mano.add(new Carta(new Trebol(), new Cuatro()));

        jokers.add(new JokerMano("Comodin", "multiplicador * 3", new ModificarMultiplicador(), new Multiplicar(3), new Poker()));

        int resultado = evaluadorMano.evaluar(mano, jokers, descarte);

        assertEquals(1512, resultado);
    }
}





