/*
 * PROMPT INICIAL DE GENERACIÓN:
 * Quiero implementar un programa en Java que gestione un ranking de jugadores ordenados de MAYOR a MENOR puntaje. 
 * Definir una clase Jugador con atributos nombre (String) y puntaje (int). 
 * Datos de entrada de ejemplo: Jugador("Ana", 1200), Jugador("Pedro", 900), Jugador("Lucia", 1500). 
 * Para ordenar el ranking se utilizará el algoritmo Insertion Sort adaptado en orden descendente. 
 * En los comentarios del código se debe justificar por qué esta estrategia es conveniente para rankings deportivos/juegos (alta eficiencia para pocos datos o rankings que se actualizan incrementalmente de a un jugador). 
 * La verificación se realizará imprimiendo el ranking resultante ordenado descendentemente.
 */

import java.util.Arrays;

class Jugador {
    private String nombre;
    private int puntaje;

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getNombre() { return nombre; }
    public int getPuntaje() { return puntaje; }

    @Override
    public String toString() {
        return nombre + " (" + puntaje + " pts)";
    }
}

public class Ejercicio10_RankingPuntajes {

    /**
     * Ordena una lista de jugadores de mayor a menor puntaje mediante Insertion Sort.
     * 
     * @param ranking Arreglo de Objetos Jugador.
     */
    public static void ordenarRanking(Jugador[] ranking) {
        if (ranking == null || ranking.length <= 1) return;

        int n = ranking.length;

        // JUSTIFICACIÓN DEL ALGORITMO:
        // Se elige Insertion Sort para el sistema de ranking por las siguientes ventajas:
        // 1. En aplicaciones de juegos, los nuevos puntajes ingresan secuencialmente uno a uno.
        //    Insertion Sort los ubica en tiempo O(N) casi de inmediato.
        // 2. Es un algoritmo estable (mantiene el orden relativo previo de jugadores con el mismo puntaje).
        // 3. Su sobrecarga de memoria es nula O(1).
        for (int i = 1; i < n; i++) {
            Jugador clave = ranking[i];
            int j = i - 1;

            // ORDEN DESCENDENTE:
            // La condición (ranking[j].getPuntaje() < clave.getPuntaje()) desplace hacia abajo
            // a aquellos jugadores que tengan MENOR puntaje que el jugador 'clave'.
            while (j >= 0 && ranking[j].getPuntaje() < clave.getPuntaje()) {
                ranking[j + 1] = ranking[j];
                j--;
            }
            ranking[j + 1] = clave;
        }
    }

    public static void main(String[] args) {
        Jugador[] listaJugadores = {
            new Jugador("Pedro", 900),
            new Jugador("Lucia", 1500),
            new Jugador("Ana", 1200),
            new Jugador("Carlos", 1500), // Prueba de estabilidad ante empates
            new Jugador("Sofia", 300)
        };

        System.out.println("--- RANKING INICIAL ---");
        System.out.println(Arrays.toString(listaJugadores));

        ordenarRanking(listaJugadores);

        System.out.println("\n--- RANKING ORDENADO (MAYOR A MENOR) ---");
        for (int i = 0; i < listaJugadores.length; i++) {
            System.out.println((i + 1) + "° Posición: " + listaJugadores[i]);
        }
    }
}

/*
 * MODIFICACIONES Y MEJORAS AL PROMPT:
 * Se incluyó un caso adicional con empate de puntajes (Lucia y Carlos con 1500 pts) para comprobar 
 * que el algoritmo preserva la estabilidad del orden de llegada original.
 */