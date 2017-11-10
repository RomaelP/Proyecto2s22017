
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
public class calcularTotal extends HttpServlet {

    public static int Total;
    public static String anio;
    public static String mes;
    public static String dia;
    public static String fechaEntrada;
    public static String fechaSalida;
    public static String Habitacion;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String chekin = request.getParameter("CheckIn");
            String chekout = request.getParameter("CheckOut");
            String Extras = request.getParameter("extras");
            String habitacion = request.getParameter("optradio");
          
            fechaEntrada = chekin.replace("-","");
            fechaSalida = chekout.replace("-", "");
            
            anio = fechaEntrada.substring(0,4);
            mes = fechaEntrada.substring(4,6);
            dia = fechaEntrada.substring(6,8);
            Habitacion = habitacion;
            
            int iExtras = Integer.parseInt(Extras);
            String subNivel ="";
            String subNumero = "";
            
            if (habitacion.length()==3)
           {
                subNivel =  habitacion.substring(0,1);
                subNumero = habitacion.substring(1,3);
            }else
            {
                subNivel = habitacion.substring(0,2);
                subNumero = habitacion.substring(2,4);
            }
            
            int Nivel = Integer.parseInt(subNivel);
            int noHabita = Integer.parseInt(subNumero);
            
            int Subtotal = (Nivel*200)+noHabita;
            int totalExtras = 0;
            for(int i=0; i<iExtras; i++)
            {
                if(i<3)
                {
                    totalExtras += 75;
                }else
                {
                    totalExtras += 50;
                }
            }
            
            Total = totalExtras + Subtotal;
            request.setAttribute("total", Total);
            request.setAttribute("habitaciones", coneccionServidor.cadenaHabitaciones);
            request.getRequestDispatcher("inicioUsuario.jsp").forward(request, response);
            
            //out.print(chekin+"%"+ chekout+"%"+Extras+"%"+habitacion+"%"+subNivel+"%"+subNumero+"%"+Total);
        }
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

}
