public class Ejercicio9_MayorMatriz {

    /**
     * Encuentra el mayor elemento dentro de una matriz de enteros.
     * 
     * @param matriz Matriz bidimensional.
     * @return El valor máximo encontrado.
     * @throws IllegalArgumentException Si la matriz está vacía o es nula.
     */
    public static int encontrarMayor(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            throw new IllegalArgumentException("La matriz no puede estar vacía ni ser nula.");
        }

        // Asumimos inicialmente que la primera celda contiene el mayor valor
        int mayor = matriz[0][0];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j]; // Actualización del máximo
                }
            }
        }

        return mayor;
    }

    public static void main(String[] args) {
        int[][] datos = {
            {12, 45, 7},
            {89, 23, 67},
            {34, 91, 15}
        };

        System.out.println("El mayor elemento de la matriz es: " + encontrarMayor(datos));
    }
}