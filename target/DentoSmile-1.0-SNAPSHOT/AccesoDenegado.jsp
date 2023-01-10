<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Panel Administrativo| Error</title>
        
        
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body class="sidebar-closed sidebar-collapse">

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper"   >
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Error 508
                </h1>
                <ol class="breadcrumb">
                    <li><a href="srvHome?accion=Home"><i class="glyphicon glyphicon-th-large"></i> PANEL ADMINISTRATIVO</a></li>
                    <li class="active"><a href="#">Error 508</a></li>
                </ol>
            </section>

            
            <!-- Main content -->
            <section class="content" style="margin-top: 100px">
                
                
                <div class="error-page">
                    <div class="row" style="text-align: center">
                    <img src="img/caida2.jpg" style="width:388px; height:300px; border-radius: 50px; margin: auto;">
                        
                    <div class="error-content">
                        &nbsp;
                       <h3><i class="fa fa-ban text-red"></i> Oops! Usted no tiene los permisos para acceder a este sitio.</h3>
                        
                        <p>
                            Solo el ADMINISTRADOR puede ingresar a este lugar.
                        </p>
                       
                    
                        <form class="search-form" >
                            <div class="input-group" style="display: flex; justify-content: center">
                                <a href="srvHome?accion=Home" class="btn btn-danger" ">
                                         <i class="fa fa-arrow-circle-o-left red"></i> Regresa al Panel Administrativo</a>
                            </div>
                            <!-- /.input-group -->
                        </form>
                        
                    </div>
                </div>
                </div>
                <!-- /.error-page -->

            </section>
            <!-- /.content -->
            </div>
        <footer class="main-footer">
            <h2><marquee behavior="" direction="left"><i>Centro Odontológico Dental Smile | 
                        ICA: Av.Municipalidad N°100, CHINCHA: Cl. Grau N°100, PISCO: Cl. Jazmín N°180 - San Clemente, NAZCA: Jr. Bolognesi N°260 </i>
                </marquee></h2>
            </footer>
        <!-- jQuery -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="plugins/iCheck/icheck.min.js"></script>

    </body>
</html>
