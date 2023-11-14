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
    private int idDepartamento;
    public DepartamentoRecursivo(){
    }
    
    public DepartamentoRecursivo(String departamento){
        this.departamento  = departamento;
    }
    public DepartamentoRecursivo(String departamento, int idDepartamento){
        this.departamento  = departamento;
        this.idDepartamento = idDepartamento;
    }
    
    public String getDepartamentoRecursivo(){
        return departamento;
    }
    public int getIdDepartamento(){
        return idDepartamento;
    }
    public void setIdDepartamento(int idDepartamento){
        this.idDepartamento = idDepartamento;
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
