<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("usuario") != null
    || session.getAttribute("odontologo") != null){
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
        <link href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="swetalert/sweetalert.css" rel="stylesheet" type="text/css"/>
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
                                    <span class="hidden-xs"> ${usuario.nombreUsuario}${odontologo.nombreUsuario}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- The user image in the menu -->
                                    <li class="user-header">
                                        <img src="img/avatar6.png" class="img-circle" alt="User Image">

                                        <p>                    
                                             ${usuario.nombreUsuario}${odontologo.nombreUsuario}
                                            <small>Usted es ${usuario.cargo.nombreCargo}${odontologo.cargo.nombreCargo} </small>
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
                            <p>${usuario.nombreUsuario}${odontologo.nombreUsuario} </p>
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
                                <li class="active"><a href="srvPaciente?accion=listarPacientes"><i class="fa fa-heartbeat"></i>Pacientes</a></li>
                                <li><a href="srvOdontologo?accion=listarOdontologos"><i class=" fa fa-user-md"></i>Odontólogos</a></li>
                                <li><a href="srvUsuario?accion=listarUsuarios"><i class="fa fa-address-card"></i>Usuarios</a></li>
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
                        
                    </ul>
                    <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <section class="content">
                    <div class="col-md-12">
                        <div class="box box-warning box-solid">    
                            <div class="box-header with-border">             
                                <h3 class="box-title">Mantenimiento de Pacientes</h3>
                            </div>
                            <div class="box-body">
                                <br>
                                <div class="form-group">
                                    <div class="col-lg-10">
                                        <div class="input-group">
                                            <input type="text" class="global_filter form-control" id="global_filter" placeholder="Ingresar dato a buscar">
                                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                                            
                                        </div>
                                    </div>
                                    <div class="col-lg-2">
                                        
                                        <a href="srvPaciente?accion=nuevo" class="btn btn-danger" style="width:100%">
                                        <i class="glyphicon glyphicon-plus"></i> Nuevo Registro </a>
                                    </div>
                                    
                                </div>
                                <br>
                                <div class="table-responsive" >  
                                    <table id="tabla_paciente" class="table table-striped display responsive nowrap dataTable dtr-inline collapsed " style="width: 100%;" role="grid">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Nro DNI</th>
                                                <th>Paciente</th>
                                                <th>Direcci&oacute;n</th>
                                                <th>Sexo</th>
                                                <th>Teléfono</th>
                                                <th>Acciones</th> 
                                            </tr>
                                        </thead>
                                        <c:forEach var="pa" items="${pacientes}" varStatus="iteracion">                                                    
                                            <tr>
                                                <td>${iteracion.index + 1}</td>
                                                <td>${pa.dni}</td>
                                                <td>${pa.nombre}</td>
                                                <td>${pa.domicilio}</td>
                                                <td>${pa.sexo}</td>
                                                <td>${pa.telefono}</td>
                                                <td><a href="<c:url value="srvPaciente">
                                                           <c:param name="accion" value="leerPaciente" />
                                                           <c:param name="cod1" value="${pa.id_paciente}" />
                                                       </c:url>"><button type="button" class="btn btn-primary" data-toggle="tooltip"  title="Editar" data-original-title="Editar">
                                                            <i class="fa fa-edit"></i></button></a>

                                                    <!-- ELIMINAR USUARIOS -->
                                                    <input type="hidden" id="codigo" value="${pa.id_paciente}">
                                                    <a id="deletePa" href="<c:url value="srvPaciente">
                                                           <c:param name="accion" value="eliminarPaciente" />
                                                           <c:param name="cod" value="${pa.id_paciente}" />
                                                       </c:url>"><button type="button" class="btn btn-warning" data-toggle="tooltip"  title="Eliminar" data-original-title="Eliminar">
                                                            <i class="fa fa-trash"></i></button></a>
                                                  
                                                </td>
                                            </tr>                                                    
                                        </c:forEach>  
                                        <tfoot>
                                            <tr>
                                                <th rowspan="1" colspan="1">#</th>
                                                <th rowspan="1" colspan="1" style="">Nro DNI</th>
                                                <th rowspan="1" colspan="1" style="">Paciente</th>
                                                <th rowspan="1" colspan="1" style="">Direcci&oacute;n</th>
                                                <th rowspan="1" colspan="1" style="">Sexo</th>
                                                <th rowspan="1" colspan="1" style="">Teléfono</th>
                                                <th rowspan="1" colspan="1" style="">Acciones</th>
                                                
                                            </tr>
                                        </tfoot>    
                                    </table>
                                </div>
                            </div>
                            <!-- /.box-body -->

                            <!-- /.box-footer-->
                            <div class="box-footer">
                                
                            </div>
                        </div>
                    </div>
                </section>
                <!-- /.content -->
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
        <script src="bower_components/datatables.net/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
        <script src="swetalert/sweetalert.js" type="text/javascript"></script>
        <script src="js/funcionesPaciente.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $('#tablaOdontologos').DataTable();
            });
        </script>
        <!-- Optionally, you can add Slimscroll and FastClick plugins.
             Both of these plugins are recommended to enhance the
             user experience. -->
    </body>
</html>
<%
    } else {
        response.sendRedirect("identificar.jsp");
    }
%>

