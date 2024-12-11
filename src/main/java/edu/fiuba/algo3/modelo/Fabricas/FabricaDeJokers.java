package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.DTOs.JokerDTO;
import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.Joker.*;
import edu.fiuba.algo3.modelo.Joker.GeneradorRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.Joker.GeneradorRandom.NumeroAleatorio;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicar;
import edu.fiuba.algo3.modelo.Modificador.Sumar;

public class FabricaDeJokers {

    public static Joker crearJoker(JokerDTO jokerDTO){
        String nombre = jokerDTO.getNombre();
        String descripcion = jokerDTO.getDescripcion();
        String activacion = jokerDTO.getActivacion();
        String parametroActivacion = jokerDTO.getParametroActivacion();
        int puntos = jokerDTO.getPuntos();
        float multiplicador = jokerDTO.getMultiplicador();

        EstrategiaModificacion modStrat;
        Modificador mod;
        if (puntos > 1) {
            modStrat = new ModificarPuntos();
            mod = obtenerModificador(descripcion.charAt(0), (float)puntos);
        } else {
            modStrat = new ModificarMultiplicador();
            mod = obtenerModificador(descripcion.charAt(0), multiplicador);
        }

        switch (activacion) {
            case "1 en":
                return CrearJokerAleatorio(nombre,descripcion,modStrat,mod,new NumeroAleatorio(Integer.parseInt(parametroActivacion)));
            case "Mano Jugada":
                return CrearJokerMano(nombre,descripcion,modStrat,mod, FabricaDeManos.crearMano(parametroActivacion));

            case "Descarte":
                return CrearJokerDescarte(nombre,descripcion,modStrat,mod, new Descarte(2));
            case "Siempre":
                return CrearJokerNormal(nombre,descripcion,modStrat,mod);
            default:
                return null;
        }
    }

    private static Joker CrearJokerAleatorio(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador, GeneradorRandom generador) {
        return new JokerAleatorio(nombre, descripcion, estrategiaModificacion, modificador, generador);
    }

    public static Joker CrearJokerCombinado(String nombre, String descripcion, Joker joker1, Joker joker2) {
        return new JokerCombinado(nombre, descripcion, joker1, joker2);
    }

    private static Joker CrearJokerDescarte(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador, Descarte descartes) {
        return new JokerDescarte(nombre, descripcion, estrategiaModificacion, modificador);
    }

    private static Joker CrearJokerMano(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador, ManoDePoker manoObjetivo) {
        return new JokerMano(nombre, descripcion, estrategiaModificacion, modificador, manoObjetivo);
    }

    private static Joker CrearJokerNormal(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador) {
        return new JokerNormal(nombre, descripcion, estrategiaModificacion, modificador);
    }

    private static Modificador obtenerModificador(char c, float valor) {
        switch (c) {
            case '+':
                return new Sumar((int)valor);
            case 'x':
                return new Multiplicar(valor);
        } return null;
    }
}
