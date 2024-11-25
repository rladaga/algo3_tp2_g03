package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.Picas;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.ManoDePoker.*;
import edu.fiuba.algo3.modelo.Modificador.Sumar;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.Tarot.TarotCarta;
import edu.fiuba.algo3.modelo.Tarot.TarotManoPoker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarotTest {
    @Test
    public void test01TarotDeCartaSeAplicaCorrectamente(){
        Carta carta = new Carta(new Picas(), new As());
        TarotCarta tarot = new TarotCarta("","",new Sumar(10), new ModificarPuntos());

        tarot.aplicarEfecto(carta);

        assertEquals(10, carta.puntosBase());
    }

    @Test
    public void test02TarotDeCartaSeAplicaSobreCartaYaModificadaYSobreescribeLaModificacion(){
        Carta carta = new Carta(new Picas(), new As());
        TarotCarta tarot1 = new TarotCarta("","",new Sumar(10), new ModificarPuntos());
        TarotCarta tarot2 = new TarotCarta("","",new Sumar(30), new ModificarPuntos());


        tarot1.aplicarEfecto(carta);
        tarot2.aplicarEfecto(carta);

        assertEquals(30, carta.puntosBase());
    }

    @Test
    public void test03TarotDeCartaModificaMultiplicadorCorrectamenteYCartaMantienePuntosBase(){
        PuntuacionTirada puntuacion = new PuntuacionTirada(10, 10);
        Carta carta = new Carta(new Picas(), new Dos());
        TarotCarta tarot = new TarotCarta("","",new Sumar(8), new ModificarMultiplicador());

        tarot.aplicarEfecto(carta);
        carta.modificarPuntuacion(puntuacion);

        assertEquals(2, carta.puntosBase());
        assertEquals(12, puntuacion.obtenerPuntos());
        assertEquals(18, puntuacion.obtenerMultiplicador());
    }

    @Test
    public void test04TarotDeManoSeAplicaCorrectamente(){
        ManoDePoker manoPar = new Par();
        TarotManoPoker tarot = new TarotManoPoker("","",new Par(), 5, 1);

        tarot.aplicarEfecto(manoPar);

        assertEquals(15, manoPar.calcularPuntos());
        assertEquals(3, manoPar.calcularMultiplicador());
    }

    @Test
    public void test05TarorDeManoSeAplicaCorrectamenteSobreUnaManoMultiplesVecesYSeAcumula(){
        ManoDePoker manoPar = new Par();
        TarotManoPoker tarot = new TarotManoPoker("","",new Par(), 5, 1);

        tarot.aplicarEfecto(manoPar);
        tarot.aplicarEfecto(manoPar);
        tarot.aplicarEfecto(manoPar);

        assertEquals(25, manoPar.calcularPuntos());
        assertEquals(5, manoPar.calcularMultiplicador());
    }
}
