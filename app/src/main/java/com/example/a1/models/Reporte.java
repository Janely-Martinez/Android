package com.example.a1.models;

public class Reporte {
    private int id;
    private String nombre;
    private String email;
    private String fecha;
    private String reporte;
    private String geo;

    public Reporte() {
    }

    public Reporte(int id, String nombre, String email, String fecha, String reporte, String geo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fecha = fecha;
        this.reporte = reporte;
        this.geo = geo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }
}
