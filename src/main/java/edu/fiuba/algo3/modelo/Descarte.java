package edu.fiuba.algo3.modelo;

public class Descarte {
    private int limiteDescartes;
    private int descartesRealizados;

    public Descarte(int limiteDescartes){
        this.limiteDescartes = limiteDescartes;
        this.descartesRealizados = 0;
    }

    public boolean permitirDescarte(){
        boolean validacion = false;

        if(descartesRealizados < limiteDescartes){
            validacion = true;
            descartesRealizados++;
        }

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
