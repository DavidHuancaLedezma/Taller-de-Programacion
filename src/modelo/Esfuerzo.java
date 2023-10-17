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
public class Esfuerzo {
    private String tipoDeEsfuerzo;
    private String descripcionEsfuerzo;
    
    
    public Esfuerzo(String tipoDeEsfuerzo,String descripcionEsfuerzo){
        this.tipoDeEsfuerzo = tipoDeEsfuerzo;
        this.descripcionEsfuerzo = descripcionEsfuerzo;
    }
    
    public String getTipoEsfuerzo(){
        return tipoDeEsfuerzo;//r
    }
    
    public String getDescripcionEsfuerzo(){
        return descripcionEsfuerzo;
    }
    
    public void setTipoEsfuerzo(String tipoDeEsfuerzo){
        this.tipoDeEsfuerzo = tipoDeEsfuerzo;
    }
    
    public void setDescripcionEsfuerzo(String descripcionEsfuerzo){
        this.descripcionEsfuerzo = descripcionEsfuerzo;
    }
}
