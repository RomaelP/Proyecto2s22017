package Clases;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;			// |
import org.jdom.Element;			// |\ Librerias
import org.jdom.JDOMException;		// |/ JDOM
import org.jdom.input.SAXBuilder;

public class Clase_Analizador {
    
    String GlobalDato = "";
    String Usuario = "";
    String Tarjeta = "";
    String Habitacion = "";
    String fechaIngreso = "";
    String fechaSalida = "";
    String extra="";
    int cont=0;
     
    public String analizadorXMLUsuarios(){
        SAXBuilder builder = new SAXBuilder();
        String respuesta = "";
	File xmlFile = new File("C:\\Users\\USuario1\\Desktop\\documentoUsuarios.xml" );//cambiar esta direccion a los documentos
        
        try
		{
			Document document = (Document) builder.build( xmlFile );//Se crea el documento a traves del archivo
                        Element rootNode = document.getRootElement();//Se obtiene la raiz 'tables'
			List lista_campos = rootNode.getChildren( "usuario" );//Se obtiene la lista de hijos de la raiz 'tables'
			for ( int j = 0; j < lista_campos.size(); j++ )
                            {
				Element campo = (Element)lista_campos.get( j );//Se obtiene el elemento 'campo'
					//Se obtienen los valores que estan entre los tags '<campo></campo>'
					//Se obtiene el valor que esta entre los tags '<nombre></nombre>'
                                String nombre = campo.getChildTextTrim("nombre");
				String contra = campo.getChildTextTrim("password");//Se obtiene el valor que esta entre los tags '<tipo></tipo>'
                                String direccion = campo.getChildTextTrim("direccion");//Se obtiene el valor que esta entre los tags '<valor></valor>'
                                String telefono = campo.getChildTextTrim("telefono");
                                String edad = campo.getChildTextTrim("edad");
                                
                                coneccionServidor conser = new coneccionServidor();
                                conser.agregarNuevoUsuario(nombre, contra, direccion, telefono, edad);
                                //System.out.println( "\t"+nombre+"\t"+contra+"\t"+direccion+"\t"+telefono+"\t"+edad);
                                
                                respuesta += "\t"+nombre+"\t"+contra+"\t"+direccion+"\t"+telefono+"\t"+edad+"\n";
				}
			//}
		}catch ( IOException io ) {
			System.out.println( io.getMessage() );
		}catch ( JDOMException jdomex ) {
			System.out.println( jdomex.getMessage() );
		}
        return respuesta;
    }
    
    public String analizadorXMLHabitaciones(){
        SAXBuilder builder = new SAXBuilder();
        String respuesta = "";
	File xmlFile = new File("C:\\Users\\Usuario1\\Desktop\\documentoHabitaciones.xml" );   
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List lista_campos = rootNode.getChildren("habitación");
            
            for (int j = 0; j < lista_campos.size(); j++){
                Element campo = (Element)lista_campos.get(j);
                String nivel = campo.getChildTextTrim("nivel");
                String numero = campo.getChildText("numero");
                String codigo = generarCodigoHabitacion(nivel, numero);
                
                coneccionServidor conser = new coneccionServidor();
                conser.agregarNuevaHabitacion(nivel, numero, codigo);
                
                respuesta += "\t"+nivel+"\t"+numero+"\n";
            }
            
            }catch ( IOException io ) {
			System.out.println( io.getMessage() );
            }catch ( JDOMException jdomex ) {
			System.out.println( jdomex.getMessage() );
		}
        return respuesta;
    }
    
    public String generarCodigoHabitacion(String nivel, String numero ){
            String codigo = nivel+numero;
        return codigo;
    }
    
    public String analizadorXMLReservaciones(){
        try {
            File xmlFile = new File("C:\\Users\\USuario1\\Desktop\\documentoReservaciones.xml");
            FileReader Datos = new FileReader(xmlFile);
            BufferedReader leer = new BufferedReader(Datos);
            String linea = leer.readLine();
            while (linea != null){
                GlobalDato += linea;
                linea = leer.readLine();
            }
            analizadorLexico(GlobalDato);
            return Usuario + Tarjeta + Habitacion + fechaIngreso + fechaSalida + extra + cont;
        } catch (IOException e) {
            System.out.println(e.toString());
            return "";
        }
    }
    
    public void analizadorLexico(String cadena){
        int inicioestado = 0;
        int estadoprincipal = 0;
        char cadenaconcatenar;
        String token = "";
        
        for(inicioestado = 0; inicioestado < cadena.length(); inicioestado++){
            cadenaconcatenar = cadena.charAt(inicioestado);
            int codigoAscii = cadenaconcatenar;
            
            switch(estadoprincipal){
                case 0://Reservacione / Reservacion
                    if(cadenaconcatenar == ' '|| cadenaconcatenar == '\r' || cadenaconcatenar == '\t' || cadenaconcatenar == '\n' || cadenaconcatenar == '\b'|| cadenaconcatenar == '\f'){
                        estadoprincipal = 0;
                    }else if(cadenaconcatenar == '<'){
                        estadoprincipal = 0;
                        token += cadenaconcatenar;
                    }else if((codigoAscii >= 65 && codigoAscii <= 90) || (codigoAscii >= 97 && codigoAscii <= 122)){
                        estadoprincipal = 0;
                        token += cadenaconcatenar;
                    }else if(cadenaconcatenar == '>'){
                        token += cadenaconcatenar;
                        if (token.equals("<reservaciones>")){
                            estadoprincipal = 0;
                            token = "";
                        }else if(token.equals("<reservacion>")){
                            estadoprincipal = 1;
                            token = "";
                        }else if (token.equals("</reservacion>")){
                            //aqui se hacen las subcadenas para obtener el nivel y el numero
                            String nivel = Habitacion.substring(0,1);
                            String numeroH = Habitacion.substring(1,Habitacion.length());
                            int nivelI = Integer.parseInt(nivel);
                            int numHabi = Integer.parseInt(numeroH);
                            String monto = devolverMonto(nivelI, numHabi, cont);
                            String anio = fechaIngreso.substring(0,4);
                            String mes = fechaIngreso.substring(4,6);
                            String dia = fechaIngreso.substring(6,8);
                            String idFecha = dia+mes+anio;
                            
                            coneccionServidor reservaciones = new coneccionServidor();
                            reservaciones.agregarReservacion(Usuario, Habitacion, Tarjeta, monto, anio, mes, dia, idFecha, fechaIngreso, fechaSalida);
                                                       
                            Usuario = "";
                            Tarjeta = "";
                            Habitacion = "";
                            fechaIngreso = "";
                            fechaSalida = "";
                            extra="";
                            cont = 0;
                            
                            estadoprincipal = 0;
                            token = "";
                        }else if (token.equals("</reservaciones>")){
                            estadoprincipal = 0;
                            token = "";
                        }else if (token.equals("</extras>")){
                            estadoprincipal = 1;
                            token = "";                            
                        }
                    }
                break;  
                
                case 1://apertura TAG
                    if(cadenaconcatenar == ' ' || cadenaconcatenar == '\r' || cadenaconcatenar == '\t' || cadenaconcatenar == '\n' || cadenaconcatenar =='\b' || cadenaconcatenar == '\f'){
                        estadoprincipal = 1;
                    }else if(cadenaconcatenar == '<'){
                        estadoprincipal = 1;
                        token += cadenaconcatenar;
                    }else if((codigoAscii >= 65 && codigoAscii <= 90) || (codigoAscii >= 97 && codigoAscii <= 122)){
                        estadoprincipal = 1;
                        token += cadenaconcatenar;
                    }else if(cadenaconcatenar == '>'){
                        estadoprincipal = 2;
                        token += cadenaconcatenar;
                    }else if(cadenaconcatenar == '/'){
                        estadoprincipal = 0;
                        token += cadenaconcatenar;
                    }
                break;
                
                case 2://contenido de la etiqueta
                    if (cadenaconcatenar == '\r' || cadenaconcatenar == '\t' || cadenaconcatenar == '\n' || cadenaconcatenar == '\b' || cadenaconcatenar == '\f'){
                        estadoprincipal = 2;
                    }else if((codigoAscii >= 65 && codigoAscii <= 90) || (codigoAscii >= 97 && codigoAscii <= 122) || (codigoAscii >= 48 && codigoAscii <= 57) || cadenaconcatenar == ' '){
                        switch(token){
                            case "<usuario>":
                                estadoprincipal = 2;
                                Usuario += cadenaconcatenar;
                                break;
                                
                            case "<tarjeta>":
                                estadoprincipal = 2;
                                Tarjeta += cadenaconcatenar;
                                break;
                                
                            case "<habitacion>":
                                estadoprincipal = 2;
                                Habitacion += cadenaconcatenar;
                                break;
                                
                            case "<fechaIngreso>":
                                estadoprincipal = 2;
                                fechaIngreso += cadenaconcatenar;
                                break;
                                
                            case "<fechaSalida>":
                                estadoprincipal = 2;
                                fechaSalida += cadenaconcatenar;
                                break;
                                
                            case "<extra>":
                                estadoprincipal = 2;
                                extra += cadenaconcatenar;
                                break;
                        }
                    }
                    else if(cadenaconcatenar == '<' && !token.equals("<extras>")){
                        if(token.equals("<extra>")){
                            cont++;
                        }                            
                        estadoprincipal = 3;
                        token="";                            
                    }else if(cadenaconcatenar == '<' && token.equals("<extras>")){
                        token="";                        
                        estadoprincipal = 1;
                        token+= cadenaconcatenar;                        
                    }
                    break;
                    
                case 3://cierre
                    if (cadenaconcatenar == ' ' || cadenaconcatenar == '\r' || cadenaconcatenar == '\t' || cadenaconcatenar == '\n' || cadenaconcatenar == '\b' || cadenaconcatenar == '\f'){
                        estadoprincipal = 3;
                    }else if(cadenaconcatenar == '/'){
                        estadoprincipal = 3;
                    }else if((codigoAscii >= 65 && codigoAscii <= 90) || (codigoAscii >= 97 && codigoAscii <= 122)){
                        estadoprincipal = 3;
                    }else if(cadenaconcatenar == '>'){
                        estadoprincipal = 1;
                    }
                    break;
            }
        }
    }
    
    public String devolverMonto(int nivel, int numero, int extras)
    {
        int monto = 0;
        int temporal = 0;
        
        for(int i = 0; i < extras; i++)
        {
            if (i<3)
            {
                temporal += 75;
            }else
            {
                temporal += 50;
            }
        }
        monto = (200*nivel)+numero+temporal;
        String montoCadena = Integer.toString(monto);
    return montoCadena;
    }
}
