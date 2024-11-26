package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.Corazon;
import edu.fiuba.algo3.modelo.Carta.Palo.Diamante;
import edu.fiuba.algo3.modelo.Carta.Palo.Picas;
import edu.fiuba.algo3.modelo.Carta.Palo.Trebol;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.EvaluadorMano;
import edu.fiuba.algo3.modelo.Joker.GeneradorRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.Joker.*;
import edu.fiuba.algo3.modelo.ManoDePoker.Color;
import edu.fiuba.algo3.modelo.ManoDePoker.Escalera;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;


public class BalatroTest {

    @Test
    public void VerificarQueComodinSume8AlMultiplicador(){

        PuntuacionTirada punt = new PuntuacionTirada(2, 2);
        Joker comodin = new JokerNormal("Comodin", "+8", new ModificarMultiplicador(), new Sumar(8));

        comodin.modificarPuntuacion(punt, new Color());

        assertEquals(10, punt.obtenerMultiplicador());
    }

    @Test
    public void VerificarQueComodinSume3AlMultiplicadorSiJuegaEscalera(){

        EvaluadorMano evaluadorMano = new EvaluadorMano();
        ArrayList<Carta> manoEscaleraBajaAS = new ArrayList<>();
        Joker comodin = new JokerMano("Comodin", "+3", new ModificarMultiplicador(), new Sumar(3), new Escalera());
        ArrayList<Joker> comodines = new ArrayList<>();
        ArrayList<Joker> sinComodines = new ArrayList<>();
        comodines.add(comodin);

        manoEscaleraBajaAS.add(new Carta(new Picas(), new As()));
        manoEscaleraBajaAS.add(new Carta(new Corazon(), new Dos()));
        manoEscaleraBajaAS.add(new Carta(new Diamante(), new Tres()));
        manoEscaleraBajaAS.add(new Carta(new Trebol(), new Cuatro()));
        manoEscaleraBajaAS.add(new Carta(new Picas(), new Cinco()));


        assertEquals(385, evaluadorMano.evaluar(manoEscaleraBajaAS, comodines));
        assertEquals(220, evaluadorMano.evaluar(manoEscaleraBajaAS, sinComodines));
    }
    @Test
    public void VerificarQueComodinSume10ALosPuntosPorDescarte() {
        Descarte descartes = new Descarte(4);
        PuntuacionTirada puntuacionTirada = new PuntuacionTirada(10, 2);
        Joker comodin = new JokerDescarte("comodin", "puntos +10", new ModificarPuntos(), new Sumar(10), descartes);

        descartes.permitirDescarte();
        descartes.permitirDescarte();
        comodin.modificarPuntuacion(puntuacionTirada, new Color());


        assertEquals(30, puntuacionTirada.obtenerPuntos());
    }

    @Test
    public void VerificarQueComodinAplicaEfectoAleatorio(){
        PuntuacionTirada puntuacionTirada1 = new PuntuacionTirada(10, 2);
        PuntuacionTirada puntuacionTirada2 = new PuntuacionTirada(10, 2);
        GeneradorRandom rand1 = mock(GeneradorRandom.class);
        GeneradorRandom rand2 = mock(GeneradorRandom.class);
        when(rand1.validar()).thenReturn(true);
        when(rand2.validar()).thenReturn(false);

        Joker comodin1 = new JokerAleatorio("comodin", "multiplicador x15", new ModificarMultiplicador(), new Multiplicar(15), rand1);
        Joker comodin2 = new JokerAleatorio("comodin", "multiplicador x15", new ModificarMultiplicador(), new Multiplicar(15), rand2);

        comodin1.modificarPuntuacion(puntuacionTirada1, new Color());
        comodin2.modificarPuntuacion(puntuacionTirada2, new Color());

        assertEquals(30, puntuacionTirada1.obtenerMultiplicador());
        assertEquals(2, puntuacionTirada2.obtenerMultiplicador());
    }

    @Test
    public void VerificarCombinacionEfectosJoker(){
        EvaluadorMano evaluadorMano = new EvaluadorMano();
        ArrayList<Carta> manoEscaleraBajaAS = new ArrayList<>();
        ArrayList<Joker> comodines = new ArrayList<>();
        ArrayList<Joker> sinComodines = new ArrayList<>();
        GeneradorRandom random = mock(GeneradorRandom.class);
        when(random.validar()).thenReturn(true);

        Joker comodinAleatorio = new JokerAleatorio("Comodin", "Aleatorio", new ModificarPuntos(), new Sumar(20), random);
        Joker comodinMano = new JokerMano("comodin", "SiEsEscalera", new ModificarMultiplicador(), new Multiplicar(3), new Escalera());

        Joker comodin = new JokerCombinado("Comodin", "EfectoDoble", comodinAleatorio, comodinMano);
        comodines.add(comodin);

        manoEscaleraBajaAS.add(new Carta(new Picas(), new As()));
        manoEscaleraBajaAS.add(new Carta(new Corazon(), new Dos()));
        manoEscaleraBajaAS.add(new Carta(new Diamante(), new Tres()));
        manoEscaleraBajaAS.add(new Carta(new Trebol(), new Cuatro()));
        manoEscaleraBajaAS.add(new Carta(new Picas(), new Cinco()));

        assertEquals(900, evaluadorMano.evaluar(manoEscaleraBajaAS, comodines));
        assertEquals(220, evaluadorMano.evaluar(manoEscaleraBajaAS, sinComodines));
    }
}
