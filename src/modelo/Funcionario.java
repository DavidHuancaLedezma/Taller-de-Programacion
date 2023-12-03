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
        String nombreF  = "";
        String ciF = "" ; 
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
                 nombreF = nombreFuncionario;
                 ciF = ci;
             crearCuenta(idFuncionario,nombreF,ciF);
            if(resultado > 0 ){
                JOptionPane.showMessageDialog(null,"Funcionario registrado\n"
                        + "Se creo la cuenta del funcionario con los datos siguientes : \n"
                        + "Usuario : "+nombreF+"\n"
                        + "Contraseña : "+ci);
                
            }else{
                JOptionPane.showMessageDialog(null,"Registro incorrecta");
            }
        }catch (Exception ex ){
          System.err.println("Error:" + ex);
        }
    }
    private void crearCuenta(int idFuncionario , String nombreFuncionario , String ci ){
        try{
        Connection conexion = new Conexion().getConexion();
        ps = conexion.prepareStatement("insert into cuenta (IDFUNCIONARIO,USUARIO,CONTRASENA) values(?,?,?)");
        ps.setInt(1,idFuncionario);
        ps.setString(2, nombreFuncionario);
        ps.setString(3, ci);
        ps.executeUpdate();
        ps.close();
        }catch(Exception ex){
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
    
    public int getIdDepartamentoDelFuncionario(){
        int id = 0;
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select dep.IDDEPARTAMENTO as idDep from cuenta c,funcionario f,puestotrabajo pt,departamento dep where c.IDFUNCIONARIO = f.IDFUNCIONARIO and f.IDPUESTO = pt.IDPUESTO and dep.IDDEPARTAMENTO = pt.IDDEPARTAMENTO and c.USUARIO = ? and c.CONTRASENA = ?");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt("idDep");
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return id;
    }
    
    public ArrayList<Subordinados> getNombreEidSubordinados(){
        ArrayList<Subordinados>res = new ArrayList<Subordinados>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("SELECT pt_subordinados.NOMBREPUESTO as nombrePuesto,pt_subordinados.IDPUESTO as id\n" +
            "    FROM cuenta c,funcionario f,puestotrabajo pt,puestotrabajo pt_subordinados\n" +
            "    WHERE c.IDFUNCIONARIO = f.IDFUNCIONARIO\n" +
            "    AND f.IDPUESTO = pt.IDPUESTO\n" +
            "    AND pt.IDPUESTO = pt_subordinados.PUE_IDPUESTO\n" +
            "    AND c.usuario = ?\n" +
            "    AND c.contrasena = ?");
            ps.setString(1,usuario);
            ps.setString(2,contraseña);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(new Subordinados(rs.getString("nombrePuesto"),rs.getInt("id")));
            }
            con.close();
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        return res;
    }
    
    
    public ArrayList<String> FuncionGeneralSubordinados(int id){
        ArrayList<String> res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("SELECT DATOFUNCIONGENERAL as datos FROM funciongeneral WHERE IDPUESTO = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("datos"));
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }   
        return res;
    }
   public ArrayList<String> FuncionesEspecificasSubordinados(int id){
       ArrayList<String> res = new ArrayList<String>();
        try{
            Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("SELECT DESCRIPCIONFUNCION as datos FROM funcionespecifica WHERE IDPUESTO = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getString("datos"));
            }
            con.close();
        
        }catch(Exception ex){
            System.err.println("Error:" + ex);
        }   
        return res;
   }
    
    
}
