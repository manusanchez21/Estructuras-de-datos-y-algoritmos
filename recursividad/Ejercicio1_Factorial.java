/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que resuelva el cálculo del factorial de un número entero n.
 * Este problema puede resolverse recursivamente porque el factorial de n equivale a multiplicar n por el factorial del número anterior (n - 1).
 * El caso base es cuando n es igual a 0 o 1, porque matemáticamente 0! = 1 y 1! = 1, lo que detiene las llamadas recursivas sin realizar más multiplicaciones.
 * El caso recursivo es n * factorial(n - 1), porque en cada llamada reducimos el problema decrementando n en 1 hacia el caso base.
 * La función debe devolver un número entero de tipo long correspondiente al factorial calculated.
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - n = 0 (debe retornar 1)
 * - n = 1 (debe retornar 1)
 * - n = 5 (debe retornar 120)
 * - n = 7 (debe retornar 5040)
 */

public class Ejercicio1_Factorial {

    /**
     * Calcula el factorial de un número n de forma recursiva.
     * 
     * @param n Número entero no negativo.
     * @return El factorial de n.
     */
    public static long factorial(int n) {
        // Validación de entradas negativas
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }

        // CASO BASE:
        // Si n es 0 o 1, el resultado es directamente 1.
        // Aquí se interrumpe el encadenamiento de llamadas y la pila comienza a desapilarse.
        if (n == 0 || n == 1) {
            return 1;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Se efectúa la llamada recursiva factorial(n - 1).
        // La ejecución actual pausa en la pila (Stack Frame) esperando la resolución de factorial(n - 1).
        // Una vez resuelta, el resultado retornado se multiplica por n.
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 0: " + factorial(0)); // Esperado: 1
        System.out.println("Factorial de 1: " + factorial(1)); // Esperado: 1
        System.out.println("Factorial de 5: " + factorial(5)); // Esperado: 120
        System.out.println("Factorial de 7: " + factorial(7)); // Esperado: 5040
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se añadió la validación para números negativos (lanzando IllegalArgumentException) 
 * y se definió el tipo de retorno como 'long' en lugar de 'int' para evitar desbordamiento 
 * aritmético rápido al calcular factoriales de números mayores.
 */