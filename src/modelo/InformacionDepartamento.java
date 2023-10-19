/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Anthony
 */
public class InformacionDepartamento {
    private ResultSet resultado;
    private PreparedStatement ps; //Variable para ejecutar consultas.
    private Connection con;
    
    public ArrayList<DepartamentoRecursivo> getListaDepartamentos(){
        ArrayList <DepartamentoRecursivo> departamentos = new ArrayList();
        DepartamentoRecursivo departamento = null;
        
        try{

            con = new Conexion().getConexion();
            ps = con.prepareStatement("select NOMBREDEPARTAMENTO from departamento");
            resultado = ps.executeQuery();
            while(resultado.next()){
                departamento = new DepartamentoRecursivo();
                departamento.setDepartamentoRecursivo(resultado.getString("NOMBREDEPARTAMENTO"));
                departamentos.add(departamento);
                
            }
        }catch(Exception ex){
             
        }
       

        return departamentos;
    } 
}
