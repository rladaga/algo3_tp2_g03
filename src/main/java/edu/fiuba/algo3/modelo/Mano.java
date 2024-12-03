package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class Mano {
    private int limiteManos;
    private int manosRealizadas;

    public Mano(int limiteManos){
        this.limiteManos = limiteManos;
        this.manosRealizadas = 0;
    }

    public boolean permitirTirada(){
        boolean validacion = false;

        if(manosRealizadas < limiteManos){
            validacion = true;
            manosRealizadas++;
        }

        return validacion;
    }

    public Integer getManosRestantes(){
        return limiteManos-manosRealizadas;
    }
}
