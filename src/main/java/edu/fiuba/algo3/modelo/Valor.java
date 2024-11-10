package edu.fiuba.algo3.modelo;

public enum Valor {
    DOS("2", 2),
    TRES("3", 3),
    CUATRO("4", 4),
    CINCO("5", 5),
    SEIS("6", 6),
    SIETE("7", 7),
    OCHO("8", 8),
    NUEVE("9", 9),
    DIEZ("10", 10),
    JOTA("J", 10),
    REINA("Q", 10),
    REY("K", 10),
    AS("A", 11);

    private final String numero;
    private final int puntoBase;

    Valor(String numero, int puntoBase) {
        this.numero = numero;
        this.puntoBase = puntoBase;
    }

    public String getNumero() {
        return numero;
    }

    public int getPuntoBase() {
        return puntoBase;
    }

    public static int obtenerIndicePorNombre(String nombre) {
        for (Valor valor : Valor.values()) {
            if (valor.getNumero().equals(nombre)) {
                return valor.ordinal();
            }
        }
        return -1;  // Si no se encuentra el nombre
    }
}
