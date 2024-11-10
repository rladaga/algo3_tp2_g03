package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
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

        assertEquals(220, evaluadorMano.evaluar(manoEscaleraBajaAS));
        assertEquals(1192, evaluadorMano.evaluar(manoEscaleraColor));
        assertEquals(1208, evaluadorMano.evaluar(manoEscaleraReal));
    }

    @Test
    public void importanciaOrdenDePuntuacionDeCartas(){

    }

    @Test
    public void modificarUnaCartaConTarotYCambiaSusPuntosPor10(){

    }

    @Test
    public void ModificarUnaCartaConTarotYCambiaSuMultiplicadorPor6(){

    }
}
