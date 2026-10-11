/*
 * Prompt inicial utilizado:
 * Quiero implementar int contarOcurrencias(int dato) para contar repeticiones de un número en la lista.
 * Ejemplo: 10 -> 20 -> 10 -> 30 -> 10 -> null con dato=10 debe devolver 3.
 * Explicar por qué es obligatorio procesar todos los nodos sin detener el recorrido al primer hallazgo.
 * 
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se simplificó la condición de acumulador usando un contador entero inicializado en 0.
 */

public class Ejercicio8_ContarOcurrencias {

    private static class Nodo {
        int dato;
        Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; }
    }

    private Nodo head;

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) head = nuevo;
        else {
            Nodo actual = head;
            while (actual.siguiente != null) actual = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    public int contarOcurrencias(int dato) {
        int contador = 0;
        Nodo actual = head;

        // JUSTIFICACIÓN:
        // A diferencia de la búsqueda lineal estándar donde nos detenemos con un 'return true' 
        // al primer hallazgo, para contar ocurrencias debemos evaluar la totalidad de los nodos 
        // ya que el dato puede reaparecer en posiciones posteriores.
        while (actual != null) {
            if (actual.dato == dato) {
                contador++;
            }
            actual = actual.siguiente; // Continuar hasta el final (null)
        }

        return contador;
    }

    public static void main(String[] args) {
        Ejercicio8_ContarOcurrencias lista = new Ejercicio8_ContarOcurrencias();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(10);
        lista.agregar(30);
        lista.agregar(10);

        System.out.println("Ocurrencias del número 10: " + lista.contarOcurrencias(10)); // 3
        System.out.println("Ocurrencias del número 50: " + lista.contarOcurrencias(50)); // 0
    }
}