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
public class FuncionEspecifica {
    private int idFuncionEspecifica;
    private String descripcionFE;

    public FuncionEspecifica(int idFuncionEspecifica, String descripcionFE) {
        this.idFuncionEspecifica = idFuncionEspecifica;
        this.descripcionFE = descripcionFE;
    }

    public int getIdFuncionEspecifica() {
        return idFuncionEspecifica;
    }

    public void setIdFuncionEspecifica(int idFuncionEspecifica) {
        this.idFuncionEspecifica = idFuncionEspecifica;
    }

    public String getDescripcionFE() {
        return descripcionFE;
    }

    public void setDescripcionFE(String descripcionFE) {
        this.descripcionFE = descripcionFE;
    }
    
    @Override
    public String toString(){
        return descripcionFE;
    }
    
}