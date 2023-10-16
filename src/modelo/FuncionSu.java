/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;


/**
 *
 * @author Usuario
 */
public class FuncionSu {
    //variable para hacer las consultas 
    PreparedStatement ps;    
    //Nos ayudara para las consultas
    ResultSet rs;
    //variables 
    JTextField jTextField2;
    JTextField jTextField1;
    JTextField jTextField3;
    JTextField jTextField4;
    JTextField jTextField5;
    public void insertarFu(){
        Conexion con = new Conexion();
        try{
        Connection exitosa = con.getConexion();
        ps = exitosa.prepareStatement("insert into funcionario (nombreFuncionario,idPuesto,telefono,fechaNacimiento)values(?,?,?,?)");
        ps.setString(1, jTextField2.getText());
        
        }catch(Exception ex){
            System.out.println("Eroor, "+ex);
        }

    }
}
