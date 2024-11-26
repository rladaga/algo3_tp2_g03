package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.Joker.GeneradorRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificador.Modificador;

public class FabricaDeJokers {

    public static Joker CrearJokerAleatorio(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador, GeneradorRandom generador) {
        return new JokerAleatorio(nombre, descripcion, estrategiaModificacion, modificador, generador);
    }

    public static Joker CrearJokerCombinado(String nombre, String descripcion, Joker joker1, Joker joker2) {
        return new JokerCombinado(nombre, descripcion, joker1, joker2);
    }

    public static Joker CrearJokerDescarte(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador, Descarte descartes) {
        return new JokerDescarte(nombre, descripcion, estrategiaModificacion, modificador, descartes);
    }

    public static Joker CrearJokerMano(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador, ManoDePoker manoObjetivo) {
        return new JokerMano(nombre, descripcion, estrategiaModificacion, modificador, manoObjetivo);
    }

    public static Joker CrearJokerNormal(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador) {
        return new JokerNormal(nombre, descripcion, estrategiaModificacion, modificador);
    }
}
