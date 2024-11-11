package edu.fiuba.algo3.modelo.Joker;

import edu.fiuba.algo3.modelo.PuntuacionTirada;
import edu.fiuba.algo3.modelo.tipo_de_mano.TipoDeMano;

public class JokerManoMultiplicador implements Joker{

    private String modificacion;
    private int factorModificacion;
    private TipoDeMano tipo;

    public JokerManoMultiplicador(String modificacion, int factorModificacion, TipoDeMano tipo) {
        this.modificacion = modificacion;
        this.factorModificacion = factorModificacion;
        this.tipo = tipo;
    }
    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacion, TipoDeMano tipo) {
        if(this.tipo.getClass().equals(tipo.getClass())){
            puntuacion.multiplicar(modificacion, factorModificacion);
        }
    }
}