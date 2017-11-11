<%-- 
    Document   : inicioUsuario
    Created on : 25-oct-2017, 23:00:21
    Author     : USuario1
--%>

<%@page import="Clases.calcularTotal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Inicio Usuario</title>
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
  <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-transparent w3-display-topright"></i>
    <h3 class="w3-text-green">Reservaciones</h3>
    <br>
        <form action="obtenerHabitaciones" method="POST">
          <p><button class="w3-bar-item w3-button w3-padding-16" type="submit"><i class="fa fa-building w3-margin-left"></i> Mostrar Habitaciones </button></p>
          <!--<input style="" type="submit" value="Prueba" class="btn btn-default">
          <a class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-building"></i> Mostrar Habitaciones </a>-->
    </form>
    
    <a href="misHabitaciones.jsp" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-home w3-margin-left"></i>Ver Mis Habitaciones</a>
    <a href="modificar.jsp" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-close w3-margin-top"></i>Modulo Modificar/Eliminar</a>
    <br>
    <br>
    <h4 class="w3-text-green"><strong>Extras</strong></h4>
        <p><i class="fa fa-fw fa-cutlery"></i> Restaurant</p>
        <p><i class="fa fa-fw fa-bell"></i> Servicio al Cuarto</p>
        <p><i class="fa fa-fw fa-home"></i> Lavanderia</p>
        <p><i class="fa fa-fw fa-taxi"></i> Servicio de Taxi</p>
        <p><i class="fa fa-fw fa-play"></i> Netflix</p>
        <p><i class="fa fa-fw fa-plane"></i>Shuttle</p>
        <p><i class="fa fa-fw fa-bus"></i> Servicio de Bus</p>
    <hr>

  </div>
  <div class="w3-bar-block">
    <a href="#apartment" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-home"></i>Inicio</a>
    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-16" onclick="document.getElementById('subscribe').style.display='block'"><i class="fa fa-rss"></i> Subscribe</a>
    
    <form >
          <!-- <input style="color: black" type="submit" value="Cargar Usuario" class="btn btn-default"> -->
          <a href="inicio.jsp" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-close"></i> Cerrar Cesion </a>
    </form>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
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
    <h2 class="w3-text-green">Hotel El Lobo</h2>
    <div class="w3-display-container mySlides">
        <img src="Recursos/vistas.jpg" style="width:75%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Ambiente Agradable</p>
      </div>
    </div>
  </div>

  <form action="calcularTotal" method="POST">
  <div class="w3-container w3-margin-top" id="habitaciones">
            <h3>Habitaciones</h3>       
  </div>

  <div class="w3-row-padding w3-padding-6">

                <%if(null != request.getAttribute("habitaciones"))
                {
                    out.print(request.getAttribute("habitaciones"));
                }
                %>

    </div>
      <p><label class="w3-text-green"><i class="fa fa-calendar-check-o"></i> Check In</label></p>
      <input class="w3-input w3-border" type="date" placeholder="" name="CheckIn" required>          
      <p><label class="w3-text-green"><i class="fa fa-calendar-o"></i> Check Out</label></p>
      <input class="w3-input w3-border" type="date" placeholder="" name="CheckOut" required>         
      <p><label class="w3-text-green"><i class="fa fa-home"></i> Extras </label></p>
      <input class="w3-input w3-border" type="number" name="extras" value="1" name="Adults" min="1" max="10">
      <p><button class="w3-button w3-block w3-green w3-left-align" type="submit"><i class="fa fa-fw fa-list"></i> Calcular Total</button></p>
                    
  </form>
  <div class="w3-container">        
    <hr>
         <p>El total a cancelar Es:</p>
         <h4 class="w3-text-blue"><%= calcularTotal.Total %></h4> 
    <p><a href="javascript:void(0)" class="w3-button w3-block w3-green w3-left-align" onclick="document.getElementById('subscribe').style.display='block'"><i class="fa fa-fw fa-money"></i>Realizar Pago</a>
        <br>
        <h4><strong>Extra Info</strong></h4>
    <hr>
     
  </div>
  <hr>
  
  <!-- Contact -->
  <div class="w3-container" id="contact">
    <h2>Contact</h2>
    <i class="fa fa-map-marker" style="width:30px"></i> Panajachel, Guatemala<br>
    <i class="fa fa-phone" style="width:30px"></i> Telefono: +00 151515<br>
    <i class="fa fa-envelope" style="width:30px"> </i> Email: ellobohotel@mail.com<br>
    <p>Otro titulo para esto</p>
    <form action="/action_page.php" target="_blank">
      <p><input class="w3-input w3-border" type="text" placeholder="Name" required name="Name"></p>
      <p><input class="w3-input w3-border" type="text" placeholder="Email" required name="Email"></p>
      <p><input class="w3-input w3-border" type="text" placeholder="Message" required name="Message"></p>
    <button type="submit" class="w3-button w3-green w3-third">Send a Message</button>
    </form>
  </div>
  <footer class="w3-container w3-padding-16" style="margin-top:32px">USAC <a ></a></footer>

<!-- End page content -->
</div>

<!-- Subscribe Modal -->


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

<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <h2 class="w3-wide">TOTAL A PAGAR</h2>
      
      <form action="reservaciones" method="POST">
      <p>El total a cancelar Es:</p>
      <h4><%= calcularTotal.Total %></h4>
      
      <p><input class="w3-input w3-border" name="tarjeta" type="text" placeholder="Tarjeta de Credito/Debito" required="" ></p>
      <button  class="w3-button w3-padding-large w3-green w3-margin-bottom">Reservar</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>

