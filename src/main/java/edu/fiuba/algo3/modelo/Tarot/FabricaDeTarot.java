package edu.fiuba.algo3.modelo.Tarot;

import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.ManoDePoker.FabricaDeManos;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicar;
import edu.fiuba.algo3.modelo.Modificador.Sumar;

public class FabricaDeTarot {
    public static Tarot crearTarot(TarotODT tarotODT){
        String nombre = tarotODT.getNombre();
        String descripcion = tarotODT.getDescripcion();
        int puntos = tarotODT.getPuntos();
        float multiplicador = tarotODT.getMultiplicador();
        String sobre = tarotODT.getSobre();
        String ejemplar = tarotODT.getEjemplar();

        switch (sobre) {
            case "mano":
                return CrearTarotManoPoker(nombre, descripcion,FabricaDeManos.crearMano(ejemplar), puntos, (int)multiplicador);
            case "carta":
                EstrategiaModificacion modStrat;
                Modificador mod;
                if (puntos > 1) {
                    modStrat = new ModificarPuntos();
                    mod = new Sumar(puntos);
                } else {
                    modStrat = new ModificarMultiplicador();
                    mod = new Multiplicar(multiplicador);
                }
                return CrearTarotCarta(nombre, descripcion,mod, modStrat);
            default:
                return null;
        }
    }

    private static Tarot CrearTarotManoPoker(String nombre, String descripcion, ManoDePoker mano, int puntos, int multiplicador) {
        return new TarotManoPoker(nombre,descripcion,mano,puntos,multiplicador);
    }

    private static Tarot CrearTarotCarta(String nombre, String descripcion, Modificador modificador, EstrategiaModificacion estrategia) {
        return new TarotCarta(nombre,descripcion,modificador,estrategia);
    }
}
