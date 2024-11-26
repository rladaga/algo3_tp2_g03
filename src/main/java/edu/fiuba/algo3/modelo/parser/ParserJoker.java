package edu.fiuba.algo3.modelo.parser;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.FabricaDeCartas;
import edu.fiuba.algo3.modelo.Descarte;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarMultiplicador;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.ModificarPuntos;
import edu.fiuba.algo3.modelo.Joker.FabricaDeJokers;
import edu.fiuba.algo3.modelo.Joker.GeneradorRandom.NumeroAleatorio;
import edu.fiuba.algo3.modelo.Joker.Joker;
import edu.fiuba.algo3.modelo.ManoDePoker.FabricaDeManos;
import edu.fiuba.algo3.modelo.ManoDePoker.ManoDePoker;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicar;
import edu.fiuba.algo3.modelo.Modificador.Sumar;

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

        ArrayList<Joker> jokers = new ArrayList<>();

        JsonArray comodinesNormal = jokersNormal.get("comodines").getAsJsonArray();
        for(JsonElement comodinElem : comodinesNormal){
            JsonObject comodinObj = comodinElem.getAsJsonObject();
            jokers.add(this.parsearJokerNormal(comodinObj));
        }
        JsonArray comodinesMano = jokersMano.get("comodines").getAsJsonArray();
        for(JsonElement comodinElem : comodinesMano){
            JsonObject comodinObj = comodinElem.getAsJsonObject();
            jokers.add(this.parsearJokerMano(comodinObj));
        }
        JsonArray comodinesDescarte = jokersDescarte.get("comodines").getAsJsonArray();
        for(JsonElement comodinElem : comodinesDescarte){
            JsonObject comodinObj = comodinElem.getAsJsonObject();
            jokers.add(this.parsearJokerDescarte(comodinObj));
        }
        JsonArray comodinesAleatorio = jokersAleatorio.get("comodines").getAsJsonArray();
        for(JsonElement comodinElem : comodinesAleatorio){
            JsonObject comodinObj = comodinElem.getAsJsonObject();
            jokers.add(this.parsearJokerAleatorio(comodinObj));
        }
        this.parsearJokerCombinado(jokers, jokersCombinados);

        return jokers;
    }


    private Joker parsearJokerNormal(JsonObject comodinObj){
            String nombre = comodinObj.get("nombre").getAsString();
            String descripcion = comodinObj.get("descripcion").getAsString();
            JsonObject efecto = comodinObj.get("efecto").getAsJsonObject();
            int puntos = efecto.get("puntos").getAsInt();
            float multiplicador = efecto.get("multiplicador").getAsFloat();
            EstrategiaModificacion modStrat;
            Modificador mod;
            if (puntos > 1) {
                modStrat = new ModificarPuntos();
                mod = obtenerModificador(descripcion.charAt(0), puntos);
            } else {
                modStrat = new ModificarMultiplicador();
                mod = obtenerModificador(descripcion.charAt(0), multiplicador);
            }
            return FabricaDeJokers.CrearJokerNormal(nombre, descripcion, modStrat, mod);
    }

    private Joker parsearJokerMano(JsonObject comodinObj){
            String nombre = comodinObj.get("nombre").getAsString();
            String descripcion = comodinObj.get("descripcion").getAsString();
            JsonObject activacion = comodinObj.get("activacion").getAsJsonObject();
            String manoString = activacion.get("Mano Jugada").getAsString();
            ManoDePoker mano = FabricaDeManos.crearMano(manoString);
            JsonObject efecto = comodinObj.get("efecto").getAsJsonObject();
            int puntos = efecto.get("puntos").getAsInt();
            float multiplicador = efecto.get("multiplicador").getAsFloat();
            EstrategiaModificacion modStrat;
            Modificador mod;
            if (puntos > 1) {
                modStrat = new ModificarPuntos();
                mod = obtenerModificador(descripcion.charAt(0), puntos);
            } else {
                modStrat = new ModificarMultiplicador();
                mod = obtenerModificador(descripcion.charAt(0), multiplicador);
            }

            return FabricaDeJokers.CrearJokerMano(nombre, descripcion, modStrat, mod, mano);
    }

    private Joker parsearJokerDescarte(JsonObject comodinObj){
            String nombre = comodinObj.get("nombre").getAsString();
            String descripcion = comodinObj.get("descripcion").getAsString();
            JsonObject efecto = comodinObj.get("efecto").getAsJsonObject();
            int puntos = efecto.get("puntos").getAsInt();
            float multiplicador = efecto.get("multiplicador").getAsFloat();
            EstrategiaModificacion modStrat;
            Modificador mod;
            if (puntos > 1) {
                modStrat = new ModificarPuntos();
                mod = obtenerModificador(descripcion.charAt(0), puntos);
            } else {
                modStrat = new ModificarMultiplicador();
                mod = obtenerModificador(descripcion.charAt(0), multiplicador);
            }
            return FabricaDeJokers.CrearJokerDescarte(nombre, descripcion, modStrat, mod, new Descarte(3));
    }

    private Joker parsearJokerAleatorio(JsonObject comodinObj){
            String nombre = comodinObj.get("nombre").getAsString();
            String descripcion = comodinObj.get("descripcion").getAsString();
            JsonObject activacion = comodinObj.get("activacion").getAsJsonObject();
            int probabilidadActivacion = activacion.get("1 en").getAsInt();
            JsonObject efecto = comodinObj.get("efecto").getAsJsonObject();
            int puntos = efecto.get("puntos").getAsInt();
            float multiplicador = efecto.get("multiplicador").getAsFloat();
            EstrategiaModificacion modStrat;
            Modificador mod;
            if (puntos > 1) {
                modStrat = new ModificarPuntos();
                mod = obtenerModificador(descripcion.charAt(0), puntos);
            } else {
                modStrat = new ModificarMultiplicador();
                mod = obtenerModificador(descripcion.charAt(0), multiplicador);
            }
        return FabricaDeJokers.CrearJokerAleatorio(nombre, descripcion, modStrat, mod, new NumeroAleatorio(probabilidadActivacion));
    }

    private void parsearJokerCombinado(ArrayList<Joker> jokers, JsonObject jokersCombinados){
        JsonArray comodines = jokersCombinados.get("comodines").getAsJsonArray();
        for(JsonElement comodinElem : comodines) {
            JsonObject comodinObj = comodinElem.getAsJsonObject();
            String nombre = comodinObj.get("nombre").getAsString();
            String descripcion = comodinObj.get("descripcion").getAsString();
            JsonArray comodinesInternos = comodinObj.get("comodines").getAsJsonArray();
            ArrayList<Joker> jokersInternos = new ArrayList<>();
            for(JsonElement comodinInterno : comodinesInternos) {
                JsonObject comodinInternoObj = comodinInterno.getAsJsonObject();
                JsonElement activacionEle = comodinInternoObj.get("activacion");
                String activacion = "";
                if(activacionEle.isJsonObject()) {
                    JsonObject activacionObj = activacionEle.getAsJsonObject();
                    if (activacionObj.has("1 en"))
                        activacion = "1 en";
                    else if (activacionObj.has("Mano Jugada"))
                        activacion = "Mano Jugada";
                }
                else
                    activacion = activacionEle.getAsString();
                switch (activacion) {
                    case "1 en":
                        jokersInternos.add(parsearJokerAleatorio(comodinInternoObj));
                        break;
                    case "Mano Jugada":
                        jokersInternos.add(parsearJokerMano(comodinInternoObj));
                        break;
                    case "Descarte":
                        jokersInternos.add(parsearJokerDescarte(comodinInternoObj));
                        break;
                    case "Siempre":
                        jokersInternos.add(parsearJokerNormal(comodinInternoObj));
                        break;
                    default:
                        break;
                }
            }
            jokers.add(FabricaDeJokers.CrearJokerCombinado(nombre,descripcion,jokersInternos.get(0), jokersInternos.get(1)));
            jokersInternos.clear();

            }
        }

    private Modificador obtenerModificador(char c, float valor) {
        switch (c) {
            case '+':
                return new Sumar((int)valor);
            case 'x':
                return new Multiplicar(valor);
            } return null;
    }
}

