package edu.fiuba.algo3.modelo.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Carta.FabricaDeCartas;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.MezcladorMazo;
import edu.fiuba.algo3.modelo.Tarot.Tarot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ParserMazo {
    private static final String RUTA_MAZO = "/json/mazo.json";

    public Mazo parse() throws FileNotFoundException {

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + RUTA_MAZO));
        JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
        JsonArray cartas = jsonObject.get("mazo").getAsJsonArray();
        ArrayList<Carta> cartasMazo = new ArrayList<>();

        for (JsonElement cartaElem : cartas) {
            JsonObject cartaObj = cartaElem.getAsJsonObject();
            String palo = cartaObj.get("palo").getAsString();
            String valor = cartaObj.get("numero").getAsString();
            cartasMazo.add(FabricaDeCartas.crearCarta(devolverPalo(palo), devolverValor(valor)));
        }
        return new Mazo(cartasMazo, new MezcladorMazo());
    }

    public Palo devolverPalo (String palo){
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

    public Valor devolverValor (String valor){
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
