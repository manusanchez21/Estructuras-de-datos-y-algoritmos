/*
 * Prompt inicial utilizado:
 * Transformar la pila enlazada en PilaEnlazada<T> genérica.
 * Explicar en qué consisten los genéricos en Java y por qué la lógica LIFO es independiente del tipo de dato guardado.
 * Probar con Integer, String y objetos propios Persona.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se implementó una clase simple Persona con métodos toString() para verificar la salida formateada.
 */

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

public class Ejercicio3_PilaGenerica<T> {

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = top;
        top = nuevo;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pila vacía.");
        }
        T valor = top.dato;
        top = top.siguiente;
        return valor;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Pila vacía.");
        return top.dato;
    }

    public void imprimir() {
        Nodo<T> actual = top;
        System.out.print("TOPE -> ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("BASE");
    }

    public static void main(String[] args) {
        // Pila de String
        Ejercicio3_PilaGenerica<String> pilaTextos = new Ejercicio3_PilaGenerica<>();
        pilaTextos.push("Primero");
        pilaTextos.push("Segundo");
        pilaTextos.imprimir();

        // Pila de Objeto Persona
        Ejercicio3_PilaGenerica<Persona> pilaPersonas = new Ejercicio3_PilaGenerica<>();
        pilaPersonas.push(new Persona("Ana", 25));
        pilaPersonas.push(new Persona("Carlos", 30));
        pilaPersonas.imprimir();
    }
}