<%-- 
    Document   : nosotros
    Created on : 22-oct-2022, 15:57:21
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
        <header class ="header-nosotrospestaña">
            <!-- cabecera -->       
            <div class="cabecera-nosotrospestaña">
                <h1 style="line-height:85px">Sobre Nosotros</h1>
            </div>
        </header>
        <!-- texto sobre nosotros -->
        <section class = "content nosotros">
            <h1 class = "title-nosotrospestaña" >QUIENES SOMOS</h1><br>
            <p class ="texto-nosotrospestaña" style="text-align:justify; padding-left: 80px; padding-right: 80px; ">Brindamos a nuestros pacientes la mejor experiencia dental con un servicio integral con múltiples alternativas de tratamiento,
                enfocado a sus necesidades, expectativas y posibilidades, con un excelente equipo humano y profesional, con una excelencia en la calidad y 
                tecnología de última generación, a valores accesibles con un alto énfasis en la prevención y salud bucal.</p><br>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="card" style=" height:35rem ;width: 23rem;margin: auto;">
                            <img src="../../img/valores.jpeg" class="card-img-top" alt="pic" height="500px" >
                            <img src="../../img/valores.jpeg" class="card-img-top" alt="pic" height="500px" >

                        </div>
                    </div>
                    <div class="col order-1" style="max-width: 1400px;">
                        <br>
                        <h1 class = "title-info">Misión</h1>
                        <p style="text-align:justify;">Brindar atención dental de calidad y un servicio amigable y personalizado, a todas aquellas personas que nos confían su mejor expresión SU SONRISA</p><br>
                        <h1 class = "title-info">Visión</h1>
                        <p style="text-align:justify;">Ser una clínica dental de vanguardia conformada por un equipo de odontólogos de primer nivel, comprometidos con su actualización continua, beneficiando de esta manera a todas las personas que nos confía su salud dental.</p><br>
                        <h1 class = "title-info">¿Por qué elegirnos?</h1>
                        <p style="text-align:justify;">Creemos que para agregar valor a nuestros servicios es necesario poseer una visión profesional que nos permita capturar la sensibilidad de nuestros pacientes y construir relaciones permanentes y confiables, con cada uno de ellos.</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- lo que dicen de nosotros -->
        <section class = "content loquedicen">
            <h1 class = "title-loquedicen" >Lo que dicen de nosotros</h1><br>
            <p style="font-size: 30px; font-weight: bold; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">TESTIMONIOS</p>
            
            
            <div class="card-group" style="margin: auto; padding: 20px">
                
                    <div class="card" style=" margin: auto;">
                        <img src="../../img/testi_1.png" class="card-img-top" alt="pic">
                        <div class="card-body">
                            <p class="card-text">«Estoy muy contento con el resultado final de mi tratamiento, los dientes han mejorado enormemente. 
                                Todo el personal es encantador y las citas siempre han sido agradables. Yo recomendaría la Clínica Dento Smile a toda mi familia y amigos»</p>
                        </div>
                    </div>
                    <div class="card" style=" margin: auto;">
                        <img src="../../img/testi_2.png" class="card-img-top" alt="pic">
                        <div class="card-body">
                            <p class="card-text">«Elegí esta clínica de ortodoncia debido a la ubicación. La clínica Dento Smile Ica está muy cerca donde vivo. 
                                Cumplieron con mis expectativas, el personal es profesional, amable y atento. 
                                Estoy muy contento con mi resultado y se lo recomendaría a cualquiera»</p>
                        </div>
                    </div>
                    <div class="card" style=" margin: auto;">
                        <img src="../../img/testi_3.png" class="card-img-top" alt="pic">
                        <div class="card-body">
                            <p class="card-text">«Tenía la boca muy descolocada. Me explicaron los diferentes sistemas de ortodoncia que había,
                                después de ver la diferencia de precio que había entre unos y otros no lo dudé, me puse la ortodoncia lingual. 
                                Un poquito raro los primeros días, pero me adapté rápidamente»</p>
                        </div>
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