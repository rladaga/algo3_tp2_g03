package edu.fiuba.algo3.modelo.Tarot;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.EstrategiaModificacion.EstrategiaModificacion;
import edu.fiuba.algo3.modelo.Modificador.Modificador;

public class TarotCarta extends Tarot {

    private Modificador modificador;
    private EstrategiaModificacion estrategiaModificacion;

    public TarotCarta(String nombre, String descripcion, Modificador modificador, EstrategiaModificacion estrategiaModificacion) {
        super(nombre, descripcion);
        this.modificador = modificador;
        this.estrategiaModificacion = estrategiaModificacion;
    }


    public void aplicarEfecto(Carta carta){
        carta.aplicarTarot(modificador, estrategiaModificacion);
    }
}
