/*
 * Prompt inicial utilizado:
 * Implementar una ListaDoblementeEnlazada<T> genérica con referencias 'siguiente' y 'anterior'.
 * Operaciones: insertarAlInicio, insertarAlFinal, eliminar, imprimirAdelante e imprimirAtras.
 * Explicar la gestión de casos especiales al eliminar nodos (head, tail, medio, lista de 1 solo nodo)
 * para mantener la integridad de los enlaces dobles.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se prestó especial cuidado en actualizar el puntero 'anterior' del nuevo head/tail al eliminar extremos.
 */

public class Ejercicio10_ListaDoblementeEnlazada<T> {

    private static class NodoDoble<T> {
        T dato;
        NodoDoble<T> siguiente;
        NodoDoble<T> anterior;

        public NodoDoble(T dato) {
            this.dato = dato;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    private NodoDoble<T> head;
    private NodoDoble<T> tail;

    public boolean estaVacia() {
        return head == null;
    }

    // Insertar al Inicio
    public void insertarAlInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.siguiente = head;
            head.anterior = nuevo;
            head = nuevo;
        }
    }

    // Insertar al Final
    public void insertarAlFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.siguiente = nuevo;
            nuevo.anterior = tail;
            tail = nuevo;
        }
    }

    // Eliminar por valor gestionando los enlaces bidireccionales
    public boolean eliminar(T dato) {
        if (estaVacia()) return false;

        NodoDoble<T> actual = head;

        while (actual != null && !actual.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        // Dato no encontrado
        if (actual == null) return false;

        // Caso 1: Es el único nodo de la lista
        if (actual == head && actual == tail) {
            head = null;
            tail = null;
        }
        // Caso 2: Eliminar head
        else if (actual == head) {
            head = head.siguiente;
            head.anterior = null;
        }
        // Caso 3: Eliminar tail
        else if (actual == tail) {
            tail = tail.anterior;
            tail.siguiente = null;
        }
        // Caso 4: Eliminar nodo del medio
        else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }

        return true;
    }

    // Recorrido hacia adelante (head a tail)
    public void imprimirAdelante() {
        System.out.print("ADELANTE: null <- ");
        NodoDoble<T> actual = head;
        while (actual != null) {
            System.out.print("[" + actual.dato + "] <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Recorrido hacia atrás (tail a head)
    public void imprimirAtras() {
        System.out.print("ATRÁS: null <- ");
        NodoDoble<T> actual = tail;
        while (actual != null) {
            System.out.print("[" + actual.dato + "] <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Ejercicio10_ListaDoblementeEnlazada<String> lista = new Ejercicio10_ListaDoblementeEnlazada<>();

        lista.insertarAlFinal("A");
        lista.insertarAlFinal("B");
        lista.insertarAlFinal("C");
        lista.insertarAlInicio("INICIO");

        lista.imprimirAdelante(); // INICIO <-> A <-> B <-> C
        lista.imprimirAtras();    // C <-> B <-> A <-> INICIO

        lista.eliminar("B"); // Elimina nodo del medio
        System.out.println("\nTras eliminar 'B':");
        lista.imprimirAdelante(); // INICIO <-> A <-> C
        lista.imprimirAtras();    // C <-> A <-> INICIO
    }
}