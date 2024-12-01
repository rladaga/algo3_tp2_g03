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
    public static Tarot crearTarot(TarotDTO tarotDTO){
        String nombre = tarotDTO.getNombre();
        String descripcion = tarotDTO.getDescripcion();
        int puntos = tarotDTO.getPuntos();
        float multiplicador = tarotDTO.getMultiplicador();
        String sobre = tarotDTO.getSobre();
        String ejemplar = tarotDTO.getEjemplar();

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
