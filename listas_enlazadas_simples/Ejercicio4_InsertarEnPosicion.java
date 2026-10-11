/*
 * Prompt inicial utilizado:
 * Quiero implementar void insertarEnPosicion(int dato, int posicion) en una lista enlazada.
 * Debe contemplar inserción al inicio, en el medio y al final, validando posiciones erróneas.
 * Explicar el orden estricto de reconexión de referencias:
 * 1. nuevo.setSiguiente(actual.getSiguiente());
 * 2. actual.setSiguiente(nuevo);
 * Explicar las consecuencias catastróficas de invertir este orden.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se reutilizaron internamente los casos especiales de insertarAlInicio para optimizar la legibilidad del código.
 */

public class Ejercicio4_InsertarEnPosicion {

    private static class Nodo {
        int dato;
        Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; }
    }

    private Nodo head;
    private int size;

    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida para inserción: " + posicion);
        }

        Nodo nuevo = new Nodo(dato);

        // Caso 1: Inserción al inicio
        if (posicion == 0) {
            nuevo.siguiente = head;
            head = nuevo;
            size++;
            return;
        }

        // Avanzar hasta el nodo anterior a la posición deseada
        Nodo actual = head;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }

        // ORDEN CRÍTICO DE ACTUALIZACIÓN DE REFERENCIAS:
        // PASO 1: El nuevo nodo debe apuntar primero al resto de la lista (actual.siguiente).
        nuevo.siguiente = actual.siguiente;

        // PASO 2: El nodo 'actual' se enlaza con el nuevo nodo.
        // ¡ATENCIÓN!: Si ejecutáramos el Paso 2 antes que el Paso 1, 'actual.siguiente'
        // perdería la dirección del resto de la lista, desconectando y perdiendo todos los nodos siguientes.
        actual.siguiente = nuevo;

        size++;
    }

    public void imprimir() {
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Ejercicio4_InsertarEnPosicion lista = new Ejercicio4_InsertarEnPosicion();
        lista.insertarEnPosicion(10, 0); // [10]
        lista.insertarEnPosicion(30, 1); // [10, 30]
        lista.insertarEnPosicion(20, 1); // [10, 20, 30] (Inserción en el medio)
        lista.insertarEnPosicion(40, 3); // [10, 20, 30, 40] (Inserción al final)

        lista.imprimir();
    }
}