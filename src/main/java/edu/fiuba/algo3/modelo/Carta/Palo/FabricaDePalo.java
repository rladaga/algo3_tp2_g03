package edu.fiuba.algo3.modelo.Carta.Palo;

public class FabricaDePalo {
    public static Palo CrearPalo (String palo){
        switch (palo) {
            case "Trebol":
                return new Trebol();
            case "Corazones":
                return new Corazon();
            case "Picas":
                return new Picas();
            case "Diamantes":
                return new Diamante();
        }
        return null;
    }
}
