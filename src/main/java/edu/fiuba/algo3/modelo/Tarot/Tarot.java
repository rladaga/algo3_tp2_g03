package edu.fiuba.algo3.modelo.Tarot;

public class Tarot {
    protected String nombre;
    protected String descripcion;

    public Tarot(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
