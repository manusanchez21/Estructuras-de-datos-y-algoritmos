/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java una función recursiva que busque un número dentro de un arreglo de enteros sin usar ciclos (for, while).
 * Este problema puede resolverse recursivamente manteniendo un parámetro 'indice' que indica la posición actual en la búsqueda, avanzando al índice siguiente (indice + 1) en cada iteración recursiva.
 * El primer caso base es si indice == arreglo.length, lo que indica que se recorrió todo el arreglo sin encontrar el elemento, retornando -1.
 * El segundo caso base es si arreglo[indice] == objetivo, lo que significa que el elemento fue hallado, retornando su posición (indice).
 * El caso recursivo es buscarElemento(arreglo, objetivo, indice + 1), que incrementa el marcador para inspeccionar la siguiente celda.
 * La función debe devolver el índice donde se encuentra el elemento o -1 si no existe.
 * Quiero que el código tenga comentarios explicando los casos base, el caso recursivo y la pila de llamadas.
 * También quiero probarlo con estos casos:
 * - arreglo = {10, 20, 30, 40, 50}, buscar 10 (debe retornar 0)
 * - arreglo = {10, 20, 30, 40, 50}, buscar 30 (debe retornar 2)
 * - arreglo = {10, 20, 30, 40, 50}, buscar 50 (debe retornar 4)
 * - arreglo = {10, 20, 30, 40, 50}, buscar 99 (debe retornar -1)
 */

public class Ejercicio10_BuscarArreglo {

    /**
     * Busca recursivamente un elemento dentro de un arreglo sin usar ciclos.
     * 
     * @param arreglo  Arreglo de enteros.
     * @param objetivo Elemento buscado.
     * @param indice   Índice de la posición actual en la búsqueda.
     * @return Índice del elemento si existe, -1 en caso contrario.
     */
    public static int buscarElemento(int[] arreglo, int objetivo, int indice) {
        if (arreglo == null) {
            return -1;
        }

        // CASO BASE 1: FIN DEL ARREGLO
        // Si el índice alcanza la longitud del arreglo, el elemento no está presente.
        if (indice == arreglo.length) {
            return -1;
        }

        // CASO BASE 2: ÉXITO
        // Si el elemento en la posición actual coincide con el objetivo, devolvemos el índice.
        if (arreglo[indice] == objetivo) {
            return indice;
        }

        // CASO RECURSIVO Y PILA DE LLAMADAS:
        // Avanzamos al siguiente elemento (indice + 1) sin recurrir a estructuras iterativas.
        return buscarElemento(arreglo, objetivo, indice + 1);
    }

    // Sobrecarga conveniente para iniciar la búsqueda en el índice 0 automáticamente
    public static int buscarElemento(int[] arreglo, int objetivo) {
        return buscarElemento(arreglo, objetivo, 0);
    }

    public static void main(String[] args) {
        int[] datos = {10, 20, 30, 40, 50};

        System.out.println("Buscar 10: " + buscarElemento(datos, 10)); // Esperado: 0
        System.out.println("Buscar 30: " + buscarElemento(datos, 30)); // Esperado: 2
        System.out.println("Buscar 50: " + buscarElemento(datos, 50)); // Esperado: 4
        System.out.println("Buscar 99: " + buscarElemento(datos, 99)); // Esperado: -1
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se incluyó un método sobrecargado `buscarElemento(arreglo, objetivo)` para simplificar la firma de invocación 
 * desde la vista externa, abstrayendo al usuario de pasar el índice inicial `0` manualmente.
 */