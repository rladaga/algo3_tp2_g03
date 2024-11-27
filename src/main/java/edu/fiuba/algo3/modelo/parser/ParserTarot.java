package edu.fiuba.algo3.modelo.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.ManoDePoker.FabricaDeManos;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicar;
import edu.fiuba.algo3.modelo.Modificador.Sumar;
import edu.fiuba.algo3.modelo.Tarot.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ParserTarot {

    private static final String RUTA_TAROT     =    "/json/tarots.json";

    public ArrayList<Tarot> parse() throws FileNotFoundException {

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + RUTA_TAROT));
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

        TarotODT tarotODT = new TarotODT();
        tarotODT.setNombre(tarotObj.get("nombre").getAsString());
        tarotODT.setDescripcion(tarotObj.get("descripcion").getAsString());
        JsonObject efecto = tarotObj.get("efecto").getAsJsonObject();
        tarotODT.setPuntos(efecto.get("puntos").getAsInt());
        tarotODT.setMultiplicador(efecto.get("multiplicador").getAsFloat());
        tarotODT.setSobre(tarotObj.get("sobre").getAsString());
        tarotODT.setEjemplar(tarotObj.get("ejemplar").getAsString());

        return FabricaDeTarot.crearTarot(tarotODT);
    }

}
