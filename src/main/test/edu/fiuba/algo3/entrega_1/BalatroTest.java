package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Joker.*;
import edu.fiuba.algo3.modelo.Mezclador.IMezclador;
import edu.fiuba.algo3.modelo.Mezclador.MezcladorMazo;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.Tarot.*;
import edu.fiuba.algo3.modelo.Tarot.TarotManoPoker;
import edu.fiuba.algo3.modelo.ManoDePoker.Escalera;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalatroTest{

    @Test
    public void jugadorPoseeCartasSuficientesParaEmpezarElJuego() {
        IMezclador mezclador = new MezcladorMazo();
        Mazo mazo = new Mazo(mezclador);
        Descarte descartes = new Descarte(3);
        Jugador jugador = new Jugador(mazo, descartes);


        assertTrue(jugador.cartasEnMazo() >= 8);
    }

    @Test
    public void jugadorSeLeReparten8CartasDelMazo(){
        IMezclador mezclador = new MezcladorMazo();
        Mazo mazo = new Mazo(mezclador);
        Descarte descartes = new Descarte(3);
        Jugador jugador = new Jugador(mazo, descartes);
        jugador.iniciarTurno();

        assertEquals(8, jugador.cantidadCartasEnMano());

    }

    @Test
    public void sePuedeJugarUnaManoDeUnMazo(){
        IMezclador mezclador = new MezcladorMazo();
        Mazo mazo = new Mazo(mezclador);
        Descarte descartes = new Descarte(3);
        Jugador jugador = new Jugador(mazo, descartes);
        jugador.iniciarTurno();

        for (int i = 0; i < 4; i++) {
            jugador.seleccionarCartaEnPosicion(i);
        }

        assertTrue(jugador.jugarMano().size() > 0 && jugador.jugarMano().size() < 6);
    }

    @Test
    public void alJugarUnaManoSeAplicaValorCorrespondiente(){

        EvaluadorMano evaluadorMano = new EvaluadorMano();
        ArrayList<Carta> manoEscaleraBajaAS = new ArrayList<>();
        ArrayList<Carta> manoEscaleraColor = new ArrayList<>();
        ArrayList<Carta> manoEscaleraReal = new ArrayList<>();
        ArrayList<Carta> manoPoker = new ArrayList<>();
        ArrayList<Carta> manoFullHouse = new ArrayList<>();
        Palo[] palos = {new Trebol(), new Picas(), new Diamante(), new Corazon()};
        Valor[] valores = {new As(), new Dos(), new Tres(), new Cuatro(), new Cinco(), new Seis(), new Siete(), new Ocho(), new Nueve(), new Diez(), new Jota(), new Reina(), new Rey()};

        manoEscaleraBajaAS.add(new Carta(palos[1], valores[0]));
        manoEscaleraBajaAS.add(new Carta(palos[3], valores[1]));
        manoEscaleraBajaAS.add(new Carta(palos[2], valores[2]));
        manoEscaleraBajaAS.add(new Carta(palos[0], valores[3]));
        manoEscaleraBajaAS.add(new Carta(palos[1], valores[4]));

        manoEscaleraColor.add(new Carta(palos[1], valores[8]));
        manoEscaleraColor.add(new Carta(palos[1],  valores[9]));
        manoEscaleraColor.add(new Carta(palos[1],  valores[10]));
        manoEscaleraColor.add(new Carta(palos[1],  valores[11]));
        manoEscaleraColor.add(new Carta(palos[1],  valores[12]));

        manoEscaleraReal.add(new Carta(palos[1],  valores[9]));
        manoEscaleraReal.add(new Carta(palos[1],  valores[10]));
        manoEscaleraReal.add(new Carta(palos[1], valores[11]));
        manoEscaleraReal.add(new Carta(palos[1],  valores[12]));
        manoEscaleraReal.add(new Carta(palos[1],  valores[0]));

        manoPoker.add(new Carta(palos[0], valores[1]));
        manoPoker.add(new Carta(palos[1], valores[1]));
        manoPoker.add(new Carta(palos[2], valores[1]));
        manoPoker.add(new Carta(palos[3], valores[1]));
        manoPoker.add(new Carta(palos[3], valores[2]));

        manoFullHouse.add(new Carta(palos[0], valores[1]));
        manoFullHouse.add(new Carta(palos[1], valores[1]));
        manoFullHouse.add(new Carta(palos[2], valores[1]));
        manoFullHouse.add(new Carta(palos[2], valores[2]));
        manoFullHouse.add(new Carta(palos[3], valores[2]));

        ArrayList<Joker> jokers = new ArrayList<>();
        Descarte descarte = new Descarte(0);

        assertEquals(220, evaluadorMano.evaluar(manoEscaleraBajaAS, jokers, descarte ));
        assertEquals(1192, evaluadorMano.evaluar(manoEscaleraColor, jokers, descarte));
        assertEquals(1208, evaluadorMano.evaluar(manoEscaleraReal, jokers, descarte));
        assertEquals(497, evaluadorMano.evaluar(manoPoker, jokers, descarte));
        assertEquals(208, evaluadorMano.evaluar(manoFullHouse, jokers, descarte));
    }

    @Test
   public void importanciaOrdenDePuntuacionDeCartas(){
        EvaluadorMano evaluadorMano = new EvaluadorMano();
        ArrayList<Carta> manoEscaleraBajaAS = new ArrayList<>();
        ArrayList<Joker> orden1 = new ArrayList<>();
        ArrayList<Joker> orden2 = new ArrayList<>();
        Descarte descarte = new Descarte(0);

        manoEscaleraBajaAS.add(new Carta(new Picas(), new As()));
        manoEscaleraBajaAS.add(new Carta(new Corazon(), new Dos()));
        manoEscaleraBajaAS.add(new Carta(new Diamante(), new Tres()));
        manoEscaleraBajaAS.add(new Carta(new Trebol(), new Cuatro()));
        manoEscaleraBajaAS.add(new Carta(new Picas(), new Cinco()));

        orden1.add(new JokerMano("Comodin", "+10", new ModificarMultiplicador(), new Sumar(10), new Escalera()));
        orden1.add(new JokerMano("Comodin", "x2", new ModificarMultiplicador(), new Multiplicar(2), new Escalera()));

        orden2.add(new JokerMano("Comodin", "+10", new ModificarMultiplicador(), new Multiplicar(2), new Escalera()));
        orden2.add(new JokerMano("Comodin", "x2", new ModificarMultiplicador(), new Sumar(10), new Escalera()));

        assertEquals(1540, evaluadorMano.evaluar(manoEscaleraBajaAS, orden1, descarte));
        assertEquals(990, evaluadorMano.evaluar(manoEscaleraBajaAS, orden2, descarte));
    }

    @Test
    public void modificarUnaCartaConTarotYCambiaSusPuntosPor10(){

        Carta carta = new Carta(new Picas(), new As());
        TarotCarta tarot = new TarotCarta("","",new Sumar(10), new ModificarPuntos());

        tarot.aplicarEfecto(carta);

        assertEquals(10, carta.puntosBase());
    }

    @Test
    public void ModificarUnaManoConTarotYCambiaSuMultiplicadorPor6(){
        ManoDePoker manoDePoker = new Escalera();
        TarotManoPoker tarot = new TarotManoPoker("","",new Escalera() , 15, 2);

        tarot.aplicarEfecto(manoDePoker);

        assertEquals(6, manoDePoker.calcularMultiplicador());

    }
}
