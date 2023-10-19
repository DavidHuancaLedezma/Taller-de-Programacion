/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony
 */
public class DepartamentoRecursivo {
    
    private String departamento;
    
    public DepartamentoRecursivo(){
    }
    
    public DepartamentoRecursivo(String departamento){
        this.departamento  = departamento;
    }
    
    public String getDepartamentoRecursivo(){
        return departamento;
    }
    
    public void setDepartamentoRecursivo(String departamento){
        this.departamento = departamento;
    }
    //El metodo de abajo es para convertir la direccion de memoria en String
    @Override
    public String toString(){
        return getDepartamentoRecursivo();
    }   
}
