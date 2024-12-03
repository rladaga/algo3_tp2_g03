package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Mezclador.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MezcladorTest {

    @Test
    public void test01MezcladorMezclaEfectivamenteLasCartasDeUnMazo(){

        MezcladorMazo mezclador = new MezcladorMazo();
        ArrayList<Carta> cartas = new ArrayList<>();
        ArrayList<Carta> cartasMezcladas = new ArrayList<>();

        cartas.add(new Carta(new Picas(), new As()));
        cartas.add(new Carta(new Corazon(), new Dos()));
        cartas.add(new Carta(new Diamante(), new Tres()));
        cartas.add(new Carta(new Trebol(), new Cuatro()));

        cartasMezcladas.add(new Carta(new Picas(), new As()));
        cartasMezcladas.add(new Carta(new Corazon(), new Dos()));
        cartasMezcladas.add(new Carta(new Diamante(), new Tres()));
        cartasMezcladas.add(new Carta(new Trebol(), new Cuatro()));

        mezclador.mezclar(cartasMezcladas);

        assertNotEquals(cartas, cartasMezcladas);
    }
}
