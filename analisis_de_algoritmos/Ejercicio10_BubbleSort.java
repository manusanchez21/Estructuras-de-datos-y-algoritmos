import java.util.Arrays;

public class Ejercicio10_BubbleSort {

    /**
     * Ordena un vector utilizando Bubble Sort optimizado y registra las métricas de ejecucion.
     * 
     * @param vector Arreglo a ordenar.
     */
    public static void ordenamientoBurbuja(int[] vector) {
        if (vector == null || vector.length <= 1) return;

        int n = vector.length;
        long comparaciones = 0;
        long intercambios = 0;
        boolean huboIntercambio;

        for (int i = 0; i < n - 1; i++) {
            huboIntercambio = false;

            // En cada pasada el elemento mayor "flota" hacia su posición final
            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;

                if (vector[j] > vector[j + 1]) {
                    // Intercambio (swap)
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;

                    intercambios++;
                    huboIntercambio = true;
                }
            }

            // Si no hubo ningún intercambio en esta pasada, el arreglo ya está ordenado
            if (!huboIntercambio) break;
        }

        System.out.println("Estadísticas de ordenamiento:");
        System.out.println(" - Comparaciones realizadas: " + comparaciones);
        System.out.println(" - Intercambios realizados: " + intercambios);
    }

    public static void main(String[] args) {
        int[] datos = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Vector original: " + Arrays.toString(datos));
        ordenamientoBurbuja(datos);
        System.out.println("Vector ordenado:  " + Arrays.toString(datos));
    }
}