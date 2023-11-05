/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Experiencia {
    private int codExperiencia;
    private String descripcionExperiencia;
    
    public Experiencia(){
        
    }
    
    public void setCodExperiencia(int codExperiencia){
        this.codExperiencia = codExperiencia;
    }
    
    public void setDescripcionExperiencia(String descripcionExperiencia){
        this.descripcionExperiencia = descripcionExperiencia;
    }
    public int getCodExperiencia(){
        return codExperiencia;
    }
    
    public String getdescripcionExperiencia(){
        return descripcionExperiencia;
    }
}
