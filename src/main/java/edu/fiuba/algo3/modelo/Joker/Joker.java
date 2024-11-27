package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Descarte;

public abstract class Joker {

    protected String nombre;
    protected String descripcion;
    protected EstrategiaModificacion estrategiaModificacion;
    protected Modificador modificador;
    protected Joker otroJoker;


    public Joker(String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estrategiaModificacion = estrategiaModificacion;
        this.modificador = modificacion;
    }

    public abstract void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada, Descarte descarte);

    public void agregarJoker(Joker joker){
        this.otroJoker = joker;
    }
}
