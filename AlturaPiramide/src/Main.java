import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int bloques = scanner.nextInt();
            if (bloques == 0) {
                break;
            }
            int nivel = 0;
            int bloquesUsados = 0;
            int bloquesNivel = 1;
            while (bloquesUsados + bloquesNivel <= bloques) {
                bloquesUsados += bloquesNivel;
                nivel++;
                bloquesNivel = (2 * nivel + 1) * (2 * nivel + 1);
            }
            System.out.println(nivel);
        }
        scanner.close();
    }
}
