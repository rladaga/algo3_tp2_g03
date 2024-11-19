package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.Joker.*;
import edu.fiuba.algo3.modelo.ManoDePoker.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class JokerTest {

    @Test
    public void test01JokerBaseSeActivaSiempre(){

        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,10);
        Joker comodin = new Joker("Comodin Base", "multiplicador + 10", new SumarMultiplicador(), 10);

        comodin.modificarPuntuacion(puntuacionTirada, new Color());

        assertEquals(20, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test02JokerManoSeActivaSiManoEsIgual(){
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,10);
        Joker comodin = new JokerMano("Comodin", "multiplicador * 3", new MultiplicarMultiplicador(), 3, new Color());

        comodin.modificarPuntuacion(puntuacionTirada, new Color());

        assertEquals(30, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test03JokerManoNoSeActivaSiManoEsDistinta(){
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10,10);
        Joker comodin = new JokerMano("Comodin", "multiplicador * 3", new MultiplicarMultiplicador(), 3, new Escalera());

        comodin.modificarPuntuacion(puntuacionTirada, new Color());

        assertEquals(10, puntuacionTirada.obtenerMultiplicador());
    }


    @Test
    public void test04JokerDescarteNoSeActivaSiNoSeRealizaronDescartes(){

        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodin = new JokerDescarte("comodin", "puntos +8", new SumarPuntos(), 8, descartes);

        comodin.modificarPuntuacion(puntuacionTirada, new Color());

        assertEquals(10, puntuacionTirada.obtenerPuntos());
    }

    @Test
    public void test05JokerDescarteSeActivaSiSeRealizaronDescartes(){

        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodin = new JokerDescarte("comodin", "puntos +8", new SumarPuntos(), 8, descartes);

        descartes.permitirDescarte();
        descartes.permitirDescarte();

        comodin.modificarPuntuacion(puntuacionTirada, new Color());

        assertEquals(26, puntuacionTirada.obtenerPuntos());
    }

    @Test
    public void test06JokerCombinadoPuedeNoActivarSusEfectos(){
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodinDescarte = new JokerDescarte("comodin", "puntos +8", new SumarPuntos(), 8, descartes);
        Joker comodinMano = new JokerMano("Comodin", "multiplicador * 3", new MultiplicarMultiplicador(), 3, new Color());
        Joker comodinCombinado = new JokerCombinado("comodin combinado", "puntos +8 y mult *3", comodinDescarte, comodinMano);

        comodinCombinado.modificarPuntuacion(puntuacionTirada, new Escalera());

        assertEquals(10, puntuacionTirada.obtenerPuntos());
        assertEquals(2, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test07JokerCombinadoPuedeActivarUnoDeSusEfectos(){
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodinDescarte = new JokerDescarte("comodin", "puntos +8", new SumarPuntos(), 8, descartes);
        Joker comodinMano = new JokerMano("Comodin", "multiplicador * 3", new MultiplicarMultiplicador(), 3, new Color());
        Joker comodinCombinado = new JokerCombinado("comodin combinado", "puntos +8 y mult *3", comodinDescarte, comodinMano);

        comodinCombinado.modificarPuntuacion(puntuacionTirada, new Color());

        assertEquals(10, puntuacionTirada.obtenerPuntos());
        assertEquals(6, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test08JokerCombinadoPuedeActivarOtroDeSusEfectos(){
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodinDescarte = new JokerDescarte("comodin", "puntos +8", new SumarPuntos(), 8, descartes);
        Joker comodinMano = new JokerMano("Comodin", "multiplicador * 3", new MultiplicarMultiplicador(), 3, new Color());
        Joker comodinCombinado = new JokerCombinado("comodin combinado", "puntos +8 y mult *3", comodinDescarte, comodinMano);

        descartes.permitirDescarte();
        descartes.permitirDescarte();
        comodinCombinado.modificarPuntuacion(puntuacionTirada, new Escalera());

        assertEquals(26, puntuacionTirada.obtenerPuntos());
        assertEquals(2, puntuacionTirada.obtenerMultiplicador());
    }

    @Test
    public void test09JokerCombinadoPuedeActivarAmbosEfectos(){
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodinDescarte = new JokerDescarte("comodin", "puntos +8", new SumarPuntos(), 8, descartes);
        Joker comodinMano = new JokerMano("Comodin", "multiplicador * 3", new MultiplicarMultiplicador(), 3, new Color());
        Joker comodinCombinado = new JokerCombinado("comodin combinado", "puntos +8 y mult *3", comodinDescarte, comodinMano);

        descartes.permitirDescarte();
        descartes.permitirDescarte();
        comodinCombinado.modificarPuntuacion(puntuacionTirada, new Color());

        assertEquals(26, puntuacionTirada.obtenerPuntos());
        assertEquals(6, puntuacionTirada.obtenerMultiplicador());
    }
}