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
public class OperationPolicy {
    private int idPoliticaOpracion;
    private String descripcion;

    public OperationPolicy(int idPoliticaOpracion, String descripcion) {
        this.idPoliticaOpracion = idPoliticaOpracion;
        this.descripcion = descripcion;
    }

    public int getIdPoliticaOpracion() {
        return idPoliticaOpracion;
    }

    public void setIdPoliticaOpracion(int idPoliticaOpracion) {
        this.idPoliticaOpracion = idPoliticaOpracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
}
