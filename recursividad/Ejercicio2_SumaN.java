/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que resuelva la suma de los números enteros desde n hasta 1.
 * Este problema puede resolverse recursivamente porque la suma de los primeros n números es equivalente a sumar el número n con el resultado de sumar los primeros (n - 1) números.
 * El caso base (más simple) es cuando n es igual a 0, porque la suma acumulada de 0 elementos es 0, sirviendo de condición de corte.
 * El caso recursivo es n + suma(n - 1), porque en cada llamada reducimos el valor de n restándole 1 hasta alcanzar el caso base 0.
 * La función debe devolver un número entero con la suma total acumulada.
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - n = 0 (debe retornar 0)
 * - n = 1 (debe retornar 1)
 * - n = 5 (debe retornar 15)
 * - n = 10 (debe retornar 55)
 */

public class Ejercicio2_SumaN {

    /**
     * Suma de manera recursiva los números enteros desde n hasta 1.
     * 
     * @param n Número entero límite superior.
     * @return Suma acumulada.
     */
    public static int suma(int n) {
        // Control para evitar ciclos infinitos si se pasa un valor negativo
        if (n < 0) {
            throw new IllegalArgumentException("n no puede ser negativo.");
        }

        // CASO BASE:
        // Cuando n llega a 0, el problema se simplifica al valor neutro de la suma (0).
        // Finalizan las llamadas descendentes en la pila.
        if (n == 0) {
            return 0;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Se suma n al resultado de la subconsulta recursiva suma(n - 1).
        // Cada estado de n queda guardado en la pila hasta que suma(0) retorna.
        return n + suma(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Suma hasta 0: " + suma(0));   // Esperado: 0
        System.out.println("Suma hasta 1: " + suma(1));   // Esperado: 1
        System.out.println("Suma hasta 5: " + suma(5));   // Esperado: 15
        System.out.println("Suma hasta 10: " + suma(10)); // Esperado: 55
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se incorporó una validación previa para prevenir bucles de recursión infinita (StackOverflowError) 
 * cuando el parámetro recibido sea un entero negativo.
 */