package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo(){
        inicializarMazo();
    }

    public int cantidadCartas() {
        return cartas.size();
    }

    private void inicializarMazo(){
        cartas = new ArrayList<>();
        Palo[] palos = {new Trebol(), new Picas(), new Diamante(), new Corazon()};
        Valor[] valores = {new As(), new Dos(), new Tres(), new Cuatro(), new Cinco(), new Seis(), new Siete(), new Ocho(), new Nueve(), new Diez(), new Jota(), new Reina(), new Rey()};
        for(Palo palo : palos){
            for(Valor valor : valores){
                cartas.add(new Carta(palo, valor));
            }
        }

        mezclarCartas();
    }

    public ArrayList<Carta> repartir(){
        ArrayList<Carta> cartasARepartir = new ArrayList<Carta>();
        for (int i = 1; i < 9; i++) {
            cartasARepartir.add(cartas.get(i - 1));
        }

        return cartasARepartir;
    }

    public void mezclarCartas(){
        Collections.shuffle(cartas);
    }
}
