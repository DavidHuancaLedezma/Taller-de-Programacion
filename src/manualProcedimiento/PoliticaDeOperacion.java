
package manualProcedimiento;


public class PoliticaDeOperacion {
    private int idPolitica ; 
    private int idProcedimiento ; 
    private String descripcionPolitica ; 
    public PoliticaDeOperacion(){
        
    }

    public PoliticaDeOperacion(int idPolitica, int idProcedimiento, String descripcionPolitica) {
        this.idPolitica = idPolitica;
        this.idProcedimiento = idProcedimiento;
        this.descripcionPolitica = descripcionPolitica;
    }

    public int getIdPolitica() {
        return idPolitica;
    }

    public void setIdPolitica(int idPolitica) {
        this.idPolitica = idPolitica;
    }

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getDescripcionPolitica() {
        return descripcionPolitica;
    }

    public void setDescripcionPolitica(String descripcionPolitica) {
        this.descripcionPolitica = descripcionPolitica;
    }
    
}
