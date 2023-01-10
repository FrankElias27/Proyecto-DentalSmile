<%-- 
    Document   : index
    Created on : 23-oct-2022, 18:01:09
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
        <link rel = "stylesheet" href = "css/master.css">
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
    <body >
        <!-- navegacion -->
        <nav class="navbar" style="height: 82px">
            
                <a href = "index.jsp">Inicio</a>
                <a href = "vistas/PaginaPrincipal/nosotros.jsp">Nosotros</a>
                <a href = "vistas/PaginaPrincipal/sedes.jsp">Sedes</a>
                <a href = "vistas/PaginaPrincipal/servicios.jsp">Servicios</a>
                <a href = "identificar.jsp"><i class="fa fa-wrench"></i></a>
            
        </nav>
        <header class ="header" style="height: 900px">
            <!-- cabecera -->       
            <div class="cabecera">
                <img src="img/logo.png" width="121" height="124" ><p></p>
                <h1 class = "slogan" style="font-size:32px; font-weight: bold;">CENTRO ODONTOLÓGICO</h1>
                <h1 style="line-height:85px;font-size:55px">DENTO<br>SMILE</h1>
                
            </div>
        </header>

        <!-- quienes somos -->
        
            
            <br>
            <br>
            <h1 class = "titl" style="font-family: 'Akshar'; font-weight: bold; padding-right: 0px" >
                <span style="color:#9DADA1;">SOMOS</span> DENTO SMILE</h1>
            <p class ="" style="font-family: Times New Roman; max-width: 1400px; margin: auto;text-align: justify; padding: 35px">
                Brindamos la mejor experiencia dental con un servicio integral con múltiples alternativas de tratamiento, 
                enfocado a sus necesidades, con un excelente equipo humano y profesional, con una excelencia en la calidad y 
                tecnología de última generación, a valores accesibles con un alto énfasis en la prevención y salud bucal.
                ¿Por qué elegirnos? Creemos que para agregar valor a nuestros servicios es necesario poseer una visión profesional 
                que nos permita capturar la sensibilidad de nuestros pacientes y construir relaciones permanentes y confiables, con cada uno de ellos.
            </p>
            
        

        <!-- servicios -->
        <section class = "content servicios">
           
            <h1 class = "title-servicios" >NUESTROS SERVICIOS</h1>
            <br>
            <br>
            <div class="container">
                <div class="row">
                        
                            <div class="col order-first">
                                <div class="card" style="width: 12rem; margin: auto;">
                                    <a href = "vistas/PaginaPrincipal/servicios/implantes.jsp" ><img src="img/implante.jpg" class="card-img-top" alt="pic"></a>
                                    <div class="card-body">
                                        <p class="card-text">Implantes</p>
                                    </div>
                                </div>
                            </div>
                    
                            <div class="col order-second">
                                <div class="card" style="width: 12rem; margin: auto;">
                                    <a href = "vistas/PaginaPrincipal/servicios/ortodoncia.jsp"> <img src="img/ortodoncia.jpg" class="card-img-top" alt="pic"></a>
                                    <div class="card-body">
                                        <p class="card-text">Ortodoncia</p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col order-third">
                                <div class="card" style="width: 12rem; margin: auto;">
                                    <a href = "vistas/PaginaPrincipal/servicios/rehabilitacion.jsp"><img src="img/rehabilitacion.jpg" class="card-img-top" alt="pic"></a>
                                    <div class="card-body">
                                        <p class="card-text">Rehabilitación</p>
                                    </div>
                                </div>
                            </div>
                                
                            <div class="col order-fourth">
                                <div class="card" style="width: 12rem; margin: auto;">
                                    <a href = "vistas/PaginaPrincipal/servicios/endodoncia.jsp"><img src="img/endodoncia.jpg" class="card-img-top" alt="pic"></a>
                                    <div class="card-body">
                                        <p class="card-text">Endodoncia</p>
                                    </div>
                                </div>
                            </div>
                                
                            <div class="col order-last">
                                <div class="card" style="width: 12rem; margin: auto;">
                                    <a href = "vistas/PaginaPrincipal/servicios/cirugia.jsp"><img src="img/cirugia.jpg" class="card-img-top" alt="pic"></a>
                                    <div class="card-body">
                                        <p class="card-text">Cirugias</p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col order-last">
                                <div class="card" style="width: 12rem; margin: auto;">
                                    <a href = "vistas/PaginaPrincipal/servicios/periodoncia.jsp"><img src="img/periodoncia.jpg" class="card-img-top" alt="pic"></a>
                                    <div class="card-body">
                                        <p class="card-text">Periodoncia</p>
                                    </div>
                                </div>
                            </div>
                            
                        <br><br>
                </div>        
            </div>
        </section>


        <!-- Pie de página -->

        <footer>
            <section class = "content pie">
                <div class="container">
                    <div class="row">
                        <p>CONTÁCTENOS</p><br>

                        <div class="col" >
                            <h4><img src="img/logo.png" style="height: 100%; width: 80px;"></h4><br>

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
                        <div class="col order-1" >

                            <p>Visítanos en el centro de Ica</p>
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3870.223216981749!2d-75.73128618462464!3d-14.063992136521934!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9110e2bdae3019ad%3A0xdc8edaf0195e4c53!2sPlaza%20de%20Armas%20de%20Ica%2C%20Ica%2011001!5e0!3m2!1ses-419!2spe!4v1665956859170!5m2!1ses-419!2spe" width="350" height="250" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        </div>
                    </div>
                </div>
            </section>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
    </body>
</html>

