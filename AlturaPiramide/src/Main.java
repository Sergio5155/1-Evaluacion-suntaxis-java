import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de bloques
            int bloques = scanner.nextInt();

            // Salir del bucle si el número de bloques es 0
            if (bloques == 0) {
                break;
            }

            int nivel = 0; // Nivel actual de la pirámide
            int bloquesUsados = 0; // Total de bloques utilizados
            int bloquesNivel = 1; // Bloques requeridos para el primer nivel

            // Construir niveles hasta agotar los bloques disponibles
            while (bloquesUsados + bloquesNivel <= bloques) {
                bloquesUsados += bloquesNivel;
                nivel++;
                bloquesNivel = (2 * nivel + 1) * (2 * nivel + 1);
            }

            // Imprimir la altura de la pirámide (número de niveles completos)
            System.out.println(nivel);
        }

        scanner.close();
    }
}
