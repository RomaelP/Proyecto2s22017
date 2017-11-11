
package Clases;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import org.apache.taglibs.standard.tag.el.core.OutTag;

public class coneccionServidor {
    
    public static String globalIpAModificar = "127.0.0.5";
    public static OkHttpClient clienteWEB = new OkHttpClient();
    
    public static String Usuario = "";
    public static String Contrasenia = "";
    //public static String Tarjeta = "";
    
    public static String cadenaHabitaciones = "";
    
    public String verificarUsuario(String usuario, String contrasenia){
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario", usuario)
                .add("contrasenia",contrasenia)
                .build();
        String res = metodoConectar("verificarUsuario", formBody);
        System.out.println(res);
        return res; 
    }
    
    public String agregarNuevoUsuario(String usuario, String contra, String direccion, String telefono, String edad){
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario",usuario)
                .add("contrasenia",contra)
                .add("direccion", direccion)
                .add("telefono",telefono)
                .add("edad",edad)
                .build();
        String res = metodoConectar("agregarNuevoUsuario", formBody);
        System.out.println("usuario Agregado: "+res);
    return res;
    }
    
    public String agregarNuevaHabitacion(String nivel, String numero, String codigo){
        RequestBody formBody = new FormEncodingBuilder()
                .add("nivel", nivel)
                .add("numero", numero)
                .add("codigo",codigo)
                .build();
        String res = metodoConectar("agregarNuevaHabitacion", formBody);
        System.out.println(" "+res);
        return res;
    }
    
    public String agregarReservacion(String Usuario, String cod_habitacion, String tarjeta, String monto, String anio, String mes, String dia, String idfecha, String ingreso, String salida){
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario", Usuario)
                .add("habitacion", cod_habitacion)
                .add("tarjeta",tarjeta)
                .add("monto",monto)
                .add("anio", anio)
                .add("mes", mes)
                .add("dia", dia)
                .add("idfecha",idfecha)
                .add("ingreso",ingreso)
                .add("salida",salida)
                .build();
        String res = metodoConectar("agregarNuevaReservacion", formBody);
        System.out.println(" "+res);
        return res;
    } 
    
    public String habitacionesUsuario(String usuario)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario",usuario)
                .build();
        String res = metodoConectar("habitacionesUsuario", formBody);
        System.out.println(" "+res);   
    return res;
    }
    
    public String actualizarReservacion(String codHabitacion)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("habitacion",codHabitacion)
                .build();
        String res = metodoConectar("actualizarReservacion", formBody);
        System.out.println(" "+res);
        return res;
    }
    
    public String eliminarUsuario(String usuarioX)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario",usuarioX)
                .build();
        String res = metodoConectar("eliminarUsuario", formBody);
        return res;
    }
    
    public String eliminarHabitacion(String habitacion)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("habitacion", habitacion)
                .build();
        String res = metodoConectar("eliminarHabitacion", formBody);
        return res;
    }
    
    public static String metodoConectar(String metodoServidor, RequestBody formBody){//Metodo que hace la conexion, todos los metodos post lo llaman
    try{
        URL url = new URL("http://"+globalIpAModificar+":5000/" + metodoServidor);
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = clienteWEB.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
            String valorrespuesta = response.body().string();//y este seria el string de las respuesta
            System.out.println(valorrespuesta);
            return valorrespuesta;
        }catch (MalformedURLException ex){
            java.util.logging.Logger.getLogger(coneccionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            java.util.logging.Logger.getLogger(coneccionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
    
    public String obtenerHabitaciones(){//Metodo GET para obtener las Habitaciones 
        try {
            URL url = new URL("http://"+globalIpAModificar+":5000/obtenerCadenaHabitaciones");
            Request request = new Request.Builder().url(url).get().build();
            Response respuestaPython = clienteWEB.newCall(request).execute();
            return respuestaPython.body().string();
            
        }catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(coneccionServidor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch (IOException ex) {
            java.util.logging.Logger.getLogger(coneccionServidor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
