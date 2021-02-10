<%-- 
    Document   : Add_Paciente
    Created on : 18/01/2021, 23:50:21
    Author     : Roque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Nuevo Paciente</title>
        <meta charset="UTF-8" />
        <meta
            name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
            />

        <link rel="stylesheet" href="./css/bootstrap.min.css" />

        <link rel="stylesheet" href="./css/main.css" />
         <link rel="stylesheet" href="./css/all.min.css" />
    </head>

    <body onload="cagarDatos()">
        <!-- SideBar -->
        <section class="full-box cover dashboard-sideBar">
            <div class="full-box dashboard-sideBar-bg btn-menu-dashboard"></div>
            <div class="full-box dashboard-sideBar-ct">
                <!--SideBar Title -->
                <div
                    class="full-box text-uppercase text-center text-titles dashboard-sideBar-title"
                    >
                    CONSULTORIO
                </div>
                <!-- SideBar User info -->
              <!--  <div class="full-box dashboard-sideBar-UserInfo">
                    <figure class="full-box">
                        <img src="./assets/img/user.png" alt="UserIcon" />
                        <figcaption class="text-center text-titles">
                            Argentino Billordo
                        </figcaption>
                    </figure>
                </div> -->
                <!-- SideBar Menu -->
                <ul class="list-unstyled full-box dashboard-sideBar-Menu">
                    <li>
                        <a href="index.jsp"
                           ><i class="fas fa-stethoscope"></i> Consulta medica</a
                        >
                    </li>
                    <li>
                        <a href="Controlador?menu=Gestion&accion=Listar"
                           ><i class="fas fa-id-card"></i> Pacientes</a
                        >
                    </li>

                    <li>
                        <a href="Servidor?menu=AddPaciente&accion=default">
                            <i class="fas fa-user-plus"></i> Nuevo paciente
                        </a>
                    </li>
                </ul>
            </div>
        </section>

        <!-- Content page-->
        <section class="full-box dashboard-contentPage">
            <!-- NavBar -->
            <nav class="full-box dashboard-Navbar">
                <ul class="full-box list-unstyled text-right">
                    <li class="pull-left">
                        <a href="index.jsp" class="btn-menu-dashboard"
                           ><i class="zmdi zmdi-more-vert"></i
                            ></a>
                    </li>
                </ul>
            </nav>

            <br />
            <br />
            <br />
            <br />

            <div class="col-sm-12">
                <div class="card">
                    <form
                        action="Servidor?menu=Ficha_paciente"
                      
                        method="POST"

                        >
                        <div class="card-body">
                            <div class="form-group d-flex">
                                <div class="col-sm-2">
                                    <label>Apellido </label>
                                    <input
                                        type="text"
                                        name="ape"
                                        class="form-control"
                                        id="ape"
                                        value="${ape}"
                                        
                                        required
                                        />
                                </div>

                                <!--ID PACIENTE-->

                                <input type="hidden" value="${id}" name="id_paciente" id="id_paciente"> 

                                <div class="col-sm-3">
                                    <label>Nombre </label>
                                    <input
                                        type="text"
                                        name="nom"
                                        class="form-control"
                                        id="nom"
                                        value="${nom}"
                                        
                                        required
                                        />
                                </div>

                                <div class="col-sm-2">
                                    <label>DNI</label>
                                    <input
                                        type="text"
                                        name="dn"
                                        class="form-control"
                                        id="dn"
                                        value="${dn}"
                                        required

                                        />
                                </div>

                                <div class="col-sm-3">
                                    <label>Fecha de nacimiento</label>
                                    <input
                                        type="date"
                                        name="fecha_n"
                                        class="form-control"
                                        id="fecha_n"
                                        value="${fecha_n}"
                                        required
                                        />
                                </div>
                            </div>
                                        
                             

                            <div class="form-group d-flex">
                                <div class="col-sm-2">
                                    <label>Sexo</label>
                                    <select class="form-control" name="sexo" id="sexo">
                                        
                                         
                                        
                                        
                                        <c:forEach var="l_sexo" items="${lista_sexo}">
                                            
                                            <c:set var="val" value="${sex}"/>
                                          
                                            <c:choose>
                                                
                                                <c:when test="${l_sexo.getId_sexo() == val}">
                                                    
                                                    <option value="${l_sexo.getId_sexo()}" selected="${l_sexo.getId_sexo()}">${l_sexo.getDesc_sexo()}</option>
                                                    
                                                </c:when>
                                                     
                                                     <c:otherwise>
                                                         
                                                          <option value="${l_sexo.getId_sexo()}" >${l_sexo.getDesc_sexo()}</option>
                                                         
                                                     </c:otherwise>  
                                                
                                                
                                            </c:choose>
                                          
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-sm-3">
                                    <label>Domicilio</label>
                                    <input
                                        type="text"
                                        name="dom"
                                        class="form-control"
                                        id="dom"
                                        value="${dom}"
                                        />
                                </div>

                                <div class="col-sm-2">
                                    <label>Obra Social</label>
                                    <select class="form-control select2" name="obra_social" id="obra_social" >
                                        
                                        <c:forEach var="l_social" items="${lista_osocial}">
                                            
                                            <c:set var="valor" value="${obra_s}"/>
                                          
                                            <c:choose>
                                                
                                                <c:when test="${l_social.getId_social() == valor}">
                                                    
                                                     <option  value="${l_social.getId_social()}" selected="${l_social.getId_social()}">${l_social.getDesc_social()}</option>
                                                    
                                                </c:when>
                                                     
                                                     <c:otherwise>
                                                         
                                                          <option value="${l_social.getId_social()}" >${l_social.getDesc_social()}</option>
                                                         
                                                     </c:otherwise>  
                                                
                                                
                                            </c:choose>
                                          
                                        </c:forEach>
                                        

                                    </select>
                                </div>

                                <div class="col-sm-2">
                                    <label>Celular</label>
                                    <input
                                        type="text"
                                        name="cel"
                                        class="form-control"
                                        id="cel"
                                        value="${cel}"

                                        />
                                </div>
                            </div>

                            <div class="form-group d-flex">
                                <div class="col-sm-3">
                                    <label>Lugar de Trabajo</label>
                                    <input
                                        type="text"
                                        name="lugar_t"
                                        class="form-control"
                                        id="lugar_t"
                                        value="${lugar_t}"
                                        />
                                </div>

                                <div class="col-sm-3">
                                    <label>Antecedentes</label>
                                    <input
                                        type="text"
                                        name="antec"
                                        class="form-control"
                                        id="antec"
                                        value="${antec}"
                                        />
                                </div>

                                <div class="col-sm-3">
                                    <label>Alergico/a</label>
                                    <input
                                        type="text"
                                        name="aler"
                                        class="form-control"
                                        id="aler"
                                        value="${aler}"
                                        />
                                </div>

                                <div class="col-sm-3">
                                    <label>Medicamentos</label>
                                    <input
                                        type="text"
                                        name="med"
                                        class="form-control"
                                        id="med"
                                        value="${med}"
                                        />
                                </div>
                            </div>

                            <div class="form-group d-flex">
                                <div class="col-sm-3">
                                    <label>Persona responsable</label>
                                    <input
                                        type="text"
                                        name="res"
                                        class="form-control"
                                        id="res"
                                        value="${res}"
                                        />
                                </div>
                            </div>



                            <div class="form-group text-center">
                                <div class="col-sm">
                                    <button
                                        type="submit"
                                        name="accion"
                                        value="Actualizar"
                                        class="agregar btn btn-primary"

                                        >
                                        <i class="fas fa-user-edit"></i> Actualizar datos
                                    </button>

                                    
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>

        <!--====== Scripts -->
        <script src="./js/jquery-3.1.1.min.js"></script>
        <script src="./js/sweetalert2.min.js"></script>
        <script
            type="text/javascript"
            src="http://code.jquery.com/jquery.min.js"
        ></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/material.min.js"></script>
        <script src="./js/ripples.min.js"></script>
        <script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="./js/main.js"></script>

        <script>

            function cargarDatos() {

                var id = $("#id_paciente").val();

                $.ajax({

                    url: "Servidor?menu=Ficha_paciente&accion=Date_paciente&id=" + id,
                    type: "GET",
                    datatype: "json",
                    success: function (data) {






                        $("#apellido").val(JSON.parse(data).apellido);
                        $("#nom").val(JSON.parse(data).nom);
                        $("#dn").val(JSON.parse(data).dn);
                        $("#fecha_n").val(JSON.parse(data).fecha_n);
                        $("#cel").val(JSON.parse(data).cel);
                        $("#dom").val(JSON.parse(data).dom);
                        $("#sex").val(JSON.parse(data).sex);
                        $("#lugar_t").val(JSON.parse(data).lugar_t);
                        $("#antec").val(JSON.parse(data).antec);
                        $("#aler").val(JSON.parse(data).aler);
                        $("#med").val(JSON.parse(data).med);
                        $("#res").val(JSON.parse(data).res);
                        $("#obra_s").val(JSON.parse(data).obra_s);




                    }

                });



            }

        </script>
    </body>
</html>