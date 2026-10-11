/*
 * Prompt inicial utilizado:
 * Implementar un sistema de cola bancaria usando una cola enlazada con objetos ClienteBanco (nombre, numeroTurno, motivoConsulta).
 * Métodos: agregarCliente, atenderProximo, consultarProximo e imprimirFila.
 * Explicar por qué corresponde usar la estructura FIFO.
 *
 * Ajustes realizados luego de la primera respuesta de OpenCode:
 * Se sobreescribió toString() en ClienteBanco para imprimir fichas de turno claras por consola.
 */

class ClienteBanco {
    private String nombre;
    private int numeroTurno;
    private String motivoConsulta;

    public ClienteBanco(String nombre, int numeroTurno, String motivoConsulta) {
        this.nombre = nombre;
        this.numeroTurno = numeroTurno;
        this.motivoConsulta = motivoConsulta;
    }

    @Override
    public String toString() {
        return "Turno T-" + numeroTurno + ": " + nombre + " [" + motivoConsulta + "]";
    }
}

public class Ejercicio6_ColaAtencionBanco {

    private static class Nodo {
        ClienteBanco cliente;
        Nodo siguiente;

        public Nodo(ClienteBanco cliente) {
            this.cliente = cliente;
            this.siguiente = null;
        }
    }

    private Nodo head;
    private Nodo tail;

    public void agregarCliente(ClienteBanco cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.siguiente = nuevo;
            tail = nuevo;
        }
        System.out.println("Ingresado a la fila: " + cliente);
    }

    public void atenderProximo() {
        if (head == null) {
            System.out.println("No hay clientes pendientes en la fila.");
            return;
        }
        ClienteBanco atendido = head.cliente;
        head = head.siguiente;
        if (head == null) tail = null;
        System.out.println("-> Atendiendo en caja a: " + atendido);
    }

    public void imprimirFila() {
        System.out.print("FILA ACTUAL: ");
        Nodo actual = head;
        while (actual != null) {
            System.out.print("[" + actual.cliente + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("FIN");
    }

    public static void main(String[] args) {
        Ejercicio6_ColaAtencionBanco banco = new Ejercicio6_ColaAtencionBanco();

        banco.agregarCliente(new ClienteBanco("Pedro", 1, "Caja de ahorro"));
        banco.agregarCliente(new ClienteBanco("Lucía", 2, "Crédito"));
        banco.imprimirFila();

        banco.atenderProximo(); // Atiende a Pedro
        banco.imprimirFila();
    }
}