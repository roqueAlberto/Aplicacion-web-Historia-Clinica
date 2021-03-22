/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consulta.Consulta;
import Modelo.Consulta.ConsultaDAOImpl;
import Modelo.ObraSocial.ObraSocialDAOImpl;
import Modelo.Paciente.Paciente;
import Modelo.Paciente.PacienteDAOImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Paciente.IPacienteDAO;
import Modelo.ObraSocial.IObraSocialDAO;
import Modelo.Consulta.IConsultaDAO;
import java.util.ArrayList;

/**
 *
 * @author Roque
 */
@WebServlet(name = "Servidor", urlPatterns = {"/Servidor"})
public class Servidor extends HttpServlet {

    //Clases de negocio
    Paciente paciente = new Paciente();
    Consulta consulta = new Consulta();

    //Instanciacion objetos DAO
    IObraSocialDAO obrasocial_dao = new ObraSocialDAOImpl();
    IPacienteDAO paciente_dao = new PacienteDAOImpl();
    IConsultaDAO consulta_dao = new ConsultaDAOImpl();

    //Lista de obras sociales
    List l_osocial = obrasocial_dao.listar();

    //Lista de sexos
    List l_sexo = paciente_dao.listarSexo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("AddPaciente")) {

            switch (accion) {

                case "Agregar":

                    //Captura de datos del nuevo paciente
                    String nombre_p = request.getParameter("nombre");
                    String apellido_p = request.getParameter("apellido");
                    String dni = request.getParameter("dni");
                    String fecha_nac = request.getParameter("f_nacimiento");
                    String celular = request.getParameter("celular");
                    String domicilio = request.getParameter("domicilio");
                    String lugar_trabajo = request.getParameter("lugar_trabajo");
                    String antecedentes = request.getParameter("antecedentes");
                    String alergico = request.getParameter("alergico");
                    String medicamentos = request.getParameter("medicamentos");
                    String responsable = request.getParameter("responsable");
                    int obra_s = Integer.parseInt(request.getParameter("obra_social"));

                    int sexo = Integer.parseInt(request.getParameter("sexo"));

                    //Calculo de edad
                    int edad = paciente_dao.calcularEdad(fecha_nac);

                    String[] datos = {celular, domicilio, lugar_trabajo, antecedentes, alergico, medicamentos, responsable};

                    //Recorrer aquellos datos en vacio y asignarles null
                    for (int i = 0; i < datos.length; i++) {

                        if (datos[i].equals("")) {

                            datos[i] = null;
                        }
                    }

                    //Agrega datos al objeto Paciente
                    paciente.setApellido(apellido_p);
                    paciente.setNombre(nombre_p);
                    paciente.setDni(dni);
                    paciente.setFecha_nac(fecha_nac);
                    paciente.setEdad(edad);
                    paciente.setCelular(datos[0]);
                    paciente.setDomicilio(datos[1]);
                    paciente.setLugar_trabajo(datos[2]);
                    paciente.setAntecedentes(datos[3]);

                    paciente.setMedicamento(datos[5]);
                    paciente.setResponsable(datos[6]);
                    paciente.setId_sexo(sexo);
                    paciente.obra_social.setId_social(obra_s);

                    paciente_dao.agregar(paciente);

                    request.getRequestDispatcher("Servidor?menu=AddPaciente&accion=default").forward(request, response);

                    break;

                default:

                    //===Listar Sexo===
                    request.setAttribute("lista_sexo", l_sexo);
                    //==========

                    //===Listar Obra Social===      
                    request.setAttribute("lista_osocial", l_osocial);
                    //========

                    request.getRequestDispatcher("/Add_Paciente.jsp").forward(request, response);
            }

        }

        if (menu.equals("Consulta")) {

            Paciente pc;

            switch (accion) {

                case "Buscar_paciente":

                    //Capturar DNI para busqueda
                    String buscar_paciente = request.getParameter("buscar_dni");

                    //Asignacion del paciente buscado
                    pc = paciente_dao.getPaciente(buscar_paciente);

                    String descripcion;

                    //Si el paciente no existe en la base de datos...
                    if (pc.getId_paciente() != 0) {

                        descripcion = pc.getApellido() + " " + pc.getNombre();

                    } else {

                        descripcion = "";

                    }

                    //Envio de datos
                    request.setAttribute("edad_paciente", pc.getEdad());
                    request.setAttribute("descripcion_paciente", descripcion);
                    request.setAttribute("id_paciente", pc.getId_paciente());
                    request.setAttribute("dni_paciente", pc.getDni());

                    List listar_historial = consulta_dao.listar(pc.getId_paciente());
                    request.setAttribute("listar_h", listar_historial);

                    //Total de visitas realizadas por el paciente
                    int visitas = paciente_dao.contarVisitas(pc.getId_paciente());
                    request.setAttribute("visitas", visitas);

                    request.getRequestDispatcher("Servidor?menu=Consulta&accion=default").forward(request, response);

                    listar_historial.clear();

                    break;

                case "Guardar_consulta":

                    String motivo = request.getParameter("motivo");
                    String observacion = request.getParameter("observacion");
                    String receta = request.getParameter("receta");

                    String[] informacion_paciente = {motivo, observacion, receta};

                    //Recorrer y aquellos datos en vacio  asignarles null
                    for (String informacion : informacion_paciente) {

                        if (informacion.equals("")) {

                            informacion = null;
                        }
                    }

                    consulta.setMotivo(motivo);
                    consulta.setObservacion(observacion);
                    consulta.setReceta(receta);
                    consulta.procesarPaciente(paciente);
                    consulta.setFecha(this.getFechaFormatoLatino());

                    consulta_dao.agregar(consulta);

                    request.getRequestDispatcher("Servidor?menu=Consulta&accion=default").forward(request, response);

                    break;

                default:

                    //Actualizacion de edad de pacientes
                    paciente_dao.getFechaNacimiento();
                    paciente_dao.actualizarEdad();

                    request.getRequestDispatcher("/index.jsp").forward(request, response);

            }

        }

        if (menu.equals("Ficha_paciente")) {

            switch (accion) {

                case "Actualizar":

                    String nombre_update = request.getParameter("nombre");
                    String apellido_update = request.getParameter("apellido");
                    String dni_update = request.getParameter("dni");
                    String fechaNac_update = request.getParameter("fecha_n");
                    int genero_update = Integer.parseInt(request.getParameter("sexo"));
                    int obraS_update = Integer.parseInt(request.getParameter("obra_social"));

                    String domicilio_update = request.getParameter("domicilio");
                    String celular_update = request.getParameter("telefono");
                    String lugarTrabajo_update = request.getParameter("lugar_trabajo");
                    String antecedentes_update = request.getParameter("antecedentes");
                    String alergias_update = request.getParameter("alergia");
                    String medicamentos_update = request.getParameter("receta");
                    String responsable_update = request.getParameter("responsable");

                    int ed = paciente_dao.calcularEdad(fechaNac_update);
                    int id = Integer.parseInt(request.getParameter("id_paciente"));

                    Paciente persona = new Paciente();

                    persona.setNombre(nombre_update);
                    persona.setApellido(apellido_update);
                    persona.setDni(dni_update);
                    persona.setFecha_nac(fechaNac_update);
                    persona.setId_sexo(genero_update);
                    persona.obra_social.setId_social(obraS_update);
                    persona.setDomicilio(domicilio_update);
                    persona.setCelular(celular_update);
                    persona.setLugar_trabajo(lugarTrabajo_update);
                    persona.setAntecedentes(antecedentes_update);
                    persona.setAlergia(alergias_update);
                    persona.setMedicamento(medicamentos_update);
                    persona.setResponsable(responsable_update);
                    persona.setEdad(ed);
                    persona.setId_paciente(id);

                    paciente_dao.update(persona);

                    request.getRequestDispatcher("/Consulta.jsp").forward(request, response);

                    break;

                default:

                    // Recibiendo 'id' desde la vista Lista_pacientes
                    int id_paciente = Integer.parseInt(request.getParameter("id_p"));

                    request.setAttribute("id", id_paciente);

                    //====Enlistar sexo y obra Social 
                    request.setAttribute("lista_osocial", l_osocial);
                    request.setAttribute("lista_sexo", l_sexo);

                    //===================    
                    //Enviar ficha del paciente desde el servidor
                    Paciente p = paciente_dao.getPaciente(id_paciente);
                    request.setAttribute("apellido_f", p.getApellido());
                    request.setAttribute("nombre_f", p.getNombre());
                    request.setAttribute("dni_f", p.getDni());
                    request.setAttribute("fechaNac_f", p.getFecha_nac());
                    request.setAttribute("celular_f", p.getCelular());
                    request.setAttribute("domicilio_f", p.getDomicilio());
                    request.setAttribute("genero_f", p.getId_sexo());
                    request.setAttribute("direccionTrabajo_f", p.getLugar_trabajo());
                    request.setAttribute("antecedentes_f", p.getAntecedentes());
                    request.setAttribute("alergias_f", p.getAlergia());
                    request.setAttribute("receta_f", p.getMedicamento());
                    request.setAttribute("responsable_f", p.getResponsable());
                    request.setAttribute("obraSocial_f", p.obra_social.getId_social());

                    request.getRequestDispatcher("/Ficha_Paciente.jsp").forward(request, response);

            }

        }

        if (menu.equals("Lista_Pacientes")) {

            //==Listar pacientes==
            ArrayList lista_pacientes = paciente_dao.listar();

            request.setAttribute("pacientes", lista_pacientes);

            //===================
            //=====Obtener cantidad varones y mujeres===
            int cantidad_mujeres = paciente_dao.contarMujeres();
            request.setAttribute("cantidad_mujeres", cantidad_mujeres);

            int cantidad_hombres = paciente_dao.contarVarones();
            request.setAttribute("cantidad_hombres", cantidad_hombres);

            request.getRequestDispatcher("/Lista_Paciente.jsp").forward(request, response);

        }

    }

    public String getFechaActualIngles() {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        String fecha_actual = formato.format(fecha);

        return fecha_actual;
    }

    public String getFechaFormatoLatino() {

        Date fecha = new Date();
        SimpleDateFormat formato_simple = new SimpleDateFormat("dd-MM-YYYY");
        String fecha_simple = formato_simple.format(fecha);

        return fecha_simple;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
