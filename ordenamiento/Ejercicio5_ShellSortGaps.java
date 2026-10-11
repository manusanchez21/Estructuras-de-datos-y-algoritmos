/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar el algoritmo ShellSort en Java sobre un arreglo de enteros. 
 * El programa debe mostrar explícitamente el valor del intervalo o 'gap' utilizado en cada etapa y el estado del arreglo al finalizar la pasada de cada gap. 
 * Los comentarios del código deben explicar por qué ShellSort representa una optimización de Insertion Sort al permitir intercambios entre elementos alejados mediante saltos grandes, reduciendo dramáticamente el desorden inicial antes de realizar la pasada final con gap = 1. 
 * La verificación se hará observando la progresiva disminución del desorden en las pasadas preliminares.
 */

import java.util.Arrays;

public class Ejercicio5_ShellSortGaps {

    /**
     * Ordena un arreglo mediante ShellSort mostrando la evolución según el intervalo 'gap'.
     * 
     * @param array Arreglo a ordenar.
     */
    public static void shellSort(int[] array) {
        int n = array.length;

        System.out.println("Estado inicial del arreglo: " + Arrays.toString(array));
        System.out.println("----------------------------------------");

        // EXPLICACIÓN DEL GAP:
        // Se comienza con un salto grande (gap = n / 2) y se reduce a la mitad en cada fase.
        // Insertion Sort convencional sólo compara elementos vecinos (gap = 1).
        // ShellSort ordena subgrupos espaciados por 'gap' posiciones; al mover elementos a larga distancia,
        // elimina rápidamente grandes desórdenes con muy pocos movimientos.
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Se realiza un ordenamiento por inserción para el salto 'gap' actual
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }

            System.out.println("Pasada con GAP = " + gap + ": " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] datos = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
        shellSort(datos);
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se explicitó en el prompt la secuencia de reducción de gap clásica (n/2) y se argumentó conceptualmente
 * por qué cuando la iteración alcanza gap = 1 el arreglo ya está en un estado casi totalmente ordenado.
 */