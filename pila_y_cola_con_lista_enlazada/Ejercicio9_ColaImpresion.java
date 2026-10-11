/*
 * Prompt inicial utilizado:
 * Implementar una cola de impresión con lista enlazada FIFO para objetos TrabajoImpresion (nombreArchivo, paginas, usuario).
 * Funciones: agregarTrabajo, imprimirProximo, consultarProximo y mostrarPendientes.
 * Explicar por qué un spooler de impresión debe procesar solicitudes usando la política FIFO.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Ninguno. La estructura enlazada gestionó las impresiones pendientes dinámicamente sin límites de capacidad.
 */

class TrabajoImpresion {
    private String nombreArchivo;
    private int paginas;
    private String usuario;

    public TrabajoImpresion(String nombreArchivo, int paginas, String usuario) {
        this.nombreArchivo = nombreArchivo;
        this.paginas = paginas;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "'" + nombreArchivo + "' (" + paginas + " pgs) - User: " + usuario;
    }
}

public class Ejercicio9_ColaImpresion {

    private static class Nodo {
        TrabajoImpresion trabajo;
        Nodo siguiente;

        public Nodo(TrabajoImpresion trabajo) {
            this.trabajo = trabajo;
            this.siguiente = null;
        }
    }

    private Nodo head;
    private Nodo tail;

    public void agregarTrabajo(TrabajoImpresion trabajo) {
        Nodo nuevo = new Nodo(trabajo);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.siguiente = nuevo;
            tail = nuevo;
        }
        System.out.println("Trabajo enviado a la impresora: " + trabajo);
    }

    public void imprimirProximo() {
        if (head == null) {
            System.out.println("No hay trabajos de impresión pendientes.");
            return;
        }
        TrabajoImpresion impreso = head.trabajo;
        head = head.siguiente;
        if (head == null) tail = null;
        System.out.println("IMPRIMIENDO AHORA -> " + impreso);
    }

    public void mostrarPendientes() {
        System.out.print("SPOOLER PENDIENTE: ");
        Nodo actual = head;
        while (actual != null) {
            System.out.print("[" + actual.trabajo + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("FIN");
    }

    public static void main(String[] args) {
        Ejercicio9_ColaImpresion impresora = new Ejercicio9_ColaImpresion();

        impresora.agregarTrabajo(new TrabajoImpresion("Tesis.pdf", 50, "Gabriel"));
        impresora.agregarTrabajo(new TrabajoImpresion("Foto.jpg", 1, "Laura"));

        impresora.mostrarPendientes();
        impresora.imprimirProximo(); // Imprime Tesis.pdf
        impresora.mostrarPendientes();
    }
}