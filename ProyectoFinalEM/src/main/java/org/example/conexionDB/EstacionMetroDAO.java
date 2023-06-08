package org.example.conexionDB;

import org.example.model.EstacionMetro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EstacionMetroDAO implements InterfazDAO{

    public EstacionMetroDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO estacionesMetro(nombre, linea, color, ubicacion, url) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("estacionesMetroCDMX.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((EstacionMetro)obj).getNombre());
        pstm.setString(2, ((EstacionMetro)obj).getLinea());
        pstm.setString(3, ((EstacionMetro)obj).getColor());
        pstm.setString(4, ((EstacionMetro)obj).getUbicacion());
        pstm.setString(5, ((EstacionMetro)obj).getUrl());
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE estacionesMetro SET nombre = ?, linea = ?, color = ?, ubicacion = ?, url = ? WHERE id = ?; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("estacionesMetroCDMX.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((EstacionMetro)obj).getNombre());
        pstm.setString(2, ((EstacionMetro)obj).getLinea());
        pstm.setString(3, ((EstacionMetro)obj).getColor());
        pstm.setString(4, ((EstacionMetro)obj).getUbicacion());
        pstm.setString(5, ((EstacionMetro)obj).getUrl());
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM estacionesMetro WHERE id = ?; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("estacionesMetroCDMX.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM estacionesMetro";
        ArrayList<EstacionMetro> resultado = new ArrayList<>();
        Statement stm = ConexionSingleton.getInstance("estacionesMetroCDMX.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new EstacionMetro(rst.getInt(1),  rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM estacionesMetro WHERE id = ? ;";
        EstacionMetro estacionM = null;
        PreparedStatement pstm = ConexionSingleton.getInstance("estacionesMetroCDMX.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if(rst.next()){
            estacionM = new EstacionMetro(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
            return estacionM;
        }
        return null;
    }
}

