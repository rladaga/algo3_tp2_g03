package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Carta.Palo.*;
import edu.fiuba.algo3.modelo.Carta.Valor.*;
import edu.fiuba.algo3.modelo.Carta.EstadoCarta.*;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;

public class Carta {
    private final Valor valor;
    private final Palo palo;
    private Estado estadoCarta;

    public Carta(Palo palo, Valor valor) {
        this.valor = valor;
        this.palo = palo;
        this.estadoCarta = new Base();

    }

    public String getImagen(){
        String nombrePalo = palo.getClass().getSimpleName();
        String nombreValor = valor.getClass().getSimpleName();


        return nombreValor + "_" + nombrePalo + ".png";
    }

    public int obtenerIndice() {
        return this.valor.numeracion();
    }

    public Palo getPalo() {
        return this.palo;
    }

    public Valor getValor() {
        return this.valor;
    }

    public void modificarPuntuacion(PuntuacionTirada puntuacion) {
        estadoCarta.modificarPuntuacion(puntuacion, valor.puntosBase());
    }

    public void aplicarTarot(Modificador modificador, EstrategiaModificacion estrategiaModificacion) {
        this.estadoCarta = new Modificada(modificador, estrategiaModificacion);
    }


    public int puntosBase() {
        return estadoCarta.puntosBase(valor.puntosBase());
    }

    public boolean compararValor(Carta unaCarta) {
        return unaCarta.compararValor(this.valor);
    }

    public boolean compararValor(Valor unValor) {
        return this.valor.compararCon(unValor);
    }

    public boolean compararPalo(Carta unaCarta) {
        return unaCarta.compararPalo(this.palo);
    }

    public boolean compararPalo(Palo unPalo) {
        return this.palo.compararCon(unPalo);
    }



}
