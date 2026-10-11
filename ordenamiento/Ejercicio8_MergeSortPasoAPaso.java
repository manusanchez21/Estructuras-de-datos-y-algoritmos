/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java el algoritmo MergeSort sobre un arreglo de enteros, mostrando detalladamente en la consola: 
 * 1) Cómo se divide recursivamente el arreglo en mitades; 
 * 2) Cuándo se alcanza la condición de corte (subarreglos de tamaño 1); 
 * 3) Cómo se ejecutan las fases de combinación o fusión (merge) ordenando las partes. 
 * En los comentarios del código debe fundamentarse la diferencia entre la fase descendente ('dividir') y la fase ascendente ('fusionar o mezclar'). 
 * La verificación consistirá en seguir secuencialmente el flujo por consola hasta obtener el arreglo final ordenado.
 */

import java.util.Arrays;

public class Ejercicio8_MergeSortPasoAPaso {

    public static void mergeSort(int[] array, int izquierda, int derecha) {
        // FASE 1: DIVIDIR
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            System.out.println("Dividiendo: " + Arrays.toString(Arrays.copyOfRange(array, izquierda, derecha + 1)));

            // Divide recursivamente la mitad izquierda y derecha
            mergeSort(array, izquierda, medio);
            mergeSort(array, medio + 1, derecha);

            // FASE 2: FUSIONAR (MERGE)
            // Una vez alcanzada la condición de corte (subarreglos de tamaño 1), 
            // la recursión desapila y entra en la fase ascendente intercalando y fusionando 
            // los dos bloques previamente ordenados en un solo subarreglo unificado.
            fusionar(array, izquierda, medio, derecha);
        } else {
            // CONDICIÓN DE CORTE: Subarreglo de 1 solo elemento (ya está ordenado por definición)
            System.out.println("  -> Caso base alcanzado (1 elemento): [" + array[izquierda] + "]");
        }
    }

    private static void fusionar(int[] array, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = array[izq + i];
        for (int j = 0; j < n2; j++) R[j] = array[medio + 1 + j];

        int i = 0, j = 0, k = izq;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) array[k++] = L[i++];
        while (j < n2) array[k++] = R[j++];

        System.out.println("Fusionado exitoso: " + Arrays.toString(Arrays.copyOfRange(array, izq, der + 1)));
    }

    public static void main(String[] args) {
        int[] datos = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Arreglo Inicial: " + Arrays.toString(datos) + "\n");

        mergeSort(datos, 0, datos.length - 1);

        System.out.println("\nArreglo Final Ordenado: " + Arrays.toString(datos));
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se dividió conceptualmente la salida en pantalla en "Dividiendo" (bajada recursiva) y 
 * "Fusionado exitoso" (subida recursiva) para evidenciar el orden en que opera la pila.
 */