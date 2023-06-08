package org.example.controller;

import org.example.model.EstacionMetro;
import org.example.model.ModeloTablaEstacionMetro;
import org.example.view.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorEstacion extends MouseAdapter {
    private Ventana view;
    private ModeloTablaEstacionMetro modelo;

    public ControladorEstacion(Ventana view) {
        this.view = view;
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTabla().addMouseListener(this);
        modelo = new ModeloTablaEstacionMetro();
        this.view.getTabla().setModel(modelo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            this.view.getTabla().updateUI();
        }
        if (e.getSource() == view.getBtnAgregar()) {
            System.out.println("Evento sobre boton agregar");
            EstacionMetro estacion = new EstacionMetro();
            estacion.setId(Integer.parseInt(this.view.getTxtId().getText()));
            estacion.setNombre(this.view.getTxtNombre().getText());
            estacion.setLinea(this.view.getTxtLinea().getText());
            estacion.setColor(this.view.getTxtColor().getText());
            estacion.setUbicacion(this.view.getTxtUbicacion().getText());
            estacion.setUrl(this.view.getTxtUrl().getText());
            if (modelo.agregar(estacion)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTabla().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la BD, por favor revise su conexion",
                        "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();
        }

        if (e.getSource() == view.getBtnEliminar()) {
            System.out.println("Evento sobre boton eliminar");
            int selectedRow = view.getTabla().getSelectedRow();
            if (selectedRow != -1) {
                EstacionMetro estacion = modelo.getEstacionAtIndex(selectedRow);
                if (modelo.eliminar(Integer.parseInt(String.valueOf(estacion.getId())))) {
                    JOptionPane.showMessageDialog(view, "Se eliminó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    modelo.cargarDatos();
                    view.getTabla().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo eliminar de la BD, por favor revise su conexión",
                            "Error al eliminar", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Seleccione un registro para eliminar",
                        "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == view.getTabla()) {
            System.out.println("Evento sobre la tabla");
            int index = this.view.getTabla().getSelectedRow();
            EstacionMetro tmp = modelo.getEstacionAtIndex(index);
            try {
                this.view.getImage().setIcon(tmp.getImagen());
                this.view.getImage().setText("");
            } catch (MalformedURLException mfue) {
                System.out.println(e.toString());
            }
        }
    }
}