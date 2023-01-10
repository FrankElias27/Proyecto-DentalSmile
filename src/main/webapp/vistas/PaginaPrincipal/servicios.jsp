<%-- 
    Document   : servicios
    Created on : 22-oct-2022, 15:59:05
    Author     : Ellis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dento Smile</title>
        <!-- Boostrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <!-- Aquí enlazamos a nuestro master.css -->
        <link rel = "stylesheet" href = "../../css/master.css">
        <!-- Icons -->
        <script src="https://kit.fontawesome.com/83ddb2f15f.js" crossorigin="anonymous"></script>
        <!-- Aquí están las fonts que usamos en la web -->
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Akshar:wght@400;500&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Kanit&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Macondo&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Poiret+One&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    </head>
    <body>
        <!-- navegacion -->
        <nav class="navbar" style="height: 82px">
            <a href = "../../index.jsp">Inicio</a>
            <a href = "nosotros.jsp">Nosotros</a>
            <a href = "sedes.jsp">Sedes</a>
            <a href = "servicios.jsp">Servicios</a>
            <a href = "../../identificar.jsp"><i class="fa fa-wrench"></i></a>
        </nav>
        <header class ="header-galeriapestaña">
            <!-- cabecera -->       
            <div class="cabecera-galeriapestaña">
                <h1 style="line-height:85px">Servicios</h1>
            </div>
        </header>

        <!-- Servicios -->
        <section class = "content nosotros">
            <div class="container">
                <div class="row">
                    <div class="col order-first">
                        <h4 style="line-height:30px; font-family:Pacifico;">Implantes</h4>
                        <div class="zoom" style="margin: auto; width: 250px; height: 280px; border-radius: 50px;">
                            <a href = "servicios/implantes.jsp"><img src="../../img/implante.jpg" alt="zoom image"></a><br>
                        </div>

                    </div>
                    <div class="col order-second">
                        <h4 style="line-height:30px; font-family:Pacifico;">Ortodoncia</h4>
                        <div class="zoom" style="margin: auto; width: 250px; height: 280px; border-radius: 50px;">
                            <a href = "servicios/ortodoncia.jsp"><img src="../../img/ortodoncia.jpg" alt="zoom image" ></a><br>
                        </div>

                    </div>
                    <br>
                    <div class="col order-third">
                        <h4 style="line-height:30px; font-family:Pacifico;">Rehabilitación Oral</h4>
                        <div class="zoom" style="margin: auto; width: 250px; height: 280px; border-radius: 50px;">
                            <a href = "servicios/rehabilitacion.jsp"><img src="../../img/rehabilitacion.jpg" alt="zoom image" ></a><br>
                        </div>

                    </div>
                    <p></p>

                    <div class="col order-fourth">
                        <div class="zoom" style="margin: auto; width: 250px; height: 280px; border-radius: 50px;">
                            <a href = "servicios/endodoncia.jsp"><img src="../../img/endodoncia.jpg" alt="zoom image" ></a><br>
                        </div>
                        <h4 style="line-height:30px; font-family:Pacifico;">Endodoncia</h4>
                    </div>
                    <br>
                    <div class="col order-last">
                        <div class="zoom" style="margin: auto; width: 250px; height: 280px; border-radius: 50px;">
                            <a href = "servicios/cirugia.jsp"><img src="../../img/cirugia.jpg" alt="zoom image" ></a><br>
                        </div>
                        <h4 style="line-height:30px; font-family:Pacifico;">Cirugías</h4>
                    </div><br>
                    <div class="col order-last">
                        <div class="zoom" style="margin: auto; width: 250px; height: 280px; border-radius: 50px;">
                            <a href = "servicios/periodoncia.jsp"><img src="../../img/periodoncia.jpg" alt="zoom image" ></a><br>
                        </div>
                        <h4 style="line-height:30px; font-family:Pacifico;">Periodoncia</h4>
                    </div>
                    <br>
                </div>
            </div>
        </section>
        <!-- Pie de página -->
        <section class = "content pie">
            <div class="container">
                <div class="row">
                    <p>CONTÁCTENOS</p><br>

                    <div class="col">
                        <h4><img src="../../img/logo.png" width="80" height="80"></h4><br>

                        <p><i>"La sonrisa es la ventana del alma"</i></p>
                        <p>Lunes a Viernes de 8:00am a 10:30pm <br> Sábado a Domingo de 12:00pm a 5:00pm</p>

                        <a href="mailto:dentosmile@gmail.com?Subject=Deseo%20agendar%20una%20cita" class="login100-social-item bg1">
                            <i class="fa fa-envelope"></i>
                        </a>&nbsp &nbsp &nbsp
                        <a href="https://wa.link/fmmz90" class="login100-social-item bg3" target="link_blank">
                            <i class="fa fa-phone"></i>
                        </a>&nbsp &nbsp &nbsp

                        <a href="https://www.facebook.com/DentalSmilePeru" class="login100-social-item bg1" target="link_blank">
                            <i class="fa fa-facebook"></i>
                        </a>
                    </div>
                    <div class="col order-1">

                        <p>Visítanos en el centro de Ica</p>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3870.223216981749!2d-75.73128618462464!3d-14.063992136521934!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9110e2bdae3019ad%3A0xdc8edaf0195e4c53!2sPlaza%20de%20Armas%20de%20Ica%2C%20Ica%2011001!5e0!3m2!1ses-419!2spe!4v1665956859170!5m2!1ses-419!2spe" width="350" height="250" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>