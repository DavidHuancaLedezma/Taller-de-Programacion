/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DavidH
 */
public class Conexion {
    private String URL = "jdbc:mysql://localhost:33065/taller_de_programcion_beta4?autoReconnet=true&useSSL=false"; // corregir con datos originales
    private String usuario = "root";  // usuario por defecto
    private String password = ""; // la base de datos del xampp no tiene contraseña

    public Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) (DriverManager.getConnection(URL, usuario, password));
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
        }
        return conexion;
    }
    
    
}
