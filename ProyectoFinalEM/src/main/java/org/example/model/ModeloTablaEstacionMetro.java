package org.example.model;

import org.example.conexionDB.EstacionMetroDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaEstacionMetro implements TableModel {
    public static final int COLS = 6;
    ArrayList<EstacionMetro> datos;
    private EstacionMetroDAO emdao;

    public ModeloTablaEstacionMetro() {
        emdao = new EstacionMetroDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaEstacionMetro(ArrayList<EstacionMetro> datos, EstacionMetroDAO emdao) {
        this.datos = datos;
        this.emdao = emdao;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String columnName = "";
        switch (columnIndex) {
            case 0:
                columnName = "ID";
                break;
            case 1:
                columnName = "Nombre";
                break;
            case 2:
                columnName = "Linea";
                break;
            case 3:
                columnName = "Color";
                break;
            case 4:
                columnName = "Ubicación";
                break;
            case 5:
                columnName = "Foto (Url)";
                break;
            default:
                columnName = "";
        }
        return columnName;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EstacionMetro tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getLinea();
            case 3:
                return tmp.getColor();
            case 4:
                return tmp.getUbicacion();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId((Integer) aValue);
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setLinea((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setColor((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setUbicacion((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public boolean agregar(EstacionMetro estacion) {
        boolean resultado = false;
        try {
            if (emdao.insertar(estacion)) {
                datos.add(estacion);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public EstacionMetro getEstacionAtIndex(int idx) {
        return datos.get(idx);
    }

    public void cargarDatos() {
        try {
            ArrayList<EstacionMetro> tirar = emdao.obtenerTodo();
            datos = emdao.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
    public boolean eliminar(int id) {
        boolean resultado = false;
        try {
            resultado = emdao.delete("id");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}