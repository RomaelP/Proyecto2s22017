<%-- 
    Document   : misHabitaciones
    Created on : 09-nov-2017, 21:42:55
    Author     : USuario1
--%>

<%@page import="Clases.coneccionServidor"%>
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
<h3>Usuario</h3>
<center><h4 class="w3-text-green"><%= coneccionServidor.Usuario %></h4></center> 
  <div class="w3-bar-block">
        <form action="habitacionesUsuario" method="POST"> 
        <p><button class="w3-bar-item w3-button w3-padding-16" type="submit"><i class="fa fa-building w3-margin-left"></i>Ver Mis Reservaciones</button></p>
        </form> 
    
    <a href="inicioUsuario.jsp" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-arrow-circle-left w3-margin-left"></i> Reservaciones </a>
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
        <img src="Recursos/principal.jpg" style="width:75%;margin-bottom:-6px">
      <div class="w3-display-bottomleft w3-container w3-black">
        <p>Habitacion</p>
      </div>
        <hr>
  </div>

    <form action="devolverHabitaciones" method="POST">  
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
        <div>
            <button type="submit" class="w3-button w3-green w3-third"><i class="fa fa-fw fa-check-circle"></i>Devolver Habitacion</button>
        </div>
      </form>

  
  
  <!-- Contact -->

  <div class="w3-container" id="contact">
    <hr>

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

</body>
</html>

