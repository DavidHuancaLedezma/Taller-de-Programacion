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
import javax.swing.JOptionPane;
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
    
    public ArrayList<String>objetivos(int idDepartamento,int idProcedimiento){
    ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select * from procedimiento p, departamento d " +
"where   d.IDDEPARTAMENTO = p.IDDEPARTAMENTO and d.IDDEPARTAMENTO = "+idDepartamento +
                    " AND p.IDPROCIMIENTO = "+idProcedimiento);
            
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
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    public boolean eliminarPoliticaOperacion(int idPolitica){
        boolean res = false;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("delete from politicasdeoperacion where IDPOLITICA = ?");
            ps.setInt(1,idPolitica);
            if(ps.executeUpdate()>0){
                res = true;
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    public ArrayList<InterventorSU>getInterventoreslistaActividades(int idProcedimiento){
        ArrayList<InterventorSU>res = new ArrayList();
        InterventorSU interventor=null;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select interventores.IDINTERVENTOR,interventores.NOMBREINTERVENTOR from procedimiento join interventores on procedimiento.IDPROCIMIENTO=interventores.IDPROCIMIENTO where procedimiento.IDPROCIMIENTO=? ");   
            ps.setInt(1,idProcedimiento);
            rs = ps.executeQuery();
            while(rs.next()){
                interventor = new InterventorSU();
                interventor.setIdInterventor(rs.getInt("IDINTERVENTOR"));
                interventor.setNombreInterventor(rs.getString("NOMBREINTERVENTOR"));
                res.add(interventor);
                
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    public void eliminarActividad(int idActividad) {
    try {
        Connection con = new Conexion().getConexion();
        ps = con.prepareStatement("DELETE FROM listadeactividades WHERE IDLISTA = ?");
        ps.setInt(1, idActividad);
        ps.executeUpdate();
        con.close();
        JOptionPane.showMessageDialog(null, "Actividad eliminada");
        
    } catch (Exception ex) {
        System.err.println("Error: " + ex);
    }
    }
    public void actualizarActividad(int idActividad, String nuevaDescripcion, int nuevoOrden) {
    try {
        Connection con = new Conexion().getConexion();
        ps = con.prepareStatement("UPDATE listadeactividades SET DESCRIPCIONDEACTIVIDAD=?, ORDENLISTA=? WHERE IDLISTA = ?");
        ps.setString(1, nuevaDescripcion);
        ps.setInt(2, nuevoOrden);
        ps.setInt(3, idActividad);
        ps.executeUpdate();
        con.close();
        JOptionPane.showMessageDialog(null, "Actividad actualizada");
    } catch (Exception ex) {
        System.err.println("Error: " + ex);
    }
}
    public void actualizarIdInterventorActividad(int idActividad, int nuevoIdInterventor) {
    try {
        Connection con = new Conexion().getConexion();
        ps = con.prepareStatement("UPDATE listadeactividades SET IDINTERVENTOR=? WHERE IDLISTA = ?");
        ps.setInt(1, nuevoIdInterventor);
        ps.setInt(2, idActividad);
        ps.executeUpdate();
        con.close();
    } catch (Exception ex) {
        System.err.println("Error: " + ex);
    }
}
public ArrayList<ListaDeActividades> obtenerDatosDeLaListaDeActividades(int idProcedimiento){
        ArrayList<ListaDeActividades> listadeActividades=new ArrayList<ListaDeActividades>();
        try{
            Connection con = new Conexion().getConexion();
            ps=con.prepareStatement("select la.IDLISTA,la.ORDENLISTA,i.IDINTERVENTOR,la.DESCRIPCIONDEACTIVIDAD from procedimiento p inner join interventores i on  p.IDPROCIMIENTO= i.IDPROCIMIENTO inner  join listadeactividades la on i.IDINTERVENTOR= la.IDINTERVENTOR where p.IDPROCIMIENTO=? order by la.ORDENLISTA asc");
            ps.setInt(1, idProcedimiento);
            rs = ps.executeQuery();
            while(rs.next()){
                ListaDeActividades lista=new ListaDeActividades();
                lista.setIdLista(rs.getInt("la.IDLISTA"));
                lista.setOrdenLista(rs.getInt("la.ORDENLISTA"));
                lista.setIdInterventor(rs.getInt("i.IDINTERVENTOR"));
                lista.setDescripcionDeActividad(rs.getString("la.DESCRIPCIONDEACTIVIDAD"));
                listadeActividades.add(lista);
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
         return listadeActividades;
    }
}
