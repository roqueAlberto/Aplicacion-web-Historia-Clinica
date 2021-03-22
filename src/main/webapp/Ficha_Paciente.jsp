<%-- 
    Document   : Ficha_Paciente
    Created on : 24/01/2021, 22:00:41
    Author     : Roque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <title>Ficha del paciente</title>

        <!-- Custom fonts for this template-->
        <link
            href="vendor/fontawesome-free/css/all.min.css"
            rel="stylesheet"
            type="text/css"
            />
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet"
            />
        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet" />
    </head>

    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <!-- Sidebar -->
            <ul
                class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
                id="accordionSidebar"
                >
                <!-- Sidebar - Brand -->
                <a
                    class="sidebar-brand d-flex align-items-center justify-content-center"
                    href="index.jsp"
                    >
                    <div class="sidebar-brand-icon">
                        <i class="fas fa-user-md"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Dr. Billordo</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0" />



                <!-- Divider -->
                <hr class="sidebar-divider" />

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a
                        class="nav-link"
                        href="Servidor?menu=Consulta&accion=default"
                        aria-expanded="true"
                        aria-controls="collapseTwo"
                        >
                        <i class="fas fa-stethoscope"></i>
                        <span>Consulta medica</span>
                    </a>
                </li>

                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item ">
                    <a
                        class="nav-link collapsed"
                        href="Servidor?menu=Lista_Pacientes"
                        aria-expanded="true"
                        aria-controls="collapseUtilities"
                        >
                        <i class="fas fa-id-card"></i>
                        <span>Pacientes</span>
                    </a>
                </li>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a
                        class="nav-link collapsed"
                        href="Servidor?menu=AddPaciente&accion=default"
                        aria-expanded="true"
                        aria-controls="collapsePages"
                        >
                        <i class="fas fa-user-plus"></i>
                        <span>Nuevo Paciente</span>
                    </a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block" />

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">
                <!-- Main Content -->
                <div id="content">
                    <!-- Topbar -->
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-2 static-top shadow"
                        >
                        <!-- Sidebar Toggle (Topbar) -->
                        <button
                            id="sidebarToggleTop"
                            class="btn btn-link d-md-none rounded-circle mr-3"
                            >
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">
                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a
                                    class="nav-link dropdown-toggle"
                                    href="#"
                                    id="searchDropdown"
                                    role="button"
                                    data-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                                    >
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div
                                    class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                    aria-labelledby="searchDropdown"
                                    >
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input
                                                type="text"
                                                class="form-control bg-light border-0 small"
                                                placeholder="Search for..."
                                                aria-label="Search"
                                                aria-describedby="basic-addon2"
                                                />
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a
                                    class="nav-link dropdown-toggle"
                                    href="index.jsp"
                                    id="userDropdown"
                                    role="button"
                                    data-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                                    >
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"
                                          >Argentino Billordo</span
                                    >
                                    <img
                                        class="img-profile rounded-circle"
                                        src="img/undraw_profile.svg"
                                        />
                                </a>
                            </li> 
                        </ul>
                    </nav>

                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">

                                <div class="card shadow mb-4">
                                    <form action="Servidor?menu=Ficha_paciente"  method="POST" >

                                        <div
                                            class="card-header py-3 d-flex flex-row align-items-center justify-content-between"
                                            >
                                            <h6 class="m-0 font-weight-bold text-primary">
                                                Ficha del paciente
                                            </h6>
                                            <div class="dropdown no-arrow">
                                                <a
                                                    class="dropdown-toggle"
                                                    href="#"
                                                    role="button"
                                                    id="dropdownMenuLink"
                                                    data-toggle="dropdown"
                                                    aria-haspopup="true"
                                                    aria-expanded="false"
                                                    >
                                                    <i
                                                        class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"
                                                        ></i>
                                                </a>
                                            </div>
                                        </div>

                                        <div class="card-body">
                                            <div class="form-group d-flex">
                                                <div class="col-sm-2">
                                                    <label class="font-weight-bold text-gray-800"
                                                           >Apellido
                                                    </label>
                                                    <input
                                                        type="text"
                                                        name="apellido"
                                                        class="form-control"
                                                        id="ape"
                                                        value="${apellido_f}"

                                                        required
                                                        />
                                                </div>

                                                <!--ID PACIENTE-->

                                                <input type="hidden" value="${id}" name="id_paciente" id="id_paciente"> 

                                                <div class="col-sm-3">
                                                    <label class="font-weight-bold text-gray-800"
                                                           >Nombre
                                                    </label>
                                                    <input
                                                        type="text"
                                                        name="nombre"
                                                        class="form-control"
                                                        id="nom"
                                                        value="${nombre_f}"

                                                        required
                                                        />
                                                </div>

                                                <div class="col-sm-2">
                                                    <label class="font-weight-bold text-gray-800"
                                                           >DNI</label
                                                    >
                                                    <input
                                                        type="text"
                                                        name="dni"
                                                        class="form-control"
                                                        id="dn"
                                                        value="${dni_f}"
                                                        required

                                                        />
                                                </div>

                                                <div class="col-sm-3">
                                                    <label class="font-weight-bold text-gray-800"
                                                           >Fecha de nacimiento</label
                                                    >
                                                    <input
                                                        type="date"
                                                        name="fecha_n"
                                                        class="form-control"
                                                        id="fecha_n"
                                                        value="${fechaNac_f}"
                                                        required
                                                        />
                                                </div>
                                            </div>

                                            <div class="form-group d-flex">
                                                <div class="col-sm-2">
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Sexo</label
                                                    >
                                                    <select class="form-control" name="sexo" id="sexo">


                                                        <c:forEach var="l_sexo" items="${lista_sexo}">

                                                            <c:set var="val" value="${genero_f}"/>

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

                                                <div class="col-sm-4">
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Domicilio</label
                                                    >
                                                    <input
                                                        type="text"
                                                        name="domicilio"
                                                        class="form-control"
                                                        id="dom"
                                                        value="${domicilio_f}"
                                                        />
                                                </div>

                                                <div class="col-sm-2">
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Obra Social</label
                                                    >
                                                    <select class="form-control select2" name="obra_social" id="obra_social" >

                                                        <c:forEach var="l_social" items="${lista_osocial}">

                                                            <c:set var="valor" value="${obraSocial_f}"/>

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
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Celular</label
                                                    >
                                                    <input
                                                        type="text"
                                                        name="telefono"
                                                        class="form-control"
                                                        id="cel"
                                                        value="${celular_f}"

                                                        />
                                                </div>
                                            </div>

                                            <div class="form-group d-flex">
                                                <div class="col-sm-3">
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Lugar de Trabajo</label
                                                    >
                                                    <input
                                                        type="text"
                                                        name="lugar_trabajo"
                                                        class="form-control"
                                                        id="lugar_t"
                                                        value="${direccionTrabajo_f}"
                                                        />
                                                </div>

                                                <div class="col-sm-3">
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Antecedentes</label
                                                    >
                                                    <input
                                                        type="text"
                                                        name="antecedentes"
                                                        class="form-control"
                                                        id="antec"
                                                        value="${antecedentes_f}"
                                                        />
                                                </div>

                                                <div class="col-sm-3">
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Alergico/a</label
                                                    >
                                                    <input
                                                        type="text"
                                                        name="alergia"
                                                        class="form-control"
                                                        id="aler"
                                                        value="${alergias_f}"
                                                        />
                                                </div>

                                                <div class="col-sm-3">
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Medicamentos</label
                                                    >
                                                    <input
                                                        type="text"
                                                        name="receta"
                                                        class="form-control"
                                                        id="med"
                                                        value="${receta_f}"
                                                        />
                                                </div>
                                            </div>
                                            <div class="form-group d-flex">
                                                <div class="col-sm-3">
                                                    <label class="font-weight-bold text-gray-900"
                                                           >Persona responsable</label
                                                    >
                                                    <input
                                                        type="text"
                                                        name="responsable"
                                                        class="form-control"
                                                        id="res"
                                                        value="${responsable_f}"
                                                        />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group text-center">
                                            <div class="col-sm">
                                                <button
                                                    type="submit"
                                                    name="accion"
                                                    value="Actualizar"
                                                    class="agregar btn btn-danger btn-icon-split"

                                                    >
                                                    <span class="icon text-white-60">
                                                        <i class="fas fa-user-edit"></i
                                                        ></span>
                                                    <span class="text">Actualizar datos</span>
                                                </button>
                                            </div>
                                        </div>
                                    </form>                 
                                </div>
                            </div>
                        </div>
                    </div>               
                </div>             
            </div>
        </div>

        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>  
        <script src="js/sb-admin-2.min.js"></script>
    </body>
</html>

