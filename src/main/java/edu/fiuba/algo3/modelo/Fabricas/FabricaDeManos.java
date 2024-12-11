package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.ManoDePoker.*;

public class FabricaDeManos {

    public static ManoDePoker crearMano(String ejemplar) {
        switch (ejemplar.toLowerCase()) {
            case "carta alta":
                return new CartaAlta();
            case "par":
                return new Par();
            case "doble par":
                return new DoblePar();
            case "trio":
                return new Trio();
            case "escalera":
                return new Escalera();
            case "color":
                return new Color();
            case "full":
                return new FullHouse();
            case "poker":
                return new Poker();
            case "escalera de color":
                return new EscaleraColor();
            case "escalera real":
                return new EscaleraReal();
            default:
                throw new IllegalArgumentException("Tipo de mano desconocido: " + ejemplar);
        }
    }
}
