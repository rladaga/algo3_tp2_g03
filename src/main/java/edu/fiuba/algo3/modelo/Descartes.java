package edu.fiuba.algo3.modelo;

public class Descartes {
    private int limiteDescartes;
    private int descartesRealizados;

    public Descartes(int limiteDescartes){
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


}
