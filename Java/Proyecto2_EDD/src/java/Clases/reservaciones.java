
package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USuario1
 */
public class reservaciones extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String tarjeta = request.getParameter("tarjeta");
            String idfecha = calcularTotal.dia+calcularTotal.mes+calcularTotal.anio;
            String monto = Integer.toString(calcularTotal.Total);
            
            /*out.print(coneccionServidor.Usuario+"   "+calcularTotal.Habitacion+"  "+tarjeta+"  "+monto+
                    "  "+calcularTotal.anio+"  "+calcularTotal.mes+"  "+calcularTotal.dia+
                    "  "+idfecha+"  "+calcularTotal.fechaEntrada+"  "+calcularTotal.fechaSalida);*/
            
            
           
            coneccionServidor multiples = new coneccionServidor();
            String res = multiples.agregarReservacion(coneccionServidor.Usuario, 
                   calcularTotal.Habitacion,
                   tarjeta,
                   monto,
                   calcularTotal.anio, 
                   calcularTotal.mes, 
                   calcularTotal.dia, 
                   idfecha, 
                   calcularTotal.fechaEntrada, 
                   calcularTotal.fechaSalida);
            
            System.out.print(res);
        
        coneccionServidor.cadenaHabitaciones = "";
            coneccionServidor cone = new coneccionServidor();
            String Habitaciones = cone.obtenerHabitaciones();
            //out.print(Habitaciones);
            String [] cargarHabitaciones;
            cargarHabitaciones =  Habitaciones.split("#");
            
            for(int i = 0; i<cargarHabitaciones.length; i++)
            {
                coneccionServidor.cadenaHabitaciones +=  "<div class=\"w3-third w3-margin-bottom\">"
                        +  "<div class=\"w3-container w3-white\">"
                        +  "<h3 class=\"w3-opacity\">Habitacion</h3>"
                        +  "<h3>Habitacion " + cargarHabitaciones[i] +" <label><input type=\"radio\" name=\"optradio\" value=\"" + cargarHabitaciones[i] + "\"></h3>"
                        + "</div>"
                        + "</div>";
            }
            request.setAttribute("habitaciones", coneccionServidor.cadenaHabitaciones);
            request.getRequestDispatcher("inicioUsuario.jsp").forward(request, response);
        }
        //limpiarVariables();
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void limpiarVariables() {
        calcularTotal.Habitacion = "";
        calcularTotal.anio = ""; 
                   calcularTotal.mes = ""; 
                   calcularTotal.dia = ""; 
                   calcularTotal.fechaEntrada = ""; 
                   calcularTotal.fechaSalida = "";
    }

}
