/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que invierta un String.
 * Este problema puede resolverse recursivamente concatenando el primer carácter del String al final del resultado obtenido de invertir el resto de la cadena.
 * El caso base es cuando la longitud del String es menor o igual a 1 (cadena vacía o de un solo carácter), retornando el mismo String sin cambios.
 * El caso recursivo es invertirCadena(texto.substring(1)) + texto.charAt(0), donde en cada llamada reducimos la cadena quitándole la primera letra mediante substring(1).
 * La función debe devolver el String invertido.
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - "a" (debe retornar "a")
 * - "hola" (debe retornar "aloh")
 * - "recursivo" (debe retornar "ovisrucer")
 * - "Java" (debe retornar "avaJ")
 */

public class Ejercicio8_InvertirPalabra {

    /**
     * Invierte una cadena de caracteres mediante recursividad.
     * 
     * @param texto Cadena original.
     * @return Cadena invertida.
     */
    public static String invertirCadena(String texto) {
        if (texto == null) {
            return null;
        }

        // CASO BASE:
        // Si la cadena tiene 0 o 1 caracteres, ya está invertida por definición.
        if (texto.length() <= 1) {
            return texto;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Se llama recursivamente a invertirCadena pasando la subcadena sin la primera letra (substring(1)).
        // Al regresar de la llamada, se concatena el primer carácter (charAt(0)) al final.
        return invertirCadena(texto.substring(1)) + texto.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("Invertir 'a': " + invertirCadena("a"));                 // Esperado: "a"
        System.out.println("Invertir 'hola': " + invertirCadena("hola"));           // Esperado: "aloh"
        System.out.println("Invertir 'recursivo': " + invertirCadena("recursivo")); // Esperado: "ovisrucer"
        System.out.println("Invertir 'Java': " + invertirCadena("Java"));           // Esperado: "avaJ"
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se añadió en la implementación la comprobación de puntero nulo (`texto == null`) para prevenir 
 * excepciones `NullPointerException` en tiempo de ejecución.
 */