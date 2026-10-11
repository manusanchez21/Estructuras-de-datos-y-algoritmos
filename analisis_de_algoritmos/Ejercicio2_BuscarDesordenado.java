public class Ejercicio2_BuscarDesordenado {

    /**
     * Busca un elemento en un vector desordenado e informa las posiciones recorridas.
     * 
     * @param vector   Arreglo donde se realizará la búsqueda.
     * @param objetivo Elemento buscado.
     * @return El índice del elemento si se encuentra, o -1 si no existe.
     */
    public static int buscarElemento(int[] vector, int objetivo) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser nulo.");
        }

        int posicionesRecorridas = 0;

        for (int i = 0; i < vector.length; i++) {
            posicionesRecorridas++; // Incrementamos el contador de comparaciones/recorridos

            if (vector[i] == objetivo) {
                System.out.println("Elemento " + objetivo + " encontrado en el índice " + i 
                                   + " tras recorrer " + posicionesRecorridas + " posición(es).");
                return i;
            }
        }

        System.out.println("Elemento " + objetivo + " NO encontrado tras recorrer " 
                           + posicionesRecorridas + " posición(es).");
        return -1;
    }

    public static void main(String[] args) {
        int[] datos = {20, 7, 14, 99, 45, 12};
        buscarElemento(datos, 14); // Caso intermedio
        buscarElemento(datos, 20); // Mejor caso
        buscarElemento(datos, 50); // Peor caso (no existe)
    }
}