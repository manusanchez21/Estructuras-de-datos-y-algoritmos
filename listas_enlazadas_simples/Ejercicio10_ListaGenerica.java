/*
 * Prompt inicial utilizado:
 * Quiero transformar la lista enlazada simple en una versión genérica ListaEnlazada<T> y Nodo<T>.
 * Debe ser compatible con Integer, String u objetos personalizados como Alumno.
 * Explicar qué cambia (firmas de tipo con parametrización <T>) y qué se mantiene idéntico 
 * (la lógica de manipulación de punteros head y siguiente).
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se implementó una clase simple Alumno para demostrar el correcto funcionamiento 
 * con clases de dominio personalizadas.
 */

// Clase de prueba personalizada
class Alumno {
    private String nombre;
    private double promedio;

    public Alumno(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return nombre + " (Prom: " + promedio + ")";
    }
}

// Estructura de Lista Enlazada Genérica
public class Ejercicio10_ListaGenerica<T> {

    private static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> head;
    private int size;

    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (head == null) {
            head = nuevo;
        } else {
            Nodo<T> actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    public void imprimir() {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 1. Prueba con Strings
        Ejercicio10_ListaGenerica<String> listaNombres = new Ejercicio10_ListaGenerica<>();
        listaNombres.insertarAlFinal("Ana");
        listaNombres.insertarAlFinal("Pedro");
        System.out.print("Lista de Strings: ");
        listaNombres.imprimir();

        // 2. Prueba con Alumnos (Objetos personalizados)
        Ejercicio10_ListaGenerica<Alumno> listaAlumnos = new Ejercicio10_ListaGenerica<>();
        listaAlumnos.insertarAlFinal(new Alumno("Lucia", 9.5));
        listaAlumnos.insertarAlFinal(new Alumno("Carlos", 8.0));
        System.out.print("Lista de Objetos Alumno: ");
        listaAlumnos.imprimir();
    }
}