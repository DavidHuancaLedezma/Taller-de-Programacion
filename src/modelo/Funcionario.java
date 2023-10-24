/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DavidH
 */
public class Funcionario {
    private PreparedStatement ps,psAux;
    private ResultSet rs,rsAux;
    private String usuario;
    private String contraseña;
    
    public Funcionario(){
        
    }
    public Funcionario(String usuario,String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    /*
    Inserciones hecho por erick
    */
    public void insercionFuncionario(String nombreFuncionario,int IdPuesto,String ci, String telefono,Date fecha){
    try {
             java.sql.Connection conexion = new Conexion().getConexion();
             ps = conexion.prepareStatement("insert into funcionario (nombreFuncionario,IdPuesto,CI,telefono,fechaNacimiento)values(?,?,?,?,?)");
             ps.setString(1,nombreFuncionario);
             ps.setInt(2,IdPuesto);
             ps.setString(3, ci);
             ps.setString(4,telefono);
             ps.setDate(5,fecha);
             int resultado = ps.executeUpdate();
            psAux = conexion.prepareStatement("SELECT MAX(IDFUNCIONARIO) FROM FUNCIONARIO");
            rsAux = psAux.executeQuery();
            int idFuncionario = 0; 
            if (rsAux.next()) {
                idFuncionario = rsAux.getInt(1); // Obtener el valor de la columna 1 (la única columna en este caso)
            }
            conexion.close();
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
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
    
    public String getDepartamentoSuperior(){
        String res = "";
        res = departamentoSuperiorBD();
        return res;
    }
    
    public ArrayList<String> getPersonalBajoSuMando(){
        return personalBajoSuMandoBD();
    }
    
    public ArrayList<String>getEstudiosAcademicos(){
        return estudiosAcademicosBD();
    }
    
    public ArrayList<String>getCargosOficialesDesempeñados(){
        return cargosOficialesDesempeñadosBD();
    }
    
    public ArrayList<String>getActividadesDocentes(){
        return actividadesDocenteBD();
    }
    
    public ArrayList<String>getActividadesProfesionales(){
        return actividadesProfesionalesBD();
    }
    public ArrayList<String>getFuncionGeneralBD(){
        return FuncionGeneralBD();
    }
     public ArrayList<String> getFuncionesEspecificasBD(){
        return FuncionesEspecificasBD();
    }
     
    public ArrayList<String>getEscolaridad(){
        return escolaridadBD();
    }
    
    public ArrayList<String> getExperiencia(){
        return experienciaBD();
    }
    
    public ArrayList<String> getHabilidades(){
        return habilidadesBD();
    }
    
    public ArrayList<String> getAptitudes(){
        return aptitudesBD();
    }
    
    public ArrayList<Esfuerzo> getEsfuerzo(){
        return esfuerzoBD();
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
    
    private String departamentoSuperiorBD(){
        String res = "";
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_departamento_superior(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            if(rs.next()){
                res = rs.getString("NOMBREDEPARTAMENTO");
            }else{
                res = "Ninguno!";
            }
        }catch(Exception ex){
            System.out.println("Error:" + ex);
        }
        
        
        return res;
    
    
    }
    
    
    private ArrayList<String>estudiosAcademicosBD(){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_estudios_academicos(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("estudios_academicos"));
            }
        }catch(Exception ex){
            System.out.println("Error:" + ex);
        }
        return res;
    }
    
    private ArrayList<String>cargosOficialesDesempeñadosBD(){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_cargos_oficiales_desempeñados(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("cargos_oficiales_desempeñados"));
            }
        }catch(Exception ex){
            System.out.println("Error:" + ex);
        }
        return res;
    }
    
    private ArrayList<String>actividadesDocenteBD(){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_actividades_docente(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("actividades_docente"));
            }
        }catch(Exception ex){
            System.out.println("Error:" + ex);
        }
        return res;
    }
    
    
    private ArrayList<String>actividadesProfesionalesBD(){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_actividades_profecionales(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("actividades_profecionales"));
            }
        }catch(Exception ex){
            System.out.println("Error:" + ex);
        }
        return res;
    }
      private ArrayList<String> FuncionGeneralBD(){
        ArrayList<String> res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_funcion_general(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("funcion_general"));
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }   
        return res;
    }
   public ArrayList<String> FuncionesEspecificasBD(){
       ArrayList<String> res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_funciones_especificas(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("funciones_especificas"));
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }   
        return res;
   }
   
   public ArrayList<String>escolaridadBD(){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_escolaridad(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("escolaridad"));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    public ArrayList<String>experienciaBD(){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_experiencia(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("experiencia"));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    public ArrayList<String>habilidadesBD(){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_habilidades_de_destreza(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("habilidades"));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    public ArrayList<String>aptitudesBD(){
        ArrayList<String>res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_aptitudes(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("aptitudes"));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    public ArrayList<Esfuerzo>esfuerzoBD(){
        ArrayList<Esfuerzo>res = new ArrayList<Esfuerzo>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("call sp_esfuerzo(?,?)");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                Esfuerzo esfuerzo = new Esfuerzo(rs.getString("tipo_de_esfuerzo"),rs.getString("esfuerzo"));
                res.add(esfuerzo);
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
}
