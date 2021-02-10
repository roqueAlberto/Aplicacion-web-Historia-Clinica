/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consulta.Consulta;
import Modelo.Consulta.ConsultaDAO;
import Modelo.Consulta.ConsultaDAOImpl;
import Modelo.ObraSocial.ObraSocialDAO;
import Modelo.ObraSocial.ObraSocialDAOImpl;
import Modelo.Paciente.Paciente;
import Modelo.Paciente.PacienteDAO;
import Modelo.Paciente.PacienteDAOImpl;
import Modelo.Sexo.SexoDAO;
import Modelo.Sexo.SexoDaoImpl;
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

/**
 *
 * @author Roque
 */
@WebServlet(name = "Servidor", urlPatterns = {"/Servidor"})
public class Servidor extends HttpServlet {

    //>>>Fecha ACTUAL<<<<
    Date fecha = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
    String fecha_actual = formato.format(fecha);

    //Clases de negocio
    Paciente paciente = new Paciente();
    Consulta consulta = new Consulta();

    //Instanciacion objetos DAO
    SexoDAO sexo_dao = new SexoDaoImpl();
    ObraSocialDAO obrasocial_dao = new ObraSocialDAOImpl();
    PacienteDAO pac_dao = new PacienteDAOImpl();
    ConsultaDAO con_dao = new ConsultaDAOImpl();

    //Lista de obras sociales
    List l_osocial = obrasocial_dao.listar();

    //Lista de sexos
    List l_sexo = sexo_dao.listar();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("AddPaciente")) {

            switch (accion) {

                case "Agregar":
                    String nombre_p = request.getParameter("nombre");
                    String apellido_p = request.getParameter("apellido");
                    String dni = request.getParameter("dni");
                    String fecha_nac = request.getParameter("f_nacimiento");

                    int edad = pac_dao.calcularEdad(fecha_nac);

                    String celular;

                    if (request.getParameter("celular").equals("")) {

                        celular = null;
                    } else {
                        celular = request.getParameter("celular");
                    }

                    String domicilio;
                    if (request.getParameter("domicilio").equals("")) {

                        domicilio = null;

                    } else {

                        domicilio = request.getParameter("domicilio");
                    }

                    String lugar_work;

                    if (request.getParameter("lugar_trabajo").equals("")) {
                        lugar_work = null;
                    } else {

                        lugar_work = request.getParameter("lugar_trabajo");
                    }

                    String antecedentes;

                    if (request.getParameter("antecedentes").equals("")) {
                        antecedentes = null;

                    } else {

                        antecedentes = request.getParameter("antecedentes");
                    }

                    String alergico;

                    if (request.getParameter("alergico").equals("")) {
                        alergico = null;
                    } else {
                        alergico = request.getParameter("alergico");
                    }

                    String medicamentos;

                    if (request.getParameter("medicamentos").equals("")) {
                        medicamentos = null;

                    } else {

                        medicamentos = request.getParameter("medicamentos");
                    }

                    String responsable;

                    if (request.getParameter("responsable").equals("")) {
                        responsable = null;

                    } else {

                        responsable = request.getParameter("responsable");
                    }

                    int obra_s = Integer.parseInt(request.getParameter("obra_social"));
                    int sexo = Integer.parseInt(request.getParameter("sexo"));

                    //===Agrega datos al objeto Paciente==
                    paciente.setApellido(apellido_p);
                    paciente.setNombre(nombre_p);
                    paciente.setDni(dni);
                    paciente.setFecha_nac(fecha_nac);
                    paciente.setEdad(edad);
                    paciente.setCelular(celular);
                    paciente.setDomicilio(domicilio);
                    paciente.setLugar_trabajo(lugar_work);
                    paciente.setAntecedentes(antecedentes);
                    paciente.setAlergico(alergico);
                    paciente.setMedicamento(medicamentos);
                    paciente.setResponsable(responsable);
                    paciente.setRela_sexo(sexo);
                    paciente.setRela_Obra_social(obra_s);

                    pac_dao.agregar(paciente);

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

            switch (accion) {

                case "Buscar_paciente":

                    //Buscar paciente atraves de su dni
                    String buscar_dni = request.getParameter("buscar_dni");

                    Paciente pc = pac_dao.buscar(buscar_dni);

                    String nom = pc.getNombre();
                    String ape = pc.getApellido();
                    String mostrar;

                    if (nom == null && ape == null) {

                        mostrar = "No hay resultados del paciente";
                        request.setAttribute("edad_paciente", " ");

                    } else {

                        mostrar = ape + " " + nom;
                        request.setAttribute("edad_paciente", pc.getEdad());

                    }

                    request.setAttribute("descripcion_paciente", mostrar);
                    request.setAttribute("id_paciente", pc.getId_paciente());
                    request.setAttribute("dni_paciente", pc.getDni());

                    List listar_historial = con_dao.listar(pc.getId_paciente());

                    request.setAttribute("listar_h", listar_historial);

                    //Total de visitas realizadas por el paciente
                    int visitas = pac_dao.contarVisitas(pc.getId_paciente());

                    request.setAttribute("visitas", visitas);

                    //---------------------
                    request.getRequestDispatcher("/Consulta.jsp").forward(request, response);

                    listar_historial.clear();

                    break;

                case "Guardar_consulta":

                    int id_pac = Integer.parseInt(request.getParameter("id_p"));
                    String motivo = request.getParameter("motivo");
                    String observacion;
                    if (request.getParameter("observacion").equals("")) {

                        observacion = null;
                    } else {

                        observacion = request.getParameter("observacion");
                    }

                    String receta;
                    if (request.getParameter("receta").equals("")) {

                        receta = null;
                    } else {

                        receta = request.getParameter("receta");

                    }

                    consulta.setMotivo(motivo);
                    consulta.setObservacion(observacion);
                    consulta.setReceta(receta);
                    consulta.setRela_pac(id_pac);
                    consulta.setFecha(fecha_actual);

                    con_dao.agregar(consulta);

                    request.getRequestDispatcher("/Consulta.jsp").forward(request, response);

                    break;

                default:

                    //Actualizacion de edad
                    pac_dao.getFechaNacimiento();
                    pac_dao.actualizarEdad();

                    request.getRequestDispatcher("/Consulta.jsp").forward(request, response);

            }

        }

        if (menu.equals("Ficha_paciente")) {

            switch (accion) {

                case "Actualizar":

                    String nom = request.getParameter("nom");
                    String ape = request.getParameter("ape");
                    String dn = request.getParameter("dn");
                    String fecha_n = request.getParameter("fecha_n");
                    int sex = Integer.parseInt(request.getParameter("sexo"));
                    int obra = Integer.parseInt(request.getParameter("obra_social"));

                    String dom;

                    if (request.getParameter("dom").equals("")) {
                        dom = null;
                    } else {

                        dom = request.getParameter("dom");
                    }

                    String cel;

                    if (request.getParameter("cel").equals("")) {

                        cel = null;
                    } else {

                        cel = request.getParameter("cel");
                    }

                    String lugar_t;
                    if (request.getParameter("lugar_t").equals("")) {

                        lugar_t = null;
                    } else {

                        lugar_t = request.getParameter("lugar_t");
                    }

                    String antec;

                    if (request.getParameter("antec").equals("")) {

                        antec = null;

                    } else {

                        antec = request.getParameter("antec");
                    }

                    String aler;

                    if (request.getParameter("aler").equals("")) {

                        aler = null;
                    } else {

                        aler = request.getParameter("aler");
                    }

                    String med;

                    if (request.getParameter("med").equals("")) {

                        med = null;
                    } else {

                        med = request.getParameter("med");

                    }

                    String res;

                    if (request.getParameter("res").equals("")) {

                        res = null;
                    } else {

                        res = request.getParameter("res");
                    }

                    int ed = pac_dao.calcularEdad(fecha_n);
                    int id = Integer.parseInt(request.getParameter("id_paciente"));

                    Paciente persona = new Paciente();

                    persona.setNombre(nom);
                    persona.setApellido(ape);
                    persona.setDni(dn);
                    persona.setFecha_nac(fecha_n);
                    persona.setRela_sexo(sex);
                    persona.setRela_Obra_social(obra);
                    persona.setDomicilio(dom);
                    persona.setCelular(cel);
                    persona.setLugar_trabajo(lugar_t);
                    persona.setAntecedentes(antec);
                    persona.setAlergico(aler);
                    persona.setMedicamento(med);
                    persona.setResponsable(res);
                    persona.setEdad(ed);
                    persona.setId_paciente(id);

                    pac_dao.update(persona);

                    request.getRequestDispatcher("/Consulta.jsp").forward(request, response);

                    break;

                default:

                    int id_pacient = Integer.parseInt(request.getParameter("id_p"));

                    request.setAttribute("id", id_pacient);

                    //====Enlistar sexo y obra Social 
                    request.setAttribute("lista_osocial", l_osocial);
                    request.setAttribute("lista_sexo", l_sexo);

                    //===================    
                    //Enviar ficha del paciente desde el servidor
                    Paciente p = pac_dao.getPaciente(id_pacient);
                    request.setAttribute("ape", p.getApellido());
                    request.setAttribute("nom", p.getNombre());
                    request.setAttribute("dn", p.getDni());
                    request.setAttribute("fecha_n", p.getFecha_nac());
                    request.setAttribute("cel", p.getCelular());
                    request.setAttribute("dom", p.getDomicilio());
                    request.setAttribute("sex", p.getRela_sexo());
                    request.setAttribute("lugar_t", p.getLugar_trabajo());
                    request.setAttribute("antec", p.getAntecedentes());
                    request.setAttribute("aler", p.getAlergico());
                    request.setAttribute("med", p.getMedicamento());
                    request.setAttribute("res", p.getResponsable());
                    request.setAttribute("obra_s", p.getRela_Obra_social());

                    request.getRequestDispatcher("/Ficha_Paciente.jsp").forward(request, response);

            }

        }

        if (menu.equals("Lista_Pacientes")) {

            //==Listar pacientes==
            List pa = pac_dao.listar();

            request.setAttribute("pacientes", pa);

            //===================
            //=====Obtener cantidad varones y mujeres===
            int cantidad_m = pac_dao.contarMujeres();
            request.setAttribute("cantidad_m", cantidad_m);

            int cantidad_v = pac_dao.contarVarones();
            request.setAttribute("cantidad_v", cantidad_v);

            request.getRequestDispatcher("/Lista_Paciente.jsp").forward(request, response);

        }

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
