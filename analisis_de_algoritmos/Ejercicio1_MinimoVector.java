public class Ejercicio1_MinimoVector {

    /**
     * Encuentra el valor mínimo en un vector de enteros desordenado.
     * 
     * @param vector Arreglo de enteros en el cual buscar.
     * @return El valor mínimo presente en el vector.
     * @throws IllegalArgumentException Si el vector es nulo o está vacío.
     */
    public static int encontrarMinimo(int[] vector) {
        // Validación de entrada
        if (vector == null || vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede ser nulo ni estar vacío.");
        }

        // Asumimos inicialmente que el primer elemento es el mínimo
        int minimoActual = vector[0];

        // Recorremos el vector desde el índice 1 hasta el final
        for (int i = 1; i < vector.length; i++) {
            // Si encontramos un valor menor al mínimo actual, actualizamos la referencia
            if (vector[i] < minimoActual) {
                minimoActual = vector[i];
            }
        }

        return minimoActual;
    }

    public static void main(String[] args) {
        int[] datos = {15, 42, 3, 8, -5, 23, 0};
        System.out.println("Vector: " + java.util.Arrays.toString(datos));
        System.out.println("El valor mínimo es: " + encontrarMinimo(datos));
    }
}