<%-- 
    Document   : Lista_paciente
    Created on : 24/01/2021, 23:23:11
    Author     : Roque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <title>Lista de pacientes</title>

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

        <link
            href="vendor/datatables/dataTables.bootstrap4.min.css"
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
                  <!--  <div class="sidebar-brand-text mx-3">Dr. Billordo</div>-->
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0" />

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">
                        <i class="fas fa-door-open"></i>
                        <span>Bienvenido</span></a
                    >
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider" />

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item ">
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
                <li class="nav-item active">
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

                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">
                                <!-- Dropdown Card Example -->
                                <div class="card shadow mb-4">
                                    <!-- Card Header - Dropdown -->
                                    <div
                                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between"
                                        >
                                        <h6 class="m-0 font-weight-bold text-primary">
                                            Lista de pacientes
                                        </h6>
                                        <div class="dropdown no-arrow">
                                            <a
                                                class="dropdown-toggle"
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
                                    <!-- Card Body -->
                                    <div class="card-body">

                                        <div class="form-group d-flex">
                                            <div class="col-sm-2">
                                                <h6 class="m-0 font-weight-bold text-gray-800">
                                                    Mujeres:<span class="m-0 font-weight-bold text-danger">
                                                        ${cantidad_m}</span
                                                    >
                                                </h6>
                                            </div>

                                            <br />

                                            <div class="col-sm-8">
                                                <h6 class="m-0 font-weight-bold text-gray-800">
                                                    Hombres:<span class="m-0 font-weight-bold text-danger">
                                                        ${cantidad_v}</span
                                                    >
                                                </h6>
                                            </div>
                                        </div>


                                                    <br>

                                        <div class="table-responsive">
                                            <table
                                                class="table table-bordered"
                                                id="table_historial"
                                                width="100%"
                                                cellspacing="0"
                                                >
                                                <thead>
                                                    <tr
                                                        class="font-weight-bold bg-gradient-primary text-gray-100"
                                                        >
                                                        <th>Apellido</th>
                                                        <th>Nombre</th>
                                                        <th>DNI</th>
                                                        <th>Edad</th>
                                                        <th>Celular</th>
                                                        <th>Obra Social</th>
                                                        <th>Acción</th>
                                                    </tr>
                                                </thead>

                                                <tbody>

                                                    <c:forEach var="listar_p" items="${pacientes}">

                                                        <tr class="text-gray-900"  >


                                                            <td>${listar_p.getNombre()}</td>
                                                            <td>${listar_p.getApellido()}</td>
                                                            <td>${listar_p.getDni()}</td>
                                                            <td>${listar_p.getEdad()}</td>
                                                            <td>${listar_p.getCelular()}</td>
                                                            <td>${listar_p.getDesc_obraSocial()}</td>
                                                            <td><a class="btn btn-danger" href="Servidor?menu=Ficha_paciente&accion=default&id_p=${listar_p.getId_paciente()}">Ver más</a></td>

                                                        </tr>

                                                    </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <!--<footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Roque</span>
                        </div>
                    </div>
                </footer> -->
                <!-- End of Footer -->
            </div>
            <!-- End of Content Wrapper -->
        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>

        <!-- Index editado-->
        <script src="js/index.js"></script>
    </body>
</html>

