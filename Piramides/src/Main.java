import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime cuantos casos quieres");
        // Leer el número de casos de prueba
        int casos = scanner.nextInt();
        // Procesar cada caso
        for (int i = 0; i < casos; i++) {
            // Leer los tres años
            System.out.println("Dame el primer numero");
            int A = scanner.nextInt();
            System.out.println("Dame el numero con el que compararas");
            int B = scanner.nextInt();
            System.out.println("Dame el segundo numero");
            int C = scanner.nextInt();

            // Calcular la distancia de A y C a B
            int distanciaA = Math.abs(A - B);
            int distanciaC = Math.abs(C - B);

            // Determinar cuál año está más cerca de B
            if (distanciaA < distanciaC) {
                System.out.println("El numero mas cercano es:");
                System.out.println(A);
            } else if (distanciaC < distanciaA) {
                System.out.println("El numero mas cercano es:");
                System.out.println(C);
            } else {
                System.out.println("EMPATE");
            }
        }
        scanner.close();
    }
}
