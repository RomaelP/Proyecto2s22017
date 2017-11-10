class NodoAVL():
    def __init__(self, numeroTarjeta=None, montoGastado=None, izquierda=None, derecha=None, padre=None):
        self.numeroTarjeta = numeroTarjeta
        self.montoGastado = montoGastado
        self.izquierda = izquierda
        self.derecha = derecha
        self.padre = padre
        self.FE = 0
        self.raiz = None
        self.encontrado = None
        
    def getAVLraiz(self):
        return self.raiz
    
    def getAVLencontrado(self):
        return self.encontrado
    
    def setAVLraiz(self, nuevoNodo):
        self.raiz = nuevoNodo
        
    def setAVLencontrado(self, valor):
        self.encontrado = valor