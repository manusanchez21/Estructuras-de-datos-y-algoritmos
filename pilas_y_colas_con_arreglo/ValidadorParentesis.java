/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java un programa que valide si los paréntesis de una expresión matemática están correctamente balanceados utilizando una Pila de caracteres.
 * Al encontrar '(', se apila. Al encontrar ')', se desapila.
 * Si al querer desapilar la pila está vacía, o si al terminar la cadena quedan elementos en la pila, la expresión es inválida.
 * Probar con: "(5 + 3) * (2 + 1)" y "(5 + 3)) * (2 + 1".
 */

public class ValidadorParentesis {

    public static boolean esBalanceado(String expresion) {
        // Pila basada en arreglo con capacidad igual al tamaño de la expresión
        char[] pila = new char[expresion.length()];
        int top = -1;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si es un paréntesis de apertura, se apila
            if (c == '(') {
                pila[++top] = c;
            } 
            // Si es un paréntesis de cierre
            else if (c == ')') {
                // Si la pila está vacía, hay un ')' sin su '(' correspondiente -> Inválido
                if (top == -1) {
                    return false;
                }
                // Se realiza el pop desapilando el '(' coincidente
                top--;
            }
        }

        // Si top == -1, todos los '(' fueron emparejados con un ')' -> Válido
        return top == -1;
    }

    public static void main(String[] args) {
        String exp1 = "(5 + 3) * (2 + 1)";
        String exp2 = "(5 + 3)) * (2 + 1";

        System.out.println("Expresión: \"" + exp1 + "\" -> ¿Es válida?: " + esBalanceado(exp1)); // true
        System.out.println("Expresión: \"" + exp2 + "\" -> ¿Es válida?: " + esBalanceado(exp2)); // false
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * Se optimizó creando una pila liviana usando directamente un arreglo primitivo `char[]` de tamaño igual 
 * a la longitud de la cadena de entrada, evitando dependencias externas de librerías.
 */