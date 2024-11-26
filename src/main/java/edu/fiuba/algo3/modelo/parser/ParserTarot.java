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
import edu.fiuba.algo3.modelo.Tarot.Tarot;
import edu.fiuba.algo3.modelo.Tarot.TarotCarta;
import edu.fiuba.algo3.modelo.Tarot.TarotManoPoker;

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
        JsonArray tarots = jsonObject.get("tarots").getAsJsonArray();
        ArrayList<Tarot> listaTarots = new ArrayList<>();

        for(JsonElement tarotElem : tarots) {
            JsonObject tarotObj = tarotElem.getAsJsonObject();
            String nombre = tarotObj.get("nombre").getAsString();
            String descripcion = tarotObj.get("descripcion").getAsString();
            JsonObject efecto = tarotObj.get("efecto").getAsJsonObject();
            int puntos = efecto.get("puntos").getAsInt();
            float multiplicador = efecto.get("multiplicador").getAsFloat();
            String sobre = tarotObj.get("sobre").getAsString();
            String ejemplar = tarotObj.get("ejemplar").getAsString();
            ManoDePoker mano;
            Carta carta;


            switch (sobre) {
                case "mano":
                    mano = FabricaDeManos.crearMano(ejemplar);
                    listaTarots.add(new TarotManoPoker(nombre, descripcion,mano, puntos, (int) multiplicador));
                    break;
                case "carta":
                    EstrategiaModificacion modStrat;
                    Modificador mod;
                    if (puntos > 1) {
                        modStrat = new ModificarPuntos();
                        mod = new Sumar(puntos);
                    } else {
                        modStrat = new ModificarMultiplicador();
                        mod = new Multiplicar(multiplicador);
                    }
                    listaTarots.add(new TarotCarta(nombre, descripcion,mod, modStrat));
                    break;
                default:
                    break;
            }
        }
        return listaTarots;

    }



    public ParserTarot() throws FileNotFoundException {
    }
}
