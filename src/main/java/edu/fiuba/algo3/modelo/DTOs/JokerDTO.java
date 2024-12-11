package edu.fiuba.algo3.modelo.DTOs;

public class JokerDTO {
    private String nombre;
    private String descripcion;
    private String activacion;
    private String parametroActivacion;
    private int puntos;
    private float multiplicador;

    // Constructor
    public JokerDTO(String nombre, String descripcion, String activacion, String parametroActivacion, int puntos, float multiplicador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activacion = activacion;
        this.parametroActivacion = parametroActivacion;
        this.puntos = puntos;
        this.multiplicador = multiplicador;
    }

    public JokerDTO(){}

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getActivacion() {
        return activacion;
    }

    public String getParametroActivacion() {
        return parametroActivacion;
    }

    public int getPuntos() {
        return puntos;
    }

    public float getMultiplicador() {
        return multiplicador;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setActivacion(String activacion) {
        this.activacion = activacion;
    }

    public void setParametroActivacion(String parametroActivacion) {
        this.parametroActivacion = parametroActivacion;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }
}
