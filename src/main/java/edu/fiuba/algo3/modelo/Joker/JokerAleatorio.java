package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.Joker.GeneradorRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class JokerAleatorio extends Joker {
    private GeneradorRandom generador;

    public JokerAleatorio(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador, GeneradorRandom generador) {
        super(nombre, descripcion, estrategiaModificacion, modificador);
        this.generador = generador;
        this.otroJoker = new JokerNulo();
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, ManoDePoker manoDePoker) {
        if(generador.validar()){
            estrategiaModificacion.modificar(puntuacionTirada, modificador);
        }
        this.otroJoker.modificarPuntuacion(puntuacionTirada, manoDePoker);
    }
}
