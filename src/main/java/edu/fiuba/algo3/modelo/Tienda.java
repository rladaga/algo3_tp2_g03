package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.Tarot.Tarot;

import java.util.ArrayList;

public class Tienda {
    ArrayList<Joker> jokers;
    ArrayList<Tarot> tarots;
    Carta carta;

    public Tienda(ArrayList<Joker> jokers, ArrayList<Tarot> tarots, Carta carta) {
        this.jokers = jokers;
        this.tarots = tarots;
        this.carta= carta;
    }

    public Carta getCarta() {
        return carta;
    }

    public ArrayList<Joker> getJokers() {
        return jokers;
    }

    public ArrayList<Tarot> getTarots() {
        return tarots;
    }
}
