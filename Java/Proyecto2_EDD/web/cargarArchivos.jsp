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
      <a href="inicio.jsp" onclose="" class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-arrow-circle-left"></i> Regresar a Inicio</a>
      <hr>
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
    <hr>
  </div>


  <div class="w3-container">
      
      <center><h3 class="w3-text-green">Modulo de Administrar Archivos</h3></center>
      <form action="cargaXMLUsuarios" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <th align="center">  </th>
                    <p><i class="fa fa-fw fa-upload"></i><i class="fa fa-fw fa-user-circle-o"></i> Usuarios</p>
                    <input style="color: black" type="file" name="file" class="btn btn-default">
                </tr>
                <tr>
                    <th align="center">  </th>
                    <input style="color: black" type="submit" value="Cargar Usuarios" class="btn btn-default">
                </tr>
            </table>
        </form>
     
      <hr>
      
            <form action="cargaXMLHabitaciones" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <th align="center">  </th>
                    <p><i class="fa fa-fw fa-upload"></i><i class="fa fa-fw fa-building"></i> Habitaciones</p>
                    <input style="color: black" type="file" name="file" class="btn btn-default">
                </tr>
                <tr>
                    <th align="center">  </th>
                    <input style="color: black" type="submit" value="Cargar Habitaciones" class="btn btn-default">
                </tr>
            </table>
        </form>
      <hr>
      
            <form action="cargaXMLReservaciones" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <th align="center">  </th>
                    <p><i class="fa fa-fw fa-upload"></i><i class="fa fa-fw fa-check-circle-o"></i> Reservaciones</p>
                    <input style="color: black" type="file" name="file" class="btn btn-default">
                </tr>
                <tr>
                    <th align="center">  </th>
                    <input style="color: black" type="submit" value="Cargar Reservaciones" class="btn btn-default">
                </tr>
            </table>
        </form>
      
  <div class="w3-container" id="agregar">
    <hr>
    <center><h2 class="w3-text-green">Registrar Habitacion</h2></center>
    <form action="cargarHabitacion" method="POST">
      <p><input class="w3-input w3-border" type="text" name="nivel" placeholder="Nivel de la Habitacion" required=""></p>
      <p><input class="w3-input w3-border" type="text" name="numero" placeholder="Numero de Habitacion" required=""></p>
      <button type="submit" class="w3-button w3-green w3-third">Registrar Habitacion</button>
    </form>
  </div>
 </div>
  
  

  
  <footer class="w3-container w3-padding-16" style="margin-top:32px">USAC <a ></a></footer>

<!-- End page content -->
</div>


</body>
</html>

