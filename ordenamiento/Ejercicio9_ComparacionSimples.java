/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java un programa comparativo que ejecute tres algoritmos cuadráticos sobre copias idénticas de un mismo arreglo: Bubble Sort, Selection Sort e Insertion Sort. 
 * El programa debe imprimir para cada método: el arreglo ordenado, el número total de comparaciones y el total de intercambios o desplazamientos realizados. 
 * En los comentarios del código se deben comparar formalmente las tres estrategias (intercambios adyacentes vs búsqueda de mínimos vs inserción secuencial) para justificar sus diferencias de rendimiento en la práctica. 
 * La verificación se realizará contrastando la tabla final de contadores.
 */

import java.util.Arrays;

public class Ejercicio9_ComparacionSimples {

    public static void probarBubbleSort(int[] arr) {
        int comp = 0, swaps = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                comp++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        imprimir("Bubble Sort", arr, comp, swaps, "Intercambios");
    }

    public static void probarSelectionSort(int[] arr) {
        int comp = 0, swaps = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                comp++;
                if (arr[j] < arr[min]) min = j;
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                swaps++;
            }
        }
        imprimir("Selection Sort", arr, comp, swaps, "Intercambios");
    }

    public static void probarInsertionSort(int[] arr) {
        int comp = 0, shifts = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int clave = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comp++;
                if (arr[j] > clave) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = clave;
        }
        imprimir("Insertion Sort", arr, comp, shifts, "Desplazamientos");
    }

    private static void imprimir(String nombre, int[] arr, int comp, int ops, String tipoOps) {
        System.out.println("=== " + nombre + " ===");
        System.out.println(" - Resultado: " + Arrays.toString(arr));
        System.out.println(" - Comparaciones: " + comp);
        System.out.println(" - " + tipoOps + ": " + ops + "\n");
    }

    public static void main(String[] args) {
        int[] datosOriginales = {45, 12, 89, 33, 23, 7, 60, 2};

        System.out.println("Arreglo Base: " + Arrays.toString(datosOriginales) + "\n");

        probarBubbleSort(datosOriginales.clone());
        probarSelectionSort(datosOriginales.clone());
        probarInsertionSort(datosOriginales.clone());
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se separó la etiqueta de la métrica secundaria en "Intercambios" para Burbuja/Selección y 
 * "Desplazamientos" para Inserción, evitando confundir operaciones con distinto costo computacional.
 */