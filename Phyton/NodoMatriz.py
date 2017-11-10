from NodoHash import NodoHash
from TablaHash import TablaHash

class NodoMatriz():
    def __init__(self, mes = None, numeroMes = None, anio = None, dia = None, codigo = None, arriba =None, abajo = None, derecha = None, izquierda = None, profundidad = None, tablaHash = None):
        self.mes = mes
        self.numeroMes = numeroMes
        self.anio = anio
        self.dia = dia
        self.codigo = codigo
        self.arriba = arriba
        self.abajo = abajo
        self.derecha = derecha
        self.izquierda = izquierda
        self.profundidad = profundidad
        self.tablaHash = TablaHash()
        
    def getHash(self):
        return self.tablaHash
    
    def setHash(self, tablaHash):
        self.tablaHash = tablaHash
    