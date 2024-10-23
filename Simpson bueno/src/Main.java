import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final int MAX_FILA_T = 10;
    private static final int MAX_COLUMNA_T = 10;
    private static char[][] tablero;
    private static int filaBart, columnaBart;
    private static int vidas = 5;
    private static void printTablero() {
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void inicializarTablero() {
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                tablero[i][j] = 'L';
            }
        }
    }
    private static void colocarEnCasillaAleatoria(char caracter, int cantidad) {
        Random aleatorio = new Random();
        int filaAleatorio, columnaAleatorio;

        for (int i = 0; i < cantidad; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(MAX_FILA_T);
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_T);
            } while (tablero[filaAleatorio][columnaAleatorio] != 'L');
            tablero[filaAleatorio][columnaAleatorio] = caracter;
        }
    }
    private static void moverBart(char direccion) {
        int nuevaFila = filaBart;
        int nuevaColumna = columnaBart;

        switch (direccion) {
            case 'A': // Izquierda
                nuevaColumna--;
                break;
            case 'D': // Derecha
                nuevaColumna++;
                break;
            case 'W': // Arriba
                nuevaFila--;
                break;
            case 'S': // Abajo
                nuevaFila++;
                break;
            default:
                System.out.println("Movimiento inválido");
                return;
        }

        // Verificar si la nueva posición está dentro del tablero
        if (nuevaFila < 0 || nuevaFila >= MAX_FILA_T || nuevaColumna < 0 || nuevaColumna >= MAX_COLUMNA_T) {
            System.out.println("Desplazamiento prohibido. Límite del tablero.");
            return;
        }

        // Verificar qué hay en la nueva posición
        switch (tablero[nuevaFila][nuevaColumna]) {
            case 'H': // Homero
                vidas--;
                System.out.println("¡Te has encontrado con Homero! Vidas restantes: " + vidas);
                break;
            case 'M': // Muro
                System.out.println("¡El muro no te deja pasar!");
                return; // No mover
            case 'F': // Final del juego
                System.out.println("¡Has llegado al final! ¡Felicidades!");
            case 'L': // Espacio libre
                break;
        }

        // Mover a Bart a la nueva posición
        tablero[filaBart][columnaBart] = 'L'; // Liberar la posición anterior
        filaBart = nuevaFila;
        columnaBart = nuevaColumna;
        tablero[filaBart][columnaBart] = 'B'; // Nueva posición de Bart
    }
    public static void main(String[] args) {
        tablero = new char[MAX_FILA_T][MAX_COLUMNA_T];
        Scanner lector = new Scanner(System.in);
        inicializarTablero();
        colocarEnCasillaAleatoria('B', 1); // Colocar a Bart
        colocarEnCasillaAleatoria('H', 10); // Colocar 5 Homeros
        colocarEnCasillaAleatoria('M', 10); // Colocar 5 muros
        tablero[MAX_FILA_T - 1][MAX_COLUMNA_T - 1] = 'F'; // Final en (9,9)
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                if (tablero[i][j] == 'B') {
                    filaBart = i;
                    columnaBart = j;
                    break;
                }
            }
        }
        printTablero();
        while (vidas > 0 && tablero[MAX_FILA_T - 1][MAX_COLUMNA_T - 1] != 'B') {
            System.out.println("Mover a Bart: (W: Arriba, A: Izquierda, S: Abajo, D: Derecha)");
            char movimiento = lector.nextLine().toUpperCase().charAt(0); // Convertir a mayúscula
            moverBart(movimiento);
            printTablero();
            if (vidas <= 0) {
                System.out.println("Game Over, Bart ha perdido todas sus vidas.");
            }
        }
        if (tablero[MAX_FILA_T - 1][MAX_COLUMNA_T - 1] == 'B') {
            System.out.println("¡Felicidades, has llegado al final del juego!");
        }
    }
}