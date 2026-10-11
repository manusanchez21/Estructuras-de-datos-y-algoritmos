/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java el algoritmo Quicksort utilizando siempre el primer elemento del subarreglo como pivote. 
 * El programa debe mostrar por consola en cada llamada recursiva: el valor del pivote seleccionado, la composición del subarreglo izquierdo (menores o iguales al pivote), el subarreglo derecho (mayores) y finalmente el arreglo completo ordenado. 
 * En los comentarios del código se debe relacionar el algoritmo con el paradigma Divide y Vencerás y con la pila de llamadas de la recursividad. 
 * La verificación se hará comprobando cómo se van subdividiendo y ordenando los subconjuntos.
 */

import java.util.Arrays;

public class Ejercicio6_QuicksortPivote {

    public static void quicksort(int[] array, int inicio, int fin) {
        // CONDICIÓN DE CORTE (CASO BASE RECURSIVO)
        if (inicio < fin) {
            // DIVIDE Y VENCERÁS:
            // 1. Particionar el arreglo alrededor del pivote elegido (primer elemento).
            int indicePivote = particionar(array, inicio, fin);

            // 2. Llamadas recursivas para los subarreglos resultantes a la izquierda y derecha.
            quicksort(array, inicio, indicePivote - 1);
            quicksort(array, indicePivote + 1, fin);
        }
    }

    private static int particionar(int[] array, int inicio, int fin) {
        // ESTRATEGIA: Tomar siempre el primer elemento como pivote
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

        // Colocar el pivote en su posición final pivote (i - 1)
        int temp = array[inicio];
        array[inicio] = array[i - 1];
        array[i - 1] = temp;

        int posicionPivote = i - 1;

        // Visualización del proceso
        System.out.println("Pivote seleccionado: " + pivote);
        System.out.println(" Subarreglo Izq: " + Arrays.toString(Arrays.copyOfRange(array, inicio, posicionPivote)));
        System.out.println(" Subarreglo Der: " + Arrays.toString(Arrays.copyOfRange(array, posicionPivote + 1, fin + 1)));
        System.out.println(" Arreglo actual: " + Arrays.toString(array));
        System.out.println("----------------------------------------");

        return posicionPivote;
    }

    public static void main(String[] args) {
        int[] datos = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Arreglo Inicial: " + Arrays.toString(datos) + "\n");

        quicksort(datos, 0, datos.length - 1);

        System.out.println("Arreglo Final Ordenado: " + Arrays.toString(datos));
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se utilizó `Arrays.copyOfRange` para poder imprimir y visualizar únicamente los límites 
 * del subarreglo activo en cada llamada recursiva sobre la consola.
 */