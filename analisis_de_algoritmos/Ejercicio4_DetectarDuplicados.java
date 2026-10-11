import java.util.HashSet;

public class Ejercicio4_DetectarDuplicados {

    /**
     * Método 1: Fuerza bruta usando ciclos anidados.
     * Complejidad Temporal: O(N^2) | Complejidad Espacial: O(1)
     */
    public static boolean tieneDuplicadosCiclos(int[] vector) {
        if (vector == null) return false;

        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] == vector[j]) {
                    return true; // Duplicado detectado
                }
            }
        }
        return false;
    }

    /**
     * Método 2: Utilizando HashSet.
     * Complejidad Temporal: O(N) | Complejidad Espacial: O(N)
     */
    public static boolean tieneDuplicadosHashSet(int[] vector) {
        if (vector == null) return false;

        HashSet<Integer> vistos = new HashSet<>();

        for (int elemento : vector) {
            // add() retorna false si el elemento ya estaba presente en el HashSet
            if (!vistos.add(elemento)) {
                return true; // Duplicado detectado
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arreglo1 = {1, 4, 7, 8, 3, 4, 9};
        int[] arreglo2 = {1, 2, 3, 4, 5, 6};

        System.out.println("Arreglo 1 (Ciclos): " + tieneDuplicadosCiclos(arreglo1));
        System.out.println("Arreglo 1 (HashSet): " + tieneDuplicadosHashSet(arreglo1));

        System.out.println("Arreglo 2 (Ciclos): " + tieneDuplicadosCiclos(arreglo2));
        System.out.println("Arreglo 2 (HashSet): " + tieneDuplicadosHashSet(arreglo2));
    }
}