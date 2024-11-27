package edu.fiuba.algo3.modelo.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.Mano;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Tienda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ParserBalatro {
    private static final String RUTA_BALATRO = "/json/balatro.json";

    public ArrayList<Ronda> parse() throws FileNotFoundException {

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + RUTA_BALATRO));
        JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
        JsonArray rondasJson = jsonObject.getAsJsonArray("rondas");
        ArrayList<Ronda> rondas = new ArrayList<>();
        for (JsonElement rondaElem : rondasJson) {
            JsonObject rondaObj = rondaElem.getAsJsonObject();
            rondas.add(parsearRonda(rondaObj));
        }

        return rondas;
    }

    public Ronda parsearRonda(JsonObject rondaObj) {
        int numeroRonda = rondaObj.get("nro").getAsInt();
        Mano mano = new Mano(rondaObj.get("manos").getAsInt());
        Descarte descarte = new Descarte(rondaObj.get("descartes").getAsInt());
        int puntajeASuperar = rondaObj.get("puntajeASuperar").getAsInt();
        JsonObject tiendaObj = rondaObj.getAsJsonObject("tienda");
        return new Ronda(numeroRonda, descarte, mano, puntajeASuperar, parsearTienda(tiendaObj));
    }

    public Tienda parsearTienda(JsonObject tiendaObj){
        ParserJoker parserJoker = new ParserJoker();
        ParserMazo parserCartas = new ParserMazo();
        ParserTarot parserTarot = new ParserTarot();
        JsonArray comodinesArr = tiendaObj.getAsJsonArray("comodines");
        JsonArray tarotsArr = tiendaObj.getAsJsonArray("tarots");
        JsonObject cartaObj = tiendaObj.getAsJsonObject("carta");
        return new Tienda(parserJoker.parsearJokers(comodinesArr), parserTarot.parsearTarots(tarotsArr), parserCartas.parsearCarta(cartaObj));
    }
}