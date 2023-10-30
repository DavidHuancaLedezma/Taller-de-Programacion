/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualProcedimiento;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Conexion;

/**
 *
 * @author DavidH
 */

public class DatosProcedimientos {
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    
    public ArrayList<Procedimiento>getProcedimientosDelDepartamento(int idDepartamento){
        ArrayList<Procedimiento>res = new ArrayList<Procedimiento>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select p.IDPROCIMIENTO as id,P.NOMBREPROCEDIMIENTO as nombre from procedimiento p,departamento d where p.IDDEPARTAMENTO = d.IDDEPARTAMENTO and d.IDDEPARTAMENTO = ?");
            ps.setInt(1, idDepartamento);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(new Procedimiento(rs.getInt("id"), rs.getString("nombre")));
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    
    public ArrayList<String>politicaDeOperacion(int idProcedimiento){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select p.DESCRIPCIONPOLITICA as descripcion from politicasdeoperacion p,procedimiento pro where pro.IDPROCIMIENTO = p.IDPROCIMIENTO and pro.IDPROCIMIENTO = ?");
            ps.setInt(1, idProcedimiento);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("descripcion"));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
}
