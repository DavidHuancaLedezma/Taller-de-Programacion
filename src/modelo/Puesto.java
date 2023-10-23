/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * 
 */
public class Puesto{
    private int idPuesto;
    private String puesto;
    
    public Puesto(){
    }
    
    public Puesto(String puesto){
        this.puesto  = puesto;
    }
    
    public String getPuesto(){
        return puesto;
    }
    
    public void setPuesto(String puesto){
        this.puesto = puesto;
    }
    public void setIdPuesto(int idPuesto){
        this.idPuesto = idPuesto;
    }
    public int getIdPuesto(){
        return idPuesto;
    }
    
    
    //El metodo de abajo es para convertir la direccion de memoria en String
    @Override
    public String toString(){
        return getPuesto();
    }
   
}
