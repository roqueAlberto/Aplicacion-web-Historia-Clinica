<%-- 
    Document   : index
    Created on : 18/01/2021, 23:49:46
    Author     : Roque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>Historia Clinica</title>

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
          href="index.html"
        >
          <div class="sidebar-brand-icon">
            <i class="fas fa-user-md"></i>
          </div>
        <!--  <div class="sidebar-brand-text mx-3">Dr. Billordo</div>-->
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0" />

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
          <a class="nav-link" href="index.jsp">
            <i class="fas fa-door-open"></i>
            <span>Bienvenido</span></a
          >
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider" />

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
          <a
            class="nav-link collapsed"
            href="Servidor?menu=Consulta&accion=default"
            aria-expanded="true"
            aria-controls="collapseTwo"
          >
            <i class="fas fa-stethoscope"></i>
            <span>Consulta medica</span>
          </a>
        </li>

        <li class="nav-item">
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
      </ul>
      <!-- End of Sidebar -->

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
          <!-- Topbar -->
        <!--  <nav
            class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
          >-->
            <!-- Topbar Navbar -->
            <!--<ul class="navbar-nav ml-auto">-->
              <!-- Nav Item - Search Dropdown (Visible Only XS) -->

              <!-- Nav Item - User Information -->
            <!--  <li class="nav-item dropdown no-arrow">
                <a
                  class="nav-link dropdown-toggle"
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
              </li>-->
         <!--   </ul>
          </nav>  -->

         <div class="card shadow mb-4">
            
            <div class="card-body text-center">
                
                <div style="position: relative;right: 300px;">
                    
                    <h2 class="font-italic text-primary">Bienvenido Dr.</h2>
                    
                </div>
                <div style="position: relative;top: -60px">
                    <img
                    class="img-profile rounded-circle"
                    src="img/avatar_medico.jpg"
                  />
                </div>
                 
              
            </div>
          </div>-

          
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>
  </body>
</html>