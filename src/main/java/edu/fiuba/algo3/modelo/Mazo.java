package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Mezclador.IMezclador;

import java.util.ArrayList;


public class Mazo {
    private ArrayList<Carta> cartasEnMazo;
    private ArrayList<Carta> cartasFueraDeMazo;
    private IMezclador mezclador;

    public Mazo(IMezclador mezclador) {
        this.mezclador = mezclador;
        inicializarMazo();
    }

    public Mazo(ArrayList<Carta> cartas, IMezclador mezclador) {
        this.mezclador = mezclador;
        cartasEnMazo = cartas;
        cartasFueraDeMazo = new ArrayList<>();
    }

    public int cantidadCartas() {
        return cartasEnMazo.size();
    }

    private void inicializarMazo(){
        cartasEnMazo = new ArrayList<>();
        cartasFueraDeMazo = new ArrayList<>();
        Palo[] palos = {new Trebol(), new Picas(), new Diamante(), new Corazon()};
        Valor[] valores = {new As(), new Dos(), new Tres(), new Cuatro(), new Cinco(), new Seis(), new Siete(), new Ocho(), new Nueve(), new Diez(), new Jota(), new Reina(), new Rey()};
        for(Palo palo : palos){
            for(Valor valor : valores){
                cartasEnMazo.add(new Carta(palo, valor));
            }
        }

        mezclarCartas();
    }

    public ArrayList<Carta> repartir(){
        mezclarCartas();
        ArrayList<Carta> cartasARepartir = new ArrayList<Carta>();
        for (int i = 1; i < 9; i++) {
            cartasARepartir.add(cartasEnMazo.get(i - 1));
            cartasFueraDeMazo.add(cartasEnMazo.get(i - 1));
            cartasEnMazo.remove(i-1);
        }

        return cartasARepartir;
    }

    public ArrayList<Carta> repartir(int cantidad){
        mezclarCartas();
        ArrayList<Carta> cartasARepartir = new ArrayList<Carta>();
        for (int i = 1; i < cantidad+1; i++) {
            cartasARepartir.add(cartasEnMazo.get(i - 1));
            cartasFueraDeMazo.add(cartasEnMazo.get(i - 1));
            cartasEnMazo.remove(i-1);
        }

        return cartasARepartir;
    }

    public void restaurarMazo(){
        cartasEnMazo.addAll(cartasFueraDeMazo);
        cartasFueraDeMazo.clear();
    }


    public void mezclarCartas(){
        mezclador.mezclar(cartasEnMazo);
    }
}
