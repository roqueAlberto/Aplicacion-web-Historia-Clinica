/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Paciente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roque
 */
public interface IPacienteDAO {

    //Metodos
    public ArrayList<Paciente> listar();

    public void update(Paciente p);

    public Paciente getPaciente(String dni);

    public void agregar(Paciente pac);

    public int contarMujeres();

    public int contarVarones();

    public int contarVisitas(int id);

    public void actualizarEdad();

    public Paciente getPaciente(int id);

    public int calcularEdad(String f_nac);

    public void getFechaNacimiento();

    public List listarSexo();

}
