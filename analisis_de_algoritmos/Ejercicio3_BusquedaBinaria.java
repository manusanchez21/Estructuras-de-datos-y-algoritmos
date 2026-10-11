public class Ejercicio3_BusquedaBinaria {

    /**
     * Realiza una búsqueda binaria en un vector ordenado mostrando la evolución de variables.
     * 
     * @param vector   Arreglo ordenado de menor a mayor.
     * @param objetivo Valor buscado.
     * @return Índice del objetivo o -1 si no se encuentra.
     */
    public static int busquedaBinaria(int[] vector, int objetivo) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser nulo.");
        }

        int inicio = 0;
        int fin = vector.length - 1;
        int paso = 1;

        System.out.println("--- Inicio de Búsqueda Binaria para objetivo: " + objetivo + " ---");

        while (inicio <= fin) {
            // Se calcula el punto medio para evitar desbordamiento aritmético
            int medio = inicio + (fin - inicio) / 2;

            System.out.println("Paso " + paso + " -> inicio: " + inicio 
                               + ", fin: " + fin 
                               + ", medio: " + medio 
                               + " [valor: " + vector[medio] + "]");

            if (vector[medio] == objetivo) {
                System.out.println("¡Elemento " + objetivo + " encontrado en el índice " + medio + "!");
                return medio;
            }

            if (vector[medio] < objetivo) {
                // El objetivo está en la mitad derecha
                inicio = medio + 1;
            } else {
                // El objetivo está en la mitad izquierda
                fin = medio - 1;
            }
            paso++;
        }

        System.out.println("El elemento " + objetivo + " no se encuentra en el vector.");
        return -1;
    }

    public static void main(String[] args) {
        int[] ordenado = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        busquedaBinaria(ordenado, 23);
        busquedaBinaria(ordenado, 100);
    }
}