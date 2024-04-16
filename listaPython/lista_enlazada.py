from nodo import Nodo

class ListaEnlazada:
    def __init__(self):
        self.cabeza = None

    def insertar_al_principio(self, dato):
        nuevo_nodo = Nodo(dato)
        nuevo_nodo.siguiente = self.cabeza
        self.cabeza = nuevo_nodo

    def buscar(self, dato):
        nodo_actual = self.cabeza
        while nodo_actual:
            if nodo_actual.dato == dato:
                return True
            nodo_actual = nodo_actual.siguiente
        return False

    def eliminar(self, dato):
        nodo_actual = self.cabeza
        if nodo_actual is None:
            return

        if nodo_actual.dato == dato:
            self.cabeza = nodo_actual.siguiente
            return

        while nodo_actual.siguiente:
            if nodo_actual.siguiente.dato == dato:
                nodo_actual.siguiente = nodo_actual.siguiente.siguiente
                return
            nodo_actual = nodo_actual.siguiente

    def imprimir(self):
        nodo_actual = self.cabeza
        while nodo_actual:
            print(nodo_actual.dato)
            nodo_actual = nodo_actual.siguiente
