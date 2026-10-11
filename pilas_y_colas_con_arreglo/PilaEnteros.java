/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una clase PilaEnteros que utilice un arreglo de tamaño fijo para gestionar una estructura de datos LIFO (Last In, First Out).
 * La clase debe incluir los métodos push(int elemento), pop(), peek(), isEmpty(), isFull() y size().
 * En el prompt explico que se utilizará un índice interno top inicializado en -1 (que indica pila vacía).
 * Cada push incrementará top en 1 y guardará el dato; cada pop devolverá el elemento en top y decrementará top en 1.
 * Debe lanzarse una excepción ante un desbordamiento por arriba (isFull()) o por abajo (isEmpty()).
 */

public class PilaEnteros {
    private int[] arreglo;
    private int top;
    private int capacidad;

    // Constructor
    public PilaEnteros(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        // El índice top inicia en -1 indicando que la pila no posee elementos
        this.top = -1;
    }

    public void push(int elemento) {
        if (isFull()) {
            throw new IllegalStateException("Error: La pila está llena (Overflow). No se puede apilar " + elemento);
        }
        // Incrementa top y coloca el nuevo elemento en la cima
        arreglo[++top] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La pila está vacía (Underflow). No hay elementos para desapilar.");
        }
        // Devuelve el elemento en top y luego decrementa la cima
        return arreglo[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La pila está vacía.");
        }
        // Consulta el elemento superior sin eliminarlo
        return arreglo[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacidad - 1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        PilaEnteros pila = new PilaEnteros(3);

        System.out.println("Pila creada. ¿Está vacía?: " + pila.isEmpty());
        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("Elemento en la cima (peek): " + pila.peek()); // 30
        System.out.println("¿Está llena?: " + pila.isFull()); // true

        System.out.println("Desapilando: " + pila.pop()); // 30
        System.out.println("Nuevo tamaño: " + pila.size()); // 2
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * Se prefirió lanzar excepciones IllegalStateException en lugar de simples impresiones de consola 
 * para garantizar la robustez frente a errores de Underflow y Overflow.
 */