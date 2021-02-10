/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Paciente;

import java.util.List;

/**
 *
 * @author Roque
 */
public interface PacienteDAO {

    //Metodos
    List listar();

    public void update(Paciente p);

    public Paciente buscar(String dni);

    public void agregar(Paciente pac);

    public int contarMujeres();

    public int contarVarones();

    public int contarVisitas(int id);

    public void actualizarEdad();

    public Paciente getPaciente(int id);

    public int calcularEdad(String f_nac);

    public void getFechaNacimiento();

}
