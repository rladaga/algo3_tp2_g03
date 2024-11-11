package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Joker.*;
import edu.fiuba.algo3.modelo.tipo_de_mano.Escalera;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalatroTest {

    @Test
    public void jugadorPoseeCartasSuficientesParaEmpezarElJuego() {
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador(mazo);


        assertTrue(jugador.cartasEnMazo() >= 8);
    }

    @Test
    public void jugadorSeLeReparten8CartasDelMazo(){
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador(mazo);
        jugador.iniciarTurno();

        assertEquals(8, jugador.cantidadCartasEnMano());

    }

    @Test
    public void sePuedeJugarUnaManoDeUnMazo(){
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador(mazo);
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

        manoEscaleraBajaAS.add(new Carta("PICA", "AS"));
        manoEscaleraBajaAS.add(new Carta("CORAZON", "DOS"));
        manoEscaleraBajaAS.add(new Carta("DIAMANTE", "TRES"));
        manoEscaleraBajaAS.add(new Carta("TREBOL", "CUATRO"));
        manoEscaleraBajaAS.add(new Carta("PICA", "CINCO"));

        manoEscaleraColor.add(new Carta("PICA", "NUEVE"));
        manoEscaleraColor.add(new Carta("PICA", "DIEZ"));
        manoEscaleraColor.add(new Carta("PICA", "JOTA"));
        manoEscaleraColor.add(new Carta("PICA", "REINA"));
        manoEscaleraColor.add(new Carta("PICA", "REY"));

        manoEscaleraReal.add(new Carta("PICA", "DIEZ"));
        manoEscaleraReal.add(new Carta("PICA", "JOTA"));
        manoEscaleraReal.add(new Carta("PICA", "REINA"));
        manoEscaleraReal.add(new Carta("PICA", "REY"));
        manoEscaleraReal.add(new Carta("PICA", "AS"));

        ArrayList<Joker> jokers = new ArrayList<>();

        assertEquals(220, evaluadorMano.evaluar(manoEscaleraBajaAS, jokers ));
        assertEquals(1192, evaluadorMano.evaluar(manoEscaleraColor, jokers));
        assertEquals(1208, evaluadorMano.evaluar(manoEscaleraReal, jokers));
    }

    @Test
    public void importanciaOrdenDePuntuacionDeCartas(){
        EvaluadorMano evaluadorMano = new EvaluadorMano();
        ArrayList<Carta> manoEscaleraBajaAS = new ArrayList<>();
        ArrayList<Joker> orden1 = new ArrayList<>();
        ArrayList<Joker> orden2 = new ArrayList<>();

        manoEscaleraBajaAS.add(new Carta("PICA", "AS"));
        manoEscaleraBajaAS.add(new Carta("CORAZON", "DOS"));
        manoEscaleraBajaAS.add(new Carta("DIAMANTE", "TRES"));
        manoEscaleraBajaAS.add(new Carta("TREBOL", "CUATRO"));
        manoEscaleraBajaAS.add(new Carta("PICA", "CINCO"));

        orden1.add(new JokerManoSumador("MULTIPLICADOR", 10, new Escalera()));
        orden1.add(new JokerManoMultiplicador("MULTIPLICADOR", 2, new Escalera()));

        orden2.add(new JokerManoMultiplicador("MULTIPLICADOR", 2, new Escalera()));
        orden2.add(new JokerManoSumador("MULTIPLICADOR", 10, new Escalera()));

        assertEquals(evaluadorMano.evaluar(manoEscaleraBajaAS, orden1), 1540);
        assertEquals(evaluadorMano.evaluar(manoEscaleraBajaAS, orden2), 990);
    }

    @Test
    public void modificarUnaCartaConTarotYCambiaSusPuntosPor10(){

    }

    @Test
    public void ModificarUnaCartaConTarotYCambiaSuMultiplicadorPor6(){

    }
}
