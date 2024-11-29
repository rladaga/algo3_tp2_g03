package edu.fiuba.algo3.modelo.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Tarot.*;

import java.io.*;
import java.util.ArrayList;

public class ParserTarot {

    public ArrayList<Tarot> parse() throws FileNotFoundException {

        InputStream inputStream = getClass().getResourceAsStream("/json/tarots.json");

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
        JsonArray tarotsArr = jsonObject.get("tarots").getAsJsonArray();
        return parsearTarots(tarotsArr);
    }

    public ArrayList<Tarot> parsearTarots(JsonArray tarotArr){
        ArrayList<Tarot> listaTarots = new ArrayList<>();

        for(JsonElement tarotElem : tarotArr) {
            JsonObject tarotObj = tarotElem.getAsJsonObject();
            listaTarots.add(parsearTarot(tarotObj));
        }
        return listaTarots;
    }

    public Tarot parsearTarot(JsonObject tarotObj){

        TarotDTO tarotDTO = new TarotDTO();
        tarotDTO.setNombre(tarotObj.get("nombre").getAsString());
        tarotDTO.setDescripcion(tarotObj.get("descripcion").getAsString());
        JsonObject efecto = tarotObj.get("efecto").getAsJsonObject();
        tarotDTO.setPuntos(efecto.get("puntos").getAsInt());
        tarotDTO.setMultiplicador(efecto.get("multiplicador").getAsFloat());
        tarotDTO.setSobre(tarotObj.get("sobre").getAsString());
        tarotDTO.setEjemplar(tarotObj.get("ejemplar").getAsString());

        return FabricaDeTarot.crearTarot(tarotDTO);
    }

}
