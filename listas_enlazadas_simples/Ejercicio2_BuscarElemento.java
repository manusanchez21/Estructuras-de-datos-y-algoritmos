/*
 * Prompt inicial utilizado:
 * Quiero implementar el método boolean buscar(int dato) en una lista enlazada simple.
 * Explicar en los comentarios por qué no es posible acceder directamente a los elementos por índice
 * y por qué es obligatorio realizar un recorrido secuencial avanzando desde head hasta null.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se añadió un mensaje por consola indicando el número de iteraciones efectuadas para encontrar el dato,
 * haciendo evidente la naturaleza secuencial del algoritmo.
 */

public class Ejercicio2_BuscarElemento {

    private static class Nodo {
        int dato;
        Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; this.siguiente = null; }
    }

    private Nodo head;

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) { head = nuevo; return; }
        Nodo actual = head;
        while (actual.siguiente != null) actual = actual.siguiente;
        actual.siguiente = nuevo;
    }

    /**
     * Busca un entero en la lista mediante recorrido secuencial.
     * Complejidad: Mejor caso O(1) [está en head] | Peor caso O(N) [está al final o no existe]
     */
    public boolean buscar(int dato) {
        Nodo actual = head;
        int comparaciones = 0;

        // RAZONAMIENTO: No hay memoria contigua ni índices físicos.
        // La única forma de avanzar es seguir la cadena de referencias 'siguiente'.
        while (actual != null) {
            comparaciones++;
            if (actual.dato == dato) {
                System.out.println("Dato " + dato + " encontrado tras " + comparaciones + " nodo(s) revisado(s).");
                return true;
            }
            actual = actual.siguiente; // Avanza al siguiente nodo
        }

        System.out.println("Dato " + dato + " NO encontrado tras recorrer los " + comparaciones + " nodo(s).");
        return false;
    }

    public static void main(String[] args) {
        Ejercicio2_BuscarElemento lista = new Ejercicio2_BuscarElemento();
        lista.agregar(5);
        lista.agregar(15);
        lista.agregar(25);
        lista.agregar(35);

        lista.buscar(5);  // Mejor caso: O(1)
        lista.buscar(25); // Caso intermedio
        lista.buscar(99); // Peor caso: O(N)
    }
}