package edu.fiuba.algo3.modelo.ManoDePoker;
import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;
import java.util.Collections;

public class Escalera extends ManoDePoker {
    public Escalera() {
        this.mejoraMano = new MejoraMano();
    }

    @Override
    public boolean esValida(ArrayList<Carta> mano) {
       
        ArrayList<Integer> indices = new ArrayList<>();
        for (Carta carta : mano) {
            
            int indice = carta.obtenerIndice();
            if (indice != -1) {
                indices.add(indice);
            }
        }
        
        Collections.sort(indices);

        return esEscalera(indices) || esEscaleraSuperiorConAs(indices);
    }

    private boolean esEscalera(ArrayList<Integer> indices) {

        for (int i = 0; i < indices.size() - 1; i++) {
            if (indices.get(i + 1) - indices.get(i) != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean esEscaleraSuperiorConAs(ArrayList<Integer> indices) {
        return indices.size() == 5 &&
                indices.contains(1) && 
                indices.contains(10) && 
                indices.contains(11) && 
                indices.contains(12) && 
                indices.contains(13); 
    }


    @Override
    public int calcularPuntos() {
        return mejoraMano.agregarPuntuacionBase(30);
    }

    @Override
    public int calcularMultiplicador() {
        return mejoraMano.agregarMultiplicadorBase(4);
    }

    @Override
    public boolean esIgual(ManoDePoker mano) {
        return mano.esIgualAEscalera(this);
    }

    @Override
    public boolean esIgualAEscalera(Escalera mano){
        return true;
    }
}
