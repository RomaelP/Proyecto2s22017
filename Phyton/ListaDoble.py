from NodoListaDoble import NodoListaDoble


class ListaDoble():
    def __init__(self):
        self.inicio = None
        self.ultimo = None
        self.grafica = "digraph G{\n"
        
    def insertarListaDoble(self, usuario, contrasenia, direccion, telefono, edad):
        if self.inicio != None:
            temporal = self.inicio
            temporal2 = self.ultimo
            
            while temporal.siguiente != None:
                temporal = temporal.siguiente
                
            self.ultimo.siguiente = NodoListaDoble(usuario, contrasenia, direccion, telefono, edad)
            self.ultimo.siguiente.anterior = self.ultimo
            self.ultimo = self.ultimo.siguiente
    
        else:
            self.inicio = self.ultimo = NodoListaDoble(usuario, contrasenia, direccion, telefono, edad)

    def verificarUsuario(self, usuario, contrasenia):
        if self.inicio != None:
            temporal = self.inicio
            while True:
                if temporal.usuario == usuario: 
                    if temporal.contrasenia == contrasenia:
                        return "True"
                else:
                    temporal = temporal.siguiente
                if temporal == self.inicio:
                    return "Datos erroneos"
        else:
            return "False"              
            
    def modificarNombre(self, usuario, nombreNuevo):
        valor = ""
        if self.inicio != None:
            temporal = self.inicio
            while temporal != None:
                if temporal.usuario == usuario:
                    if self.verificarUsuario1(nombreNuevo) == "False":
                        temporal.usuario = nombreNuevo
                        valor = "Usuario modificado" 
                        return valor
                    else:
                        valor = "El nombre de Usuario ya existe"
                        return valor
                else:
                    temporal = temporal.siguiente
            return valor
        
    def modificarContrasenia(self, usuario, contraNueva):
        if self.inicio != None:
            temporal = self.inicio
            while temporal != None:
                if temporal.usuario == usuario:
                    temporal.contrasenia = contraNueva
                    return "Contrasenia modificada"
                else:
                    temporal = temporal.siguiente
            return "Usuario no existe"
        
    def modificarDireccion(self, usuario, direccionNueva):
        if self.inicio != None:
            temporal = self.inicio
            while temporal != None:
                if temporal.usuario == usuario:
                    temporal.direccion == direccionNueva
                    return "Direccion Modificada: "+direccionNueva
                else:
                    temporal = temporal.siguiente
            return "Usuario no Existe"
        
    def modificarTelefono(self, usuario, telefonoNuevo):
        if self.inicio != None:
            temporal = self.inicio
            while  temporal != None:
                if temporal.usuario == usuario:
                    temporal.telefono == telefonoNuevo
                    return "Telefono Modificado: "+telefonoNuevo +" de usuario: "+usuario
                else:
                    temporal = temporal.siguiente
            return "Usuario no Existe"
        
    def modificarEdad(self, usuario, edadNueva):
        if self.inicio != None:
            temporal = self.inicio
            while temporal != None:
                if temporal.usuario == usuario:
                    temporal.edad = edadNueva
                    return "Edad Modificada: "+edadNueva+" del usuario: "+usuario
                else:
                    temporal = temporal.siguiente
            return "Usuario no Existe"

    def verificarUsuario1(self, usuario):
        if self.inicio != None:
            temporal = self.inicio
            while temporal != None:
                if temporal.usuario == usuario:
                    return "True"
                else:
                    temporal = temporal.siguiente
            return "False"
                
    def eliminarUsuario(self, usuario):
        if self.inicio != None:
            temporal = self.inicio
            while temporal != None:
                if temporal.usuario == usuario:
                    temporalA = temporal.anterior
                    temporalS = temporal.siguiente
                    temporalA.siguiente = temporalS
                    temporalS.anterior = temporalA
                    return "Usuario eliminado"
                else:
                    temporal = temporal.siguiente
            return "No se elimino el usuario"
        
        
    def grabarArchivoListaDoble(self):
        cont1 = 0
        temporal = self.inicio
        
        archivo = open('C:\\Users\\USuario1\\Desktop\\ListaDoble.txt','w')
        archivo.write('digraph G{\n')
        archivo.write("node [shape = record];\n")
        archivo.write("rankdir = LR;\n")
        
        while temporal != None:
            #if temporal.siguiente != None:
            archivo.write(str(temporal.usuario)+"_Nodo [label="+str(temporal.usuario)+"]\n")
            cont1 = cont1 + 1
            temporal = temporal.siguiente
            
            
        contadorUltimo = cont1
        cont2 = cont1 - 1
        temporal = self.inicio
        while temporal != None:
            if temporal.siguiente != None:
                archivo.write(str(temporal.usuario)+"_Nodo ->"+str(temporal.siguiente.usuario)+"_Nodo \n")
                archivo.write(str(temporal.siguiente.usuario)+"_Nodo ->"+str(temporal.usuario)+"_Nodo \n")
                
            temporal = temporal.siguiente
                
        archivo.write('}')
        archivo.close()
    