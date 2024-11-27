package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.*;
import edu.fiuba.algo3.modelo.Joker.*;
import edu.fiuba.algo3.modelo.Joker.GeneradorRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.ManoDePoker.*;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JokerTest {

    @Test
    public void test01JokerBaseSeActivaSiempre(){

        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,10);
        Joker comodin = new JokerNormal("Comodin Base", "multiplicador + 10", new ModificarMultiplicador(), new Sumar(10));
        Descarte descarte = new Descarte(4);

        comodin.modificarPuntuacion(puntuacionTirada, new Color(), descarte);

        assertEquals(20, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test02JokerManoSeActivaSiManoEsIgual(){
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,10);
        Joker comodin = new JokerMano("Comodin", "multiplicador * 3", new ModificarMultiplicador(), new Multiplicar(3), new Color());
        Descarte descarte = new Descarte(4);

        comodin.modificarPuntuacion(puntuacionTirada, new Color(), descarte);

        assertEquals(30, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test03JokerManoNoSeActivaSiManoEsDistinta(){
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,10);
        Joker comodin = new JokerMano("Comodin", "multiplicador * 3", new ModificarMultiplicador(), new Multiplicar(3), new Escalera());
        Descarte descarte = new Descarte(4);

        comodin.modificarPuntuacion(puntuacionTirada, new Color(), descarte);

        assertEquals(10, puntuacionTirada.obtenerMultiplicador());
    }


    @Test
    public void test04JokerDescarteNoSeActivaSiNoSeRealizaronDescartes(){

        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodin = new JokerDescarte("comodin", "puntos +8", new ModificarPuntos(), new Sumar(8));

        comodin.modificarPuntuacion(puntuacionTirada, new Color(),descartes);

        assertEquals(10, puntuacionTirada.obtenerPuntos());
    }

    @Test
    public void test05JokerDescarteSeActivaSiSeRealizaronDescartes(){

        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodin = new JokerDescarte("comodin", "puntos +8", new ModificarPuntos(), new Sumar(8));

        descartes.permitirDescarte();
        descartes.permitirDescarte();

        comodin.modificarPuntuacion(puntuacionTirada, new Color(), descartes);

        assertEquals(26, puntuacionTirada.obtenerPuntos());
    }

    @Test
    public void test06JokerCombinadoPuedeNoActivarSusEfectos(){
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodinDescarte = new JokerDescarte("comodin", "puntos +8", new ModificarPuntos(), new Sumar(8));
        Joker comodinMano = new JokerMano("Comodin", "multiplicador * 3", new ModificarMultiplicador(), new Multiplicar(3), new Color());
        Joker comodinCombinado = new JokerCombinado("comodin combinado", "puntos +8 y mult *3", comodinDescarte, comodinMano);

        comodinCombinado.modificarPuntuacion(puntuacionTirada, new Escalera(), descartes);

        assertEquals(10, puntuacionTirada.obtenerPuntos());
        assertEquals(2, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test07JokerCombinadoPuedeActivarUnoDeSusEfectos(){
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodinDescarte = new JokerDescarte("comodin", "puntos +8", new ModificarPuntos(), new Sumar(8));
        Joker comodinMano = new JokerMano("Comodin", "multiplicador * 3", new ModificarMultiplicador(), new Multiplicar(3), new Color());
        Joker comodinCombinado = new JokerCombinado("comodin combinado", "puntos +8 y mult *3", comodinDescarte, comodinMano);

        comodinCombinado.modificarPuntuacion(puntuacionTirada, new Color(), descartes);

        assertEquals(10, puntuacionTirada.obtenerPuntos());
        assertEquals(6, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test08JokerCombinadoPuedeActivarOtroDeSusEfectos(){
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodinDescarte = new JokerDescarte("comodin", "puntos +8", new ModificarPuntos(), new Sumar(8));
        Joker comodinMano = new JokerMano("Comodin", "multiplicador * 3", new ModificarMultiplicador(), new Multiplicar(3), new Color());
        Joker comodinCombinado = new JokerCombinado("comodin combinado", "puntos +8 y mult *3", comodinDescarte, comodinMano);

        descartes.permitirDescarte();
        descartes.permitirDescarte();
        comodinCombinado.modificarPuntuacion(puntuacionTirada, new Escalera(), descartes);

        assertEquals(26, puntuacionTirada.obtenerPuntos());
        assertEquals(2, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test09JokerCombinadoPuedeActivarAmbosEfectos(){
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodinDescarte = new JokerDescarte("comodin", "puntos +8", new ModificarPuntos(), new Sumar(8));
        Joker comodinMano = new JokerMano("Comodin", "multiplicador * 3", new ModificarMultiplicador(), new Multiplicar(3), new Color());
        Joker comodinCombinado = new JokerCombinado("comodin combinado", "puntos +8 y mult *3", comodinDescarte, comodinMano);

        descartes.permitirDescarte();
        descartes.permitirDescarte();
        comodinCombinado.modificarPuntuacion(puntuacionTirada, new Color(), descartes);

        assertEquals(26, puntuacionTirada.obtenerPuntos());
        assertEquals(6, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test10JokerAleatorioAplicaEfectoAlActivarse(){
        Descarte descarte = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        GeneradorRandom generadorMock = mock(GeneradorRandom.class);
        when(generadorMock.validar()).thenReturn(true);

        Joker comodinAleatorio = new JokerAleatorio("comodin", "puntos +8", new ModificarPuntos(), new Sumar(8), generadorMock);
        comodinAleatorio.modificarPuntuacion(puntuacionTirada, new Color(), descarte);

        assertEquals(18, puntuacionTirada.obtenerPuntos());
        assertEquals(2, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test11JokerAleatorioNoAplicaEfecto(){
        Descarte descarte = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        GeneradorRandom generadorMock = mock(GeneradorRandom.class);
        when(generadorMock.validar()).thenReturn(false);

        Joker comodinAleatorio = new JokerAleatorio("comodin", "puntos +8", new ModificarPuntos(), new Sumar(8), generadorMock);
        comodinAleatorio.modificarPuntuacion(puntuacionTirada, new Color(), descarte);

        assertEquals(10, puntuacionTirada.obtenerPuntos());
        assertEquals(2, puntuacionTirada.obtenerMultiplicador());
    }
}

