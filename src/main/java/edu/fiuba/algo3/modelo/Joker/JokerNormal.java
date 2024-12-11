package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class JokerNormal extends Joker {

    public JokerNormal(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador) {
        super(nombre, descripcion, estrategiaModificacion, modificador);
        this.otroJoker = new JokerNulo();
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada, Descarte descarte){
        estrategiaModificacion.modificar(puntuacion, modificador);
        this.otroJoker.modificarPuntuacion(puntuacion, manoJugada, descarte);
    }

    @Override
    public String getTipo(){
        return "Normal";
    }
}
