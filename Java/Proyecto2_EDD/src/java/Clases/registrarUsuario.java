
package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //out.println("prueba del servlet");
            //out.println("datos "+request.getParameter("usuario")+" "+request.getParameter("contrasenia")+" "+request.getParameter("direccion")+" "+request.getParameter("telefono")+" "+request.getParameter("edad"));
            String usuario = request.getParameter("usuario");
            String contra = request.getParameter("contrasenia");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String edad = request.getParameter("edad");
            
            coneccionServidor con = new coneccionServidor();
            //System.out.println("**antes de verificar: "+usuario+" "+contra+" "+direccion+" "+telefono+" "+edad );
            String respuestaConeccion = con.agregarNuevoUsuario(usuario, contra, direccion, telefono, edad);
            //out.println(respuestaConeccion);
            
            if (respuestaConeccion != null){
                if (respuestaConeccion.equals("True")){
                    request.setAttribute("informaMessage", "Usuario Agregado");
                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("informaMessage", "No se ha podido Conectar con el Servidor");
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }
            
            
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
