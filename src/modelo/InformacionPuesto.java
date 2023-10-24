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
 * @author Erick
 * Esta clase nos ayuda a generar los puesto de trabajo que estan libres
 * Si desean pueden usar esta clase es facil para poder generar el combo box
 */
public class InformacionPuesto {
 //Podemos llevar a otra clase los otros 2 
    private ResultSet resultado;
    private PreparedStatement ps; //Variable para ejecutar consultas.
    private Connection con;
public ArrayList<Puesto> getListaPuestosDisponibles(){
        ArrayList <Puesto> puestos = new ArrayList();
        Puesto puesto;
        
        try{

            con = new Conexion().getConexion();
            ps = con.prepareStatement("select IdPuesto,nombrepuesto from puestotrabajo \n" +"where not exists (select nombrepuesto from funcionario where puestotrabajo.idpuesto = funcionario.idpuesto) and nombrepuesto != 'Junta Directiva'");
            resultado = ps.executeQuery();
            while(resultado.next()){
                puesto = new Puesto();
                puesto.setPuesto(resultado.getString("nombrepuesto"));
                puesto.setIdPuesto(resultado.getInt("IdPuesto"));
                puestos.add(puesto);
                
            }
        }catch(Exception ex){
        
        }
       

        return puestos;
    }
/*
El siguiente metodo lo que hace es solo realizar la consulta de todos lo puestos de trabajos
*/
public ArrayList<Puesto> getlistaPuesto(){
    ArrayList <Puesto> puestos = new ArrayList();
    Puesto puesto = null;
    try{
        con = new Conexion().getConexion();
            ps = con.prepareStatement("select nombrepuesto from puestotrabajo ");
            resultado = ps.executeQuery();
            while(resultado.next()){
                puesto = new Puesto();
                puesto.setPuesto(resultado.getString("nombrepuesto"));
                puestos.add(puesto);
                
            }
        }catch(Exception ex){
        
        }
    return puestos;
    }
}


