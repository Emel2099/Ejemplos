import java.util.Random;


public class Baraja {

    private Nodo inicio;
    private int numCartas;

    public Baraja() {
        this.numCartas = 0;
    }

    
    // Método para agregar carta utilizando la estructura de la lista doblemente enlazada circular.
    public void agregarCarta(Carta carta) {
        Nodo nuevoNodo = new Nodo(carta);
        if (inicio == null) {
            inicio = nuevoNodo;                     //se crea el nuevo nodo
            inicio.setSiguiente(inicio);            //se enlaza a sí mismo
            inicio.setAnterior(inicio);
        } else {
            Nodo ultimo = inicio.getAnterior();     // cuando hay más nodos se enlazan circularmente
            ultimo.setSiguiente(nuevoNodo);         
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(inicio);
            inicio.setAnterior(nuevoNodo);
        }
        numCartas++;
    }

    public void mostrarBaraja() {
        if (inicio == null) {
            System.out.println("La baraja está vacía");         //si no hay nodos se imprime esto
            return;
        }

        Nodo actual = inicio;
        do {
            System.out.println(actual.getCarta().getNombre()); //imprime el nombre de la carta actual.
            actual = actual.getSiguiente();                 //recorre de manera circular apuntando al siguiente nodo.
        } while (actual != inicio);
    }

    public void mezclar() {
        if (numCartas <= 1) {
            return;                                         // No hay necesidad de mezclar si solo hay una carta o no hay.
        }

        Random rand = new Random();
        for (int i = 0; i < numCartas * 2; i++) {           // Hacer múltiples mezclas para más eficacia.
            int posicion1 = rand.nextInt(numCartas);        //Se usan 2 posiciones random en la baraja.
            int posicion2 = rand.nextInt(numCartas);
            intercambiarCartas(posicion1, posicion2);       //se llama al método para hacer la mezcla.
        }
    }

    public void intercambiarCartas(int posicion1, int posicion2) {
        if (posicion1 == posicion2) {
            return;                                         // No hay necesidad de intercambiar si solo hay 1 carta
        }

        Nodo nodo1 = obtenerNodoEnPosicion(posicion1);
        Nodo nodo2 = obtenerNodoEnPosicion(posicion2);

        Carta temp = nodo1.getCarta();                      //se usa variable temporal para guardar la información del primer nodo.
        nodo1.setCarta(nodo2.getCarta());                   //se asigna el segundo nodo al primero.
        nodo2.setCarta(temp);                               // se lleva la información de la variable temporal al segundo nodo.
    }

    private Nodo obtenerNodoEnPosicion(int posicion) {
        Nodo actual = inicio;                               //se empieza del inicio
        for (int i = 0; i < posicion; i++) {                //se mueve desde el inicio hasta la posicion random.
            actual = actual.getSiguiente();                 // apunta desde el nodo actual al siguiente.
        }
        return actual;                                      // cuando llega a la posicion devuelve el nodo de esa posición.
    }

    public Carta repartirCarta() {
        if (numCartas == 0) {
            System.out.println("No quedan cartas en la baraja"); //Cuando se acaban las cartas de la baraja.
            return null;
        }

        Carta cartaRepartida = inicio.getCarta();               //Se obtiene carta del primer nodo.
        if (numCartas == 1) {                                   // si solo hay una carta entonces al repartir queda vacía la baraja.
            inicio = null;
        } else {
            inicio.getAnterior().setSiguiente(inicio.getSiguiente());       //cuando se reparte una carta se elimina el nodo anterior
            inicio.getSiguiente().setAnterior(inicio.getAnterior());
            inicio = inicio.getSiguiente();
        }
        numCartas--;
        return cartaRepartida;
    }
    

}
