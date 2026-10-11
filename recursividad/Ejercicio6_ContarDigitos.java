/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que cuente la cantidad de dígitos de un número entero positivo n.
 * Este problema puede resolverse recursivamente eliminando un dígito en cada paso mediante división entera entre 10 (n / 10).
 * El caso base es cuando n < 10 (número de un solo dígito), devolviendo 1 ya que no se puede dividir más sin llegar a 0.
 * El caso recursivo es 1 + contarDigitos(n / 10), sumando 1 por el dígito procesado más el conteo del resto de los dígitos.
 * La función debe devolver un número entero con la cantidad total de dígitos.
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - n = 5 (debe retornar 1)
 * - n = 42 (debe retornar 2)
 * - n = 12345 (debe retornar 5)
 * - n = 987654 (debe retornar 6)
 */

public class Ejercicio6_ContarDigitos {

    /**
     * Cuenta la cantidad de dígitos de un entero positivo de forma recursiva.
     * 
     * @param n Número entero positivo.
     * @return Cantidad de dígitos de n.
     */
    public static int contarDigitos(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser positivo.");
        }

        // CASO BASE:
        // Si el número tiene un solo dígito (menor a 10), retornamos 1.
        if (n < 10) {
            return 1;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Sumamos 1 al conteo devuelto por la llamada recursiva pasándole el número sin su último dígito (n / 10).
        return 1 + contarDigitos(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("Dígitos de 5: " + contarDigitos(5));           // Esperado: 1
        System.out.println("Dígitos de 42: " + contarDigitos(42));         // Esperado: 2
        System.out.println("Dígitos de 12345: " + contarDigitos(12345));   // Esperado: 5
        System.out.println("Dígitos de 987654: " + contarDigitos(987654)); // Esperado: 6
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se estableció la restricción de que n debe ser mayor o igual a 0 para asegurar el comportamiento de la división entera.
 */