package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.parser.ParserMazo;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazoTest {
    @Test
    public void test01SeCreaUnMazoCorrectamente() throws FileNotFoundException {
        ParserMazo parser = new ParserMazo();
        Mazo mazo = parser.parse();

        assertEquals(52, mazo.cantidadCartas());
    }

    @Test
    public void test02SeAgregaUnaCartaAlMazoCorrectamente() throws FileNotFoundException {
        ParserMazo parser = new ParserMazo();
        Mazo mazo = parser.parse();

        mazo.agregarCartaAlMazo(new Carta(new Diamante(), new Siete()));

        assertEquals(53, mazo.cantidadCartas());
    }

    @Test
    public void test03SeAgreganVariasCartaAlMazoCorrectamente() throws FileNotFoundException {
        ParserMazo parser = new ParserMazo();
        Mazo mazo = parser.parse();

        mazo.agregarCartaAlMazo(new Carta(new Diamante(), new Siete()));
        mazo.agregarCartaAlMazo(new Carta(new Picas(), new As()));
        mazo.agregarCartaAlMazo(new Carta(new Trebol(), new Ocho()));
        mazo.agregarCartaAlMazo(new Carta(new Corazon(), new Rey()));

        assertEquals(56, mazo.cantidadCartas());
    }

}
