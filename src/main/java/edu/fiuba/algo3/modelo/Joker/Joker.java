package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

public class Joker {

    protected String nombre;
    protected String descripcion;
    protected EstrategiaModificacion estrategiaModificacion;
    protected Modificador modificador;


    public Joker(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estrategiaModificacion = estrategiaModificacion;
        this.modificador = modificacion;
    }

    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada){
        estrategiaModificacion.modificar(puntuacion, modificador);
    }

}
