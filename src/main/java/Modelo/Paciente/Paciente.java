/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Paciente;

public class Paciente {

    private int id_paciente;

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private String fecha_nac;
    private String celular;
    private String lugar_trabajo;
    private String antecedentes;
    private String alergico;
    private String medicamento;
    private int rela_sexo;
    private int rela_obra_social;
    private String responsable;
    private String domicilio;
    private String desc_obraSocial;

    public String getDesc_obraSocial() {
        return desc_obraSocial;
    }

    public void setDesc_obraSocial(String desc_obraSocial) {
        this.desc_obraSocial = desc_obraSocial;
    }
    
    
    
    

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getRela_obra_social() {
        return rela_obra_social;
    }

    public void setRela_obra_social(int rela_obra_social) {
        this.rela_obra_social = rela_obra_social;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLugar_trabajo() {
        return lugar_trabajo;
    }

    public void setLugar_trabajo(String lugar_trabajo) {
        this.lugar_trabajo = lugar_trabajo;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getRela_sexo() {
        return rela_sexo;
    }

    public void setRela_sexo(int rela_sexo) {
        this.rela_sexo = rela_sexo;
    }

    public int getRela_Obra_social() {
        return rela_obra_social;
    }

    public void setRela_Obra_social(int obra_social) {
        this.rela_obra_social = obra_social;
    }

}
