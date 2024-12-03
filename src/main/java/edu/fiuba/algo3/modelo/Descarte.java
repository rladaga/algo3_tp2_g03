package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepcion.DescarteError;

public class Descarte {
    private int limiteDescartes;
    private int descartesRealizados;

    public Descarte(int limiteDescartes){
        this.limiteDescartes = limiteDescartes;
        this.descartesRealizados = 0;
    }

    public boolean permitirDescarte(){
        boolean validacion = false;

        if(descartesRealizados >= limiteDescartes){
            throw new DescarteError("No más descartes posibles");
        }
        validacion = true;
        descartesRealizados++;
        return validacion;
    }

    public void reiniciarDescartes() {
        this.descartesRealizados = 0;
    }

    public int descartesRealizados(){
        return descartesRealizados;
    }

    public Integer getDescartesRestantes() {
        return limiteDescartes - descartesRealizados;
    }
}
