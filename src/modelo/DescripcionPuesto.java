/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 * Esta clase servira para intentar hacer automatizaciones 
 */
    
public class DescripcionPuesto {
    PreparedStatement ps,psAux; 
    ResultSet rs,rsAux;
    int idDescripcionPuesto =0;
    private javax.swing.JTextArea jTextArea1;
    
public void insertarDescripcionPuesto(int idPuesto){
        try {
            java.sql.Connection conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(" insert into DescripcionPuesto(IdPuesto) values(?)");
            ps.setInt(1, idPuesto);
            ps.executeUpdate();
            ps.close();
            psAux = conexion.prepareStatement("SELECT MAX(IdDescripcionPuesto) FROM DescripcionPuesto");
            rsAux = psAux.executeQuery();
            if (rsAux.next()) {
              idDescripcionPuesto = rsAux.getInt(1); // Obtener el valor de la columna 1 (la única columna en este caso)
            }
            conexion.close();
            
            JOptionPane.showMessageDialog(null,"datos registrados correctamente");
            
            }catch (Exception ex ){
                System.err.println("Error:" + ex);
            }
    }

    /**
    * Prueba extraña
    */
    public int getIdDescripcionPuesto(){
        return idDescripcionPuesto;
        }

public void insertarExperiencia(int idDescripcionPuesto,String textoExperiencia){
    
    try{
        
        Connection conexion = new Conexion().getConexion();
        ps = conexion.prepareStatement("insert into Experiencia (descripcionExperiencia,IdDescripcionPuesto) values(?,?)");
        ps.setString(1,textoExperiencia);
        ps.setInt(2, idDescripcionPuesto);
        ps.executeUpdate();
        ps.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
    }
public void insertarHabilidadDestreza(int idDescripcionPuesto, String DatoHabilidadDestreza){
try{
          java.sql.Connection conexion = new Conexion().getConexion();
        ps= conexion.prepareStatement("insert into HabilidadDestreza (DatoHabilidadDestreza,IdDescripcionPuesto) values(?,?)");
        ps.setString(1,DatoHabilidadDestreza);
        ps.setInt(2, idDescripcionPuesto);
        ps.executeUpdate();
            ps.close();
        }catch(Exception ex){
          System.err.println("Error:" + ex);
        }
}
    public void insertarEscolaridad(int idDescripcionPuesto, String textoEscolaridad){
        try{
          java.sql.Connection conexion = new Conexion().getConexion();
        ps= conexion.prepareStatement("insert into escolaridad (IdDescripcionPuesto,datoescolaridad) values(?,?)");
        ps.setString(2,textoEscolaridad);
        ps.setInt(1, idDescripcionPuesto);
        ps.executeUpdate();
        ps.close();
        }catch(Exception ex){
          System.err.println("Error:" + ex);
        }
        
    }

    public void insertarAptitudes(int idDescripcionPuesto,String nombreAptitud){
    try{
        java.sql.Connection conexion = new Conexion().getConexion();
        ps = conexion.prepareStatement("insert into aptitudes(IdDescripcionPuesto,NOMBREAAPTITUD) values(?,?)");
        ps.setInt(1, idDescripcionPuesto);
        ps.setString(2, nombreAptitud);
        ps.executeUpdate();
        ps.close();
        }catch(Exception ex){
            System.err.print("Eroor:"+ex);
        }
    }
    public void insertarEsfuerzo(int idDescripcionPuesto, String tipoEsfuerzo, String descripcionPuesto){
        try{
        Connection conexion = new Conexion().getConexion();
        ps = conexion.prepareStatement("insert into esfuerzo(IdDescripcionPuesto,TipoDeEsfuerzo,DESCRIPCIONDELESFUERZO) values(?,?,?)");
        ps.setInt(1, idDescripcionPuesto);
        ps.setString(2,tipoEsfuerzo);
        ps.setString(3, descripcionPuesto);
        ps.executeUpdate();
        ps.close();
        }catch(Exception ex){
            System.err.print("Eroor:"+ex);
        } 
    }
}

