/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author AlexanderH-DELUX
 */
public class Departamento {
    private int idDepartamento;
    private String nombreDepartamento;
    
    public Departamento(int idDepartamento,String nombreDepartamento){
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }
    
    public int getIdDepartamento(){
        return idDepartamento;
    }
    
    public String getNombreDepartamento(){
        return nombreDepartamento;
    }
    
    public void setIdDepartamento(int id){
        idDepartamento = id;
    }
    
    public void setNombreDepartamento(String nombre){
        nombreDepartamento = nombre;
    }
    
    @Override
    public String toString(){
        return nombreDepartamento;
    }
    
}
