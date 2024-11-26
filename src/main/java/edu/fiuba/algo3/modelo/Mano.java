package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;

public class Mano {
    private int limiteManos;
    private int manosRealizadas;

    public Mano(int limiteManos){
        this.limiteManos = limiteManos;
    }

    public boolean permitirTirada(){
        boolean validacion = false;

        if(manosRealizadas < limiteManos){
            validacion = true;
            manosRealizadas++;
        }

        return validacion;
    }

    public PuntuacionTirada realizarTirada(){

        manosRealizadas++;


        return validacion;
    }

    public void setearLimiteManos(int limiteManos){
        this.limiteManos = limiteManos;
        reiniciarManos();
    }

    public void reiniciarManos() {
        this.manosRealizadas = 0;
    }

    public int manosRestantes(){
        return limiteManos-manosRealizadas;
    }
}
