/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Cursada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursadaData {

    private Connection con;

    public CursadaData(miConexion conexion) {
        this.con = conexion.buscarConexion();
    }

    public void guardarCursada(Cursada c) {
        String sql = "INSERT INTO cursada (idAlumno, idMateria, nota, asist, cursa) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdAlumno());
            ps.setInt(2, c.getIdMateria());
            ps.setFloat(3, c.getNota());
            ps.setFloat(4, c.getAsist());
            ps.setInt(5, c.getCursa());
            ps.executeUpdate();
            ps.close();
            System.out.println("Cursada guardada.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar cursada: " + ex.getMessage());
        }
    }
    public List<Cursada> listarCursadas() {
    List<Cursada> lista = new ArrayList<>();
    String sql = "SELECT * FROM cursada";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Cursada c = new Cursada(
                    rs.getInt("idCursada"),
                    rs.getInt("idAlumno"),
                    rs.getInt("idMateria"),
                    rs.getFloat("nota"),
                    rs.getFloat("asist"),
                    rs.getInt("cursa")
            );
            lista.add(c);
        }

        rs.close();
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al listar cursadas: " + ex.getMessage());
    }

    return lista;
}

}
