/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class cargarHabitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nivel = request.getParameter("nivel");
            String numero = request.getParameter("numero");
            String codigo = obtenerCodigo(nivel, numero);
            
            coneccionServidor con = new coneccionServidor();
            String respServidor = con.agregarNuevaHabitacion(nivel, numero, codigo);
            //out.print(respServidor);
            
            if (respServidor != null)
            {
                if(respServidor.equals("True"))
                {
                    request.setAttribute("informaMessage", "Habitacion Agregada");
                    request.getRequestDispatcher("cargarArchivos.jsp").forward(request, response);
                }else
                {
                    request.setAttribute("informaMessage", "No se pudo conectar al servidor");
                    request.getRequestDispatcher("cargarArchivos.jsp").forward(request, response);
                }
            }
        }
    }
    
    public String obtenerCodigo(String nivel, String numero)
    {
    return nivel+numero;
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
