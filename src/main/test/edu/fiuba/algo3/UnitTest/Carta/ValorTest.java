package edu.fiuba.algo3.UnitTest.Carta;

import edu.fiuba.algo3.modelo.Carta.Valor.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValorTest {
    @Test
    public void test01UnValorSeInstanciaYTieneAsignadoSusPuntosBase(){
        Valor valor = new Cinco();

        int resultado = valor.puntosBase();

        assertEquals(5, resultado);
    }

    @Test
    public void test02UnValorSeInstanciaYTieneAsignadaSuNumeracion(){
        Valor valor = new Rey();

        int resultado = valor.numeracion();

        assertEquals(13, resultado);
    }

    @Test
    public void test03UnValorSeComparaConOtroPorTrue(){
        Valor valor = new Rey();
        Valor valor2 = new Rey();

        boolean resultado = valor.equals(valor2);

        assertEquals(true, resultado);
    }

    @Test
    public void test04UnValorSeComparaConOtroPorFalse(){
        Valor valor = new Rey();
        Valor valor2 = new Cinco();

        boolean resultado = valor.equals(valor2);

        assertEquals(false, resultado);
    }
}
