/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java el algoritmo Insertion Sort para ordenar un arreglo casi ordenado, por ejemplo: {1, 2, 3, 5, 4, 6, 7}. 
 * El programa debe contar e informar el número de desplazamientos de elementos efectuados durante el proceso. 
 * En los comentarios del código debe explicarse por qué Insertion Sort es altamente eficiente (O(N)) cuando el conjunto de datos está casi ordenado, dado que las posiciones desordenadas avanzan muy pocos lugares antes de insertarse. 
 * La verificación se hará constatando un número extremadamente bajo de desplazamientos.
 */

import java.util.Arrays;

public class Ejercicio3_InsercionCasiOrdenado {

    /**
     * Ordena mediante Inserción e informa el conteo de desplazamientos realizados.
     * 
     * @param array Arreglo casi ordenado.
     */
    public static void insertionSortCasiOrdenado(int[] array) {
        int desplazamientos = 0;
        int n = array.length;

        System.out.println("Arreglo inicial (casi ordenado): " + Arrays.toString(array));

        for (int i = 1; i < n; i++) {
            int clave = array[i];
            int j = i - 1;

            // RAZONAMIENTO DE EFICIENCIA EN DATOS CASI ORDENADOS:
            // El bucle while evalúa cuántos elementos mayores a la 'clave' deben desplazarse a la derecha.
            // Cuando un arreglo está casi ordenado, la condición (array[j] > clave) se evalúa como falsa
            // casi de inmediato, realizando 0 o muy pocos desplazamientos por elemento.
            // Esto lleva al algoritmo a operar en complejidad lineal O(N) en el mejor caso.
            while (j >= 0 && array[j] > clave) {
                array[j + 1] = array[j]; // Desplazamiento
                desplazamientos++;
                j--;
            }
            array[j + 1] = clave; // Inserción en su lugar correcto
        }

        System.out.println("Arreglo final ordenado:          " + Arrays.toString(array));
        System.out.println("Total de desplazamientos realizados: " + desplazamientos);
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 5, 4, 6, 7};
        insertionSortCasiOrdenado(numeros);
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se clarificó la distinción entre un "intercambio" y un "desplazamiento" (mover elementos un lugar a la derecha 
 * dentro de la sublista ordenada), ajustando el contador dentro del ciclo 'while'.
 */