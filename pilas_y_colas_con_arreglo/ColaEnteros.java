/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una clase ColaEnteros usando un arreglo lineal simple.
 * Métodos: enqueue, dequeue, front, isEmpty, isFull y size.
 * Explicar los índices front y rear: front señala el inicio de la cola (para desencolar) y rear el final (para encolar).
 */

public class ColaEnteros {
    private int[] arreglo;
    private int front;
    private int rear;
    private int capacidad;

    public ColaEnteros(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        this.front = 0;
        this.rear = -1;
    }

    public void enqueue(int elemento) {
        if (isFull()) {
            System.out.println("Error: Cola llena (Overflow).");
            return;
        }
        arreglo[++rear] = elemento; // Incrementar rear y guardar
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: Cola vacía (Underflow).");
        }
        int valor = arreglo[front++]; // Obtener valor e incrementar front
        return valor;
    }

    public int front() {
        if (isEmpty()) throw new IllegalStateException("Cola vacía.");
        return arreglo[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == capacidad - 1;
    }

    public int size() {
        if (isEmpty()) return 0;
        return rear - front + 1;
    }

    public static void main(String[] args) {
        ColaEnteros cola = new ColaEnteros(3);
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);

        System.out.println("Elemento al frente: " + cola.front()); // 10
        System.out.println("Desencolando: " + cola.dequeue()); // 10
        System.out.println("Nuevo frente: " + cola.front()); // 20
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * Se definió formalmente la condición de vacía para cola lineal simple como `front > rear`, 
 * lo cual refleja adecuadamente el consumo progresivo de elementos.
 */