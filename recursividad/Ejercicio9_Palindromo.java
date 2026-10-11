/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que determine si una palabra es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda).
 * Este problema puede resolverse recursivamente comparando el primer y el último carácter del String. Si son iguales, se evalúa si el sub-String interno (sin los extremos) es un palíndromo.
 * El caso base ocurre cuando la longitud del String es 0 o 1, retornando true, pues una cadena vacía o de un solo carácter es palíndromo por definición.
 * Si los extremos no coinciden en algún momento, la función retorna false de inmediato.
 * El caso recursivo es esPalindromo(texto.substring(1, texto.length() - 1)), eliminando los dos extremos en cada llamada.
 * La función debe devolver un boolean (true o false).
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - "a" (debe retornar true)
 * - "neuquen" (debe retornar true)
 * - "reconocer" (debe retornar true)
 * - "java" (debe retornar false)
 */

public class Ejercicio9_Palindromo {

    /**
     * Determina recursivamente si una palabra es palíndromo.
     * 
     * @param texto Palabra a analizar.
     * @return true si es palíndromo; false de lo contrario.
     */
    public static boolean esPalindromo(String texto) {
        if (texto == null) return false;

        // Normalización a minúsculas para ignorar diferencias entre mayúsculas y minúsculas
        String limpia = texto.toLowerCase();

        // CASO BASE 1:
        // Una cadena vacía o con 1 único carácter es siempre palíndromo.
        if (limpia.length() <= 1) {
            return true;
        }

        // CASO BASE 2 (DISCREPANCIA DE EXTREMOS):
        // Si el primer carácter difiere del último, se descarta que sea palíndromo.
        if (limpia.charAt(0) != limpia.charAt(limpia.length() - 1)) {
            return false;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Si los extremos coinciden, recortamos la primera y última letra (substring(1, length - 1))
        // y evaluamos recursivamente el interior.
        return esPalindromo(limpia.substring(1, limpia.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println("'a' es palíndromo: " + esPalindromo("a"));                 // Esperado: true
        System.out.println("'neuquen' es palíndromo: " + esPalindromo("neuquen"));     // Esperado: true
        System.out.println("'reconocer' es palíndromo: " + esPalindromo("reconocer")); // Esperado: true
        System.out.println("'java' es palíndromo: " + esPalindromo("java"));           // Esperado: false
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se incorporó la conversión de la cadena a minúsculas (`toLowerCase()`) para garantizar que la 
 * comparación entre caracteres no falle por diferencias de mayúsculas/minúsculas en las esquinas.
 */