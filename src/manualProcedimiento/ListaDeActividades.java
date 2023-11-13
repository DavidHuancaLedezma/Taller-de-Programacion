
package manualProcedimiento;

public class ListaDeActividades {
    private int idLista ; 
    private int idInterventor ; 
    private int ordenLista ; 
    private String descripcionDeActividad ; 
    public ListaDeActividades(){
        
    }

    public ListaDeActividades(int idLista, int idInterventor, int ordenLista, String descripcionDeActividad) {
        this.idLista = idLista;
        this.idInterventor = idInterventor;
        this.ordenLista = ordenLista;
        this.descripcionDeActividad = descripcionDeActividad;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdInterventor() {
        return idInterventor;
    }

    public void setIdInterventor(int idInterventor) {
        this.idInterventor = idInterventor;
    }

    public int getOrdenLista() {
        return ordenLista;
    }

    public void setOrdenLista(int ordenLista) {
        this.ordenLista = ordenLista;
    }

    public String getDescripcionDeActividad() {
        return descripcionDeActividad;
    }

    public void setDescripcionDeActividad(String descripcionDeActividad) {
        this.descripcionDeActividad = descripcionDeActividad;
    }
    
    
}
