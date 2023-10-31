/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manualProcedimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Conexion;

/**
 *
 * @author Usuario
 */
public class Interventor {
    
    String nombreInterventor;
    private ResultSet rs;
    private PreparedStatement ps; //Variable para ejecutar consultas.
    
    public Interventor(){
    
    }
    public void setNombreInterventor(String nombre){
        this.nombreInterventor = nombre;
    }
    public String getNombreInterventor(){
        return nombreInterventor;
    }
    
    
    public ArrayList<String> getInterventores(int idProcedimiento){
    //ArrayList <Interventor> intervenidos = new ArrayList();
    ArrayList<String> intervenidos = new ArrayList<>();
    //Interventor interventor;
    try{
        Connection con = new Conexion().getConexion();
            ps = con.prepareStatement("select NOMBREINTERVENTOR from interventores i, procedimiento p where i.idprocimiento = p.idprocimiento and p.IDPROCIMIENTO = ?");
            ps.setInt(1, idProcedimiento);
            rs = ps.executeQuery();
            while(rs.next()){
                //interventor = new Interventor();
                //interventor.setNombreInterventor(rs.getString("NOMBREINTERVENTOR"));
                //intervenidos.add(interventor);
                intervenidos.add(rs.getString("NOMBREINTERVENTOR"));
            }
            con.close();
        }catch(Exception ex){
        
        }
    return intervenidos;
    }
    
    
}
