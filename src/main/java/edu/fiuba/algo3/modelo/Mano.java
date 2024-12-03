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
        PuntuacionTirada  puntuacion = new PuntuacionTirada(0,0);
        manosRealizadas++;
        return puntuacion;
    }

    public void setearLimiteManos(int limiteManos){
        this.limiteManos = limiteManos;
        reiniciarManos();
    }

    public void reiniciarManos() {
        this.manosRealizadas = 0;
    }

    public Integer getManosRestantes(){
        return limiteManos-manosRealizadas;
    }
}
