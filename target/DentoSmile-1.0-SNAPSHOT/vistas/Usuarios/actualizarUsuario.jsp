<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("usuario") != null) {
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Panel Administrativo</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>

        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect. -->
        <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>

    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <!-- Main Header -->
            <header class="main-header">
                <a href="#" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b><i class="fa fa-wrench"></i></b> DS </span>
                    <!-- logo for regular state and mobile devices -->
                    <b>Admin</b>DentalSmile </span><i class="fa fa-wrench"></i>
                </a>

                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- User Account Menu -->
                            <li class="dropdown tasks-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-flag-o"></i>
                                    <span class="label label-danger">🦷</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">Actividades: </li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Solucionar dudas
                                                        <small class="pull-right">🤔🤔</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-aqua" style="width: 100%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">

                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>Verificar personal activo

                                                        <small class="pull-right">👩‍⚕️👀</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-aqua" style="width: 100%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">

                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>Agregar nuevos registros

                                                        <small class="pull-right">➕ 📒</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-green" style="width: 100%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">

                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Verificar Stocks
                                                        <small class="pull-right">📈📉 👀</small>
                                                    </h3>
                                                    <div class="progress xs">

                                                        <div class="progress-bar progress-bar-yellow" style="width:100%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">

                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Mantenimiento de registros
                                                        <small class="pull-right">📒🧰</small>
                                                    </h3>
                                                    <div class="progress xs">

                                                        <div class="progress-bar progress-bar-red" style="width:100%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">

                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                        </ul>
                                    </li>
                                    <li class="footer">
                                        <a href="#">Sonríe 😊</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown user user-menu">
                                <!-- Menu Toggle Button -->
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <!-- The user image in the navbar-->
                                    <img src="img/avatar6.png"  class="user-image" alt="User Image">
                                    <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                    <span class="hidden-xs"> ${usuario.nombreUsuario}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- The user image in the menu -->
                                    <li class="user-header">
                                        <img src="img/avatar6.png" class="img-circle" alt="User Image">

                                        <p>                    
                                            ${usuario.nombreUsuario}
                                            <small> </small>
                                        </p>
                                    </li>
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-right">
                                            <a href="srvUsuario?accion=cerrar" class="btn btn-default btn-flat">Cerrar Sesion</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/avatar6.png" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>${usuario.nombreUsuario} </p>
                            <!-- Status -->
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>

                    <!-- search form (Optional) -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->

                    <!-- Sidebar Menu -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">INICIO</li>
                        <!-- Optionally, you can add icons to the links -->
                        <li><a href="srvHome?accion=Home"><i class="fa fa-link"></i> <span>Panel Administrativo</span></a></li>
                        <li class="treeview active">
                            <a href="#"><i class="glyphicon glyphicon-th-large"></i> <span>Registros(ADMIN)</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="srvProcedimiento?accion=listarProcedimientos"><i class="fa fa-folder"></i>Procedimientos</a></li>
                                <li><a href="srvMedicamento?accion=listarMedicamentos"><i class="fa fa-medkit"></i>Medicamentos</a></li>
                                <li><a href="srvInsumo?accion=listarInsumos"><i class="fa fa fa-archive"></i>Insumos</a></li>
                                <li><a href="srvPaciente?accion=listarPacientes"><i class="fa fa-heartbeat"></i>Pacientes</a></li>
                                <li><a href="srvOdontologo?accion=listarOdontologos"><i class=" fa fa-user-md"></i>Odontólogos</a></li>
                                <li class="active"><a href="srvUsuario?accion=listarUsuarios"><i class="fa fa-address-card"></i>Usuarios</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-hospital-o"></i> <span>Citas</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="srvCita?accion=nuevo"><i class="fa fa-hospital-o"></i>Nueva Cita</a></li>
                                <li><a href="srvCita?accion=listarCitas"><i class="fa fa-ambulance"></i>Administrar Citas</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-stethoscope"></i> <span>Consultas</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="srvConsulta?accion=nuevo"><i class="fa fa-stethoscope"></i>Nueva Consulta</a></li>
                                <li><a href="srvConsulta?accion=listarConsultas"><i class="fa fa-ambulance"></i>Administrar Consultas</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-file-text-o"></i> <span>Historial Cl&iacute;nico</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="srvHistorial?accion=nuevo"><i class="fa fa-file-text-o"></i>Nuevo Historial</a></li>
                                <li><a href="srvHistorial?accion=listarHistoriales"><i class="fa fa-ambulance"></i>Administrar Historial</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-area-chart"></i> <span>Reportes</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-bar-chart"></i>Reporte Citas</a></li>
                                <li><a href="#"><i class="fa fa-bar-chart"></i>Reporte Historial</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">

                <section class="content">
                    <div class="col-md-12">
                        <div class="box box-warning box-solid">
                            <div class="box-header with-border">
                                <i class="fa fa-edit"></i> <h3 class="box-title">Actualizar Datos Usuario</h3>  
                            </div>
                            <br>
                            <form class="form-horizontal" action="srvUsuario?accion=actualizarUsuario" method="post" style="padding-right: 20px; padding-left: 20px;">
                                <input type="hidden" name="hCodigo" value="${usuario.id_usuario}">
                                <div class="box-body">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Usuario</label>
                                        <div class="col-sm-4 input-group">
                                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                            <input id="nombre" type="text" class="form-control" placeholder="Ejem: Alexander" name="txtNombre" maxlength="10"
                                                   value="${usuario.nombreUsuario}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Clave</label>
                                        <div class="col-sm-4 input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                            <input id="nombre" type="password" class="form-control" placeholder="Ejem: $%Ale!**" name="txtClave" maxlength="10"
                                                   value="${usuario.clave}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-4 input-group">
                                            <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                            <input id="email" type="email" class="form-control" placeholder="Ejem: Arodriguez@gmail.com " name="txtEmail"
                                                   value="${usuario.email}">
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Rol</label>
                                        <div class="col-sm-4 input-group">
                                            <span class="input-group-addon"><i class="fa fa-black-tie"></i></span>
                                            <select class="form-control"  name="cboCargo" autofocus=""  required="">
                                                <option value="0">Seleccione un rol</option>
                                                <c:forEach items="${cargos}" var="car">
                                                    <option value="${car.codigo}"  
                                                            <c:if test="${car.codigo == 
                                                                          usuario.cargo.codigo}">
                                                                  selected
                                                            </c:if>
                                                            >${car.nombreCargo}</option>
                                                </c:forEach>
                                            </select>
                                        </div>                                  
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Estado</label> 
                                        
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" name="chkEstado" 
                                                           <c:out value="${usuario.estado == false ?
                                                                           'unchecked' : 'checked'}"
                                                                  default="" />>Activo
                                                </label>
                                            </div>
                                        
                                    </div>
                                </div>
                                <!-- /.box-body -->
                                <div class="box-footer">
                                    <a href="srvUsuario?accion=listarUsuarios" class="btn btn-danger" style="text-align: right">
                                    <i class="fa fa-close red"></i> Cancelar</a>
                                    <button type="submit" id="" name="btnRegistrar" value="Registrar" class="btn btn-success"><i class="fa fa-refresh"></i> Actualizar Usuario</button>

                                </div>
                                <!-- /.box-footer -->
                            </form>
                        </div>
                    </div>
                </section> 

            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <footer class="main-footer">
                <marquee behavior="" direction="left"><i>Centro Odontológico Dental Smile | 
                        ICA: Av.Municipalidad N°100, CHINCHA: Cl. Grau N°100, PISCO: Cl. Jazmín N°180 - San Clemente, NAZCA: Jr. Bolognesi N°260 </i>
                </marquee>
            </footer>

            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED JS SCRIPTS -->

        <!-- jQuery 3 -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>

        <!-- Optionally, you can add Slimscroll and FastClick plugins.
             Both of these plugins are recommended to enhance the
             user experience. -->
    </body>
</html>
<%
    } else {
        response.sendRedirect("AccesoDenegado.jsp");
    }
%>

