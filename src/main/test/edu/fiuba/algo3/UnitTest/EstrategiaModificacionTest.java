package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.EstrategiaModificacion.*;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstrategiaModificacionTest {

    @Test
    public void test01ModificadorPuntosModificaLosPuntosDePuntuacionTirada(){
        EstrategiaModificacion modificarPuntos = new ModificarPuntos();
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,8);

        modificarPuntos.modificar(puntuacionTirada, new Sumar(8));

        assertEquals(18, puntuacionTirada.obtenerPuntos());
    }

    @Test
    public void test02ObtenerPuntosCartaEnModificadorPuntosDevuelveSoloLosPuntosDelModificador(){
        EstrategiaModificacion modificarPuntos = new ModificarPuntos();

        int resultado = modificarPuntos.puntosCarta(3, new Sumar(20));

        assertEquals(20, resultado);

    }

    @Test
    public void test03ModificarMultiplicadorModificaLosPuntosDePuntuacionTirada(){
        EstrategiaModificacion modificarMultiplicador = new ModificarMultiplicador();
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,8);

        modificarMultiplicador.modificar(puntuacionTirada, new Sumar(20));
        modificarMultiplicador.modificar(puntuacionTirada, new Multiplicar(2));

        assertEquals(10, puntuacionTirada.obtenerPuntos());
        assertEquals(56, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test04ObtenerPuntosCartaEnModificadorMultiplicadorDevuelveLosPuntosDeLaCarta(){
        EstrategiaModificacion modificarMultiplicador = new ModificarMultiplicador();

        int resultado = modificarMultiplicador.puntosCarta(3, new Sumar(20));

        assertEquals(3, resultado);
    }
}
