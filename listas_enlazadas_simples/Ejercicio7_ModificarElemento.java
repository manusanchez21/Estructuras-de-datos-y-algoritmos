/*
 * Prompt inicial utilizado:
 * Quiero implementar void modificar(int posicion, int nuevoDato) para actualizar el valor en un índice.
 * Validar posición previa al recorrido.
 * Explicar la diferencia entre alterar el atributo 'dato' de un nodo y reconfigurar la referencia 'siguiente'.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se destacó en los comentarios cómo esta operación mantiene la estructura topológica idéntica de la lista.
 */

public class Ejercicio7_ModificarElemento {

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

    public void modificar(int posicion, int nuevoDato) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + posicion);
        }

        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }

        // RESTRUCTURACIÓN VS MUTACIÓN:
        // No se modifican las referencias 'siguiente'. La estructura de punteros de la lista no cambia.
        // Simplemente se reasigna el valor interno guardado en la celda 'dato'.
        actual.dato = nuevoDato;
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
        Ejercicio7_ModificarElemento lista = new Ejercicio7_ModificarElemento();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);

        lista.modificar(1, 99); // Cambia 20 por 99
        lista.imprimir(); // 10 -> 99 -> 30 -> null
    }
}