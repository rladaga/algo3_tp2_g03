package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

import java.util.ArrayList;

public class Joker {

    protected String nombre;
    protected String descripcion;
    protected EstrategiaModificacion modificador;
    protected int modificacion;


    public Joker(String nombre, String descripcion, EstrategiaModificacion modificador, int modificacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modificador = modificador;
        this.modificacion = modificacion;
    }

    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada){
        modificador.modificar(puntuacion, modificacion);
    }

}
