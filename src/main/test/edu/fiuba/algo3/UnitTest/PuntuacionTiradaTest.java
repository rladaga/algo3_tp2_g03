package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Modificador.Sumar;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuacionTiradaTest {
    @Test
    public void test01PuntuacionTiradaSeInstanciCorrectamente(){
        PuntuacionTirada punt = new PuntuacionTirada(10,5);

        assertEquals(10, punt.obtenerPuntos());
        assertEquals(5,punt.obtenerMultiplicador());
    }

    @Test
    public void test02PuntuacionTiradaCalculaCorrectamenteLaPuntuacion(){
        PuntuacionTirada punt = new PuntuacionTirada(10,5);

        assertEquals(50, punt.obtenerPuntuacion());
    }

    @Test
    public void test03ModificarPuntosModificaLosPuntosUnicaamente(){
        PuntuacionTirada punt = new PuntuacionTirada(10,5);

        punt.modificarPuntos(new Sumar(8));

        assertEquals(18,punt.obtenerPuntos());
        assertEquals(5, punt.obtenerMultiplicador());
    }

    @Test
    public void test03ModificarMultiplicadorModificaElMultiplicadorUnicaamente() {
        PuntuacionTirada punt = new PuntuacionTirada(10, 5);

        punt.modificarMultiplicador(new Sumar(5));

        assertEquals(10, punt.obtenerPuntos());
        assertEquals(10, punt.obtenerMultiplicador());
    }


    }
