package edu.fiuba.algo3.UnitTest.Carta;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.EstadoCarta.*;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.Modificador.Multiplicar;
import edu.fiuba.algo3.modelo.Modificador.Sumar;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstadoTest {
    @Test
    public void test01EstadoBaseDevuelveLaPuntuacionValorRecibida(){
        Estado estadoBase = new Base();
        Carta cartaTest = new Carta(new Trebol(), new Diez());

        int resultado = estadoBase.puntosBase(cartaTest.puntosBase());

        assertEquals(10, resultado);
    }

    @Test
    public void test02EstadoBaseModificaLaPuntuacionYsSumaLosPuntosDeLaCarta(){
        Carta cartaTest = new Carta(new Trebol(), new Cinco());
        Estado estadoBase = new Base();
        PuntuacionTirada punt = new PuntuacionTirada(3,3);

        estadoBase.modificarPuntuacion(punt, cartaTest.puntosBase());

        assertEquals(8, punt.obtenerPuntos());
    }

    @Test
    public void test03EstadoModificadaEnPuntosBaseDevuelvePuntosDeLaCartaSiModificaMultiplicador(){
        Estado estadoModificada = new Modificada(new Sumar(4), new ModificarMultiplicador());

        Carta cartaTest = new Carta(new Trebol(), new Diez());

        int resultado = estadoModificada.puntosBase(cartaTest.puntosBase());

        assertEquals(10, resultado);
    }

    @Test
    public void test04EstadoModificadaEnPuntosBaseDevuelvePuntosDeModifcadorSiModificaPuntos(){
        Estado estadoModificada = new Modificada(new Sumar(15), new ModificarPuntos());

        Carta cartaTest = new Carta(new Trebol(), new Diez());

        int resultado = estadoModificada.puntosBase(cartaTest.puntosBase());

        assertEquals(15, resultado);
    }

    @Test
    public void test05ModificarPuntuacionModificaPuntosYMultiplicadorSiEstrategiaEsModificarMultiplicador(){
        PuntuacionTirada punt = new PuntuacionTirada(10,2);
        Carta cartaTest = new Carta(new Trebol(), new Diez());
        Estado estadoModificada = new Modificada(new Multiplicar(4), new ModificarMultiplicador());

        estadoModificada.modificarPuntuacion(punt, cartaTest.puntosBase());

        assertEquals(20, punt.obtenerPuntos());
        assertEquals(8, punt.obtenerMultiplicador());
    }

    @Test
    public void test06ModificarPuntuacionModificaPuntosSiEstrategiaEsModificarPuntos(){
        PuntuacionTirada punt = new PuntuacionTirada(10,2);
        Carta cartaTest = new Carta(new Trebol(), new Diez());
        Estado estadoModificada = new Modificada(new Sumar(20), new ModificarPuntos());

        estadoModificada.modificarPuntuacion(punt, cartaTest.puntosBase());

        assertEquals(30, punt.obtenerPuntos());
        assertEquals(2, punt.obtenerMultiplicador());
    }
}
