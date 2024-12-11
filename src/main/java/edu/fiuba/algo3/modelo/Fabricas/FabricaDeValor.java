package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.Carta.Valor.*;

public class FabricaDeValor {
    public static Valor CrearValor (String valor){
        switch (valor) {
            case "As":
                return new As();
            case "2":
                return new Dos();
            case "3":
                return new Tres();
            case "4":
                return new Cuatro();
            case "5":
                return new Cinco();
            case "6":
                return new Seis();
            case "7":
                return new Siete();
            case "8":
                return new Ocho();
            case "9":
                return new Nueve();
            case "10":
                return new Diez();
            case "Jota":
                return new Jota();
            case "Reina":
                return new Reina();
            case "Rey":
                return new Rey();
        }
        return null;
    }
}
