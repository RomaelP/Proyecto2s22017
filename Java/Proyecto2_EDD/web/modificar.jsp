<%-- 
    Document   : modificar
    Created on : 09-nov-2017, 21:58:56
    Author     : USuario1
--%>

<%@page import="Clases.coneccionServidor"%>
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
<center><h2 class="w3-text-red">Eliminar</h2></center>
  <div class="w3-bar-block">
    
    <a href="#eliminarUsuario" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-user-circle"></i>Usuario</a>
    <a href="#eliminarHabitacion" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-building-o"></i>Habitacion</a>
    <a href="#eliminarAVL" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-money"></i> Pago </a>
    <a href="#eliminarB" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-list-alt"></i> Bitacora </a>
    <br>
    <center><h2 class="w3-text-blue">Modificar</h2></center>
    
    <a href="#editarUsuario" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-user-circle"></i>Usuario</a>
    <a href="#editarAVL" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-money"></i> Pago </a>
    <a href="#editarB" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-list-alt"></i> Bitacora </a>
    <br>
    <br>
    <a href="#apartment" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-fw fa-home"></i>Inicio</a>
    
    <div>
        
        <%if(null != request.getAttribute("informacion"))
                {
                    out.print(request.getAttribute("informacion"));
                }
                %>
    </div>
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
    <h2>Usuario</h2>
    <h2><%= coneccionServidor.Usuario %></h2>
  </div>
  <br>
  <hr>
  <div class="w3-container" id="eliminarUsuario">
      <h5 class="w3-text-red">Eliminar Usuario</h5>
    <form action="elimanarUsuario" method="POST">
      <p><input class="w3-input w3-border" type="text" name="usuario" placeholder="Usuario a eliminar" required=""></p>
      <button type="submit" class="w3-button w3-green w3-third">Eliminar Usuario</button>
    </form>
     
  </div>
  <hr>
  
  <div class="w3-container" id="eliminarHabitacion">
      <h5 class="w3-text-red">Eliminar Habitacion</h5>
    <form action="elimanarHabitacion" method="POST">
      <p><input class="w3-input w3-border" type="text" name="habitacion" placeholder="Habitacion a eliminar" required=""></p>
      <button type="submit" class="w3-button w3-green w3-third">Eliminar Habitacion</button>
    </form>
  </div>
  <hr>
  <div class="w3-container" id="eliminarAVL">
      <h5 class="w3-text-red">Eliminar Pago(AVL)</h5>
    <form action="elimanarAVL" method="POST">
      <p><input class="w3-input w3-border" type="text" name="usuario" placeholder="Tarjeta a eliminar" required=""></p>
      <button type="submit" class="w3-button w3-green w3-third">Eliminar Pago</button>
    </form>
  </div>
  <hr>
  <div class="w3-container" id="eliminarB">
      <h5 class="w3-text-red">Eliminar Bitacora(B)</h5>
    <form action="elimanarBitacora" method="POST">
      <p><input class="w3-input w3-border" type="text" name="usuario" placeholder="Eliminar por Fecha de Entrada" required=""></p>
      <button type="submit" class="w3-button w3-green w3-third">Eliminar Bitacora</button>
    </form>
  </div>
  <hr>
  <hr>
  <hr>
  
    <div class="w3-container" id="editarUsuario">
      <h4 class="w3-text-green">Modificar Usuario</h4>
      <h4 class="w3-text-green"> <%= coneccionServidor.Usuario %> </h4>
      <form action="editarUsuario" method="POST">
          <h6 class="w3-text-green">Editar Nombre</h6>  
        <p><input class="w3-input w3-border" type="text" name="nuevo" placeholder="Nuevo Nombre" required=""></p>
        <button type="submit" class="w3-button w3-green w3-third">Modificar Nombre</button>
      </form>
      <br>
      <hr>
      <br>
      <form action="editarPass" method="POST">
        <h6 class="w3-text-green">Editar Contraseña</h6>  
        <p><input class="w3-input w3-border" type="text" name="nuevaContra" placeholder="Nueva Contraseña" required=""></p>
        <button type="submit" class="w3-button w3-green w3-third">Modificar Contraseña</button>
      </form>
      <br>
      <hr>
      <br>
      <form action="editarDireccion" method="POST">
        <h6 class="w3-text-green">Editar Direccion</h6>
        <p><input class="w3-input w3-border" type="text" name="nuevaDireccion" placeholder="Nueva Direccion" required=""></p>
        <button type="submit" class="w3-button w3-green w3-third">Modificar Direccion</button>
      </form>
      <br>
      <hr>
      <br>
      <form action="editarTelefono" method="POST">
        <h6 class="w3-text-green">Editar Telefono</h6> 
        <p><input class="w3-input w3-border" type="text" name="nuevoTelefono" placeholder="Nuevo Telefono" required=""></p>
        <button type="submit" class="w3-button w3-green w3-third">Modificar Telefono</button>
      </form>
      <br>
      <hr>
      <br>
      <form action="editarEdad" method="POST">
        <h6 class="w3-text-green">Editar Edad</h6>
        <p><input class="w3-input w3-border" type="text" name="nuevaEdad" placeholder="Nueva Edad" required=""></p>
        <button type="submit" class="w3-button w3-green w3-third">Modificar Edad</button>
      </form>
      <br>
    
  </div>
  <hr>
  
  <div class="w3-container" id="editarAVL">
      <h4 class="w3-text-green">Editar Pago/Tarjeta(AVL)</h4>
      <form action="edTarjetaAVL" method="POST">
        <h6 class="w3-text-green">Editar Tarjeta</h6>  
        <p><input class="w3-input w3-border" type="text" name="tarjeta" placeholder="Numero de Tarjeta" required=""></p>
        <p><input class="w3-input w3-border" type="text" name="nuevaTarjeta" placeholder="Nueva Tarjeta" required=""></p>
        <button type="submit" class="w3-button w3-green w3-third">Modificar Tarjeta</button>
      </form>
      <br>
      <hr>
      <br>
       <form action="edMontoAVL" method="POST">
        <h6 class="w3-text-green">Editar Monto</h6>  
        <p><input class="w3-input w3-border" type="text" name="tarjeta" placeholder="Numero de Tarjeta" required=""></p>
        <p><input class="w3-input w3-border" type="text" name="nuevoMonto" placeholder="Nuevo Monto" required=""></p>
        <button type="submit" class="w3-button w3-green w3-third">Modificar Monto</button>
      </form>
  </div>
  <hr>
  
  <div class="w3-container" id="editarB">
      <h4 class="w3-text-green">Editar Bitacora(B)</h4>
      <form action="editarBitacoraUser" method="POST">
        <h6 class="w3-text-green">Editar Fecha de Entrada</h6>  
        <p><input class="w3-input w3-border" type="text" name="usuario" placeholder="Usuario" required=""></p>
        <p><input class="w3-input w3-border" type="text" name="nuevaUsuario" placeholder="Usuario" required=""></p>
        <button type="submit" class="w3-button w3-green w3-third">Modificar Fecha de Entrada</button>
      </form>
  </div>
  <hr>
  
  <!-- Contact -->

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