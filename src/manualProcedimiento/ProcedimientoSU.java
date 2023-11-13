
package manualProcedimiento;

public class ProcedimientoSU {
    private int  idProcedimiento ;
    private int idDepartamento ; 
    private String nombreProcedimiento ; 
    private String objetivoProcedimiento ; 
    
    public ProcedimientoSU(){
        
    }

    public ProcedimientoSU(int idProcedimiento, int idDepartamento, String nombreProcedimiento, String objetivoProcedimiento) {
        this.idProcedimiento = idProcedimiento;
        this.idDepartamento = idDepartamento;
        this.nombreProcedimiento = nombreProcedimiento;
        this.objetivoProcedimiento = objetivoProcedimiento;
    }

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }

    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    public String getObjetivoProcedimiento() {
        return objetivoProcedimiento;
    }

    public void setObjetivoProcedimiento(String objetivoProcedimiento) {
        this.objetivoProcedimiento = objetivoProcedimiento;
    }
    
    
}
