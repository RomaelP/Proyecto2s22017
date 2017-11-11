from ArbolB import ArbolB
from ListaB import ListaB
from ListaDoble import ListaDoble
from ListaSimple import ListaSimple
from Matriz import Matriz
from NodoMatriz import NodoMatriz
from NodoHash import NodoHash
from TablaHash import TablaHash
from ArbolB import ArbolB

claseArbolB = ArbolB()
claseListaB = ListaB()
listaDoble = ListaDoble()
listaSimple = ListaSimple()
arbolB = ArbolB()
matriz = Matriz()

tablaHash = TablaHash()

if __name__ == "__main__":
    
    
    while True:
        print "*****Menu de Prueba*****"
        print "Lista Doble(usuarios) 1.-Agregar 3.-Archivo 4.-Eliminar 5.-Modificar"
        print "Lista Simple Circular(Habitaciones) 6.-Agregar 70.-Escribir Archivo"
        print "Arbol B 80.-Agregar 90.-Actualizar 100.-Eliminar 110.-Eliminar"
        print "71...711. Agregar Matriz"
        print("8. ver profundidad")
        print("9. graficar")
        print("10 y 11. eliminar")        
        num = input("Ingrese una opcion: ")
        
        if num == 1:
            print "Agregar Valores Arbol B"
            arbolB.crearNodoInsertar(int("01022017"), "usuario1", "descripcion1", "20170201", "20170205", "551", "si")
            arbolB.crearNodoInsertar(int("01052019"), "usuario2", "descripcion2", "20170201", "20170205", "551", "si")
            arbolB.crearNodoInsertar(int("11062017"), "usuario3", "descripcion3", "20170201", "20170205", "551", "si")
            arbolB.crearNodoInsertar(int("21092017"), "usuario4", "descripcion4", "20170201", "20170205", "551", "si")
            arbolB.crearNodoInsertar(int("06082015"), "usuario5", "descripcion5", "20170201", "20170205", "551", "si")
            arbolB.crearNodoInsertar(int("02022019"), "usuario6", "descripcion6", "20170201", "20170205", "551", "si")
        
        if num == 2:
            print "graficar Arbol B"
            arbolB.crearArchivo()
            
        if num == 3:
            print "eliminar Arbol B"
            arbolB.Eliminar(int("06082015"))
            
        #if num == 4:

            
        #if num == 5:

            
        #if num == 6:
 
            
        #if num == 61:

            
        #if num == 62:

            
        #if num == 70:
            cadena =str(listaSimple.concatenarHabitaciones())
            print(cadena)
            print("Listado de codigo de Habitaciones")
            #listaSimple.grabarArchivoListaSimple()
            #print("escribiendo archivo Habitaciones\n")
            
        if num == 7:
            anio = "2017"
            numeroMes = "02"
            dia = "14"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)            
            
        if num == 71:
            anio = "2017"
            numeroMes = "03"
            dia = "5"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo) 
            print (str(listaSimple.generarCodigoHabitacion(5,3)))
            
        if num == 72:
            anio = "2019"
            numeroMes = "05"
            dia = "3"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)
                    
        if num == 73:
            anio = "2020"
            numeroMes = "02"
            dia = "25"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)
        if num == 74:
            anio = "2018"
            numeroMes = "01"
            dia = "4"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)
        
        if num == 75:            
            anio = "2018"
            numeroMes = "03"
            dia = "10"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)

        if num == 76:
            anio = "2017"
            numeroMes = "01"
            dia = "2"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)
    
        if num == 77:
            anio = "2017"
            numeroMes = "02"
            dia = "16"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)

        if num == 78:
            anio = "2017"
            numeroMes = "07"
            dia = "7"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)   
                    
        if num == 79:
            anio = "2017"
            numeroMes = "05"
            dia = "10"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)  
                
        if num == 710:
            anio = "2016"
            numeroMes = "02"
            dia = "15"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)
                    
            nodoHash = NodoHash(7, "Luis")
            matriz.agregarTablaHash(nuevoNodo, nodoHash)
            nodoHash = NodoHash(3, "Roma")
            matriz.agregarTablaHash(nuevoNodo, nodoHash) 
            nodoHash = NodoHash(1, "Guayo")
            matriz.agregarTablaHash(nuevoNodo, nodoHash)  
            matriz.graficarTablaHash(nuevoNodo) 
            
        if num == 711:
            anio = "2014"
            numeroMes = "02"
            dia = "14"
            mes = matriz.verMes(numeroMes)
            
            matriz.aumentarContador()
            codigo = str(matriz.obtenerContador())            
            
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia, codigo)           
            
            if matriz.existeReservacion(nuevoNodo) == False:
                matriz.agregarCabecerasMatriz(nuevoNodo)
                if matriz.necesitaProfundidad(nuevoNodo) == True:
                    matriz.agregarProfundidad(nuevoNodo)
                else:
                    matriz.agregarMatriz(nuevoNodo)
                    
                    
            nodoHash = NodoHash(5, "Luis")
            matriz.agregarTablaHash(nuevoNodo, nodoHash)
            nodoHash = NodoHash(9, "Enrique")
            matriz.agregarTablaHash(nuevoNodo, nodoHash) 
            nodoHash = NodoHash(10, "Lopez")
            matriz.agregarTablaHash(nuevoNodo, nodoHash)  
            matriz.graficarTablaHash(nuevoNodo)
                    
        if num == 8:
            anio = "2017"
            mes = matriz.verMes(numeroMes)
            numeroMes = "02"
        
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, "")
            matriz.mostrarProfundidad(nuevoNodo)
            
        if num == 9:
            matriz.archivoMatriz()
    
        if num == 10:
            anio = "2017"
            mes = matriz.verMes(numeroMes)
            numeroMes = "02"
            dia = "14"
        
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia)
            matriz.eliminarMatriz(nuevoNodo)            
            
        if num == 11:
            anio = "2017"
            mes = matriz.verMes(numeroMes)
            numeroMes = "02"
            dia = "16"
        
            nuevoNodo = NodoMatriz(mes, numeroMes, anio, dia)
            matriz.eliminarMatriz(nuevoNodo)   
            
        if num == 18:
            nodoHash = NodoHash(5, "Luis")
            tablaHash.Insertar(nodoHash)
            nodoHash = NodoHash(9, "Enrique")
            tablaHash.Insertar(nodoHash)
            nodoHash = NodoHash(10, "Lopez")
            tablaHash.Insertar(nodoHash)
            nodoHash = NodoHash(78, "Urbina")
            tablaHash.Insertar(nodoHash)
            tablaHash.mostrar()
            tablaHash.graficar()            
            
        if num == 80:            
            claseArbolB.crearNodoInsertar(97, "a", "2", "1", "3")
            claseArbolB.crearNodoInsertar(98, "b", "2", "1", "3")
            claseArbolB.crearNodoInsertar(99, "c", "2", "1", "3")
            claseArbolB.crearNodoInsertar(102, "f", "2", "1", "3")
            claseArbolB.crearNodoInsertar(122, "z", "2", "1", "3")
            claseArbolB.crearNodoInsertar(119, "w", "2", "1", "3")
            claseArbolB.crearNodoInsertar(82, "R", "2", "1", "3")
            claseArbolB.crearNodoInsertar(68, "D", "2", "1", "3")
            claseArbolB.crearNodoInsertar(76, "L", "2", "1", "3") 
            claseArbolB.crearArchivo()            
            
        if num == 90:
            claseArbolB.actualizarNombre(119, "wrt")
            claseArbolB.crearArchivo()            
            
        if num == 100:
            NuevaRaizB = claseArbolB.Eliminar(50)
            claseArbolB.crearArchivo2(NuevaRaizB)  
            
        if num == 110:
            NuevaRaizB = claseArbolB.Eliminar(76)
            claseArbolB.crearArchivo2(NuevaRaizB)            
        
            