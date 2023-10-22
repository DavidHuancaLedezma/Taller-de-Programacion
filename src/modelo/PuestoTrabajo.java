/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author AlexanderH-DELUX
 */
public class PuestoTrabajo {
    private int idPuesto;
    private String nombrePuesto;

    public PuestoTrabajo(int idPuesto, String nombrePuesto) {
        this.idPuesto = idPuesto;
        this.nombrePuesto = nombrePuesto;
    }

    public int getIdPuesto(){
        return idPuesto;
    
    }
    
    public String getNombrePuesto(){
        return nombrePuesto;
    
    }
    
    public void setIdPuesto(int id){
        idPuesto = id;
    
    }
    
    public void setNombrePuesto(String nombre){
        nombrePuesto = nombre;
    
    }
    
    @Override
    public String toString(){
        return nombrePuesto;
    
    }
    
    
    @Override
    public boolean equals(Object otroObjeto) {
        if (this == otroObjeto) return true;
        if (otroObjeto == null || getClass() != otroObjeto.getClass()) return false;
        PuestoTrabajo otro = (PuestoTrabajo) otroObjeto;
        return idPuesto == otro.idPuesto &&
               Objects.equals(nombrePuesto, otro.nombrePuesto);
    }
    
}
