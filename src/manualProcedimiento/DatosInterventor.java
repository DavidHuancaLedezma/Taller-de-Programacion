/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manualProcedimiento;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;

/**
 *
 * @author HP
 */
public class DatosInterventor {
    private PreparedStatement ps;
    private ResultSet rs;
    public  String obtenerNombredeInterventor(int idInterventor){
        String nombreInterventor=null;
        try{
            Connection con = new Conexion().getConexion();
            ps=con.prepareStatement("select  NOMBREINTERVENTOR from interventores where IDINTERVENTOR=?");
            ps.setInt(1, idInterventor);
            rs = ps.executeQuery();
            if(rs.next()){
                nombreInterventor=rs.getString("NOMBREINTERVENTOR");
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
            ex.printStackTrace();
        }
        return nombreInterventor;
    }
}
