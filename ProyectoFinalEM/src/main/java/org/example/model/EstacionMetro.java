package org.example.model;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class EstacionMetro {
    private int id;
    private String nombre;
    private String linea;
    private String color;
    private String ubicacion;
    private String url;

    public EstacionMetro() {
    }

    public EstacionMetro(int id, String nombre, String linea, String color, String ubicacion, String url) {
        this.id = id;
        this.nombre = nombre;
        this.linea = linea;
        this.color = color;
        this.ubicacion = ubicacion;
        this.url = url;
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

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EstacionMetro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", linea='" + linea + '\'' +
                ", color='" + color + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(this.url);
        return new ImageIcon(urlImage);
    }
}
