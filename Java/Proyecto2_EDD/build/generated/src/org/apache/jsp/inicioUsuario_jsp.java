package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.calcularTotal;

public final class inicioUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<title>Inicio Usuario</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"CSS/nuevoCSS.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<style>\n");
      out.write("body,h1,h2,h3,h4,h5,h6 {font-family: \"Raleway\", Arial, Helvetica, sans-serif}\n");
      out.write(".mySlides {display:none}\n");
      out.write("</style>\n");
      out.write("<body class=\"w3-content w3-border-left w3-border-right\">\n");
      out.write("\n");
      out.write("<!-- Sidebar/menu -->\n");
      out.write("<nav class=\"w3-sidebar w3-light-grey w3-collapse w3-top\" style=\"z-index:3;width:260px\" id=\"mySidebar\">\n");
      out.write("  <div class=\"w3-container w3-display-container w3-padding-16\">\n");
      out.write("    <i onclick=\"w3_close()\" class=\"fa fa-remove w3-hide-large w3-button w3-transparent w3-display-topright\"></i>\n");
      out.write("    <h3 class=\"w3-text-green\">Reservaciones</h3>\n");
      out.write("    <br>\n");
      out.write("        <form action=\"obtenerHabitaciones\" method=\"POST\">\n");
      out.write("          <p><button class=\"w3-bar-item w3-button w3-padding-16\" type=\"submit\"><i class=\"fa fa-building w3-margin-left\"></i> Mostrar Habitaciones </button></p>\n");
      out.write("          <!--<input style=\"\" type=\"submit\" value=\"Prueba\" class=\"btn btn-default\">\n");
      out.write("          <a class=\"w3-bar-item w3-button w3-padding-16\"><i class=\"fa fa-building\"></i> Mostrar Habitaciones </a>-->\n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("    <a href=\"misHabitaciones.jsp\" class=\"w3-bar-item w3-button w3-padding-16\"><i class=\"fa fa-home w3-margin-left\"></i>Ver Mis Habitaciones</a>\n");
      out.write("    <a href=\"modificar.jsp\" class=\"w3-bar-item w3-button w3-padding-16\"><i class=\"fa fa-close w3-margin-top\"></i>Modulo Modificar/Eliminar</a>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <h4 class=\"w3-text-green\"><strong>Extras</strong></h4>\n");
      out.write("        <p><i class=\"fa fa-fw fa-cutlery\"></i> Restaurant</p>\n");
      out.write("        <p><i class=\"fa fa-fw fa-bell\"></i> Servicio al Cuarto</p>\n");
      out.write("        <p><i class=\"fa fa-fw fa-home\"></i> Lavanderia</p>\n");
      out.write("        <p><i class=\"fa fa-fw fa-taxi\"></i> Servicio de Taxi</p>\n");
      out.write("        <p><i class=\"fa fa-fw fa-play\"></i> Netflix</p>\n");
      out.write("        <p><i class=\"fa fa-fw fa-plane\"></i>Shuttle</p>\n");
      out.write("        <p><i class=\"fa fa-fw fa-bus\"></i> Servicio de Bus</p>\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <div class=\"w3-bar-block\">\n");
      out.write("    <a href=\"#apartment\" class=\"w3-bar-item w3-button w3-padding-16\"><i class=\"fa fa-home\"></i>Inicio</a>\n");
      out.write("    <a href=\"javascript:void(0)\" class=\"w3-bar-item w3-button w3-padding-16\" onclick=\"document.getElementById('subscribe').style.display='block'\"><i class=\"fa fa-rss\"></i> Subscribe</a>\n");
      out.write("    \n");
      out.write("    <form >\n");
      out.write("          <!-- <input style=\"color: black\" type=\"submit\" value=\"Cargar Usuario\" class=\"btn btn-default\"> -->\n");
      out.write("          <a href=\"inicio.jsp\" class=\"w3-bar-item w3-button w3-padding-16\"><i class=\"fa fa-close\"></i> Cerrar Cesion </a>\n");
      out.write("    </form>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<!-- Top menu on small screens -->\n");
      out.write("<header class=\"w3-bar w3-top w3-hide-large w3-black w3-xlarge\">\n");
      out.write("  <span class=\"w3-bar-item\">Rental</span>\n");
      out.write("  <a href=\"javascript:void(0)\" class=\"w3-right w3-bar-item w3-button\" onclick=\"w3_open()\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<!-- Overlay effect when opening sidebar on small screens -->\n");
      out.write("<div class=\"w3-overlay w3-hide-large\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n");
      out.write("\n");
      out.write("<!-- !PAGE CONTENT! -->\n");
      out.write("<div class=\"w3-main w3-white\" style=\"margin-left:260px\">\n");
      out.write("\n");
      out.write("  <!-- Push down content on small screens -->\n");
      out.write("  <div class=\"w3-hide-large\" style=\"margin-top:80px\"></div>\n");
      out.write("\n");
      out.write("  <!-- Slideshow Header -->\n");
      out.write("  <div class=\"w3-container\" id=\"apartment\">\n");
      out.write("    <h2 class=\"w3-text-green\">Hotel El Lobo</h2>\n");
      out.write("    <div class=\"w3-display-container mySlides\">\n");
      out.write("        <img src=\"Recursos/vistas.jpg\" style=\"width:75%;margin-bottom:-6px\">\n");
      out.write("      <div class=\"w3-display-bottomleft w3-container w3-black\">\n");
      out.write("        <p>Ambiente Agradable</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <form action=\"calcularTotal\" method=\"POST\">\n");
      out.write("  <div class=\"w3-container w3-margin-top\" id=\"habitaciones\">\n");
      out.write("            <h3>Habitaciones</h3>       \n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"w3-row-padding w3-padding-6\">\n");
      out.write("\n");
      out.write("                ");
if(null != request.getAttribute("habitaciones"))
                {
                    out.print(request.getAttribute("habitaciones"));
                }
                
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("      <p><label class=\"w3-text-green\"><i class=\"fa fa-calendar-check-o\"></i> Check In</label></p>\n");
      out.write("      <input class=\"w3-input w3-border\" type=\"date\" placeholder=\"\" name=\"CheckIn\" required>          \n");
      out.write("      <p><label class=\"w3-text-green\"><i class=\"fa fa-calendar-o\"></i> Check Out</label></p>\n");
      out.write("      <input class=\"w3-input w3-border\" type=\"date\" placeholder=\"\" name=\"CheckOut\" required>         \n");
      out.write("      <p><label class=\"w3-text-green\"><i class=\"fa fa-home\"></i> Extras </label></p>\n");
      out.write("      <input class=\"w3-input w3-border\" type=\"number\" name=\"extras\" value=\"1\" name=\"Adults\" min=\"1\" max=\"10\">\n");
      out.write("      <p><button class=\"w3-button w3-block w3-green w3-left-align\" type=\"submit\"><i class=\"fa fa-fw fa-list\"></i> Calcular Total</button></p>\n");
      out.write("                    \n");
      out.write("  </form>\n");
      out.write("  <div class=\"w3-container\">        \n");
      out.write("    <hr>\n");
      out.write("         <p>El total a cancelar Es:</p>\n");
      out.write("         <h4 class=\"w3-text-blue\">");
      out.print( calcularTotal.Total );
      out.write("</h4> \n");
      out.write("    <p><a href=\"javascript:void(0)\" class=\"w3-button w3-block w3-green w3-left-align\" onclick=\"document.getElementById('subscribe').style.display='block'\"><i class=\"fa fa-fw fa-money\"></i>Realizar Pago</a>\n");
      out.write("        <br>\n");
      out.write("        <h4><strong>Extra Info</strong></h4>\n");
      out.write("    <hr>\n");
      out.write("     \n");
      out.write("  </div>\n");
      out.write("  <hr>\n");
      out.write("  \n");
      out.write("  <!-- Contact -->\n");
      out.write("  <div class=\"w3-container\" id=\"contact\">\n");
      out.write("    <h2>Contact</h2>\n");
      out.write("    <i class=\"fa fa-map-marker\" style=\"width:30px\"></i> Panajachel, Guatemala<br>\n");
      out.write("    <i class=\"fa fa-phone\" style=\"width:30px\"></i> Telefono: +00 151515<br>\n");
      out.write("    <i class=\"fa fa-envelope\" style=\"width:30px\"> </i> Email: ellobohotel@mail.com<br>\n");
      out.write("    <p>Otro titulo para esto</p>\n");
      out.write("    <form action=\"/action_page.php\" target=\"_blank\">\n");
      out.write("      <p><input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Name\" required name=\"Name\"></p>\n");
      out.write("      <p><input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Email\" required name=\"Email\"></p>\n");
      out.write("      <p><input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Message\" required name=\"Message\"></p>\n");
      out.write("    <button type=\"submit\" class=\"w3-button w3-green w3-third\">Send a Message</button>\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("  <footer class=\"w3-container w3-padding-16\" style=\"margin-top:32px\">USAC <a ></a></footer>\n");
      out.write("\n");
      out.write("<!-- End page content -->\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Subscribe Modal -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("// Script to open and close sidebar when on tablets and phones\n");
      out.write("function w3_open() {\n");
      out.write("    document.getElementById(\"mySidebar\").style.display = \"block\";\n");
      out.write("    document.getElementById(\"myOverlay\").style.display = \"block\";\n");
      out.write("}\n");
      out.write(" \n");
      out.write("function w3_close() {\n");
      out.write("    document.getElementById(\"mySidebar\").style.display = \"none\";\n");
      out.write("    document.getElementById(\"myOverlay\").style.display = \"none\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("// Slideshow Apartment Images\n");
      out.write("var slideIndex = 1;\n");
      out.write("showDivs(slideIndex);\n");
      out.write("\n");
      out.write("function plusDivs(n) {\n");
      out.write("  showDivs(slideIndex += n);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function currentDiv(n) {\n");
      out.write("  showDivs(slideIndex = n);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function showDivs(n) {\n");
      out.write("  var i;\n");
      out.write("  var x = document.getElementsByClassName(\"mySlides\");\n");
      out.write("  var dots = document.getElementsByClassName(\"demo\");\n");
      out.write("  if (n > x.length) {slideIndex = 1}\n");
      out.write("  if (n < 1) {slideIndex = x.length}\n");
      out.write("  for (i = 0; i < x.length; i++) {\n");
      out.write("     x[i].style.display = \"none\";\n");
      out.write("  }\n");
      out.write("  for (i = 0; i < dots.length; i++) {\n");
      out.write("     dots[i].className = dots[i].className.replace(\" w3-opacity-off\", \"\");\n");
      out.write("  }\n");
      out.write("  x[slideIndex-1].style.display = \"block\";\n");
      out.write("  dots[slideIndex-1].className += \" w3-opacity-off\";\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<div id=\"subscribe\" class=\"w3-modal\">\n");
      out.write("  <div class=\"w3-modal-content w3-animate-zoom w3-padding-large\">\n");
      out.write("    <div class=\"w3-container w3-white w3-center\">\n");
      out.write("      <i onclick=\"document.getElementById('subscribe').style.display='none'\" class=\"fa fa-remove w3-button w3-xlarge w3-right w3-transparent\"></i>\n");
      out.write("      <h2 class=\"w3-wide\">TOTAL A PAGAR</h2>\n");
      out.write("      <form action=\"reservaciones\" method=\"POST\">\n");
      out.write("      <p>El total a cancelar Es:</p>\n");
      out.write("      <h4>");
      out.print( calcularTotal.Total );
      out.write("</h4>\n");
      out.write("      \n");
      out.write("      <p><input class=\"w3-input w3-border\" name=\"tarjeta\" type=\"text\" placeholder=\"Tarjeta de Credito/Debito\" required=\"\" ></p>\n");
      out.write("      <button  class=\"w3-button w3-padding-large w3-green w3-margin-bottom\">Reservar</button>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
