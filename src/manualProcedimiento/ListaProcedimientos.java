/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manualProcedimiento;

/**
 *
 * @author HP
 */
public class ListaProcedimientos {
    private String procedimiento;
    
    public ListaProcedimientos(){
    }
    
    public ListaProcedimientos(String procedimiento ){
        this.procedimiento  = procedimiento;
    }
    
    public String getListaProcedimiento(){
        return procedimiento;
    }
    
    public void setListaProcedimiento(String procedimiento){
        this.procedimiento = procedimiento;
    }
    //El metodo de abajo es para convertir la direccion de memoria en String
    @Override
    public String toString(){
        return getListaProcedimiento();
    }   
}
