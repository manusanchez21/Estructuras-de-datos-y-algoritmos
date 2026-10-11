/*
 * Prompt inicial utilizado:
 * Crear una clase ColaEnlazada<T> genérica con referencias head y tail.
 * Explicar cómo se mantiene el comportamiento FIFO independientemente del tipo de dato.
 * Probar con cadenas String y con objetos Cliente.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Ninguno. La parametrización genérica resolvió directamente el manejo de cualquier objeto.
 */

class Cliente {
    private int id;
    private String nombre;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente #" + id + ": " + nombre;
    }
}

public class Ejercicio4_ColaGenerica<T> {

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> head;
    private Nodo<T> tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.siguiente = nuevo;
            tail = nuevo;
        }
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Cola vacía.");
        T valor = head.dato;
        head = head.siguiente;
        if (head == null) tail = null;
        return valor;
    }

    public void imprimir() {
        Nodo<T> actual = head;
        System.out.print("FRENTE -> ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("FINAL");
    }

    public static void main(String[] args) {
        // Cola de Clientes
        Ejercicio4_ColaGenerica<Cliente> colaClientes = new Ejercicio4_ColaGenerica<>();
        colaClientes.enqueue(new Cliente(101, "María"));
        colaClientes.enqueue(new Cliente(102, "Juan"));
        colaClientes.imprimir();

        System.out.println("Atendiendo a: " + colaClientes.dequeue());
        colaClientes.imprimir();
    }
}