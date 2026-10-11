/*
 * Prompt inicial utilizado:
 * Quiero implementar void eliminarEnPosicion(int posicion) en una lista enlazada simple.
 * Debe validar posiciones inválidas y decrementar size.
 * Explicar el procedimiento para hallar el nodo anterior y saltar la referencia sobre el nodo eliminado.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se previno un error de puntero nulo verificando explícitamente cuando se elimina la posición 0 (head).
 */

public class Ejercicio6_EliminarPorPosicion {

    private static class Nodo {
        int dato;
        Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; }
    }

    private Nodo head;
    private int size;

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) head = nuevo;
        else {
            Nodo actual = head;
            while (actual.siguiente != null) actual = actual.siguiente;
            actual.siguiente = nuevo;
        }
        size++;
    }

    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición fuera de límites: " + posicion);
        }

        // Caso 1: Eliminar posición 0
        if (posicion == 0) {
            head = head.siguiente;
            size--;
            return;
        }

        // Caso 2: Buscar el nodo anterior al que se eliminará
        Nodo anterior = head;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.siguiente;
        }

        // Nodo objetivo a eliminar
        Nodo eliminado = anterior.siguiente;

        // BYPASS: El puntero 'siguiente' del anterior apunta al nodo posterior del eliminado
        anterior.siguiente = eliminado.siguiente;

        size--;
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
        Ejercicio6_EliminarPorPosicion lista = new Ejercicio6_EliminarPorPosicion();
        lista.agregar(5);  // pos 0
        lista.agregar(15); // pos 1
        lista.agregar(25); // pos 2

        lista.eliminarEnPosicion(1); // Elimina 15
        lista.imprimir(); // 5 -> 25 -> null
    }
}