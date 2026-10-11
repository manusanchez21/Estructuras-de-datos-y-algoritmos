/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una versión de Quicksort (usando el primer elemento como pivote) que se ejecute sobre un arreglo que YA está totalmente ordenado, como por ejemplo: {1, 2, 3, 4, 5, 6, 7}. 
 * El programa debe contar e informar el número total de llamadas recursivas realizadas durante la ejecución. 
 * En los comentarios del código debe explicarse teóricamente por qué elegir siempre el primer elemento de una secuencia previamente ordenada destruye la eficiencia del algoritmo, degradándolo de su promedio O(N log N) a su peor caso O(N^2) debido al desbalance absoluto de las particiones (tamaños 0 y N-1). 
 * La verificación se hará comprobando que la cantidad de llamadas recursivas sea proporcional a N.
 */

import java.util.Arrays;

public class Ejercicio7_PeorCasoQuicksort {

    private static int contadorLlamadas = 0;

    public static void quicksortPeorCaso(int[] array, int inicio, int fin) {
        contadorLlamadas++; // Incremento de la llamada recursiva

        if (inicio < fin) {
            int indicePivote = particionar(array, inicio, fin);

            // ANÁLISIS DEL PEOR CASO:
            // Al estar el arreglo ordenado de antemano y elegir array[inicio] como pivote,
            // la partición produce un subarreglo izquierdo vacío (0 elementos) y uno derecho con (N - 1) elementos.
            // Esto convierte el árbol de decisiones recursivas en una lista totalmente desbalanceada de profundidad N,
            // derivando en una complejidad de O(N^2) y un número excesivo de llamadas a la pila.
            quicksortPeorCaso(array, inicio, indicePivote - 1);
            quicksortPeorCaso(array, indicePivote + 1, fin);
        }
    }

    private static int particionar(int[] array, int inicio, int fin) {
        int pivote = array[inicio];
        int i = inicio + 1;

        for (int j = inicio + 1; j <= fin; j++) {
            if (array[j] < pivote) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }

        int temp = array[inicio];
        array[inicio] = array[i - 1];
        array[i - 1] = temp;

        return i - 1;
    }

    public static void main(String[] args) {
        int[] yaOrdenado = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Arreglo de entrada (Ya ordenado): " + Arrays.toString(yaOrdenado));
        quicksortPeorCaso(yaOrdenado, 0, yaOrdenado.length - 1);

        System.out.println("Arreglo final:                     " + Arrays.toString(yaOrdenado));
        System.out.println("Total de llamadas recursivas realizadas: " + contadorLlamadas);
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se introdujo una variable estática para registrar con exactitud cada entrada al método recursivo
 * `quicksortPeorCaso` y evidenciar empíricamente la degeneración de la pila de llamadas.
 */