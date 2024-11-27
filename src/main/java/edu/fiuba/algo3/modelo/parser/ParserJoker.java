package edu.fiuba.algo3.modelo.parser;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.Joker.FabricaDeJokers;
import edu.fiuba.algo3.modelo.Joker.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ParserJoker {
    private static final String RUTA_JOKER = "/json/comodines.json";

    public ArrayList<Joker> parse() throws FileNotFoundException {

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + RUTA_JOKER));
        JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
        JsonObject jokersNormal = jsonObject.get("Al Puntaje").getAsJsonObject();
        JsonObject jokersMano = jsonObject.get("Bonus por Mano Jugada").getAsJsonObject();
        JsonObject jokersDescarte = jsonObject.get("Bonus por Descarte").getAsJsonObject();
        JsonObject jokersAleatorio = jsonObject.get("Chance de activarse aleatoriamente").getAsJsonObject();
        JsonObject jokersCombinados = jsonObject.get("Combinación").getAsJsonObject();

        JsonArray comodines = jokersNormal.get("comodines").getAsJsonArray();
        comodines.addAll(jokersMano.get("comodines").getAsJsonArray());
        comodines.addAll(jokersDescarte.get("comodines").getAsJsonArray());
        comodines.addAll(jokersAleatorio.get("comodines").getAsJsonArray());
        comodines.addAll(jokersCombinados.get("comodines").getAsJsonArray());
        return parsearJokers(comodines);

    }

    public ArrayList<Joker> parsearJokers(JsonArray comodines){
        ArrayList<Joker> jokers = new ArrayList<>();
        for (JsonElement comodinElem : comodines) {
            JsonObject comodinObj = comodinElem.getAsJsonObject();
            jokers.add(this.parsearJoker(comodinObj));
        }
        return jokers;
    }

    public Joker parsearJoker(JsonObject comodinObj) {
        JokerODT jokerODT = new JokerODT();
        if (comodinObj.has("comodines"))
            return parsearJokerCombinado(comodinObj);
        jokerODT.setNombre(comodinObj.get("nombre").getAsString());
        jokerODT.setDescripcion(comodinObj.get("descripcion").getAsString());
        JsonElement activacionEle = comodinObj.get("activacion");
        if (activacionEle.isJsonObject()) {
            JsonObject activacionObj = activacionEle.getAsJsonObject();
            if (activacionObj.has("1 en")) {
                jokerODT.setActivacion("1 en");
                jokerODT.setParametroActivacion(activacionObj.get("1 en").getAsString());
            } else if (activacionObj.has("Mano Jugada")) {
                jokerODT.setActivacion("Mano Jugada");
                jokerODT.setParametroActivacion(activacionObj.get("Mano Jugada").getAsString());
            }
        } else {
            jokerODT.setActivacion(activacionEle.getAsString());
            jokerODT.setParametroActivacion("");
        }
        JsonObject efecto = comodinObj.get("efecto").getAsJsonObject();
        jokerODT.setPuntos(efecto.get("puntos").getAsInt());
        jokerODT.setMultiplicador(efecto.get("multiplicador").getAsFloat());

        return FabricaDeJokers.crearJoker(jokerODT);
    }


    private Joker parsearJokerCombinado(JsonObject comodinObj) {
        String nombre = comodinObj.get("nombre").getAsString();
        String descripcion = comodinObj.get("descripcion").getAsString();
        JsonArray comodinesInternos = comodinObj.get("comodines").getAsJsonArray();
        ArrayList<Joker> jokersInternos = new ArrayList<>();
        for (JsonElement comodinInterno : comodinesInternos) {
            JsonObject comodinInternoObj = comodinInterno.getAsJsonObject();
            jokersInternos.add(parsearJoker(comodinInternoObj));
        }
        return FabricaDeJokers.CrearJokerCombinado(nombre, descripcion, jokersInternos.get(0), jokersInternos.get(1));
    }
}


