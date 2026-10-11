/*
 * Prompt inicial utilizado:
 * Quiero implementar el método int obtener(int posicion) en una lista enlazada simple de enteros.
 * Debe validar límites (posicion < 0 o posicion >= size) lanzando IndexOutOfBoundsException.
 * Explicar que para llegar a la posición deseada hay que simular el índice avanzando secuencialmente.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se mantuvo un atributo 'size' actualizado en cada inserción para realizar la validación de rango 
 * en tiempo O(1) antes de iniciar el bucle de recorrido.
 */

public class Ejercicio3_ObtenerPorPosicion {

    private static class Nodo {
        int dato;
        Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; }
    }

    private Nodo head;
    private int size;

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) { head = nuevo; }
        else {
            Nodo actual = head;
            while (actual.siguiente != null) actual = actual.siguiente;
            actual.siguiente = nuevo;
        }
        size++;
    }

    public int obtener(int posicion) {
        // Validación previa de límites
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + posicion + " (Tamaño: " + size + ")");
        }

        // Simulación de acceso por índice mediante iteración
        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }

        return actual.dato;
    }

    public static void main(String[] args) {
        Ejercicio3_ObtenerPorPosicion lista = new Ejercicio3_ObtenerPorPosicion();
        lista.agregar(100); // pos 0
        lista.agregar(200); // pos 1
        lista.agregar(300); // pos 2

        System.out.println("Elemento en pos 1: " + lista.obtener(1)); // 200

        try {
            lista.obtener(5); // Lanzará excepción
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}