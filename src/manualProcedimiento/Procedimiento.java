/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualProcedimiento;

/**
 *
 * @author DavidH
 */
public class Procedimiento {
    private int idProcedimiento;
    private String nombreProcedimiento;

    public Procedimiento(int idProcedimiento, String nombreProcedimiento) {
        this.idProcedimiento = idProcedimiento;
        this.nombreProcedimiento = nombreProcedimiento;
    }

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }

    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }
    
    @Override
    public String toString(){
        return nombreProcedimiento;
    }
    
    
}
