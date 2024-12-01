package edu.fiuba.algo3.UnitTest.Carta;

import edu.fiuba.algo3.modelo.Carta.Palo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaloTest {
    @Test
    public void test01PaloSeComparaConOtroPorTrue(){
        Palo corazon = new Corazon();
        Palo corazon2 = new Corazon();

        boolean resultado = corazon.compararCon(corazon2);

        assertEquals(true, resultado);
    }

    @Test
    public void test02PaloSeComparaConOtroPorFalse(){
        Palo corazon = new Corazon();
        Palo trebol = new Trebol();

        boolean resultado = corazon.compararCon(trebol);

        assertEquals(false, resultado);
    }
}
