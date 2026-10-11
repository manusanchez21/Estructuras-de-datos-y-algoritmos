/*
 * Prompt inicial utilizado:
 * Quiero implementar en Java una pila de enteros (PilaEnlazadaEnteros) utilizando una lista enlazada simple interna.
 * Explicar por qué head representa el tope de la pila y por qué push y pop son de complejidad O(1).
 * Implementar: push, pop, peek, isEmpty, contener e imprimir.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se previno el error de desapilar sobre pila vacía lanzando IllegalStateException en los métodos pop y peek.
 */

public class Ejercicio1_PilaEnlazadaEnteros {

    private static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // head actúa como el TOPE (top) de la pila.
    private Nodo head;
    private int size;

    public Ejercicio1_PilaEnlazadaEnteros() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // O(1) - Inserta al inicio (tope) de la lista enlazada
    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = head;
        head = nuevo;
        size++;
    }

    // O(1) - Desapila removiendo el nodo head
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: Pila vacía. No hay elementos para desapilar.");
        }
        int valor = head.dato;
        head = head.siguiente; // Avanza el tope al nodo posterior
        size--;
        return valor;
    }

    // O(1) - Consulta el tope sin remover
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: Pila vacía.");
        }
        return head.dato;
    }

    // O(N) - Recorrido secuencial para buscar un valor
    public boolean contener(int dato) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.dato == dato) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // O(N) - Muestra la pila desde el tope hacia la base
    public void imprimir() {
        if (isEmpty()) {
            System.out.println("Pila vacía: [ ]");
            return;
        }
        System.out.print("TOPE -> ");
        Nodo actual = head;
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("BASE");
    }

    public static void main(String[] args) {
        Ejercicio1_PilaEnlazadaEnteros pila = new Ejercicio1_PilaEnlazadaEnteros();
        pila.push(10);
        pila.push(20);
        pila.push(30);

        pila.imprimir(); // TOPE -> [30] -> [20] -> [10] -> BASE
        System.out.println("Tope actual: " + pila.peek()); // 30
        System.out.println("Desapilado: " + pila.pop());  // 30
        pila.imprimir(); // TOPE -> [20] -> [10] -> BASE
        System.out.println("¿Contiene el 10?: " + pila.contener(10)); // true
    }
}