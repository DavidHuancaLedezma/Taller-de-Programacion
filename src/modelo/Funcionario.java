/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DavidH
 */
public class Funcionario {
    private PreparedStatement ps;
    private ResultSet rs;
    private String usuario;
    private String contraseña;
    
    public Funcionario(String usuario,String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    public String getNombre(){
        String res = "";
        res = nombreBD();
        return res;
    }
    
    private String nombreBD(){
        String res = "";
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select f.NOMBRE from funcionario as f,login as l where f.ID_FUNCIONARIO = l.ID_FUNCIONARIO and l.USUARIO = ? and l.CONTRASENA = ?");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            if(rs.next()){
                res = rs.getString("NOMBRE");
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
        
        return res;
    }
    
}
