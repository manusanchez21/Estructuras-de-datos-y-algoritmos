/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar en Java un simulador de una torre de platos utilizando el concepto de Pila (LIFO).
 * El programa debe permitir agregar un plato, retirar el plato superior y consultar el plato de arriba.
 * En los comentarios se debe explicar por qué este problema requiere LIFO (Pila) y no FIFO (Cola): 
 * el último plato apilado es el único accesible en la superficie superior sin romper la torre.
 */

public class TorrePlatos {
    private String[] platos;
    private int cima;

    public TorrePlatos(int capacidad) {
        platos = new String[capacidad];
        cima = -1;
    }

    // JUSTIFICACIÓN LIFO vs FIFO:
    // Una torre de platos física sigue estrictamente el principio LIFO (Last In, First Out).
    // El último plato ingresado queda expuesto en la cima. Si intentáramos aplicar FIFO (retirar el 
    // primer plato colocado en la base), romperíamos la pila entera.
    public void apilarPlato(String plato) {
        if (cima == platos.length - 1) {
            System.out.println("No se pueden agregar más platos: La torre alcanzó su altura máxima.");
            return;
        }
        platos[++cima] = plato;
        System.out.println("Plato agregado: " + plato);
    }

    public String retirarPlato() {
        if (cima == -1) {
            System.out.println("No hay platos para retirar.");
            return null;
        }
        String retirado = platos[cima--];
        System.out.println("Plato retirado de arriba: " + retirado);
        return retirado;
    }

    public String platoEnCima() {
        if (cima == -1) return "Torre vacía";
        return platos[cima];
    }

    public static void main(String[] args) {
        TorrePlatos torre = new TorrePlatos(4);
        torre.apilarPlato("Plato Rojo");
        torre.apilarPlato("Plato Azul");
        torre.apilarPlato("Plato Blanco");

        System.out.println("Plato actualmente arriba: " + torre.platoEnCima());
        torre.retirarPlato(); // Retira "Plato Blanco"
        System.out.println("Plato actualmente arriba: " + torre.platoEnCima()); // "Plato Azul"
    }
}

/*
 * AJUSTES AL PROMPT Y EXPLICACIÓN:
 * El modelo original utilizaba representaciones numéricas; se adaptó para usar cadenas de texto (`String`), 
 * lo que otorga una mayor claridad al simular etiquetas de platos reales.
 */