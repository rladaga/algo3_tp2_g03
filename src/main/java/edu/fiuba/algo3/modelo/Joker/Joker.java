package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;

import java.util.ArrayList;

public class Joker {

    protected EstrategiaModificacion modificador;
    protected int modificacion;
    protected String nombre;
    protected String descripcion;
    protected ArrayList<CondicionActivacion> condicionActivacion;


    public Joker(String nombre, String descripcion, EstrategiaModificacion modificador, int modificacion, ArrayList<CondicionActivacion> condicionActivacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modificador = modificador;
        this.modificacion = modificacion;
        this.condicionActivacion = condicionActivacion;
    }

    public Joker(String nombre, String descripcion, EstrategiaModificacion modificador, int modificacion, CondicionActivacion condicionActivacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modificador = modificador;
        this.modificacion = modificacion;
        this.condicionActivacion = new ArrayList<CondicionActivacion>();
        this.condicionActivacion.add(condicionActivacion);
    }

    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoJugada){
        boolean valido = true;

        for (CondicionActivacion condicionActivacion : condicionActivacion) {
            if (!condicionActivacion.realizarValidacion(manoJugada)){
                valido = false;
            }
        }

        if (valido){
            modificador.modificar(puntuacion, modificacion);
        }
    }

}
