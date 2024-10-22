import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int filas = 3;
        int columnas = 9;
        int[][] matriz = new int[filas][columnas];
        Random random = new Random();
        // Rellenar la matriz con números aleatorios en los rangos especificados
        for (int j = 0; j < columnas; j++) {
            int rangoInferior = j * 10;
            for (int i = 0; i < filas; i++) {
                matriz[i][j] = rangoInferior + random.nextInt(10); // Genera un número aleatorio en el rango
            }
        }
        // Mostrar la matriz original
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        // Ordenar cada columna de la matriz
        for (int j = 0; j < columnas; j++) {
            ordenarColumna(matriz, j);
        }

        // Mostrar la matriz ordenada
        System.out.println("\nMatriz ordenada:");
        imprimirMatriz(matriz);
    }

    // Método para ordenar una columna específica usando el método de burbuja
    public static void ordenarColumna(int[][] matriz, int columna) {
        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 0; j < matriz.length - 1 - i; j++) {
                if (matriz[j][columna] > matriz[j + 1][columna]) {
                    // Intercambiar
                    int temp = matriz[j][columna];
                    matriz[j][columna] = matriz[j + 1][columna];
                    matriz[j + 1][columna] = temp;
                }
            }
        }
    }

    // Método para imprimir la matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}