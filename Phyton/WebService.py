from flask import Flask, request, Response
from ListaDoble import ListaDoble
from ListaSimple import ListaSimple
from ArbolB import ArbolB
from AVL import ArbolAVL
from Matriz import Matriz
from NodoMatriz import NodoMatriz
from NodoLista import NodoLista
from TablaHash import TablaHash
from NodoHash import NodoHash


app = Flask("EDD")

listaUsuarios = ListaDoble()
listaHabitaciones = ListaSimple()
arbolB = ArbolB()
arbolAVL = ArbolAVL()
matriz = Matriz()
tablaHash = TablaHash()

class webService():
    @app.route('/verificarUsuario', methods = ['POST'])
    def verificarUsuario():
        usuario = str(request.form['usuario'])
        contra = str(request.form['contrasenia'])
        respuesta = listaUsuarios.verificarUsuario(usuario, contra)
        return respuesta
    
    @app.route('/agregarNuevoUsuario', methods = ['POST'])
    def agregarUsuario():
        usuario = str(request.form['usuario'])
        contra = str(request.form['contrasenia'])
        direccion = str(request.form['direccion'])
        telefono = str(request.form['telefono'])
        edad = str(request.form['edad'])
        listaUsuarios.insertarListaDoble(usuario, contra, direccion, telefono, edad)
        return "True"
    
    @app.route('/agregarNuevaHabitacion', methods = ['POST'])
    def agregarHabitacions():
        nivel = str(request.form['nivel'])
        numero = str(request.form['numero'])
        codigo = str(request.form['codigo'])
        listaHabitaciones.agregarHabitacion(numero, nivel, codigo, "no")
        return "True"
    
    @app.route('/agregarNuevaReservacion', methods=['POST'])#agrega una nueva reservacion y desencadena otras llamadas AVL/B
    def agregarReservacion():
        usuario = str(request.form['usuario']) 
        habitacion = str(request.form['habitacion'])
        tarjeta = str(request.form['tarjeta'])
        monto = str(request.form['monto'])
        anio = str(request.form['anio'])
        numMes = str(request.form['mes'])
        dia = str(request.form['dia'])
        idfecha = str(request.form['idfecha'])
        ingreso = str(request.form['ingreso'])
        salida = str(request.form['salida'])
        #_#################################################_termino de obtener los 10 parametros ara guardar en las Estructuras
        codigo = int(habitacion)
        nodoHash = NodoHash(codigo, usuario)#
        
        mes = matriz.verMes(numMes)
        matriz.aumentarContador()
        codigo = str(matriz.obtenerContador())
        
        nuevoNodo = NodoMatriz(mes, numMes, anio, dia, codigo)
        
        matriz.agregarCabecerasMatriz(nuevoNodo)
        if matriz.necesitaProfundidad(nuevoNodo) == True:
            matriz.agregarProfundidad(nuevoNodo)
        else:
            matriz.agregarMatriz(nuevoNodo)
        
        matriz.archivoMatriz()
        
        matriz.agregarTablaHash(nuevoNodo, nodoHash)
        matriz.graficarTablaHash(nuevoNodo)
        #_#########################################################################_Matriz/Hash
        nuevoNodoLista = NodoLista(tarjeta, monto)
        arbolAVL.agregarListaAVL(nuevoNodoLista)
        #_##########################################################################_AVL
        descripcion = ("El usaurio "+usuario+" reservo la habitacion: "+habitacion+" gastando un monto de Q"+monto+".00, pago con la tarjeta: "+tarjeta+", fecha de ingreso: "+ingreso+" y fecha de salida: "+salida)
        arbolB.crearNodoInsertar(idfecha, usuario, descripcion, ingreso, salida, habitacion, "si")
        #_##########################################################################_B
        listaHabitaciones.actualizarReservada(habitacion)
        #_####_Actualizar Datos de Habitacion
        
        return "operacion realizada con exito"
    
    
    @app.route('/obtenerCadenaHabitaciones')
    def obtenerHabitaciones():
        cadena = listaHabitaciones.concatenarHabitaciones()
        return cadena
    
    @app.route('/habitacionesUsuario', methods = ['POST'])
    def habitacionesUsuario():
        nombUsuario = str(request.form['usuario'])
        cadena = arbolB.retornarHabitaciones(nombUsuario)
        return cadena
    
    @app.route('/modificarUsuario', methods=['POST'])
    def modificarUsuario():
        usuario = str(request.form['usuario'])
        nuevoNombre = str(request.form['nuevoNombre'])
        respuesta = listaUsuarios.modificarContrasenia(usuario, contraNueva)
        return respuesta
    
    @app.route('/actualizarReservacion', methods=['POST'])
    def actualizarReservacion():
        idHabitacion = str(request.form['habitacion'])
        arbolB.actualizarH(idHabitacion)
        listaHabitaciones.actualizarReservacionDevuelta(idHabitacion)
        return "Dato Actualizado"
    
    @app.route('/eliminarUsuario',methods=['POST'])
    def eliminarUsuario():
        nombre = str(request.form['usuario'])
        listaUsuarios.eliminarUsuario(nombre)
        return "Usuario eliminado "+nombre
    
    @app.route('/eliminarHabitacion', methods=['POST'])
    def eliminarHabitacion():
        habitacion = str(request.form['habitacion'])
        res = listaHabitaciones.eliminarHabitacion(habitacion)
        return res+": "+habitacion
    
    if __name__ == "__main__":
        app.run(debug=True, host='127.0.0.5')#IP para pruebas solo JSP
       # app.run(debug=True, host='192.168.43.128')#IP para pruebas solo Android