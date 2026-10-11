/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar una Cola Circular en Java utilizando arreglos y el operador módulo %.
 * Debe reutilizar las posiciones liberadas al inicio del arreglo.
 * Explicar el uso de (rear + 1) % capacidad para el avance circular y la variable count para verificar estado.
 */

import java.util.Arrays;

public class ColaCircular {
    private int[] arreglo;
    private int front;
    private int rear;
    private int count;
    private int capacidad;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int elemento) {
        if (isFull()) {
            System.out.println("Error: La cola circular está llena. No se puede encolar " + elemento);
            return;
        }
        // AVANCE CIRCULAR: El operador módulo reinicia rear a 0 cuando llega al final del arreglo
        rear = (rear + 1) % capacidad;
        arreglo[rear] = elemento;
        count++;
        System.out.println("Enqueue(" + elemento + ") en índice real [" + rear + "]");
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La cola circular está vacía.");
        }
        int valor = arreglo[front];
        // AVANCE CIRCULAR del frente
        front = (front + 1) % capacidad;
        count--;
        System.out.println("Dequeue(): Retirado valor " + valor + " de la posición.");
        return valor;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacidad;
    }

    public void mostrarArreglo() {
        System.out.println("Arreglo físico: " + Arrays.toString(arreglo) 
                           + " | Front: " + front + " | Rear: " + rear + " | Count: " + count);
    }

    public static void main(String[] args) {
        ColaCircular cola = new ColaCircular(3);

        System.out.println("--- 1. Llenado inicial ---");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.mostrarArreglo();

        System.out.println("\n--- 2. Liberando dos posiciones (Dequeue) ---");
        cola.dequeue();
        cola.dequeue();
        cola.mostrarArreglo();

        System.out.println("\n--- 3. Encolado Circular (Reutilización de espacio) ---");
        cola.enqueue(40); // Ocupará el índice 0 que fue liberado
        cola.enqueue(50); // Ocupará el índice 1
        cola.mostrarArreglo();
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * La adición de la variable `count` simplificó enormemente el diseño y evitó la ambigüedad que surge 
 * en colas circulares cuando `front == rear` (situación donde la cola podría estar tanto vacía como totalmente llena).
 */