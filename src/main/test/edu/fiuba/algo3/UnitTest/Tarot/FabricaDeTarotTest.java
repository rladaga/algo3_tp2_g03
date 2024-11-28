package edu.fiuba.algo3.UnitTest.Tarot;

import edu.fiuba.algo3.modelo.Tarot.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricaDeTarotTest {
    @Test
    public void test01FabricaDeTarotPuedeCrearTarotCarta(){
        TarotODT tarotODT = new TarotODT("TarotCarta", "x4 multiplicador", 1, 4, "carta", "cualquiera");

        Tarot tarotCarta = FabricaDeTarot.crearTarot(tarotODT);

        assertEquals(TarotCarta.class, tarotCarta.getClass());
    }

    @Test
    public void test02FabricaDeTarotPuedeCrearTarotMano(){
        TarotODT tarotODT = new TarotODT("TarotMano", "+10 puntos y +2 multiplicador", 10, 2, "mano", "Poker");

        Tarot tarotMano = FabricaDeTarot.crearTarot(tarotODT);

        assertEquals(TarotManoPoker.class, tarotMano.getClass());
    }
}
