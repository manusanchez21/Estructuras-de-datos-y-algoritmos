/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que resuelva el cálculo de la potencia de un número (base^exponente) sin usar Math.pow.
 * Este problema puede resolverse recursivamente porque calcular una potencia equivale a multiplicar la base por sí misma la cantidad de veces indicada por el exponente (base * base^(exponente - 1)).
 * El caso base es cuando el exponente es igual a 0, porque todo número elevado a la 0 da como resultado 1.
 * El caso recursivo es base * potencia(base, exponente - 1), porque en cada paso reducimos el exponente en 1 unidad.
 * La función debe devolver el resultado entero o de tipo long de la potencia.
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - base = 2, exponente = 0 (debe retornar 1)
 * - base = 3, exponente = 1 (debe retornar 3)
 * - base = 2, exponente = 3 (debe retornar 8)
 * - base = 5, exponente = 3 (debe retornar 125)
 */

public class Ejercicio4_Potencia {

    /**
     * Calcula la potencia de un número de forma recursiva.
     * 
     * @param base      Número base.
     * @param exponente Exponente no negativo.
     * @return Resultado de base elevado a exponente.
     */
    public static long potencia(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo.");
        }

        // CASO BASE:
        // Cualquier número elevado a la potencia 0 es igual a 1.
        if (exponente == 0) {
            return 1;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Retorna la base multiplicada por la potencia reducida (exponente - 1).
        // Las iteraciones recursivas quedan pausadas en la pila hasta que exponente llega a 0.
        return base * potencia(base, exponente - 1);
    }

    public static void main(String[] args) {
        System.out.println("2^0 = " + potencia(2, 0)); // Esperado: 1
        System.out.println("3^1 = " + potencia(3, 1)); // Esperado: 3
        System.out.println("2^3 = " + potencia(2, 3)); // Esperado: 8
        System.out.println("5^3 = " + potencia(5, 3)); // Esperado: 125
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se ajustó el tipo de retorno a 'long' para dar soporte a exponentes mayores sin desbordar el rango 
 * máximo de enteros de 32 bits de Java.
 */