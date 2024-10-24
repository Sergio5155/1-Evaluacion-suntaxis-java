import java.util.Random;

public class Main {
    private static  int filas = 3;
  private static   int columnas = 9;
   private static  int matriz[][] = new int[filas][columnas];
   private static Random aleatorio = new Random();
    private static void imprimirtablero(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        // Llenar la matriz con números aleatorios
        for (int j = 0; j < columnas; j++) {
            int rangoInferior = j * 10;
            for (int i = 0; i < filas; i++) {
                matriz[i][j] = rangoInferior + aleatorio.nextInt(10);
            }
        }

        System.out.println("Matriz original:");
        imprimirtablero();

        // Ordenar cada columna de menor a mayor
        for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas - 1; i++) {
                for (int k = i + 1; k < filas; k++) {
                    if (matriz[i][j] > matriz[k][j]) {
                        // Intercambiar los elementos
                        int temp = matriz[i][j];
                        matriz[i][j] = matriz[k][j];
                        matriz[k][j] = temp;
                    }
                }
            }
        }

        System.out.println("Matriz ordenada por columnas:");
        imprimirtablero();
    }
}
