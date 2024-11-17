package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.GeneradorRandom.GeneradorRandom;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class JokerAleatorio extends Joker {
    private GeneradorRandom generador;

    public JokerAleatorio(String nombre, String descripcion, EstrategiaModificacion modificador, int modificacion, GeneradorRandom generador) {
        super(nombre, descripcion, modificador, modificacion);
        this.generador = generador;
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, ManoDePoker manoDePoker) {
        if(generador.validar()){
            modificador.modificar(puntuacionTirada, modificacion);
        }
    }
}
