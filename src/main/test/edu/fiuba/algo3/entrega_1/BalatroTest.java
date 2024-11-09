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
        Mazo mazo = new Mazo();

        EvaluadorMano evaluadorMano = new EvaluadorMano();
        Jugador jugador = new Jugador(mazo);
        ArrayList<Carta> mano = new ArrayList<Carta>();
        jugador.iniciarTurno();

        mano.add(new Carta("PICA", "AS"));
        mano.add(new Carta("CORAZON", "AS"));


        assertEquals(22, evaluadorMano.evaluar(mano));
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
