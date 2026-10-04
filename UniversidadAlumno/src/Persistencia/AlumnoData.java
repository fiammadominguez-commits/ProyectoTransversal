/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class AlumnoData {

    private Connection con;

    public AlumnoData(miConexion conexion) {
        this.con = conexion.buscarConexion();
    }

    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, nombre, fecha, activo) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, alumno.getFecNac());
            ps.setBoolean(4, alumno.isActivo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
            }

            ps.close();
            System.out.println("Guardado!");
        } catch (SQLException ex) {
            System.out.println("Error al guardar alumno: " + ex.getMessage());
        }
    }

    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno(
                        rs.getInt("idAlumno"),
                        rs.getInt("dni"),
                        rs.getString("nombre"),
                        rs.getDate("fecha"),
                        rs.getBoolean("activo")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumno: " + ex.getMessage());
        }

        return alumno;
    }
    
    public List<Alumno> listarAlumnos() {
    List<Alumno> lista = new ArrayList<>();
    String sql = "SELECT * FROM alumno";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Alumno a = new Alumno(
                    rs.getInt("idAlumno"),
                    rs.getInt("dni"),
                    rs.getString("nombre"),
                    rs.getDate("fecha"),
                    rs.getBoolean("activo")
            );
            lista.add(a);
        }

        rs.close();
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al listar alumnos: " + ex.getMessage());
    }

    return lista;
}

}

