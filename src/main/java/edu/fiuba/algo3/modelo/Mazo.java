package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;

import java.util.ArrayList;


public class Mazo {
    private ArrayList<Carta> cartas;
    private MezcladorMazo mezcladorMazo;

    public Mazo(){
        mezcladorMazo = new MezcladorMazo();
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
        mezcladorMazo.mezclar(cartas);
    }
}
