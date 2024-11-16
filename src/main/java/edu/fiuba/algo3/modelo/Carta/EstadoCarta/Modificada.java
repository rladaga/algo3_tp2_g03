package edu.fiuba.algo3.modelo.Carta.EstadoCarta;

import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.PuntuacionTirada.EstrategiaModificacion.EstrategiaModificacion;

public class Modificada implements Estado {

    private final int modificacion;
    private EstrategiaModificacion modificador;


    public Modificada(int puntuacion, EstrategiaModificacion modificador){
        this.modificacion = puntuacion;
        this.modificador = modificador;
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, int puntuacionCarta) {
        modificador.sumarValorCarta(puntuacionTirada, puntuacionCarta);
        modificador.modificar(puntuacionTirada, modificacion);
    }

    @Override
    public int puntosBase(int puntuacionValor) {
        return modificacion;
    }
}
