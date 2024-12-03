package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Excepcion.ManoError;
import edu.fiuba.algo3.modelo.Mano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManoTest {

    @Test
    public void test01SeAplicaCorrectamenteUnaMano(){
        Mano mano = new Mano(5);
        mano.permitirTirada();

        assertEquals(4, mano.getManosRestantes());
    }

    @Test
    public void test02SeAplicanTodasLasManosPosibles(){
        Mano mano = new Mano(3);

        mano.permitirTirada();
        mano.permitirTirada();
        mano.permitirTirada();


        assertEquals(0, mano.getManosRestantes());
    }

    @Test
    public void test03SeAplicanTodosLosDescartesPosiblesYCuandoSeQuiereDescartarUnaVezMasLanzaUnaExcepcion(){
        Mano mano = new Mano(3);

        mano.permitirTirada();
        mano.permitirTirada();
        mano.permitirTirada();

        assertThrows(ManoError.class, mano::permitirTirada);
    }

}
