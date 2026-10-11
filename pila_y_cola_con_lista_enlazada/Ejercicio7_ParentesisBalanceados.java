/*
 * Prompt inicial utilizado:
 * Crear un programa que valide si los paréntesis están balanceados utilizando una pila enlazada de caracteres.
 * Al encontrar '(', push. Al encontrar ')', pop.
 * Evaluar invalidez si la pila está vacía al desapilar o si no queda vacía al terminar.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se encapsuló la estructura de nodo internamente para no depender de librerías externas.
 */

public class Ejercicio7_ParentesisBalanceados {

    private static class NodoChar {
        char caracter;
        NodoChar siguiente;

        public NodoChar(char caracter) {
            this.caracter = caracter;
            this.siguiente = null;
        }
    }

    public static boolean esBalanceado(String expresion) {
        NodoChar top = null;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(') {
                // Push
                NodoChar nuevo = new NodoChar(c);
                nuevo.siguiente = top;
                top = nuevo;
            } else if (c == ')') {
                // Pop con verificación de vacía
                if (top == null) {
                    return false; // Cierre sin apertura previa
                }
                top = top.siguiente;
            }
        }

        // Válido únicamente si no quedaron aperturas sin cerrar
        return top == null;
    }

    public static void main(String[] args) {
        String val1 = "(2 + 3) * (5 - 1)";
        String val2 = "((a + b) * c)";
        String inv1 = "(2 + 3";
        String inv2 = "())(";

        System.out.println("Expresión: \"" + val1 + "\" -> ¿Es válida?: " + esBalanceado(val1)); // true
        System.out.println("Expresión: \"" + val2 + "\" -> ¿Es válida?: " + esBalanceado(val2)); // true
        System.out.println("Expresión: \"" + inv1 + "\" -> ¿Es válida?: " + esBalanceado(inv1)); // false
        System.out.println("Expresión: \"" + inv2 + "\" -> ¿Es válida?: " + esBalanceado(inv2)); // false
    }
}