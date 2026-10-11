/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java un sistema de cola de impresión FIFO.
 * Definir la clase Documento (nombre, páginas). Los documentos se imprimen en el orden exacto de llegada.
 * Explicar la idoneidad de la Cola para procesar recursos compartidos como impresoras de red.
 */

class Documento {
    private String nombre;
    private int paginas;

    public Documento(String nombre, int paginas) {
        this.nombre = nombre;
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "'" + nombre + "' (" + paginas + " pgs)";
    }
}

public class ColaImpresion {
    private Documento[] cola;
    private int front;
    private int rear;
    private int cantidad;

    public ColaImpresion(int capacidad) {
        cola = new Documento[capacidad];
        front = 0;
        rear = -1;
        cantidad = 0;
    }

    public void enviarDocumento(Documento doc) {
        if (cantidad == cola.length) {
            System.out.println("Memoria de impresora llena. Trabajo rechazado: " + doc);
            return;
        }
        cola[++rear] = doc;
        cantidad++;
        System.out.println("Documento enviado a cola de impresión: " + doc);
    }

    public void imprimirSiguiente() {
        if (cantidad == 0) {
            System.out.println("No hay documentos pendientes de impresión.");
            return;
        }
        Documento docImpreso = cola[front++];
        cantidad--;
        System.out.println("Imprimiendo ahora -> " + docImpreso);
    }

    public static void main(String[] args) {
        ColaImpresion impresora = new ColaImpresion(3);

        impresora.enviarDocumento(new Documento("Reporte_Anual.pdf", 15));
        impresora.enviarDocumento(new Documento("Contrato.docx", 3));

        impresora.imprimirSiguiente(); // Imprime Reporte_Anual.pdf
        impresora.imprimirSiguiente(); // Imprime Contrato.docx
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * Se sobreescribió el método `toString()` en la clase `Documento` para obtener salidas de consola descriptivas 
 * y legibles durante el procesamiento.
 */