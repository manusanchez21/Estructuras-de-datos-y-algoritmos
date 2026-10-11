public class Ejercicio6_CompararVectores {

    /**
     * Compara si dos vectores son exactamente iguales en dimensión y contenido.
     * 
     * @param v1 Primer vector.
     * @param v2 Segundo vector.
     * @return true si son totalmente iguales; false en caso contrario.
     */
    public static boolean sonIguales(int[] v1, int[] v2) {
        // Si ambas referencias apuntan al mismo objeto en memoria
        if (v1 == v2) return true;

        // Si alguno es nulo o tienen dimensiones distintas (Parada Temprana - O(1))
        if (v1 == null || v2 == null || v1.length != v2.length) {
            return false;
        }

        // Comparación elemento por elemento
        for (int i = 0; i < v1.length; i++) {
            if (v1[i] != v2[i]) {
                // Parada temprana apenas se detecta una diferencia
                return false; 
            }
        }

        return true; // Son idénticos
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int[] b = {10, 20, 30, 40};
        int[] c = {10, 20, 99, 40};
        int[] d = {10, 20};

        System.out.println("¿a y b son iguales?: " + sonIguales(a, b)); // true
        System.out.println("¿a y c son iguales?: " + sonIguales(a, c)); // false (difieren en index 2)
        System.out.println("¿a y d son iguales?: " + sonIguales(a, d)); // false (tamaño distinto)
    }
}