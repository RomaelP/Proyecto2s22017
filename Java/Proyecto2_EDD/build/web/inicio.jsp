<!DOCTYPE html>
<html>
<title>El Lobo Hotel</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/nuevoCSS.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.mySlides {display:none}
</style>
<body class="w3-content w3-border-left w3-border-right">

<!-- Sidebar/menu -->

<nav class="w3-sidebar w3-light-grey w3-collapse w3-top" style="z-index:3;width:260px" id="mySidebar">
<center><h2 class="w3-text-green">MENU</h2></center>
  <div class="w3-bar-block">
    <a href="cargarArchivos.jsp" target="_blank" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-arrow-circle-right"></i> Cargar Archivos</a>
    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-16" onclick="document.getElementById('subscribe').style.display='block'"><i class="fa fa-fw fa-user-o"></i> Login</a>
    <a href="#apartment" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-home"></i> Home</a>
    
    <a href="#contact" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-envelope"></i> Contact</a>
    
    
    <br>
    <br>
          <h3 style="color: #2D3B55; text-align: center"><%
                        if(null!= request.getAttribute("errorMessage"))
                        {
                            out.print(request.getAttribute("errorMessage"));
                        }
                        %></h3>
    <br>
    <br>
     <h3 style="color: #2D3B55; text-align: center"><%
                        if(null!= request.getAttribute("informaMessage"))
                        {
                            out.print(request.getAttribute("informaMessage"));
                        }
                        %></h3>
  </div>
</nav>

<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
  <span class="w3-bar-item">Rental</span>
  <a href="javascript:void(0)" class="w3-right w3-bar-item w3-button" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main w3-white" style="margin-left:260px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:80px"></div>

  <!-- Slideshow Header -->
  <div class="w3-container" id="apartment">
    <h2 class="w3-text-green">El Lobo Hotel</h2>
    <div class="w3-display-container mySlides">
        <img src="Recursos/principal.jpg" style="width:100%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Habitacion</p>
      </div>
    </div>
    <div class="w3-display-container mySlides">
        <img src="Recursos/servicios.jpg" style="width:100%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Servicios</p>
      </div>
    </div>
    <div class="w3-display-container mySlides">
        <img src="Recursos/vistas.jpg" style="width:100%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Vistas</p>
      </div>
    </div>
    <div class="w3-display-container mySlides">
        <img src="Recursos/restaurant.jpg" style="width:100%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Restaurant</p>
      </div>
    </div>
  </div>
  <div class="w3-row-padding w3-section">
    <div class="w3-col s3">
      <img class="demo w3-opacity w3-hover-opacity-off" src="Recursos/principal.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(1)" title="Habitacion">
    </div>
    <div class="w3-col s3">
      <img class="demo w3-opacity w3-hover-opacity-off" src="Recursos/servicios.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(2)" title="Servicios">
    </div>
    <div class="w3-col s3">
      <img class="demo w3-opacity w3-hover-opacity-off" src="Recursos/vistas.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(3)" title="Vistas">
    </div>
    <div class="w3-col s3">
        <img class="demo w3-opacity w3-hover-opacity-off" src="Recursos/restaurant.jpg" style="width:100%;cursor:pointer" onclick="currentDiv(4)" title="Restaurant">
    </div>
  </div>

  <div class="w3-container">
    <h4><strong>El Lobo Hotel</strong></h4>
    <p>El lobo Hotel esta ubicado a la orilla del lago de Atitlan en Panajachel, Solola en Guatemala, un lugar donde puedes disfrutar de las mejores vistas que el lugar puede ofrecerte.</p>
    <p>Cuenta con distintos servicios que haran de tu estadia algo inolvidable</p>  
    <hr>
    <h4><strong>Especificaciones de Habitacion</strong></h4>
    <div class="w3-row w3-large">
      <div class="w3-col s6">
        <p><i class="fa fa-fw fa-male"></i> Capacidad: 4</p>
        <p><i class="fa fa-fw fa-bath"></i> Baño: 2</p>
        <p><i class="fa fa-fw fa-bed"></i> Camas: 2</p>
        <p><i class="fa fa-fw fa-shower"></i> Shower</p>
      </div>
      <div class="w3-col s6">
          <p><i class="fa fa-fw fa-thermometer"></i> Aire Acondicionado</p>
          <p><i class="fa fa-fw fa-tv"></i> TV</p>
          <p><i class="fa fa-fw fa-wifi"></i> WiFi</p>
          <p><i class="fa fa-fw fa-phone"></i> Telefono </p>
      </div>
    </div>
    <hr>
    
    <h4><strong>Servicios</strong></h4>
    <div class="w3-row w3-large">
      <div class="w3-col s6">
        <p><i class="fa fa-fw fa-cutlery"></i> Restaurant</p>
        <p><i class="fa fa-fw fa-bell"></i> Servicio al Cuarto</p>
        <p><i class="fa fa-fw fa-taxi"></i> Servicio de Taxi</p>
      </div>
      <div class="w3-col s6">
        <p><i class="fa fa-fw fa-play"></i> Netflix</p>
        <p><i class="fa fa-fw fa-plane"></i>Shuttle</p>
        <p><i class="fa fa-fw fa-bus"></i> Servicio de Bus</p>
      </div>
    </div>
    <hr>
    
    <h4><strong>Precios Q</strong></h4>
    <p>HOTEL EL LOBO cuenta con una gran variedad de precios muy accesibles para disfrutar sin pensar en el bolsillo.</p>
    <p>Aceptamos: <i class="fa fa-money w3-large"></i> <i class="fa fa-credit-card w3-large"></i> <i class="fa fa-cc-mastercard w3-large"></i> <i class="fa fa-cc-amex w3-large"></i> <i class="fa fa-cc-cc-visa w3-large"></i></p>
    <hr>
    
    <h4><strong>Rules</strong></h4>
    <p>*******</p>
    <p></p>
  </div>
  <hr>
  
  <!-- Contact -->
  <div class="w3-container" id="contact">
    <h2>Contact</h2>
    <i class="fa fa-map-marker" style="width:30px"></i> Panajachel Guatemala<br>
    <i class="fa fa-phone" style="width:30px"></i> Phone: +00 151515<br>
    <i class="fa fa-envelope" style="width:30px"> </i> Email: ellobohotel@mail.com<br>
    
    </div>
  <div class="w3-container" id="contact">
    <hr>
    <h2>Registrarse</h2>
    <form action="registrarUsuario" method="POST">
      <p><input class="w3-input w3-border" type="text" name="usuario" placeholder="Nombre de Usuario" required=""></p>
      <p><input class="w3-input w3-border" type="password" name="contrasenia" placeholder="Contraseña" required=""></p>
      <p><input class="w3-input w3-border" type="text" name="direccion" placeholder="Direccion" required=""></p>
      <p><input class="w3-input w3-border" type="text" name="telefono" placeholder="Telefono" required=""></p>
      <p><input class="w3-input w3-border" type="text" name="edad" placeholder="Edad" required=""></p>
      <button type="submit" class="w3-button w3-green w3-third">Registrar</button>
    </form>
  </div>
  
  <footer class="w3-container w3-padding-16" style="margin-top:32px">USAC <a ></a></footer>

<!-- End page content -->
</div>

<!-- Subscribe Modal -->
<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <h2 class="w3-wide">LOGIN</h2>
      <form action="login" method="POST">
      <p>Por favor ingrese su usuario y contraseña</p>
      
      <p><input class="w3-input w3-border" name="usuario" type="text" placeholder="Nombre de Usuario" required=""></p>
      <p><input class="w3-input w3-border" name="contrasenia" type="password" placeholder="Contraseña" required="" ></p>
      <button  class="w3-button w3-padding-large w3-green w3-margin-bottom">Enviar</button>
      </form>
    </div>
  </div>
</div>

<script>
// Script to open and close sidebar when on tablets and phones
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Slideshow Apartment Images
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
  }
  x[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " w3-opacity-off";
}
</script>

</body>
</html>
