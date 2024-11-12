import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] tablero = new char[10][10];
        // Asegúrate de que todas las palabras tienen 5 letras
        String[] palabras = {"BALON", "CAMPO", "PASES", "GOLES", "ROJA", "PENAL", "JUGAR", "CAMIS", "MESSI", "TIROS"};
        Scanner teclado = new Scanner(System.in);
        int intentos = 10;
        int palabrasencontradas = 0;
        // Paso 1: Rellenar la matriz con letras aleatorias
        rellenarTableroConLetrasAleatorias(tablero);
        // Paso 2: Colocar las palabras en el tablero en direcciones aleatorias
        colocarPalabrasEnTablero(tablero, palabras);
        // Paso 3: Mostrar el tablero
        mostrarTablero(tablero);
        // Vamos a explicar el juego al usuario
        System.out.println("Encuentra las 10 palabras de la sopa de letras, el tema de la sopa es FUTBOL");
        // Bucle principal del juego
        while (intentos > 0 && palabrasencontradas < palabras.length) {
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Introduce una palabra: ");
            String palabra = teclado.nextLine().toUpperCase();

            // Verificar si la palabra está en el tablero
            if (verificarPalabraEnTablero(tablero, palabra)) {
                palabrasencontradas++;
                intentos--;
                System.out.println("¡Has encontrado una palabra! Palabras encontradas: " + palabrasencontradas);
            } else {
                intentos--;
                System.out.println("La palabra no está en el tablero. Intenta de nuevo.");
            }
        }

        // Mensaje de finalización
        if (palabrasencontradas == palabras.length) {
            System.out.println("¡Felicidades! Has encontrado todas las palabras.");
        } else {
            System.out.println("Te has quedado sin intentos. ¡Fin del juego!");
        }
    }

    // Rellenar el tablero con letras aleatorias
    public static void rellenarTableroConLetrasAleatorias(char[][] tablero) {
        Random rand = new Random();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = (char) ('A' + rand.nextInt(26));  // Letras aleatorias de la A a la Z
            }
        }
    }

    // Colocar palabras en el tablero
    public static void colocarPalabrasEnTablero(char[][] tablero, String[] palabras) {
        Random rand = new Random();

        for (String palabra : palabras) {
            boolean colocada = false;
            while (!colocada) {
                // Elegir una posición aleatoria en el tablero
                int direccion = rand.nextInt(3);  // 0 = horizontal, 1 = vertical, 2 = diagonal
                int fila = rand.nextInt(10);
                int col = rand.nextInt(10);

                // Comprobar si la palabra cabe en la dirección seleccionada
                if (direccion == 0 && col + palabra.length() <= 10) {  // Horizontal
                    colocada = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila][col + i] = palabra.charAt(i);
                    }
                } else if (direccion == 1 && fila + palabra.length() <= 10) {  // Vertical
                    colocada = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][col] = palabra.charAt(i);
                    }
                } else if (direccion == 2 && fila + palabra.length() <= 10 && col + palabra.length() <= 10) {  // Diagonal
                    colocada = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][col + i] = palabra.charAt(i);
                    }
                }
            }
        }
    }

    // Verificar si una palabra está en el tablero
    public static boolean verificarPalabraEnTablero(char[][] tablero, String palabra) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                // Buscar horizontalmente
                if (j + palabra.length() <= tablero[i].length) {
                    boolean encontrada = true;
                    for (int k = 0; k < palabra.length(); k++) {
                        if (tablero[i][j + k] != palabra.charAt(k)) {
                            encontrada = false;
                            break;
                        }
                    }
                    if (encontrada) return true;
                }

                // Buscar verticalmente
                if (i + palabra.length() <= tablero.length) {
                    boolean encontrada = true;
                    for (int k = 0; k < palabra.length(); k++) {
                        if (tablero[i + k][j] != palabra.charAt(k)) {
                            encontrada = false;
                            break;
                        }
                    }
                    if (encontrada) return true;
                }

                // Buscar diagonalmente
                if (i + palabra.length() <= tablero.length && j + palabra.length() <= tablero[i].length) {
                    boolean encontrada = true;
                    for (int k = 0; k < palabra.length(); k++) {
                        if (tablero[i + k][j + k] != palabra.charAt(k)) {
                            encontrada = false;
                            break;
                        }
                    }
                    if (encontrada) return true;
                }
            }
        }
        return false;
    }

    // Mostrar el tablero
    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}