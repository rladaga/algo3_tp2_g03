package edu.fiuba.algo3.modelo.Carta.EstadoCarta;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.PuntuacionTirada.PuntuacionTirada;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;

public class Modificada implements Estado {

    private final Modificador modificador;
    private EstrategiaModificacion estrategiaModificacion;



    public Modificada(Modificador modificador, EstrategiaModificacion estrategiaModificacion) {
        this.modificador = modificador;
        this.estrategiaModificacion = estrategiaModificacion;
    }

    @Override
    public void modificarPuntuacion(PuntuacionTirada puntuacionTirada, int puntuacionCarta) {
        estrategiaModificacion.sumarValorCarta(puntuacionTirada, puntuacionCarta);
        estrategiaModificacion.modificar(puntuacionTirada, modificador);
    }

    @Override
    public int puntosBase(int valorBaseCarta) {
        return estrategiaModificacion.puntosCarta(valorBaseCarta, modificador);
    }
}
