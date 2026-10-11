/*
 * Prompt inicial utilizado:
 * Implementar un programa que invierta un String utilizando una pila enlazada de caracteres.
 * Explicar por qué la política LIFO revierte automáticamente el orden de la secuencia ingresada.
 * Ejemplo de prueba: "algoritmo" -> "omtirogla".
 *
 * Ajustes realizados luego de la primera respuesta of OpenCode:
 * Se utilizó StringBuilder para acumular eficientemente las letras desapiladas en O(N) de tiempo.
 */

public class Ejercicio8_InvertirPalabraPila {

    private static class NodoChar {
        char caracter;
        NodoChar siguiente;

        public NodoChar(char caracter) {
            this.caracter = caracter;
        }
    }

    public static String invertirPalabra(String palabra) {
        if (palabra == null) return null;

        NodoChar top = null;

        // 1. Apilar cada carácter de la palabra de izquierda a derecha
        for (int i = 0; i < palabra.length(); i++) {
            NodoChar nuevo = new NodoChar(palabra.charAt(i));
            nuevo.siguiente = top;
            top = nuevo;
        }

        // 2. Desapilar los caracteres para construir la palabra invertida
        StringBuilder resultado = new StringBuilder();
        while (top != null) {
            resultado.append(top.caracter);
            top = top.siguiente; // Pop
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        String original = "algoritmo";
        String invertida = invertirPalabra(original);

        System.out.println("Palabra original:  " + original);
        System.out.println("Palabra invertida: " + invertida); // "omtirogla"
    }
}