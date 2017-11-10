package Clases;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class cargaXMLHabitaciones extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
            FileItemFactory itemfactory = new DiskFileItemFactory(); 
            ServletFileUpload upload = new ServletFileUpload(itemfactory);
            try{
                List<FileItem> items = upload.parseRequest(request);
                for(FileItem item:items)
                {
                    FileItem archivoItem = (FileItem) item;
                    if (!archivoItem.isFormField())
                    {
                        File archivo = new File("C:\\Users\\USuario1\\Desktop\\documentoHabitaciones.xml");
                        item.write(archivo);                                             
                    
                        Clase_Analizador cargar = new Clase_Analizador();
                        String respuesta = cargar.analizadorXMLHabitaciones();
                        //response.setStatus(HttpServletResponse.SC_RESET_CONTENT);                    
                    }
                }
            request.setAttribute("infoMessage", "Habitaciones cargadas con exito");
            request.getRequestDispatcher("cargarArchivos.jsp").forward(request, response);
            }
            catch(FileUploadException e){
                out.println("Carga Sin Exito");
            }
            catch(Exception ex){
                out.println(ex.toString());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
            processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet Para Cargar XML";
    }
}