/*
 * Prompt inicial utilizado:
 * Quiero implementar en Java una lista enlazada simple de números enteros desde cero, sin utilizar estructuras de Java como ArrayList o LinkedList.
 * Define una clase Nodo (int dato, Nodo siguiente) y una clase ListaEnlazadaSimple con atributos head y size.
 * Explica en el código qué función cumple head, cómo se autoreferencian los nodos y cómo evoluciona el atributo size.
 * Implementa los métodos: insertarAlInicio, insertarAlFinal, imprimir, estaVacia y getSize.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se privatizaron los atributos de la clase Nodo y se crearon getters y setters explícitos 
 * para garantizar la encapsulación dentro del paquete.
 */

public class Ejercicio1_ListaSimple {

    // Clase interna para representar cada nodo de la lista
    private static class Nodo {
        private int dato;
        private Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null; // Al crearse, no apunta a ningún nodo posterior
        }

        public int getDato() { return dato; }
        public void setDato(int dato) { this.dato = dato; }
        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }

    private Nodo head; // Puntero de entrada a la lista. Si es null, la lista está vacía.
    private int size;  // Contador para mantener el tamaño en complejidad O(1)

    public Ejercicio1_ListaSimple() {
        this.head = null;
        this.size = 0;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        // El nuevo nodo debe apuntar a lo que head apuntaba previamente
        nuevo.setSiguiente(head);
        // head se actualiza para apuntar al nuevo nodo
        head = nuevo;
        size++;
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            head = nuevo;
        } else {
            // Recorrido secuencial hasta el último nodo (aquel cuyo 'siguiente' es null)
            Nodo actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Lista vacía: null");
            return;
        }
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Ejercicio1_ListaSimple lista = new Ejercicio1_ListaSimple();
        System.out.println("¿Está vacía?: " + lista.estaVacia());

        lista.insertarAlInicio(20);
        lista.insertarAlInicio(10); // Lista: 10 -> 20 -> null
        lista.insertarAlFinal(30);  // Lista: 10 -> 20 -> 30 -> null

        lista.imprimir();
        System.out.println("Tamaño de la lista: " + lista.getSize());
    }
}