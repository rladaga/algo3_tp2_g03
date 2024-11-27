package edu.fiuba.algo3.modelo.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Carta.FabricaDeCartas;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Palo.FabricaDePalo;
import edu.fiuba.algo3.modelo.Carta.Valor.FabricaDeValor;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mezclador.MezcladorMazo;

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
            cartasMazo.add(FabricaDeCartas.crearCarta(FabricaDePalo.CrearPalo(palo), FabricaDeValor.CrearValor(valor)));
        }
        return new Mazo(cartasMazo, new MezcladorMazo());
    }
}
