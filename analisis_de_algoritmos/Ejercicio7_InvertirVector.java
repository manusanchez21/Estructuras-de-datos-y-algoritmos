import java.util.Arrays;

public class Ejercicio7_InvertirVector {

    /**
     * Versión 1: Utiliza un vector auxiliar.
     * Temporal: O(N) | Espacial: O(N)
     */
    public static int[] invertirConAuxiliar(int[] vector) {
        if (vector == null) return null;

        int n = vector.length;
        int[] auxiliar = new int[n];

        for (int i = 0; i < n; i++) {
            auxiliar[i] = vector[n - 1 - i];
        }

        return auxiliar;
    }

    /**
     * Versión 2: Inversión en el sitio (in-place) utilizando dos punteros.
     * Temporal: O(N) | Espacial: O(1)
     */
    public static void invertirInPlace(int[] vector) {
        if (vector == null) return;

        int izquierda = 0;
        int derecha = vector.length - 1;

        while (izquierda < derecha) {
            // Intercambio (swap) de valores
            int temp = vector[izquierda];
            vector[izquierda] = vector[derecha];
            vector[derecha] = temp;

            // Mover punteros hacia el centro
            izquierda++;
            derecha--;
        }
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};

        int[] invertidoAux = invertirConAuxiliar(original);
        System.out.println("Invertido con auxiliar: " + Arrays.toString(invertidoAux));

        invertirInPlace(original);
        System.out.println("Invertido in-place: " + Arrays.toString(original));
    }
}