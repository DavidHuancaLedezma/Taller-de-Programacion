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
    
    
    
}
