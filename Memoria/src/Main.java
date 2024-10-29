import java.util.Random;
import java.util.Scanner;

public class Main {
    static int[][] tableroNumeros = new int[4][4];
    static String[][] tableroUsuario = new String[4][4];
    static boolean juegoTerminado = false;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Generar el tablero aleatorio y llenar el tablero del usuario con "X"
        generarTableroAleatorio();
        inicializarTableroUsuario();

        // Mostrar el tablero de números por 2 segundos
        System.out.println("Tablero con los números:");
        mostrarTableroNumeros();
        Thread.sleep(2000); // Espera de 2 segundos para mostrar el tablero
        limpiarPantalla();  // Limpia la pantalla después de la pausa

        // Comienza el juego ocultando el tablero
        System.out.println("Comienza el juego de memoria:");
        while (!juegoTerminado) {
            mostrarTableroUsuario();

            // Pedir al usuario la primera posición
            System.out.print("Ingresa la fila de la primera carta (0-3): ");
            int fila1 = scanner.nextInt();
            System.out.print("Ingresa la columna de la primera carta (0-3): ");
            int col1 = scanner.nextInt();

            // Pedir al usuario la segunda posición
            System.out.print("Ingresa la fila de la segunda carta (0-3): ");
            int fila2 = scanner.nextInt();
            System.out.print("Ingresa la columna de la segunda carta (0-3): ");
            int col2 = scanner.nextInt();

            // Verificar si las posiciones contienen el mismo número
            if (tableroNumeros[fila1][col1] == tableroNumeros[fila2][col2] && !(fila1 == fila2 && col1 == col2)) {
                // Si acierta, mostrar el número en el tablero del usuario
                tableroUsuario[fila1][col1] = String.valueOf(tableroNumeros[fila1][col1]);
                tableroUsuario[fila2][col2] = String.valueOf(tableroNumeros[fila2][col2]);
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto, inténtalo de nuevo.");
            }

            // Verificar si el juego ha terminado
            verificarJuegoTerminado();
        }

        System.out.println("¡Felicidades! Has descubierto todos los pares.");
        mostrarTableroUsuario();
        scanner.close();
    }

    // Método para generar el tablero de números con parejas aleatorias sin return
    public static void generarTableroAleatorio() {
        int[] pares = new int[16];
        int numero = 1;

        // Crear las parejas de números del 1 al 8 (dos veces cada uno)
        for (int i = 0; i < 16; i += 2) {
            pares[i] = numero;
            pares[i + 1] = numero;
            numero++;
        }

        // Barajar el arreglo de pares manualmente
        Random rand = new Random();
        for (int i = 0; i < pares.length; i++) {
            int j = rand.nextInt(16);
            int temp = pares[i];
            pares[i] = pares[j];
            pares[j] = temp;
        }

        // Llenar el tablero 4x4 con los números barajados
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tableroNumeros[i][j] = pares[index++];
            }
        }
    }

    // Método para inicializar el tablero del usuario con "X"
    public static void inicializarTableroUsuario() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tableroUsuario[i][j] = "X";
            }
        }
    }

    // Método para mostrar el tablero de números
    public static void mostrarTableroNumeros() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tableroNumeros[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Método para mostrar el tablero del usuario
    public static void mostrarTableroUsuario() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tableroUsuario[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Método para verificar si el juego ha terminado
    public static void verificarJuegoTerminado() {
        juegoTerminado = true;  // Suponemos que el juego ha terminado

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tableroUsuario[i][j].equals("X")) {
                    juegoTerminado = false;  // Si hay alguna "X", el juego no ha terminado
                    return;  // Salir de la función al encontrar una "X"
                }
            }
        }
    }

    // Método para simular limpiar la pantalla
    public static void limpiarPantalla() throws InterruptedException {
        System.out.print("\n".repeat(50)); // Imprime 50 líneas en blanco para simular la limpieza de consola
    }
}
