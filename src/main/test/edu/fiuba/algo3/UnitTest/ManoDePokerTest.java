package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.ManoDePoker.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManoDePokerTest {
    @Test
    public void test01ManoDePokerSeComparaCorrectamentePorVerdedaro(){
        ManoDePoker manoDePoker = new FullHouse();
        ManoDePoker manoDePoker2 = new FullHouse();

        boolean resultado = manoDePoker.esIgual(manoDePoker2);

        assertEquals(true, resultado);
    }

    @Test
    public void test02ManoDePokerSeComparaCorrectamentePorFalso(){
        ManoDePoker manoDePoker = new FullHouse();
        ManoDePoker manoDePoker2 = new Par();

        boolean resultado = manoDePoker.esIgual(manoDePoker2);

        assertEquals(false, resultado);
    }
}
