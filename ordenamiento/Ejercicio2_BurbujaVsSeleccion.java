/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java dos métodos de ordenamiento sobre arreglos de enteros: bubbleSort(int[] array) y selectionSort(int[] array). 
 * Ambos deben recibir copias idénticas del mismo arreglo desordenado y devolver estadísticas contables sobre la cantidad de comparaciones e intercambios efectuados. 
 * El objetivo es contrastar la estrategia de la burbuja (comparación continua entre vecinos) contra la de selección (búsqueda directa del mínimo por pasada para realizar un único intercambio). 
 * La verificación se realizará imprimiendo y comparando los contadores para ambos algoritmos.
 */

import java.util.Arrays;

public class Ejercicio2_BurbujaVsSeleccion {

    // Método para Burbuja
    public static void bubbleSort(int[] array) {
        int comparaciones = 0;
        int intercambios = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;
                // COMPARACIÓN ENTRE VECINOS ADYACENTES:
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    intercambios++; // Ocurren múltiples intercambios por pasada
                }
            }
        }

        System.out.println("BUBBLE SORT:");
        System.out.println(" - Resultado: " + Arrays.toString(array));
        System.out.println(" - Comparaciones: " + comparaciones);
        System.out.println(" - Intercambios: " + intercambios);
    }

    // Método para Selección
    public static void selectionSort(int[] array) {
        int comparaciones = 0;
        int intercambios = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            // BÚSQUEDA DIRECTA DEL MÍNIMO:
            // Recorre el resto del arreglo buscando la posición del valor más pequeño.
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (array[j] < array[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Realiza como máximo UN ÚNICO intercambio por cada pasada del ciclo exterior.
            if (indiceMinimo != i) {
                int temp = array[i];
                array[i] = array[indiceMinimo];
                array[indiceMinimo] = temp;
                intercambios++;
            }
        }

        System.out.println("SELECTION SORT:");
        System.out.println(" - Resultado: " + Arrays.toString(array));
        System.out.println(" - Comparaciones: " + comparaciones);
        System.out.println(" - Intercambios: " + intercambios);
    }

    public static void main(String[] args) {
        int[] original = {64, 25, 12, 22, 11, 90, 4, 38};

        System.out.println("Arreglo original: " + Arrays.toString(original) + "\n");

        bubbleSort(original.clone());
        System.out.println();
        selectionSort(original.clone());
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se incluyó la clonación del arreglo original (`original.clone()`) al llamar a cada función 
 * para garantizar que ambos algoritmos compitan exactamente bajo las mismas condiciones iniciales.
 */