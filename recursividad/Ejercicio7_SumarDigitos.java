/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que sume los dígitos de un número entero positivo n.
 * Este problema puede resolverse recursivamente extrayendo el último dígito con el operador módulo (n % 10) y reduciendo el número con división entera (n / 10).
 * El caso base es cuando n < 10, donde el número consta de un solo dígito y la suma es el mismo valor de n.
 * El caso recursivo es (n % 10) + sumarDigitos(n / 10), sumando el último dígito obtenido a la suma recursiva del resto de los dígitos.
 * La función debe devolver la suma entera acumulada de los dígitos.
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - n = 7 (debe retornar 7)
 * - n = 12 (debe retornar 3)
 * - n = 1234 (debe retornar 10)
 * - n = 999 (debe retornar 27)
 */

public class Ejercicio7_SumarDigitos {

    /**
     * Suma los dígitos de un entero positivo recursivamente.
     * 
     * @param n Número entero no negativo.
     * @return Suma de sus dígitos.
     */
    public static int sumarDigitos(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }

        // CASO BASE:
        // Un número de un solo dígito se retorna directamente a sí mismo.
        if (n < 10) {
            return n;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Extraemos el dígito de la derecha (n % 10) y lo sumamos a la llamada recursiva sobre el resto (n / 10).
        return (n % 10) + sumarDigitos(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("Suma dígitos de 7: " + sumarDigitos(7));       // Esperado: 7
        System.out.println("Suma dígitos de 12: " + sumarDigitos(12));     // Esperado: 3
        System.out.println("Suma dígitos de 1234: " + sumarDigitos(1234)); // Esperado: 10
        System.out.println("Suma dígitos de 999: " + sumarDigitos(999));   // Esperado: 27
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se justified la combinación de los operadores de módulo (%) para aislar unidades y de división (/) 
 * para contraer las decenas en cada cuadro de ejecución de la pila.
 */