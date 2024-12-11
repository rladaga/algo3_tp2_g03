package edu.fiuba.algo3.modelo.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Fabricas.FabricaDeCarta;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Fabricas.FabricaDePalo;
import edu.fiuba.algo3.modelo.Fabricas.FabricaDeValor;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mezclador.MezcladorMazo;

import java.io.*;
import java.util.ArrayList;

public class ParserMazo {
    private static final String RUTA_MAZO = "/recursos/json/mazo.json";

    public Mazo parse() throws FileNotFoundException {

        InputStream inputStream = getClass().getResourceAsStream("/json/mazo.json");

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
        JsonArray cartas = jsonObject.get("mazo").getAsJsonArray();
        return new Mazo(parsearCartas(cartas), new MezcladorMazo());
    }

    public ArrayList<Carta> parsearCartas(JsonArray cartasArr){
        ArrayList<Carta> cartas = new ArrayList<>();

        for (JsonElement cartaElem : cartasArr) {
            JsonObject cartaObj = cartaElem.getAsJsonObject();
            cartas.add(parsearCarta(cartaObj));
        }
        return cartas;
    }

    public Carta parsearCarta(JsonObject cartaObj){
        String palo = cartaObj.get("palo").getAsString();
        String valor = cartaObj.get("numero").getAsString();
        return FabricaDeCarta.crearCarta(FabricaDePalo.CrearPalo(palo), FabricaDeValor.CrearValor(valor));
    }
}
