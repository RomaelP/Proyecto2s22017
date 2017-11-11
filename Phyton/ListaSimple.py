from NodoListaSimple import NodoListaSimple

class ListaSimple():
    def __init__(self):
        self.inicio = None
        self.ultimo = None
        self.cadenaHabitaciones = ""
        
    def verificarHabitacion(self, codigo):
        if self.inicio != None:
            temporal = self.inicio
            while True:
                if temporal.codigo == codigo:
                    return "True"
                else:
                    temporal = temporal.siguiente
                if temporal == self.inicio:
                    break
            return "False"
        
    def generarCodigoHabitacion(self, planta, habitacion):
        codigo = str(planta)+str(habitacion)
        return codigo
     
     
    def actualizarReservacionDevuelta(self, idHabitacion):
        aux = self.inicio
        while aux:
            if aux.codigo == idHabitacion:
                aux.reservada = "no"
            aux = aux.siguiente
            if aux == self.inicio:
                break			
        return "true"     
        
        
    def concatenarHabitaciones(self):
        self.cadenaHabitaciones = ""
        temporal=NodoListaSimple()
        if self.inicio != None:
            temporal = self.inicio
        while True:
            if temporal.reservada == "no":
                self.cadenaHabitaciones += str(temporal.codigo) + "#"
                    
            temporal = temporal.siguiente
            if temporal== self.inicio:
                break
        return self.cadenaHabitaciones
   
    def actualizarReservada(self, idHabitacion):
        aux = self.inicio
        while aux:
            if aux.codigo == idHabitacion:
                aux.reservada = "si"
            aux = aux.siguiente
            if aux == self.inicio:
                break
        return "True"
            
    def agregarHabitacion(self, numero, planta, codigo, reservada):
        if self.inicio != None:
            temporal = self.inicio
            temporal2 = self.ultimo
            
            
            while temporal.siguiente != self.inicio:
                temporal = temporal.siguiente
            if self.verificarHabitacion(codigo) == "False":
                temporal.siguiente = NodoListaSimple(numero, planta, codigo, reservada)
                temporal2 = temporal.siguiente
                temporal2.siguiente = self.inicio
            else:
                return "La habitacion ya existia"
        else:
            self.inicio = self.ultimo = NodoListaSimple(numero, planta, codigo, reservada)
            self.ultimo.siguiente = self.inicio
            
    def eliminarHabitacion(self, codigo):
        if self.inicio != None:
            temporal = self.inicio
            if temporal.codigo == codigo:
                if temporal.siguiente == self.inicio:
                    self.inicio = None
                    return "Habitacion Eliminada"
            
            if temporal.siguiente != None:
                if self.inicio.codigo == codigo:
                    self.inicio = temporal.siguiente
                    return "Habitacion Eliminada"
            
            while True:
                temporal2 = temporal.siguiente
                if temporal2.codigo == codigo:
                    temporal.siguiente = temporal2.siguiente
                    return "Habitacion Eliminada"
                else:
                    temporal = temporal.siguiente
                if temporal2 == self.inicio:
                    break
            return "No se encontro la Habitacion"
    
            
    def grabarArchivoListaSimple(self):
        contador1 = 0
        if self.inicio != None:
            temporal = self.inicio
           
            archivo = open('C:\\Users\\USuario1\\Desktop\\ListaSimple.txt','w')
            archivo.write('digraph G{\n')
            archivo.write("node [shape = record];\n")
            archivo.write("rankdir = LR;\n")   
            
            while True:
                archivo.write("Nodo_"+str(temporal.codigo)+ " [label=\""+str(temporal.numero)+" &#92;n"+str(temporal.planta)+" &#92;n"+str(temporal.codigo)+"\" ]\n")
                contador1 += 1
                temporal = temporal.siguiente
                if temporal == self.inicio:
                    break
                
            contador1 = 0
            temporal = self.inicio
            
            while True:
                if temporal.siguiente != None:
                    archivo.write("Nodo_"+str(temporal.codigo)+" ->"+"Nodo_"+str(temporal.siguiente.codigo)+"\n")
                    contador1 += 1
                temporal = temporal.siguiente
                if temporal == self.inicio:
                    break
            
            archivo.write('}')
            archivo.close()