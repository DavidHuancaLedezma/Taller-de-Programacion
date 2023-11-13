/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manualProcedimiento;

/**
 *
 * @author HP
 */
public class Interventores {
    //private int idinterventor;
    private String nombreinterventor;
    public Interventores(){
    
    }
    public void setNombreinterventor(String nombreinterventor){
        this.nombreinterventor = nombreinterventor;
    }
    public String getNombrenterventor(){
        return nombreinterventor;
    }
    /*public void setIdinterventor(int idinterventor){
        this.idinterventor = idinterventor;
    }
    public int getIdinterventor(){
        return idinterventor;
    }*/
    @Override
    public String toString(){
        return nombreinterventor;
    }
}
