package edu.fiuba.algo3.modelo.Tarot;

public class TarotODT {
    String nombre;
    String descripcion;
    int puntos;
    float multiplicador;
    String sobre;
    String ejemplar;

    public TarotODT(){}

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPuntos() {
        return puntos;
    }

    public float getMultiplicador() {
        return multiplicador;
    }

    public String getSobre() {
        return sobre;
    }

    public String getEjemplar() {
        return ejemplar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public void setEjemplar(String ejemplar) {
        this.ejemplar = ejemplar;
    }
}