package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class JokerDescarte extends Joker{

    public JokerDescarte (String nombre, String descripcion, EstrategiaModificacion estrategiaModificacion, Modificador modificador){
        super(nombre, descripcion, estrategiaModificacion, modificador);
        this.otroJoker = new JokerNulo();
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, ManoDePoker manoDePoker, Descarte descarte){
        for(int i = 0 ; i < descarte.descartesRealizados() ; i++){
            estrategiaModificacion.modificar(puntuacionTirada, modificador);
        }
        this.otroJoker.modificarPuntuacion(puntuacionTirada, manoDePoker, descarte);
    }

    @Override
    public String getTipo(){
        return "Descarte";
    }

}
