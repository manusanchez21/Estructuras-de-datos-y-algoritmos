/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar un simulador de historial de navegación web en Java basado en una Pila de Strings.
 * Cada página visitada realiza un push. Retroceder realiza un pop.
 * Se debe explicar por qué el historial funciona bajo LIFO: la última página cargada es la primera a la que se renuncia al presionar 'Atrás'.
 */

public class HistorialNavegacion {
    private String[] historial;
    private int top;

    public HistorialNavegacion(int capacidad) {
        historial = new String[capacidad];
        top = -1;
    }

    public void visitarPagina(String url) {
        if (top == historial.length - 1) {
            System.out.println("Historial lleno.");
            return;
        }
        historial[++top] = url;
        System.out.println("Navegando a: " + url);
    }

    public void paginaAnterior() {
        if (top <= 0) {
            System.out.println("No hay páginas anteriores en el historial.");
            return;
        }
        // Se remueve la página actual (pop)
        String paginaActual = historial[top--];
        System.out.println("Saliendo de [" + paginaActual + "]. Volviendo a: " + historial[top]);
    }

    public String obtenerPaginaActual() {
        if (top == -1) return "Pestaña en blanco";
        return historial[top];
    }

    public static void main(String[] args) {
        HistorialNavegacion navegacion = new HistorialNavegacion(5);

        navegacion.visitarPagina("google.com");
        navegacion.visitarPagina("github.com");
        navegacion.visitarPagina("stackoverflow.com");

        System.out.println("Página actual: " + navegacion.obtenerPaginaActual());
        navegacion.paginaAnterior(); // Regresa a github.com
        navegacion.paginaAnterior(); // Regresa a google.com
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * Se previno un error de comportamiento en `paginaAnterior()` ajustando el límite inferior (`top <= 0`), 
 * impidiendo que el usuario pueda desapilar la página raíz del historial dejándolo vacío por accidente.
 */