/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class miConexion {

    private String url;
    private String usuario;
    private String password;

    private static Connection conexion = null;

    public miConexion(String url, String usr, String pass) {
        this.url = url;
        usuario = usr;
        password = pass;
    }

    public Connection buscarConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println("Conexión establecida.");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Error de conexión: " + ex.getMessage());
            }
        }
        return conexion;
    }
}

