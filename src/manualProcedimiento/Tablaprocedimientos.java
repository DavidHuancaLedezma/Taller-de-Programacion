/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manualProcedimiento;

/**
 *
 * @author HP
 */
public class Tablaprocedimientos {
    private int ordenlista;
    private String nombreinterventor;
    private String descripcionprocedimiento;
    
    public Tablaprocedimientos(int ordenlista,String nombreinterventor, String descripcionprocedimiento){
        this.ordenlista=ordenlista;
        this.nombreinterventor=nombreinterventor;
        this.descripcionprocedimiento=descripcionprocedimiento;

    }
    public int getOrdenlista(){
        return ordenlista;
    }
    public void setOrdenlista(int ordenlista){
        this.ordenlista=ordenlista;
    }
    
     public String getNombreinterventor(){
        return nombreinterventor;
    }
    public void setNombreinterventor(String nombreinterventor){
        this.nombreinterventor=nombreinterventor;
    }
     public String getDescripcionprocedimiento(){
        return descripcionprocedimiento;
    }
    public void setDescripcionprocedimiento(String descripcionprocedimiento){
        this.descripcionprocedimiento=descripcionprocedimiento;
    }
}
