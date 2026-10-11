public class Ejercicio8_SumaMatriz {

    /**
     * Suma todos los elementos de una matriz e imprime el número de operaciones ejecutadas.
     * 
     * @param matriz Matriz de enteros de dimensiones F x C.
     * @return Suma acumulada de todos los valores.
     */
    public static int sumarMatriz(int[][] matriz) {
        if (matriz == null || matriz.length == 0) return 0;

        int sumaTotal = 0;
        int operacionesSuma = 0; // Contador de operaciones aritméticas realizadas

        // Ciclo externo: recorre filas
        for (int i = 0; i < matriz.length; i++) {
            // Ciclo interno: recorre columnas de la fila actual
            for (int j = 0; j < matriz[i].length; j++) {
                sumaTotal += matriz[i][j];
                operacionesSuma++;
            }
        }

        System.out.println("Se realizaron " + operacionesSuma + " operaciones de adición.");
        return sumaTotal;
    }

    public static void main(String[] args) {
        int[][] matrizEjemplo = {
            {3, 5, 2},
            {8, 1, 4},
            {7, 6, 9}
        };

        int suma = sumarMatriz(matrizEjemplo);
        System.out.println("La suma total de la matriz es: " + suma);
    }
}