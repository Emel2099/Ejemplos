from lista_enlazada import ListaEnlazada

# Función para ingresar un entero válido
def input_entero(mensaje):
    while True:
        try:
            valor = int(input(mensaje))
            return valor
        except ValueError:
            print("Por favor, ingresa un número entero válido.")

# Crear una lista enlazada
lista = ListaEnlazada()

# Insertar elementos
num_elementos = input_entero("¿Cuántos elementos deseas insertar? ")
for _ in range(num_elementos):
    valor = input_entero("Ingresa un valor para insertar en la lista: ")
    lista.insertar_al_principio(valor)

# Imprimir la lista
print("Lista actual:")
lista.imprimir()

# Buscar un elemento
buscar_valor = input_entero("Ingresa el valor que deseas buscar en la lista: ")
if lista.buscar(buscar_valor):
    print(f"El valor {buscar_valor} está en la lista.")
else:
    print(f"El valor {buscar_valor} no está en la lista.")

# Eliminar un elemento
eliminar_valor = input_entero("Ingresa el valor que deseas eliminar de la lista: ")
lista.eliminar(eliminar_valor)
print("Lista después de eliminar el valor seleccionado:")
lista.imprimir()
