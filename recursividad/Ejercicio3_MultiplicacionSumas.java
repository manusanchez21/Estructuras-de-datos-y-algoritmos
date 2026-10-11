/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que resuelva la multiplicación de dos números enteros sin utilizar el operador '*'.
 * Este problema puede resolverse recursivamente porque la multiplicación 'a x b' puede representarse como sumar el número 'a' con sí mismo 'b' veces.
 * El caso base es cuando el multiplicador b es 0, porque cualquier número multiplicado por 0 resulta en 0.
 * El caso recursivo es a + multiplicar(a, b - 1), porque en cada llamada sumamos 'a' y reducimos el multiplicador 'b' en 1 unidad.
 * La función debe devolver el producto total entero acumulado por las sumas.
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - 5 x 0 (debe retornar 0)
 * - 7 x 1 (debe retornar 7)
 * - 5 x 3 (debe retornar 15)
 * - 4 x 6 (debe retornar 24)
 */

public class Ejercicio3_MultiplicacionSumas {

    /**
     * Multiplica dos números enteros no negativos usando sumas recursivas.
     * 
     * @param a Multiplicando.
     * @param b Multiplicador.
     * @return Producto de a y b.
     */
    public static int multiplicar(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Los argumentos deben ser enteros no negativos.");
        }

        // CASO BASE:
        // Todo número multiplicado por 0 es 0. 
        // Detiene la recursión y retorna 0 para empezar a sumar de regreso.
        if (b == 0) {
            return 0;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Sumamos 'a' al resultado de decrementar 'b' en 1: multiplicar(a, b - 1).
        // Las llamadas quedan en la pila 'b' veces hasta que b alcanza 0.
        return a + multiplicar(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println("5 x 0 = " + multiplicar(5, 0)); // Esperado: 0
        System.out.println("7 x 1 = " + multiplicar(7, 1)); // Esperado: 7
        System.out.println("5 x 3 = " + multiplicar(5, 3)); // Esperado: 15
        System.out.println("4 x 6 = " + multiplicar(4, 6)); // Esperado: 24
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se precisó en el prompt que el parámetro a reducir de forma explícita es el multiplicador 'b', 
 * garantizando una cantidad acotada de b llamadas en la pila.
 */