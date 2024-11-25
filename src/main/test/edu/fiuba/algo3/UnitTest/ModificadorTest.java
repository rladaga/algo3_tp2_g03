package edu.fiuba.algo3.UnitTest;

import edu.fiuba.algo3.modelo.Modificador.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ModificadorTest {
    @Test
    public void test01ModificadorSumarRecibeUn0YDevuelveElValorConElQueFueInstanciado(){
        Modificador sumar = new Sumar(8);
        int valorASumar = 0;

        int resultado = sumar.modificar(valorASumar);

        assertEquals(8, resultado);
    }

    @Test
    public void test02ModificadorSumarRecibeUnEnteroYDevuelveCorrectamenteLaSuma(){
        Modificador sumar = new Sumar(8);
        int valorASumar = 12;

        int resultado = sumar.modificar(valorASumar);

        assertEquals(20, resultado);
    }

    @Test
    public void test03ModificadorMulitplicarRecibeUn0YDevuelveCero() {
        Modificador multiplicar = new Multiplicar(8);
        int valorAMultiplicar = 0;

        int resultado = multiplicar.modificar(valorAMultiplicar);

        assertEquals(0, resultado);
    }

    @Test
    public void test04ModificadorMulitplicarRecibeUnUnoYDevuelveValorConElQueFueInstanciado() {
        Modificador multiplicar = new Multiplicar(8);
        int valorAMultiplicar = 1;

        int resultado = multiplicar.modificar(valorAMultiplicar);

        assertEquals(8, resultado);
    }

    @Test
    public void test05ModificadorMulitplicarRecibeUnUnoYDevuelveCorrectamenteLaMultiplicacion() {
        Modificador multiplicar = new Multiplicar(8);
        int valorAMultiplicar = 5;

        int resultado = multiplicar.modificar(valorAMultiplicar);

        assertEquals(40, resultado);
    }
}
