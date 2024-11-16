package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.Corazon;
import edu.fiuba.algo3.modelo.Carta.Palo.Diamante;
import edu.fiuba.algo3.modelo.Carta.Palo.Picas;
import edu.fiuba.algo3.modelo.Carta.Palo.Trebol;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.EvaluadorMano;
import edu.fiuba.algo3.modelo.GeneradorRandom.NumeroAleatorioMock;
import edu.fiuba.algo3.modelo.Joker.*;
import edu.fiuba.algo3.modelo.ManoDePoker.Color;
import edu.fiuba.algo3.modelo.ManoDePoker.Escalera;
import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.SumarMultiplicador;
import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.SumarPuntos;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

public class BalatroTest {

    @Test
    public void VerificarQueComodinSume8AlMultiplicador(){

        PuntuacionTirada punt = new PuntuacionTirada(2, 2);
        Joker comodin = new Joker("Comodin", "+8", new SumarMultiplicador(), 8, new Siempre());

        comodin.modificarPuntuacion(punt, new Color());

        assertEquals(10, punt.obtenerMultiplicador());
    }

    @Test
    public void VerificarQueComodinSume3AlMultiplicadorSiJuegaEscalera(){

        EvaluadorMano evaluadorMano = new EvaluadorMano();
        ArrayList<Carta> manoEscaleraBajaAS = new ArrayList<>();
        Joker comodin = new Joker("Comodin", "+3", new SumarMultiplicador(), 3, new Mano(new Escalera()));
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
    public void VerificarCombinacionEfectosJoker(){
        EvaluadorMano evaluadorMano = new EvaluadorMano();
        ArrayList<Carta> manoEscaleraBajaAS = new ArrayList<>();
        ArrayList<Joker> comodines = new ArrayList<>();
        ArrayList<Joker> sinComodines = new ArrayList<>();
        ArrayList<CondicionActivacion> condicionesActivaciones = new ArrayList<>();

        condicionesActivaciones.add(new Mano(new Escalera()));
        condicionesActivaciones.add(new Aleatorio(new NumeroAleatorioMock()));

        Joker comodin = new Joker("Comodin", "+8", new SumarPuntos(), 8, condicionesActivaciones);
        comodines.add(comodin);

        manoEscaleraBajaAS.add(new Carta(new Picas(), new As()));
        manoEscaleraBajaAS.add(new Carta(new Corazon(), new Dos()));
        manoEscaleraBajaAS.add(new Carta(new Diamante(), new Tres()));
        manoEscaleraBajaAS.add(new Carta(new Trebol(), new Cuatro()));
        manoEscaleraBajaAS.add(new Carta(new Picas(), new Cinco()));

        assertEquals(252, evaluadorMano.evaluar(manoEscaleraBajaAS, comodines));
        assertEquals(220, evaluadorMano.evaluar(manoEscaleraBajaAS, sinComodines));

    }
}
