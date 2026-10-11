/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar una cola simple en Java con arreglo que demuestre el desperdicio de posiciones.
 * Mostrar cómo tras insertar y desencolar, el puntero rear llega al final (isFull == true), 
 * impidiendo insertar más datos a pesar de haber celdas vacías al comienzo del arreglo.
 */

import java.util.Arrays;

public class DemostracionDesperdicioCola {
    private Integer[] arreglo;
    private int front;
    private int rear;

    public DemostracionDesperdicioCola(int capacidad) {
        arreglo = new Integer[capacidad];
        front = 0;
        rear = -1;
    }

    public void enqueue(int x) {
        if (rear == arreglo.length - 1) {
            System.out.println("¡ERROR! Se intenta encolar " + x + " pero rear llegó al final. ¿isFull?: TRUE");
            return;
        }
        arreglo[++rear] = x;
        System.out.println("Enqueue(" + x + ") exitoso.");
    }

    public void dequeue() {
        if (front > rear) {
            System.out.println("Cola vacía.");
            return;
        }
        System.out.println("Dequeue(): Liberando elemento en índice " + front + " [Valor: " + arreglo[front] + "]");
        arreglo[front] = null; // Celda inutilizada
        front++;
    }

    public void mostrarEstadoArreglo() {
        System.out.println("Estado Físico del Arreglo Interno: " + Arrays.toString(arreglo));
        System.out.println(" Puntero Front en índice: " + front + " | Puntero Rear en índice: " + rear);
        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        DemostracionDesperdicioCola cola = new DemostracionDesperdicioCola(3);

        System.out.println("--- 1. Llenando la cola simple ---");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.mostrarEstadoArreglo();

        System.out.println("--- 2. Liberando dos posiciones (Dequeue) ---");
        cola.dequeue();
        cola.dequeue();
        cola.mostrarEstadoArreglo();

        System.out.println("--- 3. Intentando agregar un nuevo elemento ---");
        cola.enqueue(40); // Fallará a pesar de existir 2 posiciones nulas a la izquierda
        cola.mostrarEstadoArreglo();
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * Se utilizó un arreglo de envoltorios `Integer[]` inicializados en `null` para hacer visualmente evidente 
 * en la impresión del arreglo qué casillas físicas quedaron inutilizadas tras el desencolado.
 */