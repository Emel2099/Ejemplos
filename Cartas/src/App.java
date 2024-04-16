import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Baraja baraja = new Baraja();
        Scanner scanner = new Scanner(System.in);
        
        
        
        System.out.print("¿Cuántas cartas desea agregar? ");
        int numCartas = scanner.nextInt();
        scanner.nextLine(); 

        //Agregar las cartas asignando el nombre a cada una.
        for (int i = 0; i < numCartas; i++) {
            System.out.print("Ingrese el nombre de la carta #" + (i + 1) + ": ");
            String nombreCarta = scanner.nextLine();
            baraja.agregarCarta(new Carta(nombreCarta));
        }

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mezclar baraja");
            System.out.println("2. Intercambiar cartas");
            System.out.println("3. Repartir carta");
            System.out.println("4. Mostrar baraja");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    baraja.mezclar();
                    System.out.println("Baraja mezclada.");
                    break;
                case 2:
                    System.out.print("Ingrese la posición de la primera carta a intercambiar: "); //se cuenta desde la posicion 0
                    int pos1 = scanner.nextInt();
                    System.out.print("Ingrese la posición de la segunda carta a intercambiar: ");
                    int pos2 = scanner.nextInt();
                    baraja.intercambiarCartas(pos1, pos2);
                    System.out.println("Cartas intercambiadas.");
                    break;
                case 3:
                    Carta cartaRepartida = baraja.repartirCarta();
                    if (cartaRepartida != null) {
                        System.out.println("Se repartió la carta: " + cartaRepartida.getNombre());
                    }
                    break;
                case 4:
                    System.out.println("Estado actual de la baraja:");
                    baraja.mostrarBaraja();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
