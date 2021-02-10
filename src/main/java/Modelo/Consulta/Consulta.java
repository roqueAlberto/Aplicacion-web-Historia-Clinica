/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Consulta;

/**
 *
 * @author Roque
 */
public class Consulta {
    
    private String motivo;
    private String observacion;
    private String receta;
    private int rela_pac;
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public int getRela_pac() {
        return rela_pac;
    }

    public void setRela_pac(int rela_pac) {
        this.rela_pac = rela_pac;
    }
    
    
    
}
