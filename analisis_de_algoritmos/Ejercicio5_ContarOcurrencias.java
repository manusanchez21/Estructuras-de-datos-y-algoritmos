public class Ejercicio5_ContarOcurrencias {

    /**
     * Cuenta cuántas veces se repite un número objetivo en un vector.
     * 
     * @param vector   Arreglo de datos.
     * @param objetivo Valor a contar.
     * @return Cantidad de veces que aparece el valor objetivo.
     */
    public static int contarOcurrencias(int[] vector, int objetivo) {
        if (vector == null || vector.length == 0) {
            return 0;
        }

        int contador = 0;

        // Se recorren todos y cada uno de los elementos sin excepción
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == objetivo) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        int[] datos = {5, 2, 8, 5, 3, 5, 9, 1, 5};
        int buscado = 5;
        int total = contarOcurrencias(datos, buscado);
        System.out.println("El elemento " + buscado + " aparece " + total + " veces en el vector.");
    }
}