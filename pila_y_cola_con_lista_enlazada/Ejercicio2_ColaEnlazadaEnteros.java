/*
 * Prompt inicial utilizado:
 * Quiero implementar una cola de enteros (ColaEnlazadaEnteros) con lista enlazada simple.
 * Explicar por qué requiere las referencias 'head' (frente) y 'tail' (final) para lograr O(1) en enqueue y dequeue,
 * y qué problema de rendimiento O(N) ocurriría si solo usáramos 'head'.
 * Implementar: enqueue, dequeue, front, isEmpty, contener e imprimir.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se aseguró que al desencolar el último nodo disponible, la referencia 'tail' se actualice también a null.
 */

public class Ejercicio2_ColaEnlazadaEnteros {

    private static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo head; // Puntero al Frente (atención/dequeue)
    private Nodo tail; // Puntero al Final (inserción/enqueue)
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    // O(1) - Inserta al final usando 'tail'
    public void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.siguiente = nuevo;
            tail = nuevo; // Se actualiza la referencia al nuevo último nodo
        }
        size++;
    }

    // O(1) - Remueve desde el frente usando 'head'
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: Cola vacía. No se puede desencolar.");
        }
        int valor = head.dato;
        head = head.siguiente;
        
        // Si la cola quedó vacía tras el dequeue, tail debe ser null
        if (head == null) {
            tail = null;
        }
        size--;
        return valor;
    }

    // O(1) - Consulta el primer elemento a salir
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: Cola vacía.");
        }
        return head.dato;
    }

    // O(N) - Búsqueda lineal
    public boolean contener(int dato) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.dato == dato) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("Cola vacía: [ ]");
            return;
        }
        System.out.print("FRENTE -> ");
        Nodo actual = head;
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("FINAL");
    }

    public static void main(String[] args) {
        Ejercicio2_ColaEnlazadaEnteros cola = new Ejercicio2_ColaEnlazadaEnteros();
        cola.enqueue(100);
        cola.enqueue(200);
        cola.enqueue(300);

        cola.imprimir(); // FRENTE -> [100] -> [200] -> [300] -> FINAL
        System.out.println("Frente actual: " + cola.front()); // 100
        System.out.println("Desencolado: " + cola.dequeue());  // 100
        cola.imprimir(); // FRENTE -> [200] -> [300] -> FINAL
    }
}