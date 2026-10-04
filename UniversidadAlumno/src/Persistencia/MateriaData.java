/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MateriaData {

    private Connection con;

    public MateriaData(miConexion conexion) {
        this.con = conexion.buscarConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, estado) VALUES (?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getEstado());
            ps.executeUpdate();
            ps.close();
            System.out.println("Materia guardada.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar materia: " + ex.getMessage());
        }
    }
    public List<Materia> listarMaterias() {
    List<Materia> lista = new ArrayList<>();
    String sql = "SELECT * FROM materia";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Materia m = new Materia(
                    rs.getInt("idMateria"),
                    rs.getString("nombre"),
                    rs.getInt("estado")
            );
            lista.add(m);
        }

        rs.close();
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al listar materias: " + ex.getMessage());
    }

    return lista;
}

}
