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
import javax.swing.table.DefaultTableModel;
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
    
    public ArrayList<String>objetivos(int idDepartamento){
    ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select * from procedimiento p, departamento d " +
"where   d.IDDEPARTAMENTO = p.IDDEPARTAMENTO and d.IDDEPARTAMENTO = "+idDepartamento);
            
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("OBJETIVOPROCEDIMIENTO"));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    public ArrayList<Tablaprocedimientos> cargarLista(int idProcedimiento){
        ArrayList<Tablaprocedimientos> resultado= new ArrayList<Tablaprocedimientos>();
        try{
            Connection con = new Conexion().getConexion();
            ps=con.prepareStatement("select la.ORDENLISTA,i.NOMBREINTERVENTOR,la.DESCRIPCIONDEACTIVIDAD from procedimiento p inner join interventores i on  p.IDPROCIMIENTO= i.IDPROCIMIENTO inner  join listadeactividades la on i.IDINTERVENTOR= la.IDINTERVENTOR where p.IDPROCIMIENTO=? order by la.ORDENLISTA asc");
            ps.setInt(1, idProcedimiento);
            rs = ps.executeQuery();
            while(rs.next()){
                resultado.add(new Tablaprocedimientos(rs.getInt("ORDENLISTA"), rs.getString("NOMBREINTERVENTOR"), rs.getString("DESCRIPCIONDEACTIVIDAD")));
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
         
        return resultado;
    }
    
    
    public ArrayList<ListaProcedimientos>getProcedimientos(){
        ArrayList<ListaProcedimientos>res = new ArrayList();
        ListaProcedimientos procedimiento=null;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select NOMBREPROCEDIMIENTO from procedimiento ");   
            rs = ps.executeQuery();
            while(rs.next()){
                procedimiento = new ListaProcedimientos();
                procedimiento.setListaProcedimiento(rs.getString("NOMBREPROCEDIMIENTO"));
                res.add(procedimiento);
                
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    public ArrayList<Interventores>getInterventores(){
        ArrayList<Interventores>res = new ArrayList();
        Interventores interventor=null;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select NOMBREINTERVENTOR from interventores ");   
            rs = ps.executeQuery();
            while(rs.next()){
                interventor = new Interventores();
                interventor.setNombreinterventor(rs.getString("NOMBREINTERVENTOR"));
                res.add(interventor);
                
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    public ArrayList<OperationPolicy>objetosPoliticasDeOperacion(int idProcedimiento){
        ArrayList<OperationPolicy>res = new ArrayList<OperationPolicy>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select IDPOLITICA as id,DESCRIPCIONPOLITICA as descripcion from politicasdeoperacion where IDPROCIMIENTO = ?");
            ps.setInt(1,idProcedimiento);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(new OperationPolicy(rs.getInt("id"), rs.getString("descripcion")));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        
        return res;
    
    }
    public boolean actualizarPoliticasDeOperacion(String nuevaDescripcion,int idPolitica){
        boolean res = false;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("update politicasdeoperacion set DESCRIPCIONPOLITICA = ? where IDPOLITICA = ?");
            ps.setString(1, nuevaDescripcion);
            ps.setInt(2,idPolitica);
            if(ps.executeUpdate()>0){
                res = true;
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }

}
