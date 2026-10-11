/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java un sistema de turnos para atención en una oficina usando una Cola (FIFO).
 * Funciones: agregarPersona, atenderSiguiente y consultarPrimero.
 * Explicar por qué es FIFO: el cliente que llega primero tiene derecho prioritario a ser atendido antes que quienes llegaron después.
 */

public class SistemaTurnos {
    private String[] colaClientes;
    private int front;
    private int rear;
    private int contador;

    public SistemaTurnos(int capacidad) {
        colaClientes = new String[capacidad];
        front = 0;
        rear = -1;
        contador = 0;
    }

    public void agregarPersona(String nombre) {
        if (contador == colaClientes.length) {
            System.out.println("Fila de espera llena. No se admiten más turnos por hoy.");
            return;
        }
        rear++;
        colaClientes[rear] = nombre;
        contador++;
        System.out.println("Turno asignado a: " + nombre);
    }

    public void atenderSiguiente() {
        if (contador == 0) {
            System.out.println("No hay clientes en espera.");
            return;
        }
        String clienteAtendido = colaClientes[front++];
        contador--;
        System.out.println("Atendiendo a: " + clienteAtendido);
    }

    public String consultarPrimero() {
        if (contador == 0) return "Nadie en la cola";
        return colaClientes[front];
    }

    public static void main(String[] args) {
        SistemaTurnos oficina = new SistemaTurnos(3);

        oficina.agregarPersona("Juan Pérez");
        oficina.agregarPersona("María Gómez");
        oficina.agregarPersona("Carlos López");

        System.out.println("Siguiente en la fila: " + oficina.consultarPrimero()); // Juan Pérez
        oficina.atenderSiguiente(); // Atiende a Juan Pérez
        System.out.println("Siguiente en la fila: " + oficina.consultarPrimero()); // María Gómez
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * Se introdujo una variable auxiliar `contador` para verificar el estado de cola llena/vacía de manera independiente 
 * a la posición absoluta de las posiciones `front` y `rear`.
 */