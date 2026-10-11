/*
 * Prompt inicial utilizado:
 * Quiero implementar el método void invertir() para invertir una lista enlazada in-place.
 * Ejemplo: 10 -> 20 -> 30 -> 40 -> null pasa a ser 40 -> 30 -> 20 -> 10 -> null.
 * Explicar detalladamente el uso de los punteros auxiliares: anterior, actual y siguiente,
 * indicando el orden paso a paso para no romper los puentes de memoria.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se verificaron explícitamente los casos bordes de lista vacía o de 1 solo elemento, 
 * donde invertir no requiere realizar ningún cambio.
 */

public class Ejercicio9_InvertirLista {

    private static class Nodo {
        int dato;
        Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; }
    }

    private Nodo head;

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) head = nuevo;
        else {
            Nodo actual = head;
            while (actual.siguiente != null) actual = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    public void invertir() {
        if (head == null || head.siguiente == null) return; // Nada que invertir

        Nodo anterior = null;
        Nodo actual = head;
        Nodo siguiente = null;

        // BUCLE DE INVERSIÓN:
        while (actual != null) {
            // 1. Guardar la referencia al siguiente nodo original para no perderlo
            siguiente = actual.siguiente;

            // 2. Invertir el puntero del nodo actual hacia el nodo anterior
            actual.siguiente = anterior;

            // 3. Desplazar los punteros un paso adelante para la siguiente iteración
            anterior = actual;
            actual = siguiente;
        }

        // 4. Actualizar head para que apunte al último nodo procesado (que ahora es el primero)
        head = anterior;
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
        Ejercicio9_InvertirLista lista = new Ejercicio9_InvertirLista();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);

        System.out.print("Lista original:  ");
        lista.imprimir();

        lista.invertir();

        System.out.print("Lista invertida: ");
        lista.imprimir();
    }
}