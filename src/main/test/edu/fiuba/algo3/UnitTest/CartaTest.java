package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.Modificador.Sumar;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.Tarot.TarotCarta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartaTest {

    @Test
    public void test01CartaSeInstanciaCorrectamenteConSuValorYPalo(){
        Carta carteTest = new Carta(new Corazon(), new Diez());

        Palo paloCarta = carteTest.getPalo();
        Valor valorCarta = carteTest.getValor();

        assertEquals(Corazon.class, paloCarta.getClass());
        assertEquals(Diez.class, valorCarta.getClass());
    }

    @Test
    public void test02CartaDevuelveSuPuntuacionBaseCorrectamente(){
        Carta cartaTest = new Carta(new Corazon(), new Diez());

        int resultado = cartaTest.puntosBase();

        assertEquals(10, resultado);
    }

    @Test
    public void test03CartaDevuelveSuIndiceCorrectamente(){
        Carta cartaTest = new Carta(new Corazon(), new Reina());

        int resultado = cartaTest.obtenerIndice();

        assertEquals(12, resultado);
    }

    @Test
    public void test04aCartaSeModificaCorectamenteConTarotYModificarPuntosYCambiaSuPuntuacionBase(){
        Carta cartaTest = new Carta(new Corazon(), new Dos());
        TarotCarta tarot = new TarotCarta("","",new Sumar(20), new ModificarPuntos());

        tarot.aplicarEfecto(cartaTest);
        int resultado = cartaTest.puntosBase();

        assertEquals(20, resultado);
    }

    @Test
    public void test04bCartaSeModificaCorectamenteConTarotYModificarMultiplicarYNoCambiaSuPuntuacionBase(){
        Carta cartaTest = new Carta(new Corazon(), new Dos());
        TarotCarta tarot = new TarotCarta("","",new Sumar(20), new ModificarMultiplicador());

        tarot.aplicarEfecto(cartaTest);
        int resultado = cartaTest.puntosBase();

        assertEquals(2, resultado);
    }

    @Test
    public void test05UnaCartaComparaSuPaloConOtraConIgualPaloYDevuelveTrue(){
        Carta cartaTest = new Carta(new Corazon(), new Diez());
        Carta cartaTest2 = new Carta(new Corazon(), new Seis());

        boolean resultado = cartaTest.compararPalo(cartaTest2);

        assertEquals(true, resultado);
    }

    @Test
    public void test06UnaCartaComparaSuPaloConOtraConDistintoPaloYDevuelveFalse(){
        Carta cartaTest = new Carta(new Corazon(), new Diez());
        Carta cartaTest2 = new Carta(new Picas(), new Seis());

        boolean resultado = cartaTest.compararPalo(cartaTest2);

        assertEquals(false, resultado);
    }

    @Test
    public void test07UnaCartaComparaSuValorConOtraConIgualValorYDevuelveTrue(){
        Carta cartaTest = new Carta(new Corazon(), new Diez());
        Carta cartaTest2 = new Carta(new Picas(), new Diez());

        boolean resultado = cartaTest.compararValor(cartaTest2);

        assertEquals(true, resultado);
    }

    @Test
    public void test08UnaCartaComparaSuValorConOtraConDistintoValorYDevuelveFalse(){
        Carta cartaTest = new Carta(new Corazon(), new Ocho());
        Carta cartaTest2 = new Carta(new Picas(), new Diez());

        boolean resultado = cartaTest.compararValor(cartaTest2);

        assertEquals(false, resultado);
    }

    @Test
    public void test09UnaCartaConEstadaBaseModificaLosPuntosDeLaPuntuacionTirada(){
        Carta cartaTest = new Carta(new Corazon(), new Diez());
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,2);

        cartaTest.modificarPuntuacion(puntuacionTirada);

        assertEquals(20, puntuacionTirada.obtenerPuntos());
    }

    @Test
    public void test10UnaCartaTarotizadaConModificarMultiplicadorAlModificarPuntuacionTiradaAplicaSusPuntos(){
        Carta cartaTest = new Carta(new Corazon(), new Diez());
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,2);
        TarotCarta tarot = new TarotCarta("","",new Sumar(20), new ModificarMultiplicador());

        tarot.aplicarEfecto(cartaTest);
        cartaTest.modificarPuntuacion(puntuacionTirada);

        assertEquals(20, puntuacionTirada.obtenerPuntos());
        assertEquals(22, puntuacionTirada.obtenerMultiplicador());
    }


}
