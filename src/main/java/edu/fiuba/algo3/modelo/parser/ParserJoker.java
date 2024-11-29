package edu.fiuba.algo3.modelo.parser;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.Joker.FabricaDeJokers;
import edu.fiuba.algo3.modelo.Joker.*;

import java.io.*;
import java.util.ArrayList;

public class ParserJoker {
    private static final String RUTA_JOKER = "/recursos/json/comodines.json";

    public ArrayList<Joker> parse() throws FileNotFoundException {

        InputStream inputStream = getClass().getResourceAsStream("/json/comodines.json");

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
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
        JokerDTO jokerDTO = new JokerDTO();
        if (comodinObj.has("comodines"))
            return parsearJokerCombinado(comodinObj);
        jokerDTO.setNombre(comodinObj.get("nombre").getAsString());
        jokerDTO.setDescripcion(comodinObj.get("descripcion").getAsString());
        JsonElement activacionEle = comodinObj.get("activacion");
        if (activacionEle.isJsonObject()) {
            JsonObject activacionObj = activacionEle.getAsJsonObject();
            if (activacionObj.has("1 en")) {
                jokerDTO.setActivacion("1 en");
                jokerDTO.setParametroActivacion(activacionObj.get("1 en").getAsString());
            } else if (activacionObj.has("Mano Jugada")) {
                jokerDTO.setActivacion("Mano Jugada");
                jokerDTO.setParametroActivacion(activacionObj.get("Mano Jugada").getAsString());
            }
        } else {
            jokerDTO.setActivacion(activacionEle.getAsString());
            jokerDTO.setParametroActivacion("");
        }
        JsonObject efecto = comodinObj.get("efecto").getAsJsonObject();
        jokerDTO.setPuntos(efecto.get("puntos").getAsInt());
        jokerDTO.setMultiplicador(efecto.get("multiplicador").getAsFloat());

        return FabricaDeJokers.crearJoker(jokerDTO);
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


