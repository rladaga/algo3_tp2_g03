package edu.fiuba.algo3.modelo.ManoDePoker;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;

public abstract class ManoDePoker {
    protected MejoraMano mejoraMano;

    public abstract boolean esValida(ArrayList<Carta> mano);
    public abstract int calcularPuntos();
    public abstract int calcularMultiplicador();


    protected int cuentaRepeticiones(ArrayList<Carta> mano, int repeticionesDeseadas) {
        int gruposEncontrados = 0;
        for (Carta carta : mano) {
            int cartaRepetida = 0;

            for (Carta otraCarta : mano) { 
                if (carta.compararValor(otraCarta)) { 
                    cartaRepetida++; 
                }
            }

            if (cartaRepetida == repeticionesDeseadas) {
                gruposEncontrados++;
            }
        }
        
        return gruposEncontrados / repeticionesDeseadas;
    }


    public void agregarMejora(int puntuacion, int multiplicador) {
        mejoraMano.mejorarMano(puntuacion, multiplicador);
    }

    public abstract boolean esIgual(ManoDePoker mano);

    public boolean esIgualACartaAlta(CartaAlta mano){
        return false;
    }
    public boolean esIgualAPar(Par mano){
        return false;
    }
    public boolean esIgualADoblePar(DoblePar mano){
        return false;
    }
    public boolean esIgualATrio(Trio mano){
        return false;
    }
    public boolean esIgualAPoker(Poker mano){
        return false;
    }
    public boolean esIgualAColor(Color mano){
        return false;
    }
    public boolean esIgualAEscalera(Escalera mano){
        return false;
    }
    public boolean esIgualAFullHouse(FullHouse mano){
        return false;
    }
    public boolean esIgualAEscaleraColor(EscaleraColor mano){
        return false;
    }
    public boolean esIgualAEscaleraReal(EscaleraReal mano){
        return false;
    }

}