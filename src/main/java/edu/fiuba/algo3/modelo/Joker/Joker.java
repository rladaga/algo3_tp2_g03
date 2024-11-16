package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class Joker {

    protected EstrategiaModificacion modificador;
    protected int modificacion;


    public Joker(EstrategiaModificacion modificador, int modificacion) {
        this.modificador = modificador;
        this.modificacion = modificacion;
    }

    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada){
        modificador.modificar(puntuacion, modificacion);
    }

}
