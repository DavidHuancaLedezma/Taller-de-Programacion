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
public class DatosPuestoTrabajo {
    
    
    private PreparedStatement ps;
    private ResultSet rs;
    private int idDepartamento = 1;
    
    public DatosPuestoTrabajo(){
    
    }
    public DatosPuestoTrabajo(int idDepartamento){
        this.idDepartamento = idDepartamento;
    }
    
    public ArrayList<Departamento>getDepartamentos(){
        ArrayList<Departamento>res = new ArrayList<Departamento>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select * from departamento");
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(new Departamento(rs.getInt("IDDEPARTAMENTO"),rs.getString("NOMBREDEPARTAMENTO")));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    
    public ArrayList<PuestoTrabajo>getPuestosTrabajo(){
        ArrayList<PuestoTrabajo>res = new ArrayList<PuestoTrabajo>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select * from puestotrabajo where IDDEPARTAMENTO = ?");
            ps.setInt(1,idDepartamento);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(new PuestoTrabajo(rs.getInt("IDPUESTO"),rs.getString("NOMBREPUESTO"))); 
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
        
        
        
        return res;
    }
    
    
    public void insertarPuesto(String nombrePuesto,int idPuestoSuperior,int departamentoAlQuePertenece){
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("insert into puestotrabajo(PUE_IDPUESTO,IDDEPARTAMENTO,NOMBREPUESTO)values(?,?,?)");
            ps.setInt(1,idPuestoSuperior);
            ps.setInt(2,departamentoAlQuePertenece);
            ps.setString(3,nombrePuesto);
            if(ps.executeUpdate()>0){
                System.out.println("insertado con exito puesto de trabajo");
            
            }
            con.close();
            
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
    }
    
    public int getIdUltimoPuestoInsertado(){
        int id = 0;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select MAX(IDPUESTO) as idP from puestotrabajo");
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt("idP");
            
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
        return id;
    
    }
    
    
    public void insertarFuncionesEspesificas(int idPuesto,String descripcion){
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("insert into funcionespecifica(IDPUESTO,DESCRIPCIONFUNCION)values(?,?)");
            ps.setInt(1, idPuesto);
            ps.setString(2, descripcion);
            if(ps.executeUpdate()>0){
                System.out.println("se registro con exito las F.E");
            
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
    
    
    }
    
    
    public void insertarFuncionGeneral(int idPuesto,String funcionGeneral){
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("insert into funciongeneral(IDPUESTO,DATOFUNCIONGENERAL)values(?,?)");
            ps.setInt(1, idPuesto);
            ps.setString(2, funcionGeneral);
            if(ps.executeUpdate()>0){
                System.out.println("se registro con exito las F.G");
            
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
    
    
    }
    
    
    public ArrayList<PuestoTrabajo>getAllPuestosTrabajo(){
        ArrayList<PuestoTrabajo>res = new ArrayList<PuestoTrabajo>(); //implementar
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select * from puestotrabajo");
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("IDPUESTO")!=28){  // JUNTA DIRECTIVA NO ES UN PUESTO DE TRABAJO
                   res.add(new PuestoTrabajo(rs.getInt("IDPUESTO"),rs.getString("NOMBREPUESTO"))); 
                }
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
        return res;
    }
    
    public boolean actualizarNombreDepartamento(String nombre,int idPuesto){  //implementar
        boolean res = false;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("update puestotrabajo set nombrepuesto = ? where idpuesto = ?");
            ps.setString(1, nombre);
            ps.setInt(2, idPuesto);
            if(ps.executeUpdate()>0){
                res = true;
                System.out.println("Se actualizo con exito");
            }
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    
    
    }
    
    
    public Departamento getDepartamento(int id){
        Departamento dep = null;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select dep.IDDEPARTAMENTO,dep.NOMBREDEPARTAMENTO from puestotrabajo as pt, departamento as dep where pt.IDDEPARTAMENTO = dep.IDDEPARTAMENTO and pt.IDPUESTO = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                dep = new Departamento(rs.getInt("IDDEPARTAMENTO"),rs.getString("NOMBREDEPARTAMENTO"));
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
        return dep;
    }
    
    public PuestoTrabajo getPuestoSuperior(int id){
       PuestoTrabajo pt = null;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select IDPUESTO, NOMBREPUESTO from puestotrabajo where IDPUESTO = (select PUE_IDPUESTO from puestotrabajo where IDPUESTO = ?)");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                pt = new PuestoTrabajo(rs.getInt("IDPUESTO"),rs.getString("NOMBREPUESTO"));
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        
        }
        return pt;
    }
    
    public boolean actualizarDepartamentoPertenece(int idNuevoDepartamento,int idPuesto){
        boolean res = false;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("update puestotrabajo set IDDEPARTAMENTO = ? where idpuesto = ?");
            ps.setInt(1, idNuevoDepartamento);
            ps.setInt(2, idPuesto);
            if(ps.executeUpdate()>0){
                res = true;
                System.out.println("Se actualizo con exito");
            }
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    
    
    }
    
    public boolean actualizarJefeSuperior(int idNuevoJefe,int idPuesto){
        boolean res = false;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("update puestotrabajo set PUE_IDPUESTO = ? where idpuesto = ?");
            ps.setInt(1, idNuevoJefe);
            ps.setInt(2, idPuesto);
            if(ps.executeUpdate()>0){
                res = true;
                System.out.println("Se actualizo con exito");
            }
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    
    
    }
    
    
    
    
    public ArrayList<FuncionGeneral> getFuncinesGenerales(int id){
        ArrayList<FuncionGeneral>res = new ArrayList<FuncionGeneral>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select fg.IDFUNCION,fg.DATOFUNCIONGENERAL as descripcion from puestotrabajo as pt, funciongeneral as fg where pt.IDPUESTO = fg.IDPUESTO and pt.IDPUESTO = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(new FuncionGeneral(rs.getInt("IDFUNCION"),rs.getString("descripcion")));
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    
    
    
    
    public ArrayList<FuncionEspecifica> getFuncinesEspecificas(int id){
        ArrayList<FuncionEspecifica>res = new ArrayList<FuncionEspecifica>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select fe.IDFUNCIONESPECIFICA as id, fe.DESCRIPCIONFUNCION as descripcion from puestotrabajo as pt, funcionespecifica as fe where pt.IDPUESTO = fe.IDPUESTO and pt.IDPUESTO = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(new FuncionEspecifica(rs.getInt("id"),rs.getString("descripcion")));
            }
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    public boolean actualizarFG(String descripcion,int id){
        boolean res = false;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("update funciongeneral set DATOFUNCIONGENERAL = ? where IDFUNCION = ?");
            ps.setString(1, descripcion);
            ps.setInt(2, id);
            if(ps.executeUpdate()>0){
                res = true;
            }
            
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        
        return res;
    
    }
    
    
    public boolean actualizarFE(String descripcion,int id){
        boolean res = false;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("update funcionespecifica set DESCRIPCIONFUNCION = ? where IDFUNCIONESPECIFICA = ?");
            ps.setString(1, descripcion);
            ps.setInt(2, id);
            if(ps.executeUpdate()>0){
                res = true;
            }   
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
 
    
    
}
