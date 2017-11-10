from NodoAVL import NodoAVL
from Logical import Logical

class ArbolAVL():
    def __init__(self):
        self.raizPrincipal = None
        self.encontrado = None
        self.raizB = None
        self.inicio = None
        self.nodoAeliminar = None
        self.nodoSustitucion = None        

    def getEncontrado(self):
        return self.encontrado
    
    def setEncontrado(self, valor):
        self.encontrado = valor
        
    def agregarAVL1(self, nuevoNodo):
        temp = self.retorarAVL(nuevoNodo) 
        if temp == None:
            h = Logical(False)
            self.raizPrincipal = self.agregarAVL(self.raizPrincipal, nuevoNodo, h)
            varibleNueva = "nodo agregado correctamente" #print("nodo agregado correctamente")
        else:
            varibleNueva = "ya existe" #print("ya existe")
            
    def retorarAVL(self, nuevoNodo):
        self.setEncontrado(None)
        self.buscarAVL(self.raizPrincipal, nuevoNodo)
        return self.getEncontrado()        
    
    def buscarAVL(self, raiz, nuevoNodo):
        if raiz != None:
            if nuevoNodo.numeroTarjeta == raiz.numeroTarjeta:
                self.setEncontrado(raiz)
            else:
                self.buscarAVL(raiz.izquierda, nuevoNodo)
                self.buscarAVL(raiz.derecha, nuevoNodo)
                
    def agregarAVL(self, raiz, nuevoNodo, h):
        if self.raizPrincipal == None:
            self.raizPrincipal = nuevoNodo
            h.setLogical(True)
            raiz = self.raizPrincipal
        elif raiz == None:
            raiz = nuevoNodo
            h.setLogical(True)
        elif str(nuevoNodo.numeroTarjeta) < str(raiz.numeroTarjeta):
            nodoIz = self.agregarAVL(raiz.izquierda, nuevoNodo, h)
            raiz.izquierda = nodoIz
            if h.getLogical() == True:
                op = raiz.FE
                if op == 1:
                    raiz.FE = 0
                    h.setLogical(False)
                elif op == 0:
                    raiz.FE = -1
                elif op == -1:
                    nodo1 = raiz.izquierda
                    if nodo1.FE == -1:
                        raiz = self.rotacionII(raiz, nodo1)
                    else:
                        raiz = self.rotacionID(raiz, nodo1)
                    h.setLogical(False)
        elif str(nuevoNodo.numeroTarjeta) > str(raiz.numeroTarjeta):
            nodoDr = self.agregarAVL(raiz.derecha, nuevoNodo, h)
            raiz.derecha = nodoDr
            if h.getLogical() == True:
                op = raiz.FE
                if op == 1:
                    nodo1 = raiz.derecha
                    if nodo1.FE == 1:
                        raiz = self.rotacionDD(raiz, nodo1)
                    else:
                        raiz = self.rotacionDI(raiz, nodo1)
                    h.setLogical(False)
                elif op == 0:
                    raiz.FE = 1
                elif op == -1:
                    raiz.FE = 0
                    h.setLogical(False)
        return raiz
    
    def rotacionID(self, nodo, nodo1):
        nodo2 = nodo1.derecha
        nodo1.derecha = nodo2.izquierda
        nodo2.izquierda = nodo1
        nodo.izquierda = nodo2.derecha
        nodo2.derecha = nodo
        #nodo = nodo2
        if nodo2.FE == 1:
            nodo1.FE = -1
        else:
            nodo1.FE = 0
        if nodo2.FE == -1:
            nodo.FE = 1
        else:
            nodo.FE = 0
        nodo2.FE = 0
        return nodo2
    
    def rotacionII(self, nodo, nodo1):
        nodo.izquierda = nodo1.derecha
        nodo1.derecha = nodo
        if nodo1.FE == -1:
            nodo.FE = 0
            nodo1.FE = 0
        else:
            nodo.FE = -1
            nodo1.FE = 1
        return nodo1
    
    def rotacionDD(self, nodo, nodo1):
        nodo.derecha = nodo1.izquierda
        nodo1.izquierda = nodo
        if nodo1.FE == 1:
            nodo.FE = 0
            nodo1.FE = 0
        else:
            nodo.FE = 1
            nodo1.FE = -1
        return nodo1
    
    def rotacionDI(self, nodo, nodo1):
        nodo2 = nodo1.izquierda
        nodo1.izquierda = nodo2.derecha
        nodo2.derecha = nodo1
        nodo.derecha = nodo2.izquierda
        nodo2.izquierda = nodo
    
        if nodo2.FE == 1:
            nodo.FE = -1
        else:
            nodo.FE = 0
        if nodo2.FE == -1:
            nodo1.FE = 1
        else:
            nodo1.FE = 0
        nodo2.FE = 0
        return nodo2
    
    def grabarArchivoAVL(self):
        self.agregarAVLmodificado()  #PRUEBA 1
        nuevoNodo = self.raizPrincipal
        self.limpiarVariableGraficar()
        archivo = open("ArbolAVL.txt", 'w')#<------------------------------------------------------------PATH PARA GRAFICAR----------------
        self.graficarPreOrden(nuevoNodo)
        self.digraf += "\n}"
        archivo.write(self.digraf)
        archivo.close()   
        
    def graficarPreOrden(self, nuevoNodo):
        if nuevoNodo != None:
            self.digraf += "nodo_" + self.arreglarNombre(nuevoNodo.numeroTarjeta) + ' [label="' +self.arreglarNombre(nuevoNodo.numeroTarjeta) + '\\n' +self.arreglarNombre(nuevoNodo.montoGastado)+ ' " ]\n'
            if nuevoNodo.izquierda != None:
                self.digraf += "nodo_" + self.arreglarNombre(nuevoNodo.numeroTarjeta) + " -> " "nodo_" + self.arreglarNombre(nuevoNodo.izquierda.numeroTarjeta) + "\n"
                self.graficarPreOrden(nuevoNodo.izquierda)
            else:
                pass
            if nuevoNodo.derecha != None:
                self.digraf += "nodo_" + self.arreglarNombre(nuevoNodo.numeroTarjeta) + " -> " "nodo_" + self.arreglarNombre(nuevoNodo.derecha.numeroTarjeta) + "\n"
                self.graficarPreOrden(nuevoNodo.derecha)                   
            else:
                pass
        else:
            pass
        
    def arreglarNombre(self, cadena):
        diccionario = {' ':'_','-':'_','.':'_','@':'_','!':'_','#':'_','$':'_','(':'_',')':'_','$':'_'}
        nuevaCadena = ''
        for i in cadena:
            if i in diccionario.keys():
                nuevaCadena += diccionario[i]
            else:
                nuevaCadena +=i
    
        return str(nuevaCadena)
    
    def limpiarVariableGraficar(self):
        self.digraf = "digraph G{\n"
        
    def mostrarPreOrden(self, nuevoNodo):
        if nuevoNodo != None:
            varibleNueva = "" #print(str(nuevoNodo.numeroTarjeta))
            self.mostrarPreOrden(nuevoNodo.izquierda)
            self.mostrarPreOrden(nuevoNodo.derecha)
            
    def mostrarInOrden(self, nuevoNodo):
        if nuevoNodo != None:  
            self.mostrarInOrden(nuevoNodo.izquierda)
            varibleNueva = "" #print(str(nuevoNodo.numeroTarjeta))
            self.mostrarInOrden(nuevoNodo.derecha)
            
    def mostrarPostOrden(self, nuevoNodo):
        if nuevoNodo != None:  
            self.mostrarPostOrden(nuevoNodo.izquierda)
            self.mostrarPostOrden(nuevoNodo.derecha)
            varibleNueva = "" #print(str(nuevoNodo.numeroTarjeta))
            
    def obtenerRaiz(self):
        return self.raizPrincipal
    
    def agregarListaAVL(self, nuevoNodo):
        if self.inicio != None:
            temp = self.inicio
            while temp.siguiente != None:
                temp = temp.siguiente
            temp.siguiente = nuevoNodo
        else:
            self.inicio = nuevoNodo
            
    def agregarAVLmodificado(self):  #Este metodo se llama por primera vez antes de GRAFICAR
        self.raizPrincipal = None
        if self.inicio != None:
            temp = self.inicio
            while temp != None:
                nuevoNodo = NodoAVL(temp.numeroTarjeta, temp.montoGastado)
                self.agregarAVL1(nuevoNodo)
                temp = temp.siguiente
                
    def eliminarAVL(self, numeroTarjeta):
        if self.inicio != None:
            if self.inicio.numeroTarjeta == numeroTarjeta:
                if self.inicio.siguiente != None:
                    self.inicio = self.inicio.siguiente
                else:
                    self.inicio = None
                
            temp = self.inicio
            while temp.siguiente != None:
                temp2 = temp.siguiente
                if temp2.numeroTarjeta == numeroTarjeta:
                    temp.siguiente = temp2.siguiente
                temp = temp.siguiente
                
            self.agregarAVLmodificado()
            
    def metodoEliminarAVL(self, numeroTarjeta):
        nuevoNodo = NodoAVL(numeroTarjeta)
        self.buscarAVLparaEliminar(self.raizPrincipal, nuevoNodo)
        nodoIzDeNodoAeliminar = self.nodoAeliminar.izquierda
        self.complementoBuscarAVLparaEliminar(nodoIzDeNodoAeliminar)
        if self.inicio != None:
            if self.inicio.numeroTarjeta == self.nodoSustitucion.numeroTarjeta:
                if self.inicio.siguiente != None:
                    self.inicio = self.inicio.siguiente
                else:
                    self.inicio = None
                    
            temp = self.inicio
            while temp.siguiente != None:
                temp2 = temp.siguiente
                if temp2.numeroTarjeta == self.nodoSustitucion.numeroTarjeta:
                    temp.siguiente = temp2.siguiente
                    break
                    #temp.siguiente = None# ########################
                temp = temp.siguiente
                
            self.metodoModificarAVL(self.nodoSustitucion.numeroTarjeta, self.nodoSustitucion.montoGastado)
            
    def buscarAVLparaEliminar(self, raiz, nuevoNodo):
        if raiz != None:
            if nuevoNodo.numeroTarjeta == raiz.numeroTarjeta:
                self.nodoAeliminar = raiz #self.setEncontrado(raiz)
            else:
                self.buscarAVLparaEliminar(raiz.izquierda, nuevoNodo)
                self.buscarAVLparaEliminar(raiz.derecha, nuevoNodo)
                
    def complementoBuscarAVLparaEliminar(self, raiz):
        if raiz.derecha != None:
            self.complementoBuscarAVLparaEliminar(raiz.derecha)
        else:
            self.nodoSustitucion = raiz
            
    def metodoModificarAVL(self, nuevoNumeroTarjeta, nuevoMonto):
        if self.inicio != None:
            temp = self.inicio
            while temp != None:
                if temp.numeroTarjeta == self.nodoAeliminar.numeroTarjeta:
                    temp.numeroTarjeta = nuevoNumeroTarjeta #temp.siguiente = self.nodoSustitucion #temp.siguiente = temp2.siguiente
                    temp.montoGastado = nuevoMonto
                temp = temp.siguiente
                
    def mostrarLista(self):
        if self.inicio != None:
            temp = self.inicio
            while temp != None:
                print str(temp.numeroTarjeta)#variableNueva = "" #print str(temp.numeroTarjeta)   ESTO SI SIRVE
                temp = temp.siguiente
                
    def modificarAVL(self, numeroTarjeta, nuevoNumeroTarjeta, nuevoMonto):
        if self.inicio != None:
            temp = self.inicio
            while temp != None:
                if temp.numeroTarjeta == numeroTarjeta:
                    temp.numeroTarjeta = nuevoNumeroTarjeta #temp.siguiente = self.nodoSustitucion #temp.siguiente = temp2.siguiente
                    temp.montoGastado = nuevoMonto
                temp = temp.siguiente        
 