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
public class Verificador {
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    public boolean campoUsuarioLleno(String usuario){
        boolean res = false;
        if(!usuario.equals("")){
            res = true;
        }
        return res;
    }
    
    public boolean campoContraseñaLleno(char []contraseña){
        boolean res = false;
        if(contraseña.length>0){
            res = true;
        }
        return res;
    }
    
    public boolean existeCuenta(String usuario,char []contraseña){
        boolean res = false;
        String contra = "";
        
        for(int i=0;i<contraseña.length;i++){
            contra += contraseña[i];
        }
        
        res = verificarEnBD(usuario,contra);
        
        return res;
    }
    
    private boolean verificarEnBD(String usuario,String contraseña){
        boolean res = false;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select * from cuenta where usuario = ? and contraseña = ?");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            if(rs.next()){
                res = true;
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    
}
