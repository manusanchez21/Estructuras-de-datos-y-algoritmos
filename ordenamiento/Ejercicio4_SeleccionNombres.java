/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una variante de Selection Sort que ordene un arreglo de nombres (String[]) en orden alfabético. 
 * Datos de entrada de ejemplo: {"Lucia", "Ana", "Pedro", "Juan"}. 
 * El programa debe mostrar por pantalla el arreglo original y el resultado final ordenado. 
 * En los comentarios del código se debe explicar cómo cambia la comparación al trabajar con cadenas de texto (utilizando el método compareTo() de la interfaz Comparable) en lugar de operadores relacionales numéricos como < o >. 
 * La verificación consistirá en validar el correcto orden lexicográfico resultante.
 */

import java.util.Arrays;

public class Ejercicio4_SeleccionNombres {

    /**
     * Ordena un arreglo de String alfabéticamente usando Selection Sort.
     * 
     * @param nombres Arreglo de cadenas de texto.
     */
    public static void selectionSortNombres(String[] nombres) {
        if (nombres == null || nombres.length <= 1) return;

        int n = nombres.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                // COMPARACIÓN DE TEXTOS:
                // En Java no se pueden usar '<' o '>' para comparar Objetos/Strings.
                // Se utiliza el método compareTo():
                // nombres[j].compareTo(nombres[indiceMinimo]) < 0 indica que
                // nombres[j] antecede alfabéticamente a nombres[indiceMinimo].
                if (nombres[j].compareTo(nombres[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }

            // Intercambiar la cadena encontrada con la primera posición no ordenada
            if (indiceMinimo != i) {
                String temp = nombres[i];
                nombres[i] = nombres[indiceMinimo];
                nombres[indiceMinimo] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String[] nombres = {"Lucia", "Ana", "Pedro", "Juan"};

        System.out.println("Nombres originales: " + Arrays.toString(nombres));
        selectionSortNombres(nombres);
        System.out.println("Nombres ordenados:  " + Arrays.toString(nombres));
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se aclaró en los comentarios la importancia de considerar el orden según la tabla ASCII/Unicode
 * cuando se comparan cadenas mediante `compareTo()` (distinguiendo mayúsculas y minúsculas).
 */