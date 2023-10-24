/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DavidH
 */
public class FuncionGeneral {
    private int idFuncion;
    private String descripcionFG;

    public FuncionGeneral(int idFuncion, String descripcionFG) {
        this.idFuncion = idFuncion;
        this.descripcionFG = descripcionFG;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getDescripcionFG() {
        return descripcionFG;
    }

    public void setDescripcionFG(String descripcionFG) {
        this.descripcionFG = descripcionFG;
    }
    
    @Override 
    public String toString(){
        return descripcionFG;
    }
    
}