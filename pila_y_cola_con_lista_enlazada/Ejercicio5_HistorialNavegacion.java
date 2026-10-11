/*
 * Prompt inicial utilizado:
 * Implementar un historial de navegación con pila enlazada de Strings.
 * Funciones: visitarPagina, volverAtras, paginaActual e imprimirHistorial.
 * Explicar por qué LIFO representa el comportamiento del botón 'Atrás' en un navegador.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se agregó una verificación para impedir la desapilación de la página base cuando sólo queda 1 sitio en el historial.
 */

public class Ejercicio5_HistorialNavegacion {

    private static class Nodo {
        String url;
        Nodo siguiente;

        public Nodo(String url) {
            this.url = url;
            this.siguiente = null;
        }
    }

    private Nodo top;

    public void visitarPagina(String url) {
        Nodo nuevo = new Nodo(url);
        nuevo.siguiente = top;
        top = nuevo;
        System.out.println("Navegando a: " + url);
    }

    public void volverAtras() {
        if (top == null || top.siguiente == null) {
            System.out.println("No hay páginas anteriores a las cuales regresar.");
            return;
        }
        String saliendo = top.url;
        top = top.siguiente; // Pop de la página activa
        System.out.println("Retrocediendo desde [" + saliendo + "] hacia -> " + top.url);
    }

    public String paginaActual() {
        if (top == null) return "Pestaña en blanco";
        return top.url;
    }

    public void imprimirHistorial() {
        System.out.print("HISTORIAL (Actual primero): ");
        Nodo actual = top;
        while (actual != null) {
            System.out.print("[" + actual.url + "] <- ");
            actual = actual.siguiente;
        }
        System.out.println("INICIO");
    }

    public static void main(String[] args) {
        Ejercicio5_HistorialNavegacion historial = new Ejercicio5_HistorialNavegacion();

        historial.visitarPagina("google.com");
        historial.visitarPagina("github.com");
        historial.visitarPagina("wikipedia.org");

        historial.imprimirHistorial();
        historial.volverAtras(); // Regresa a github.com
        System.out.println("Página en pantalla: " + historial.paginaActual());
    }
}