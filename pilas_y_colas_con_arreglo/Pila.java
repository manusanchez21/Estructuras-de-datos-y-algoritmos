/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una clase Pila genérica Pila<T> utilizando arreglos internos.
 * Debe permitir almacenar Integer, String u objetos genéricos.
 * Se debe explicar qué problema resuelven los genéricos (reutilización de código y type-safety) 
 * en comparación con una pila exclusivamente hecha con tipos primitivos int.
 */

public class Pila<T> {
    private Object[] arreglo;
    private int top;

    @SuppressWarnings("unchecked")
    public Pila(int capacidad) {
        // En Java no se pueden instanciar arreglos de tipos genéricos directamente T[],
        // por lo que se crea un arreglo de Object y se castea.
        this.arreglo = new Object[capacidad];
        this.top = -1;
    }

    public void push(T elemento) {
        if (top == arreglo.length - 1) {
            throw new IllegalStateException("Pila llena.");
        }
        arreglo[++top] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            throw new IllegalStateException("Pila vacía.");
        }
        T elemento = (T) arreglo[top];
        arreglo[top--] = null; // Limpieza de referencia para el Garbage Collector
        return elemento;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        // Pila de Enteros
        Pila<Integer> pilaNumeros = new Pila<>(3);
        pilaNumeros.push(100);
        pilaNumeros.push(200);
        System.out.println("Pop en Pila de Enteros: " + pilaNumeros.pop());

        // Pila de Cadenas de texto
        Pila<String> pilaTextos = new Pila<>(3);
        pilaTextos.push("Estructuras");
        pilaTextos.push("Algoritmos");
        System.out.println("Pop en Pila de Textos: " + pilaTextos.pop());
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * Se añadió la anotación `@SuppressWarnings("unchecked")` y la anulación del puntero desapilado (`arreglo[top] = null`) 
 * para garantizar un manejo limpio de la memoria sin advertencias del compilador.
 */