package edu.fiuba.algo3.modelo.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.Mezclador.MezcladorMazo;

import java.io.*;
import java.util.ArrayList;

public class ParserBalatro {
    private static final String RUTA_BALATRO = "/recursos/json/balatro.json";
    private JsonObject jsonObject;

    public ParserBalatro() throws FileNotFoundException {

        InputStream inputStream = getClass().getResourceAsStream("/json/balatro.json");

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
        this.jsonObject = jsonObject;
    }

    public Balatro pasearBalatro() {
        return new Balatro(parsearRondas(), new Mazo(parsearMazo(), new MezcladorMazo()));
    }

    public ArrayList<Ronda> parsearRondas() {
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

    public ArrayList<Carta> parsearMazo(){
        ParserMazo parserCartas = new ParserMazo();
        JsonArray mazoArr = jsonObject.getAsJsonArray("mazo");
        return parserCartas.parsearCartas(mazoArr);
    }
}