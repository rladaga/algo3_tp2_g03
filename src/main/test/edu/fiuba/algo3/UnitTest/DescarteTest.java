package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.Excepcion.DescarteError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DescarteTest {

    @Test
    public void test01SeAplicaCorrectamenteUnDescarte(){
        Descarte descarte = new Descarte(5);
        descarte.permitirDescarte();

        assertEquals(4, descarte.getDescartesRestantes());
    }

    @Test
    public void test02SeAplicanTodosLosDescartesPosibles(){
        Descarte descarte = new Descarte(3);

        descarte.permitirDescarte();
        descarte.permitirDescarte();
        descarte.permitirDescarte();

        assertEquals(0, descarte.getDescartesRestantes());
    }

    @Test
    public void test03SeAplicanTodosLosDescartesPosiblesYCuandoSeQuiereDescartarUnaVezMasLanzaUnaExcepcion(){
        Descarte descarte = new Descarte(3);

        descarte.permitirDescarte();
        descarte.permitirDescarte();
        descarte.permitirDescarte();

        assertThrows(DescarteError.class, descarte::permitirDescarte);
    }

}
