<%-- 
    Document   : Registro
    Created on : 10-oct-2022, 15:39:19
    Author     : Ellis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Inicia Sesi&oacute;n</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="Login/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Login/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Login/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Login/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="Login/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Login/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Login/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="Login/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="Login/css/util.css">
        <link rel="stylesheet" type="text/css" href="Login/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" >

                <div class="wrap-login100 p-l-15 p-r-10 p-t-15 p-b-10">
                    <br>
                    <span class="login100-form-title p-b-49">
                        INICIAR SESI&Oacute;N
                    </span>

                    <form class="form" action="srvUsuario?accion=verificar" method="POST">
                        <div class="wrap-input100 validate-input m-b-23" >
                            <span class="label-input100">Usuario</span>
                            <input class="input100" type="text" name="txtUsu" class="form-control">
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>
                        <div class="wrap-input100 validate-input" >
                            <span class="label-input100">Contrase&ntilde;a</span>
                            <input class="input100" type="password" name="txtPass" class="form-control">
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>
                        <br>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button type="submit" name="verificar" value="Proceder" class="login100-form-btn" >Ingresar</button>
                            </div>
                        </div><br>

                    </form>

                    <div class="flex-c-m">
                        <a href="https://www.youtube.com/channel/UCMBw2VtwpVNWtSKzNerPXEg" class="login100-social-item bg3" target="link_blank">
                            <i class="fa fa-youtube-play"></i>
                        </a>
                        <a href="https://www.facebook.com/DentalSmilePeru" class="login100-social-item bg1" target="link_blank">
                            <i class="fa fa-facebook"></i>
                        </a>

                        <a href="index.jsp" class="login100-social-item bg3" >
                            <i class="fa fa-home"></i>
                        </a>

                    </div>

                </div>
            </div>
        </div>


        <!--===============================================================================================-->
        <script src="vendor/sweetalert2/sweetalert2.js"></script>
        <!--===============================================================================================-->

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
        <script src="../js/usuario.js"></script>

    </body>
    <script>
                            txt_usu.focus();
    </script>
</html>
