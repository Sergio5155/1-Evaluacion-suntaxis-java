import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_FILA_T = 10;
    private static final int MAX_COLUMNA_T = 10;
    private static char[][] tableroYoda;
    private static char[][] tableroVader;
    private static int filaYoda, columnaYoda;
    private static int filaVader, columnaVader;
    private static int vidasYoda = 3;
    private static int vidasVader = 3;

    private static void printTableroYoda() {
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                System.out.print(tableroYoda[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printTableroVader() {
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                System.out.print(tableroVader[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void inicializarTableroYoda() {
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                tableroYoda[i][j] = 'L';
            }
        }
    }

    private static void inicializarTableroVader() {
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                tableroVader[i][j] = 'L';
            }
        }
    }

    private static void colocarEnCasillaAleatoriaYoda(char caracter, int cantidad) {
        Random aleatorio = new Random();
        int filaAleatorio, columnaAleatorio;
        for (int i = 0; i < cantidad; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(MAX_FILA_T);
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_T);
            } while (tableroYoda[filaAleatorio][columnaAleatorio] != 'L');
            tableroYoda[filaAleatorio][columnaAleatorio] = caracter;
        }
    }

    private static void colocarEnCasillaAleatoriaVader(char caracter, int cantidad) {
        Random aleatorio = new Random();
        int filaAleatorio, columnaAleatorio;
        for (int i = 0; i < cantidad; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(MAX_FILA_T);
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_T);
            } while (tableroVader[filaAleatorio][columnaAleatorio] != 'L');
            tableroVader[filaAleatorio][columnaAleatorio] = caracter;
        }
    }
    private static void teletransportarYoda() {
        Random aleatorio = new Random();
        int nuevaFila, nuevaColumna;

        do {
            nuevaFila = aleatorio.nextInt(MAX_FILA_T);
            nuevaColumna = aleatorio.nextInt(MAX_COLUMNA_T);
        } while (tableroYoda[nuevaFila][nuevaColumna] != 'L');

        tableroYoda[filaYoda][columnaYoda] = 'L'; // Liberamos la posición actual
        filaYoda = nuevaFila; // Actualizamos la posición de Yoda
        columnaYoda = nuevaColumna;
        tableroYoda[filaYoda][columnaYoda] = 'Y'; // Colocamos a Yoda en la nueva posición
    }

    private static void teletransportarVader() {
        Random aleatorio = new Random();
        int nuevaFila2, nuevaColumna2;
        do {
            nuevaFila2 = aleatorio.nextInt(MAX_FILA_T);
            nuevaColumna2 = aleatorio.nextInt(MAX_COLUMNA_T);
        } while (tableroVader[nuevaFila2][nuevaColumna2] != 'L');

        tableroVader[filaVader][columnaVader] = 'L'; // Liberamos la posición actual
        filaVader = nuevaFila2; // Actualizamos la posición de Vader
        columnaVader = nuevaColumna2;
        tableroVader[filaVader][columnaVader] = 'V'; // Colocamos a Vader en la nueva posición
    }
    private static int pedirPasos() {
        Scanner lector = new Scanner(System.in);
        int pasos;
        do {
            System.out.println("Elige el número de pasos para moverte (1-3): ");
            pasos = lector.nextInt();
        } while (pasos < 1 || pasos > 3);
        return pasos;
    }

    private static void moverYoda(char direccion, int pasos) {
        for (int i = 0; i < pasos; i++) {
            int nuevaFila = filaYoda;
            int nuevaColumna = columnaYoda;

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
                case 'Q': //Diagonal arriba izquierda
                    nuevaFila--;
                    nuevaColumna--;
                case 'E': //Diagonal arriba derecha
                    nuevaFila--;
                    nuevaColumna++;
                case 'Z': //Diagonal abajo izquierda
                    nuevaFila++;
                    nuevaColumna--;
                case 'C': //Diagonal abajo derecha
                    nuevaFila++;
                    nuevaColumna++;
                case'P':
                    nuevaColumna--;
                    nuevaFila++;
            }

            if (nuevaFila < 0 || nuevaFila >= MAX_FILA_T || nuevaColumna < 0 || nuevaColumna >= MAX_COLUMNA_T) {
                System.out.println("Desplazamiento prohibido. Límite del tablero.");
                return;
            }

            switch (tableroYoda[nuevaFila][nuevaColumna]) {
                case 'D':
                    vidasYoda--;
                    System.out.println("¡Te has encontrado con Darth Maul! Vidas restantes: " + vidasYoda);
                    break;
                case 'M':
                    System.out.println("¡El muro no te deja pasar!");
                    return;
                case 'F':
                    System.out.println("¡Has llegado al final! ¡Felicidades!");
                case'P':
                    System.out.println("Te has encontrado una pocion");
                    teletransportarYoda();
                case 'L':
                    break;
            }

            tableroYoda[filaYoda][columnaYoda] = 'L';
            filaYoda = nuevaFila;
            columnaYoda = nuevaColumna;
            tableroYoda[filaYoda][columnaYoda] = 'Y';
        }
    }

    private static void moverVader(char direccion, int pasos) {
        for (int i = 0; i < pasos; i++) {
            int nuevaFila2 = filaVader;
            int nuevaColumna2 = columnaVader;

            switch (direccion) {
                case 'A': // Izquierda
                    nuevaColumna2--;
                    break;
                case 'D': // Derecha
                    nuevaColumna2++;
                    break;
                case 'W': // Arriba
                    nuevaFila2--;
                    break;
                case 'S': // Abajo
                    nuevaFila2++;
                    break;
                case 'Q': //Diagonal arriba izquierda
                    nuevaFila2--;
                    nuevaColumna2--;
                case 'E': //Diagonal arriba derecha
                    nuevaFila2--;
                    nuevaColumna2++;
                case 'Z': //Diagonal abajo izquierda
                    nuevaFila2++;
                    nuevaColumna2--;
                case 'C': //Diagonal abajo derecha
                    nuevaFila2++;
                    nuevaColumna2++;
                case'P':
                    nuevaColumna2--;
                    nuevaFila2++;
                default:
                    System.out.println("Movimiento inválido");
                    return;
            }

            if (nuevaFila2 < 0 || nuevaFila2 >= MAX_FILA_T || nuevaColumna2 < 0 || nuevaColumna2 >= MAX_COLUMNA_T) {
                System.out.println("Desplazamiento prohibido. Límite del tablero.");
                return;
            }

            switch (tableroVader[nuevaFila2][nuevaColumna2]) {
                case 'R':
                    vidasVader--;
                    System.out.println("¡Te has encontrado con R2D2! Vidas restantes: " + vidasVader);
                    break;
                case 'M':
                    System.out.println("¡El muro no te deja pasar!");
                    return;
                case 'F':
                    System.out.println("¡Has llegado al final! ¡Felicidades!");
                case'P':
                    System.out.println("Te has encontrado una pocion");
                    teletransportarVader();
                case 'L':
                    break;
            }

            tableroVader[filaVader][columnaVader] = 'L';
            filaVader = nuevaFila2;
            columnaVader = nuevaColumna2;
            tableroVader[filaVader][columnaVader] = 'V';
        }
    }

    public static void main(String[] args) {
        tableroYoda = new char[MAX_FILA_T][MAX_COLUMNA_T];
        tableroVader = new char[MAX_FILA_T][MAX_COLUMNA_T];
        Scanner lector = new Scanner(System.in);
        inicializarTableroYoda();
        inicializarTableroVader();
        colocarEnCasillaAleatoriaYoda('Y', 1);
        colocarEnCasillaAleatoriaYoda('D', 5);
        colocarEnCasillaAleatoriaYoda('M', 5);
        colocarEnCasillaAleatoriaYoda('P',5);
        colocarEnCasillaAleatoriaVader('V', 1);
        colocarEnCasillaAleatoriaVader('R', 5);
        colocarEnCasillaAleatoriaVader('M', 5);
        colocarEnCasillaAleatoriaVader('P',5);
        tableroYoda[MAX_FILA_T - 1][MAX_COLUMNA_T - 1] = 'F';
        tableroVader[MAX_FILA_T - 1][MAX_COLUMNA_T - 1] = 'F';

        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                if (tableroYoda[i][j] == 'Y') {
                    filaYoda = i;
                    columnaYoda = j;
                    break;
                }
            }
        }
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                if (tableroVader[i][j] == 'V') {
                    filaVader = i;
                    columnaVader = j;
                    break;
                }
            }
        }

        System.out.println("Tablero Yoda:");
        printTableroYoda();

        while (vidasYoda > 0 && vidasVader > 0) {
            System.out.println("Mover a Yoda: (W: Arriba, A: Izquierda, S: Abajo, D: Derecha)");
            char movimientoYoda = lector.nextLine().toUpperCase().charAt(0);
            int pasosYoda = pedirPasos();
            moverYoda(movimientoYoda, pasosYoda);
            printTableroVader();
            if (vidasYoda <= 0) {
                System.out.println("Game Over, Yoda ha perdido todas sus vidas.");
                break;
            }

            System.out.println("Mover a Vader: (W: Arriba, A: Izquierda, S: Abajo, D: Derecha)");
            char movimientoVader = lector.nextLine().toUpperCase().charAt(0);
            int pasosVader = pedirPasos();
            moverVader(movimientoVader, pasosVader);
            printTableroYoda();
            if (vidasVader <= 0) {
                System.out.println("Game Over, Vader ha perdido todas sus vidas.");
                break;
            }
        }
    }
}