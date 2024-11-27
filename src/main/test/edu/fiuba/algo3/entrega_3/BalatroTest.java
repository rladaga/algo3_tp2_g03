package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.parser.ParserBalatro;
import edu.fiuba.algo3.modelo.parser.ParserJoker;
import edu.fiuba.algo3.modelo.parser.ParserMazo;
import edu.fiuba.algo3.modelo.parser.ParserTarot;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalatroTest {

    @Test
    public void test01ParserTarot() throws FileNotFoundException {

        ParserTarot parserTarot = new ParserTarot();

        ArrayList<Tarot> arrayList = parserTarot.parse();

        assertEquals(15, arrayList.size());
    }

    @Test
    public void test02ParserMazo() throws FileNotFoundException {
        ParserMazo parserMazo = new ParserMazo();

        Mazo mazo = parserMazo.parse();

        assertEquals(52, mazo.cantidadCartas());
    }

    @Test
    public void test03ParserJokers() throws FileNotFoundException {
        ParserJoker parserJokers = new ParserJoker();

        ArrayList<Joker> jokers = parserJokers.parse();

        assertEquals(33, jokers.size());
    }

    @Test
    public void test04ParserBalatroDevueleveLasRondas() throws FileNotFoundException {
        ParserBalatro parserBalatro = new ParserBalatro();

        ArrayList<Ronda> rondas = parserBalatro.parsearRondas();

        assertEquals(8, rondas.size());
    }

    @Test
    public void test05ParserBalatroDevuelveElMazo() throws FileNotFoundException {
        ParserBalatro parserBalatro = new ParserBalatro();

        ArrayList<Carta> cartas = parserBalatro.parsearMazo();

        assertEquals(52, cartas.size());
    }


}