/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        res = getDatos()[0];
        return res;
    }
    
    public String getCargoOficial(){
        String res = "";
        res = getDatos()[3];
        return res;
    }
    
    public String getTelefonoOficial(){
        String res = "";
        res = getDatos()[1] + "";
        return res;
    }
    
    public String getFechaDeNacimiento(){
        String res = "";
        res = getDatos()[2];
        return res;
    
    } 
    
    public String getJefeInmediato(){
        String res = "";
        res = getJefeInmediatoBD();
        return res;
    }
    
    public String getDepatamento(){
        String res = "";
        res = getDatos()[4];
        return res;
    }
    
    public ArrayList<String> getPersonalBajoSuMando(){
        return personalBajoSuMandoBD();
    }
    
    private String[] getDatos(){
        String[] res = new String[5];
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_datos_de_la_cuenta(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            if(rs.next()){
                res[0] = rs.getString("nombre");
                res[1] = rs.getString("telefono");
                res[2] = rs.getString("fecha_de_nacimiento");
                res[3] = rs.getString("puesto_de_trabajo");
                res[4] = rs.getString("pertenece_al_departamento");
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
        
        return res;
    }
    
    private String getJefeInmediatoBD(){
        String res = "";
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_jefe_inmediato(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            if(rs.next()){
                res = rs.getString("jefe_inmediato");
            }else{
                res = "Ninguno";
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    
    private ArrayList<String> personalBajoSuMandoBD(){
        ArrayList<String> res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_puestos_subordinados(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("puestos_subordinados"));
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }   
        return res;
    }
      
}
