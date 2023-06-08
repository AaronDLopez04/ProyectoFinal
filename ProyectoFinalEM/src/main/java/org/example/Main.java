package org.example;

import org.example.controller.ControladorEstacion;
import org.example.view.Ventana;

public class Main {
    public static void main(String[] args) {
        Ventana view = new Ventana("Estaciones del Metro de la Ciudad de México");
        ControladorEstacion controller = new ControladorEstacion(view);
    }
}