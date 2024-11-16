package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import java.util.Random;

public class JokerRandom extends Joker{
    private int probabilidadUnoEn;

    public JokerRandom(EstrategiaModificacion modificador, int modificacion, int probabilidadUnoEn) {
        super(modificador, modificacion);
        this.probabilidadUnoEn = probabilidadUnoEn;
    }
    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion, ManoDePoker manoDePoker) {
        if(realizarValidacion()){
            modificador.modificar(puntuacion, modificacion);
        }
    }

    public boolean realizarValidacion(){
        int validador = (int) (Math.random() * probabilidadUnoEn) + 1;
        return validador == 1;
    }
}
