/*
 * Prompt inicial utilizado:
 * Quiero implementar boolean eliminar(int dato) para eliminar la primera aparición de un valor.
 * Debe contemplar: lista vacía, borrar head, borrar en medio, borrar el último y dato inexistente.
 * Explicar conceptualmente el rol del Garbage Collector en Java al dejar un nodo inaccesible.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se añadió la devolución de un valor booleano (true si fue eliminado, false si no existía)
 * para comunicar el resultado del proceso a la llamada cliente.
 */

public class Ejercicio5_EliminarPorValor {

    private static class Nodo {
        int dato;
        Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; }
    }

    private Nodo head;
    private int size;

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) { head = nuevo; }
        else {
            Nodo actual = head;
            while (actual.siguiente != null) actual = actual.siguiente;
            actual.siguiente = nuevo;
        }
        size++;
    }

    public boolean eliminar(int dato) {
        // Escenario 1: Lista vacía
        if (head == null) return false;

        // Escenario 2: Eliminar el primer nodo (head)
        if (head.dato == dato) {
            head = head.siguiente; // Head avanza al segundo nodo
            size--;
            return true;
        }

        // Escenario 3 y 4: Eliminar en el medio o al final
        Nodo actual = head;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }

        // Escenario 5: Dato no encontrado
        if (actual.siguiente == null) return false;

        // PUENTEO DE REFERENCIAS:
        // Se hace que el nodo anterior apunte al nodo posterior del que deseamos eliminar.
        // El nodo descartado queda sin ninguna referencia apuntándolo.
        // Java detecta que es inalcanzable y el Garbage Collector libera su memoria.
        actual.siguiente = actual.siguiente.siguiente;
        size--;
        return true;
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
        Ejercicio5_EliminarPorValor lista = new Ejercicio5_EliminarPorValor();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);

        lista.eliminar(10); // Borra head
        lista.imprimir();   // 20 -> 30 -> null

        lista.eliminar(30); // Borra último
        lista.imprimir();   // 20 -> null
    }
}