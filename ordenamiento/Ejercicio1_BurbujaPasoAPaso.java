/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java un algoritmo de ordenamiento por Burbuja (Bubble Sort) sobre un arreglo de números enteros. 
 * El programa debe recibir un arreglo desordenado, mostrar su estado inicial y luego imprimir el estado del arreglo al finalizar cada pasada del ciclo externo. 
 * En el código debe explicarse mediante comentarios por qué el elemento mayor se va desplazando paulatinamente hacia el final del arreglo en cada iteración. 
 * La verificación del programa se realizará comprobando que los elementos con los valores más altos se ubiquen correctamente en los últimos índices desde las primeras pasadas, terminando con un arreglo completamente ordenado de menor a mayor.
 */

import java.util.Arrays;

public class Ejercicio1_BurbujaPasoAPaso {

    /**
     * Ordena un arreglo de enteros por el método de la Burbuja e imprime el estado en cada pasada.
     * 
     * @param array Arreglo de números enteros a ordenar.
     */
    public static void bubbleSortPasoAPaso(int[] array) {
        if (array == null || array.length <= 1) return;

        int n = array.length;

        System.out.println("Estado inicial: " + Arrays.toString(array));
        System.out.println("----------------------------------------");

        for (int i = 0; i < n - 1; i++) {
            // RAZONAMIENTO DEL ALGORITMO:
            // En cada pasada i, los elementos adyacentes se comparan de a pares.
            // Si el elemento de la izquierda es mayor que el de la derecha, se intercambian.
            // Esto provoca que en cada pasada el valor MÁS GRANDE no ordenado "flote" o
            // se desplace secuencialmente hasta su posición definitiva al final del subarreglo (índice n - 1 - i).
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambio (swap)
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            System.out.println("Pasada " + (i + 1) + ": " + Arrays.toString(array) 
                               + " (El mayor restante llegó al final)");
        }
    }

    public static void main(String[] args) {
        int[] datos = {25, 14, 8, 30, 2, 19};
        bubbleSortPasoAPaso(datos);
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se acotó el ciclo interno a 'n - 1 - i' para evitar comparaciones innecesarias con los elementos 
 * que ya flotaron y quedaron definitivamente ordenados al final del arreglo en las pasadas previas.
 */