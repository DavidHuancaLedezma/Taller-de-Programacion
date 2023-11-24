
package manualProcedimiento;


public class InterventorSU {
    private int idInterventor ; 
    private int idProcedimiento;
    private String nombreInterventor; 
    public InterventorSU(){
        
    }

    public InterventorSU(int idInterventor, int idProcedimiento, String nombreInterventor) {
        this.idInterventor = idInterventor;
        this.idProcedimiento = idProcedimiento;
        this.nombreInterventor = nombreInterventor;
    }

    public int getIdInterventor() {
        return idInterventor;
    }

    public void setIdInterventor(int idInterventor) {
        this.idInterventor = idInterventor;
    }

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getNombreInterventor() {
        return nombreInterventor;
    }

    public void setNombreInterventor(String nombreInterventor) {
        this.nombreInterventor = nombreInterventor;
    }
    @Override
    public String toString(){
        return nombreInterventor;
    }
    
}
