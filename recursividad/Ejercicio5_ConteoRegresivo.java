/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que realice un conteo regresivo imprimiendo los números desde n hasta 0.
 * Este problema puede resolverse recursivamente ejecutando la impresión del número actual n y delegando la impresión del resto de números a una llamada recursiva con (n - 1).
 * La función no devuelve un valor (retorna void) porque su objetivo no es calcular algo sino producir un efecto secundario (imprimir en consola).
 * El caso base es cuando n es menor a 0, instante en el que la función retorna para finalizar el conteo.
 * El caso recursivo es imprimir n y luego llamar a conteoRegresivo(n - 1). Si usáramos n + 1 en lugar de n - 1, el parámetro aumentaría indefinidamente alejándose de 0 y provocando un error de desbordamiento de pila (StackOverflowError).
 * Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - n = 5
 * - n = 3
 * - n = 0
 */

public class Ejercicio5_ConteoRegresivo {

    /**
     * Imprime una cuenta regresiva desde n hasta 0 recursivamente.
     * 
     * @param n Valor inicial del conteo.
     */
    public static void conteoRegresivo(int n) {
        // CASO BASE:
        // Cuando n es menor que 0, se interrumpe la función mediante 'return'.
        if (n < 0) {
            return;
        }

        // ACCIÓN DEL NIVEL ACTUAL:
        System.out.print(n + " ");

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Llamada recursiva disminuyendo n en 1 hacia el caso base.
        // Cada estado se coloca en la pila hasta alcanzar n < 0.
        conteoRegresivo(n - 1);
    }

    public static void main(String[] args) {
        System.out.print("Conteo desde 5: ");
        conteoRegresivo(5); // Esperado: 5 4 3 2 1 0
        System.out.println();

        System.out.print("Conteo desde 3: ");
        conteoRegresivo(3); // Esperado: 3 2 1 0
        System.out.println();

        System.out.print("Conteo desde 0: ");
        conteoRegresivo(0); // Esperado: 0
        System.out.println();
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se aclaró de forma explícita en el análisis del prompt la razón teórica de por qué la expresión (n + 1) 
 * deriva en un StackOverflowError al dinamizar el comportamiento de la pila.
 */